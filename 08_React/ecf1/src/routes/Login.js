import {useState} from "react";
import { signInWithEmailAndPassword } from "firebase/auth";
import {auth} from "../firebaseConfig";
import {useNavigate} from "react-router-dom";


const Login = () => {
    const [email , setEmail] = useState("");
    const [password , setPassword] = useState("");
    const [error , setError] = useState(null);
    const isLogin = true;
    const navigate = useNavigate();


    const onSubmit = async (e) => {
        e.preventDefault();

        try {
            await signInWithEmailAndPassword(auth , email , password);
            console.log("User logged in");
        } catch (error) {
            setError(error.message);
        }
        isLogin ? navigate(`/imcDisplay`) : navigate(`/signup`)


    };
    return (
        <main>
            <section>
                <div>
                    <div>
                        <h1> FocusApp </h1>
                        <form onSubmit={onSubmit}>
                            <div className={
                                "mb-3"
                            }>
                                <label className={
                                    "form-label"
                                } htmlFor="email-address">
                                    Email address
                                </label>
                                <input
                                    className={
                                        "form-control"
                                    }
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
                                <label className={
                                    "form-label"
                                } htmlFor="password">
                                    Password
                                </label>
                                <input
                                    className={
                                        "form-control"
                                    }
                                    type="password"
                                    label="Create password"
                                    value={password}
                                    onChange={(e) => setPassword(e.target.value)}
                                    required
                                    placeholder="Password"
                                />
                            </div>

                            <div>
                                <button type="submit" className={" m-3 btn btn-primary"}>
                                    Login
                                </button>
                            </div>
                        </form>
                        {error && <p>{error}</p>}
                    </div>
                </div>
            </section>
        </main>
    );
};

export default Login;

