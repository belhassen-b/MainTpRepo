import {Component} from "react";

export class Formulary extends Component {
    constructor(props) {
        super(props);
        this.state = {
            client: {
                nom: "" ,
                prenom: ""
            }

        }
    }


    submitForm = (e) => {
        e.preventDefault();
        const monClientValid =  {...this.state.client};
        console.log(monClientValid);
        this.setState({client: {nom: "" , prenom: "" }});
        // console.log("Prénom : " + this.state.prenom);
        // console.log("Client: " + this.state.client);
        e.target.reset();
        }
    fieldsChangeClient = (e) => {
        const tmpClient = {...this.state.client};
       tmpClient[e.target.getAttribute("name")] = e.target.value;
        // console.log("Nom : " + tmpClient.nom);
        // console.log("Prénom : " + tmpClient.prenom);
        this.setState({client: {...tmpClient}});
    }

    render() {
        return (
            <>
                <div>
                    <h1>Mon formulaire Client </h1>
                    <form onSubmit={this.submitForm}>
                        <div className="form-group">
                            <p>Votre nom :</p>
                            <input type="text" onChange={this.fieldsChangeClient} name="nom"></input>
                            <p>Votre prénom :</p>
                            <input type="text" onChange={this.fieldsChangeClient} name="prenom"></input>
                            <button>Envoyer</button>
                        </div>
                    </form>
                </div>
            </>
        );
    }
}
