const jwt = require('jwt-simple');
const moment = require('moment');

module.exports.createToken = ({ _id, firstname, lastname, pseudo, email, role, image }) => {
  const payload = {
    sub: _id,
    firstname, lastname, pseudo, email, role, image,
    iat: moment().unix(),
    exp: moment().add(30, 'days').unix(),
  };

  return jwt.encode(payload, process.env.SECRET_KEY);
};
