import {useNavigate} from "react-router-dom";
import {buildTimeValue} from "@testing-library/user-event/dist/utils";
import {useState} from "react";


const LoginForm = () => {
    const [userData, setUserData] = useState({
        email: "",
        password: "",
    });

    const [errorMessage, setErrorMessage] = useState({value:""});
    const handleInputChange = (e) => {
        setUserData((prevState) => {
            return {
                ...prevState,
                [e.target.name]: e.target.value,
            };
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        if (userData.email === "" || userData.password === "") {
            setErrorMessage((prevState) => ({
                value: "Empty username/password field",
            }));

        } else if (
            userData.email.toLowerCase() === "test@test.com" &&
            userData.password === "123456"
        ) {
            //Signin Success
            localStorage.setItem("isAuthenticated", "true");
            window.location.pathname = "/ContactsList";
        } else {
            //If credentials entered is invalid
            setErrorMessage((prevState) => ({ value: "Invalid username/password" }));
            return;
        }

    }


    return (

            <div>

                <h1>Login</h1>
                <form>
                    <div className="mb-3">
                        <label htmlFor="email" className="form-label">Email : </label>
                        <input type="text" required className="form-control" name="email" onChange={(e) =>
                        handleInputChange(e)} />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="password" className="form-label">Password : </label>
                        <input type="password" required  className="form-control" name="password" onChange={(e) =>
                            handleInputChange(e)} />
                    </div>
                    <div className="text-end">
                        <button type="submit" className="btn btn-primary" onClick={handleSubmit}>Login</button>
                    </div>
                    {errorMessage.value && (
                        <p className="text-danger"> {errorMessage.value} </p>
                    )}
                </form>

            </div>

        )

}
export default LoginForm