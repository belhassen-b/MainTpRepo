const fs = require('fs');
const path = require('path');
const bcrypt = require('bcrypt-nodejs');
const { createToken } = require('../services/jwt');

const User = require('../models/user');

function saveUser(req, res) {
  const { firstname, lastname, pseudo, email, password } = req.body;
  console.log(req.body)

  if (firstname && lastname && pseudo && email && password) {
    const user = new User();

    user.firstname = firstname;
    user.lastname = lastname;
    user.pseudo = pseudo;
    user.email = email;
    user.role = 'ROLE_USER';
    user.image = null;

    User.find({ $or: [ {email}, {pseudo} ] })
      .then(users => {
        if (users.length > 0) {
          return res.status(403).send({ message: `Cet utilisateur existe déjà.` });
        }

        bcrypt.hash(password, null, null, (err, hash) => {
          if (err) {
            return res.status(500).send({ message: `Le cryptage du mot de passe n'a pas abouti.` });
          }
    
          user.password = hash;

          user.save()
            .then(user => {
              res.status(200).send({ user });
            })
            .catch(error => res.status(500).send({ error }));
        });

      });
  }
  else {
    res.status(400).send({ message: `Il manque des données pour créer un utilisateur.`});
  }
}

function loginUser(req, res) {
  const { email, password } = req.body;

  User.findOne({ email }, (err, user) => {
    if (err || !user) {
      return res.status(404).send({ message: `L'utilisateur n'a pas de compte.` });
    }

    bcrypt.compare(password, user.password, (err, checked) => {
      if (err || !checked) {
        return res.status(500).send({ message: `Le mot de passe ne correspond pas.` });
      }

      user.password = undefined;
      res.status(200).send({ user, token: createToken(user) });
    })
  });
}

function getUsers(req, res) {
  User.find().then(users => {
    if (users.length <= 0) {
      return res.status(404).send({ message: `Il n'y a pas d'utilisateurs.` });
    }

    res.status(200).send({ users });
  })
}

function getUser(req, res) {
  const userId = req.params.id;

  User.findById(userId)
    .then((user) => {
      if (!user) {
        return res.status(404).send({ message: `L'utilisateur demandé n'existe pas.` });
      }

      res.status(200).send({ user });
    })
    .catch(error => res.status(500).send({ error }));
}

function updateUser(req, res) {
  const userId = req.params.id;
  const { firstname, lastname, email, pseudo } = req.body;

  if (userId !== req.user.sub) {
    return res.status(403).send({ message: `Vous n'êtes pas autorisé à modifier cet utilisateur.` });
  }

  if (firstname || lastname || email || pseudo) {
    const propsToUpdate = {};
    if (firstname) propsToUpdate.firstname = firstname;
    if (lastname) propsToUpdate.lastname = lastname;
    if (email) propsToUpdate.email = email;
    if (pseudo) propsToUpdate.pseudo = pseudo;

    User.findByIdAndUpdate(userId, propsToUpdate, { new: true })
      .then(user => res.status(200).send({ user }))
      .catch(error => res.status(500).send({ error }));
  }
}

function uploadImage(req, res) {
  const userId = req.params.id;

  if (userId !== req.user.sub) {
    return res.status(403).send({ message: `Vous n'êtes pas autorisé à mettre à jour cet utilisateur.` });
  }

  if (req.files) {
    const filePath = req.files.image.path;
    const fileEntireName = path.parse(filePath).base;
    const fileExtension = path.parse(filePath).ext.substr(1);
    const fileName = path.basename(fileEntireName, `.${fileExtension}`);

    const validExtension = ['png', 'jpg', 'jpeg', 'gif'].filter(ext => {
      return fileExtension.toLowerCase().includes(ext);
    });

    if (validExtension.length > 0) {
      User.findByIdAndUpdate(userId, { image: fileEntireName })
        .then(user => {

          if (user.image) {
            require('fs').unlink(`./uploads/users/${user.image}`, err => {});
          }

          user.image = fileEntireName;
          return res.status(200).send({ user }); 
        })
    }
    else {
      require('fs').unlink(filePath, err => {});
      return res.status(500).send({ message: `Extension de fichier non autorisée.` });
    }
  }
  else {
    res.status(200).send({ message: `Aucune image n'a été chargé...` });
  }
}

function getImage(req, res) {
  const filePath = `./uploads/users/${req.params.imageFile}`;

  console.log()
  console.log()
  console.log(filePath)
  console.log(path.resolve(filePath))
  console.log()
  console.log()

  fs.exists(filePath, exists => {
    if (exists) {
      res.sendFile(path.resolve(filePath));
    }
    else {
      res.status(404).send({ message: `L'image demandée n'existe pas...` });
    }
  })
}

module.exports = {
  saveUser,
  loginUser,
  getUsers,
  getUser,
  updateUser,
  uploadImage,
  getImage,
};
