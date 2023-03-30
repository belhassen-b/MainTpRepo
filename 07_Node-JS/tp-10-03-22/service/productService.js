import {Product} from "../models/Product.js";
import {read , write} from "../utils/utilsService.js";

export class ProductService {
    constructor() {
        this.file = "data/products.json";
    }

//add product
    createProduct(product) {
        let products = read(this.file);
        let newProduct = new Product(products.length , product.name , product.price , product.description);
        products.push(newProduct);
        write(this.file , products);
        return product;
    }

//show all products
    showAllProducts() {
        return read(this.file);
    }

//show product by id
    showProductById(id) {
        let product = read(this.file);
        return product.find(p => p.id == id);
    }

//delete product by id
    deleteProduct(id) {
        let products = read(this.file);
        let product = products.find(p => p.id == id);
        products.splice(products.indexOf(product) , 1);
        write(this.file , products);
        return product;
    }

    removeStock(id , quantity) {
        let products = read(this.file);
        let product = products.find(p => p.id === id);
        if (product.stock < quantity) {
            throw new Error("Not enough stock");
        }
        product.stock -= quantity;
        write(this.file , products);
        return product;
    }

    // addStock(id , quantity) {
    //     let products = read(this.file);
    //     let product = products.find(p => p.id == id);
    //     product.stock += quantity;
    //     write(this.file , products);
    //     return product;
    // }
}

