const express = require('express');
const router = express.Router();
const { Route } = require('../models/route');

const multipart = require('connect-multiparty');
const uploadMultipart = multipart({ uploadDir: './uploads/users' });

const userCtrl = require('../controllers/user');
const { checkAuth } = require('../middlewares/check-auth');

const routes = [
  new Route({ path: '/signup', method: 'post', controller: userCtrl.saveUser }),
  new Route({ path: '/login', method: 'post', controller: userCtrl.loginUser }),
  new Route({ path: '/users', method: 'get', controller: userCtrl.getUsers, middlewares: [checkAuth] }),
  new Route({ path: '/users/:id', method: 'get', controller: userCtrl.getUser, middlewares: [checkAuth] }),
  new Route({ path: '/users/:id', method: 'put', controller: userCtrl.updateUser, middlewares: [checkAuth] }),
  new Route({ path: '/users/:id/image', method: 'post', controller: userCtrl.uploadImage, middlewares: [checkAuth, uploadMultipart] }),
  new Route({ path: '/users/image/:imageFile', method: 'get', controller: userCtrl.getImage, middlewares: [checkAuth] }),
];

routes.map(({ path, method, controller, middlewares }) => {
  switch (method) {
    case 'post': router.post(path, ...middlewares, controller); break;
    case 'get': router.get(path, ...middlewares, controller); break;
    case 'put': router.put(path, ...middlewares, controller); break;
  }
});

module.exports = router;
