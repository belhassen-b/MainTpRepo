import express from 'express';
import {OrderService} from '../service/orderService.js';

let orderService = new OrderService();

const orderRoutes = express.Router();



// ---------------------------------------------------------

// orders
// Afficher toutes les commandes

orderRoutes.get('/' , (req , res) => {
    res.json(orderService.showAllOrders());
});

// Afficher une commande par son id
orderRoutes.get('/:id' , (req , res) => {
        res.json(orderService.showOrderById(req.params.id));
    }
);

// Afficher les commandes d'un client par son id
orderRoutes.get('/client/:id' , (req , res) => {
        res.json(orderService.showOrdersByClientId(req.params.id));
    }
);

// Créer une commande
orderRoutes.post('/' , (req , res) => {
    res.json(orderService.addOrder(req.body));
});


// Supprimer une commande par son id
orderRoutes.delete('/:id' , (req , res) => {
    res.json(orderService.deleteOrder(req.params.id));
});

export default orderRoutes;