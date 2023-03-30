

export class Order {
    constructor(id, clientId) {
        this.id = id;
        this.clientId = clientId;
        this.products = [];
    }
}