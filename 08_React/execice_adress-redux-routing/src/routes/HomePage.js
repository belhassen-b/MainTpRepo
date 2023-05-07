import {Link} from "react-router-dom";

const HomePage = () => {


return (
        <div className="container-fluid">
            <div className="row">
                <div className="col-12">
                    <h1>Home Page</h1>
                    <form action="">
                        <div className="form-title">
                            <h2>Connection</h2></div>
                        <hr/>
                        <div className="form-group">
                            <label className="m-3" htmlFor="signup">S'enregistrer:</label>
                            <button type="submit" className="p-1 w-auto btn btn-primary btn-block">Sign Up</button>
                            <hr/>
                            <label  className="m-3" htmlFor="signin">Se connecter : </label>
                            <Link to={`/loginForm`} className=" ms-auto btn btn-outline-success rounded-circle p-1 px-2"><i className="bi bi-plus"></i>Sign in</Link>

            </div>
            </form>
            </div>
            </div>
        </div>

)
}

export default HomePage