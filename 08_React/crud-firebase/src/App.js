import {useRef , useState , useEffect} from "react";
import ModalComponent from "./components/shared/ModalComponent";
import {ModalUpdateComponent} from "./components/shared/ModalUpdate";
import {createPortal} from "react-dom";
import {API_KEY} from "./apiKey";
import UserDisplay from "./components/UserItems/UserDisplay";
import {UserForm} from "./components/UserItems/UserForm";
import * as PropTypes from "prop-types";
import './App.css'


function UserList(props) {
    // show user list from firebase
    const {users , deleteUser , UpdateModalHandler} = props
    return (
        <>
            <h1>Liste des utilisateurs</h1>
            <ul>
                {users.map((user , index) => (
                    <UserDisplay key={index} user={user} deleteUser={deleteUser} updateUsers={UpdateModalHandler}/>
                ))}
            </ul>
        </>
    );
}


const App = () => {
    const BASE_DB_URL = "https://m2i-demo-auth-default-rtdb.europe-west1.firebasedatabase.app/"
    const [modalVisible , setModalVisible] = useState(false)
    const [modalUpdateVisible , setModalUpdateVisible] = useState(false)
    const [isLogging , setIsLogging] = useState(false)
    const [isLogged , setIsLogged] = useState(false)
    const emailRef = useRef()
    const passwordRef = useRef()

    const [users , setUsers] = useState([])


    UserList.propTypes = {
        deleteUser: PropTypes.func ,
        updateUsers: PropTypes.func ,
        users: PropTypes.arrayOf(PropTypes.any)
    };


    const submiFormtHandler = async (e) => {
        e.preventDefault();
        let BASE_URL = ""
        if (isLogging) {
            BASE_URL = `https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=${API_KEY}`
        } else {
            BASE_URL = `https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=${API_KEY}`
        }
        try {
            const response = await fetch(BASE_URL , {
                method: "POST" ,
                headers: {
                    "Content-Type": "application/json"
                } ,
                body: JSON.stringify({
                    email: emailRef.current.value ,
                    password: passwordRef.current.value ,
                    returnSecureToken: true
                })
            })

            if (!response.ok) {
                throw new Error("Il y a eu une erreur !")
            }

            const data = await response.json()

            localStorage.setItem('token' , data.idToken)

            emailRef.current.value = ""
            passwordRef.current.value = ""

            setIsLogged(true)
            setModalVisible(false)
        } catch (error) {
            console.error(error.message);
        }
    }

    const addUserHandler = async (user) => {
        try {
            const token = localStorage.getItem('token')
            if (token) {
                const response = await fetch(`${BASE_DB_URL}/users.json?auth=${token}` , {
                    method: "POST" ,
                    headers: {
                        "Content-Type": "application/json"
                    } ,
                    body: JSON.stringify(user)
                })
                if (!response.ok) {
                    throw new Error("Il y a eu un problème !")
                }

                const data = await response.json()
                console.log(data);
                setUsers([...users , {...user , id: data.name}])
                refreshUsers()
            }
        } catch (error) {
            console.error(error.message);
        }
    }

    const logOutHandler = () => {
        setIsLogged(false)
        localStorage.removeItem('token')
    }

    const refreshUsers = async () => {
        try {
            const response = await fetch(`${BASE_DB_URL}/users.json`)
            if (!response.ok) {
                throw new Error("Il y a eu un problème !")
            }
            const data = await response.json()
            const tmpUsers = []
            for (const key in data) {
                tmpUsers.push({...data[key] , id: key})

            }
            setUsers(tmpUsers)
        } catch (error) {
            console.error(error.message);
        }
    }
    useEffect(() => {
            refreshUsers()
        }
        , [])


    const deleteUserHandler = async (id) => {

        // eslint-disable-next-line no-restricted-globals
        if (confirm("Voulez-vous vraiment supprimer cet utilisateur ?")) {
            const userFound = users.find(user => user.id === id)
            console.log(userFound)
            try {
                const token = localStorage.getItem('token')
                if (token) {
                    const response = await fetch(`${BASE_DB_URL}/users/${id}.json?auth=${token}` , {
                        method: "DELETE"
                    })
                    if (!response.ok) {
                        throw new Error("Erreur lors de la requête DELETE ! !")
                    }
                    setUsers([...users.filter(user => user !== userFound)])
                }
            } catch (error) {
                console.error(error.message);
            }
        }
    }


    const UpdateModalHandler = async (id , user) => {
        try {
            const token = localStorage.getItem('token')
            if (token) {
                const response = await fetch(`${BASE_DB_URL}/users/${id}.json?auth=${token}` , {
                    method: "PUT" ,
                    headers: {
                        "Content-Type": "application/json"
                    } ,
                    body: JSON.stringify(user)
                })
                if (!response.ok) {
                    throw new Error("Il y a eu un problème !")
                }
                setUsers(users.map(user => user.id === id ? {...user , ...user} : user))
            }
        } catch (error) {
            console.error(error.message);
        }
    }
    return (
        <>
            <h1>Authentification</h1>
            {modalVisible && createPortal(<ModalComponent closeModal={() => setModalVisible(false)}>
                <div className="d-flex justify-content-between align-items center">
                    <h3>{isLogging ? 'Sign In' : 'Sign Up'}</h3>
                    <button onClick={() => setModalVisible(false)} className="btn btn-outline-dark rounded-circle"><i
                        className="bi bi-x"></i></button>
                </div>
                <hr/>
                <form onSubmit={submiFormtHandler}>
                    <div className="mb-3">
                        <label htmlFor="email" className="form-label">Email : </label>
                        <input type="text" required ref={emailRef} className="form-control"/>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="password" className="form-label">Password : </label>
                        <input type="password" required ref={passwordRef} className="form-control"/>
                    </div>
                    <div className="text-end">
                        <button type="button" className="btn btn-outline-info me-2"
                                onClick={() => setIsLogging(!isLogging)}>Switch
                            to {isLogging ? 'Sign Up' : 'Sign In'}</button>
                        <button className="btn btn-primary">{isLogging ? 'Sign In' : 'Sign Up'}</button>
                    </div>
                </form>
            </ModalComponent> , document.getElementById("modal-root"))}
            <div className="container">
                <div className="row g-2 py-3">
                    <div className="col-4">
                        <div className="bg-dark text-light rounded p-3">
                            <UserForm addUser={addUserHandler}/>
                        </div>
                    </div>
                    <div className="col-8">
                        <div className="bg-dark text-light rounded p-3">
                            <div className="d-flex justify-content-between align-items-center">
                                <h1>App</h1>
                                <button className="btn btn-primary" >S'ENREGISTRER</button>
                                <button className="btn btn-primary">SE CONNECTER</button>
                                <button className="btn btn-primary"
                                        onClick={() => isLogged ? logOutHandler() : setModalVisible(true)}>{isLogged ? 'Log Out' : 'Show Modal'}</button>
                            </div>
                            <hr/>
                            <UserList users={users} deleteUser={deleteUserHandler} updateUser={UpdateModalHandler}/>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default App;


