import { useSelector } from "react-redux"
import { Link } from "react-router-dom"
import ContactDisplay from "./ContactDisplay"

const ContactsList = () => {
  const contacts = useSelector(state => state.contacts.contacts)



  return (
    <>
      <div className="d-flex align-items-center">
        <h3 className="m-0">Contact List</h3>
        <Link to={`/contacts/add`} className=" ms-auto btn btn-outline-success rounded-circle p-1 px-2"><i className="bi bi-plus"></i></Link>
      </div>
      <hr />
      {contacts.length === 0 ?
      <p>Il n'y a pas de contact dans la base de données !</p> :
      [...contacts].sort((a, b) => a.id.localeCompare(b.id)).map(c => <ContactDisplay key={c.id} contactId={c.id} />)}
    </>
  )
}

export default ContactsList