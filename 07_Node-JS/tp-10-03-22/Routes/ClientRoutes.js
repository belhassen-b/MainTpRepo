import express  from "express";
import {ClientService} from "../service/clientService.js";




let clientService = new ClientService();
const clientRoutes = express.Router();



// Clients
// Afficher tous les clients
clientRoutes.get('/' , (req , res) => {
    res.json(clientService.showAllClients());
});

// Afficher un client par son id
clientRoutes.get('/:id' , (req , res) => {
    res.json(clientService.showClientById(req.params.id));
});

// Créer un client
clientRoutes.post('/' , (req , res) => {
    res.json(clientService.createClient(req.body));
});

// Supprimer un client par son id
clientRoutes.delete('/:id' , (req , res) => {
    res.json(clientService.deleteClient(req.params.id));
});

export default clientRoutes;