import {Client} from "../models/Client.js";
import {read , write} from "../utils/utilsService.js";


export class ClientService {
    constructor() {
        this.file = "data/clients.json";
    }



    // add client
    createClient(client) {
        let clients = read(this.file);
        let newClient = new Client(clients.length , client.name , client.firstName , client.phone);
        clients.push(newClient);
        write( this.file  , clients);
        return client;
    }

    //show all clients
    showAllClients() {
        return read(this.file);
    }

    //read  clients by id
    showClientById(id) {
        let client = read(this.file);
        return client.find(c => c.id == id);
    }

    //delete client by id
    deleteClient(id) {
        let clients = read(this.file);
        let client = clients.find(c => c.id == id);
        clients.splice(clients.indexOf(client) , 1);
        write(this.file , clients);
        return client;
    }

}