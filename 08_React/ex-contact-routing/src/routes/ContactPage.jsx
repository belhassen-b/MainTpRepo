import {useLocation , useRouteError , useSearchParams} from "react-router-dom"
import contactListPage from "./ContactListPage"
import {useState} from "react";



const ContactPage = () => {
    const error = useRouteError()
    const { state } = useLocation()
    const [name, setName] = useState(state.name)
    const [email, setEmail] = useState(state.email)
    const [phone, setPhone] = useState(state.phone)

    function   handleSubmit(e) {
        e.preventDefault()
        const FormValues = {
            name: e.target.name.value,
            email: e.target.email.value,
            phone: e.target.phone.value
        }
        console.log(FormValues)

    }




    return (
<main className="container">
    <div className="row my-3">
        <div className="col-10 offset-1 bg-dark rounded text-light p-3">
            <form onSubmit={handleSubmit}>
            <div className="form-group">
                  <label htmlFor="name">Name</label>
                    <input type="text" className="form-control" id="name" name="name" defaultValue={state.name} />
                <hr/>
                <label htmlFor="email">Email</label>
                    <input type="email" className="form-control" id="email" name="email" defaultValue={state.email} />
                <hr/>
                <label htmlFor="phone">Phone</label>
                    <input type="text" className="form-control" id="phone" name="phone" defaultValue={state.phone} />
                <hr/>
<button type="submit" className="btn btn-outline-light">Submit</button>
            </div>
            </form>
        </div>
    </div>
</main>
        );
    }


export  default  ContactPage