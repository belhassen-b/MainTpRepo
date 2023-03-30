import express  from 'express';
import {ProductService} from "../service/productService.js";

let productService = new ProductService();

const productRoutes = express.Router();



// ---------------------------------------------------------
// Products
// Afficher tous les produits

productRoutes.get('/' , (req , res) => {
    // console.log("products");
    res.json(productService.showAllProducts());
});

// Afficher un produit par son id
productRoutes.get('/:id' , (req , res) => {
    res.json(productService.showProductById(req.params.id));
});
// Créer un produit
productRoutes.post('/' , (req , res) => {
    res.json(productService.createProduct(req.body));
});

// Supprimer un produit par son id
productRoutes.delete('/:id' , (req , res) => {
    // console.log("delete" , req.params.id);
    res.json(productService.deleteProduct(req.params.id));
});

export default productRoutes;