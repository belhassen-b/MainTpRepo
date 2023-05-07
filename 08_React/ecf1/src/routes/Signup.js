import React, {useState} from 'react';
import { NavLink, useNavigate } from 'react-router-dom';
import {  createUserWithEmailAndPassword  } from 'firebase/auth';
import {auth} from "../firebaseConfig";

const Signup = () => {
    const navigate = useNavigate();
    const [name , setName] = useState();
    const [firstName , setFirstName] = useState();
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('');

    const onSubmit = async (e) => {
        e.preventDefault()

        await createUserWithEmailAndPassword(auth, email, password)
            .then((userCredential) => {
                // Signed in
                const user = userCredential.user;
                console.log(user);
                navigate(`/userImc`)
                // ...
            })
            .catch((error) => {
                const errorCode = error.code;
                const errorMessage = error.message;
                console.log(errorCode, errorMessage);
                // ..
            });


    }

    return (
        <main className={"container"} >
            <section className={
                "row justify-content-center"
            }>
                <div className={
                    "col-12 col-md-6 col-lg-4"
                }>
                    <div>
                        <h1> Imc Calc </h1>
                        <form className={
                            "card-body"
                        }>
                            <div className={
                                "mb-3"
                            }>
                                <label  className={"form-label"} htmlFor="email-address">
                                    Email address
                                </label>
                                <input
                                    className={"form-control"}
                                    type="email"
                                    label="Email address"
                                    value={email}
                                    onChange={(e) => setEmail(e.target.value)}
                                    required
                                    placeholder="Email address"
                                />
                            </div>

                            <div className={
                                "mb-3"
                            }>
                                <label className={"form-label"} htmlFor="password">
                                    Password
                                </label>
                                <input
                                    className={"form-control"}
                                    type="password"
                                    label="Create password"
                                    value={password}
                                    onChange={(e) => setPassword(e.target.value)}
                                    required
                                    placeholder="Password"
                                />
                            </div>

                            <button
                                className={"btn btn-primary mt-2"}
                                type="submit"
                                onClick={onSubmit}
                            >
                                Sign up
                            </button>

                        </form>

                        <p>
                            Already have an account?{' '}
                            <NavLink to="/login" >
                                Sign in
                            </NavLink>
                        </p>
                    </div>
                </div>
            </section>
        </main>
    )
}

export default Signup