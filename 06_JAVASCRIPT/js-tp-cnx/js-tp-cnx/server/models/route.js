class Route {
  constructor({ path, method, controller, middlewares = [] }) {
    this.path = path;
    this.method = method;
    this.controller = controller;
    this.middlewares = middlewares;
  }
}

module.exports = { Route };
