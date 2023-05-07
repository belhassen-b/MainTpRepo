import {Form , useNavigate} from "react-router-dom";
import React , {useRef , useState} from "react";
import { getDatabase, ref, set } from "firebase/database";
import {getAuth} from "firebase/auth";

const UserImcDataForm = () => {
    const nameRef = useRef();
    const firstNameRef = useRef();
    const weightRef = useRef();
    const heightRef = useRef();
    const ageRef = useRef();
    const navigate = useNavigate();



    const submitHandler = (e) => {
        e.preventDefault();

        const enteredWeight = weightRef.current.value;
        const enteredHeight = heightRef.current.value;
        const enteredAge = ageRef.current.value;
        const user = getAuth().currentUser;
        const imcData = {
            id  : user.uid,
            weight: enteredWeight,
            height: enteredHeight,
            age: enteredAge,
            date: {
                date: new Date().getDate(),
            }
        };
        console.log(imcData);
        weightRef.current.value= '';
        heightRef.current.value= '';
        ageRef.current.value= '';

        const db = getDatabase();
        const currentUser = getAuth().currentUser;
        const userId = currentUser.uid;
        set(ref(db, 'users/' + userId), imcData);
        navigate('/imcDisplay');
    };


    return (
        <Form className="form" onSubmit={submitHandler}>
            <div className="row">
                <div className="col-12">
                    <h1>FocusApp</h1>
                    <h2>Calcul de l'IMC</h2>
                </div>
            </div>
            <div className="row">
                <div className="col-12">
                    <label className="form-label" htmlFor="weight">Poids</label>
                    <input className="form-control" type="number" placeholder="en kg" id="weight" ref={weightRef} required/>
                </div>
            </div>
            <div className="row">
                <div className="col-12">
                    <label className="form-label" htmlFor="height">Taille</label>
                    <input  className="form-control" type="number" step="any"  placeholder="taille en mètre" id="height" ref={heightRef} required/>
                </div>
            </div>
            <div className="row">
                <div className="col-12">
                    <label className="form-label" htmlFor="age">Age</label>
                    <input className="form-control" type="number" id="age" ref={ageRef} required/>
                </div>
            </div>

            <div className="row">
                <div className="col-12">
                    <button className="btn btn-primary m-2" type="submit">Envoyer</button>
                </div>
            </div>
        </Form>
)
}


export default UserImcDataForm