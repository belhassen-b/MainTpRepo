const jwt = require('jwt-simple');
const moment = require('moment');

module.exports.checkAuth = (req, res, next) => {
  if (!req.headers.authorization) {
    return res.status(403).send({ message: `La requête n'a pas l'en-tête d'authentification.` });
  }

  const token = req.headers.authorization;

  try {
    const payload = jwt.decode(token, process.env.SECRET_KEY);

    if (payload.exp <= moment().unix()) {
      return res.status(401).send({ message: `Le jeton a expiré.` });
    }

    req.user = payload;
  }
  catch (e) {
    return res.status(401).send({ message: `Le jeton n'est pas valide.` });
  }

  next();
};
