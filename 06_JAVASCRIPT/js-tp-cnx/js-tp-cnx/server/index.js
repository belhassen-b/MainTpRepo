const app = require('./app');
const PORT = process.env.PORT || 3000;

const mongoose = require('mongoose');

const { BDD_HOST, BDD_PORT, BDD_NAME, BDD_USER, BDD_PWD } = process.env;
let dbUrl;

if (process.env.NODE_ENV === 'production') {
  dbUrl = `mongodb+srv://${BDD_USER}:${BDD_PWD}@${BDD_HOST}/${BDD_NAME}?retryWrites=true&w=majority`;
}
else {
  dbUrl = `mongodb://${BDD_HOST}:${BDD_PORT}/${BDD_NAME}`;
}

// mongoose.Promise = Promise;
mongoose.connect(dbUrl, { useNewUrlParser: true })
  .then(() => console.log(`Connexion à la BDD "${BDD_NAME}" réussie.`))
  .catch(error => console.error(error));
  
app.listen(PORT, () => console.log(`Server listening on port ${PORT}`));
