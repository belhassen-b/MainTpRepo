import express from 'express';
import productRoutes from "./Routes/productRoutes.js";
import clientRoutes from "./Routes/clientRoutes.js";
import orderRoutes  from "./Routes/OrderRoutes.js";

// Déclaration de l'API
const api = express();
const port = 3000;
// Configuration du middleware
api.use(express.json());


api.use('/products', productRoutes);
api.use('/clients', clientRoutes);
api.use('/orders', orderRoutes);


// ---------------------------------------------------------//
// Lancement du serveur
api.listen(port , () => {
    console.log(`App listening on port : ${port}`);
});
