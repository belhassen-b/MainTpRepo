import {getAuth} from 'firebase/auth';
import {getDatabase , ref , onValue} from "firebase/database";
import {Profiler , useEffect , useState} from "react";
import {useNavigate} from "react-router-dom";


const ImcDisplay = () => {
    const user = getAuth().currentUser;
    const userId = user.uid;

    const [data , setData] = useState({});
    useEffect(() => {
        const db = getDatabase();
        const userRef = ref(db , 'users/' + userId);
        onValue(userRef , (snapshot) => {
                const data = snapshot.val()
                setData(data);
                // console.log(data)
            }
        )
    })
    const getImc = () => {
        const imc = data.weight / (data.height * data.height);
        return imc;
    }

    const navigate = useNavigate();
    const logoutHandler = () => {
        getAuth().signOut();
        navigate('/');
    }
    const addDataHandler = () => {
        navigate('/userImc');
    }
    const getImcByDate = () => {
        const imcByDate = data.date.day;
        return imcByDate;
    }

    return (
        <div className="container m-3" >
            <h1>Résultat Imc</h1> <br/>
            <button className="btn btn-primary m-2" onClick={addDataHandler}>Ajouter des données</button>
            <p className={"mb-3"}>Age : {data.age}</p>
            <p> Poids : {data.weight}</p>
            <p> Taille : {data.height}</p>
            <hr/>
            <h3 className={"p-3"}> Votre IMC :</h3>
            <p style={ {fontSize: "2rem" , fontWeight: "bold" , textAlign: "center" , padding: "1rem"    } }
               className={getImc() < 18.5 ? "text-danger" : getImc() < 25 ? "text-success" : getImc() < 30 ? "text-warning" : "text-danger"}> {getImc()}</p>
            <hr/>
            <h3 className={"p-3"}> Vos précédentes Imc :</h3>
            {/*<li> {getImcByDate()} : {getImc()}</li>*/}
            <div className="container" style={{textAlign: "center"}
            }>
                <p> Informations sur l'IMC</p>
                <p> IMC inférieure à 18.5 : Maigreur</p>
                <p> IMC entre 18.5 et 25 : Corpulence normale</p>
                <p> IMC entre 25 et 30 : Surpoids</p>
                <p> IMC > 30 : Obésité</p>
            <button className="btn btn-danger m-2" onClick={logoutHandler}>Déconnexion</button>
            </div>
        </div>
    )
};


export default ImcDisplay;



