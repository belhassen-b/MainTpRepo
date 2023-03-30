import {read , write} from "../utils/utilsService.js";
import {ProductService} from "./productService.js";
import {ClientService} from "./clientService.js";
import {Order} from "../models/Order.js";

export class OrderService {
    constructor(productService, clientService) {
        this.file = "data/orders.json";
        this.productService = new ProductService()
        this.clientService = new ClientService();
    }


//show all orders
    showAllOrders() {
        return read(this.file);
    }

//show order by id
    showOrderById(id) {
        let orders = read(this.file);
        return orders.find(o => o.id == id);
    }

//show orders by client id
    showOrdersByClientId(id) {
        let orders = read(this.file);
        return orders.filter(o => o.clientId == id);
    }


//add order
    addOrder(order) {
        let orders = read(this.file);
        const client = this.clientService.showClientById(order.clientId);
        if (client != undefined) {
            let newOrder = new Order(orders.length , order.clientId);
            order.products.forEach(p => {
                    this.productService.removeStock(p.productId , p.quantity);
                    newOrder.products.push(p);
                }
            );
            orders.push(newOrder);
            write(this.file , orders);

            console.error("not found client");
        }
    }

//delete order by id
    deleteOrder(id) {
        let orders = read(this.file);
        let order = orders.find(o => o.id == id);
        orders.splice(orders.indexOf(order) , 1);
        write(this.file , orders);
        return order;
    }
}

