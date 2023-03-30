import {BaseObjet} from "./BaseObjet.js";

export default class Service extends BaseObjet {
    constructor(titre, prix, description, domaine) {
        super(titre, prix, description);
        this.domaine = domaine;
    }

}

