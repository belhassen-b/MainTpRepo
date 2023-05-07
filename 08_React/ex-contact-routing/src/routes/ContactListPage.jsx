import {useRouteError ,  useNavigate} from "react-router-dom"
import React from "react";
import ContactAddPage from "./ContactAddPage";
import {useState} from "react";


export const ContactListPage = () => {
    const error = useRouteError()
    const navigate = useNavigate()
    const [ContactList, setContactList]  = useState({

        contacts: [
        {
            id  : 1,
            name: "John Doe",
            email:  "j.doe@jdoe.fr",
            phone: "555-555-5555"
        },
        {
            id  : 2,
            name: "Jane Doe",
            email:  "j.doe@jdoe.fr",
            phone: "555-555-5555"
        },
        {
            id  : 3,
            name: "John Smith",
            email:  "jsmith@js.fr",
            phone: "555-555-5555"
        },
        {
            id  : 4,
            name: "Jane Smith",
            email:  "jsmith@js.fr",
            phone: "555-555-5555"
        },
        {
            id  : 5,
            name: "Malcom Doe",
            email:  "mdoe@doe.fr",
            phone: "555-555-5555"
        },
        {
            id  : 6,
            name: "Jules Doe",
            email:  "j.doe@jdoe.fr",
            phone: "555-555-5555"
        },
        {
            id  : 7,
            name: "Marius Doe",
            email:  "marius@mdoe.fr",
            phone: "555-555-5555"
        }
    ]
    }
    )


    function    handleSubmit(e) {
        e.preventDefault()
        const FormValues = {
            name: e.target.name.value,
            email: e.target.email.value,
            phone: e.target.phone.value
        }
        console.log(FormValues)
    }

    const handleEdit = (data) => {
        console.log(data)
        navigate('/contact/contactEdit' , {state:{
            id: data.id,
            name: data.name,
            email: data.email,
            phone: data.phone
            }})
    }
const handleAdd = () => {
    navigate('/contact/contactAdd')

    return  <ContactAddPage/>

}

    const handleDelete = (data) => {
        console.log(data)
   ContactList.contacts.filter((current) => {
            return current.id !== data.id
        }
        )
        console.log(ContactList.contacts)
        
    }



    return (
        <>
            <div className="row my-3">
                <div className="col-10 offset-1 bg-dark rounded text-light p-3">
                    <div className="justify-content between">
                        <h4 className="bg bg-dark text-start  text-white m-2">Contact List</h4><hr/>
                        <button className="btn btn-outline-success float-end" onClick={handleAdd}><i className="bi bi-plus"></i>Add</button>
                        <table className="table table-dark table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">Name</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Phone</th>
                                    <th scope="col">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    ContactList.contacts.map((current) => {
                                        return (
                                            <tr key={current.id}>
                                                <td id="name">{current.name}</td>
                                                <td id="email">{current.email}</td>
                                                <td id="email">{current.phone}</td>
                                                <td>
                                                    <button type="button"  onClick={()=>handleEdit(current)} className="btn btn-outline-warning"><i className="bi bi-pencil"></i>Edit</button>
                                                    <button type="button" onClick={() => handleDelete(current)
                                                    } className="btn btn-outline-danger"><i className="bi bi-trash"></i>Delete</button>
                                                </td>
                                            </tr>
                                        )

                                    }
                                    )
}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </>
    )
}






export  default  ContactListPage