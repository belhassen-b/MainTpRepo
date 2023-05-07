import { useSelector } from "react-redux"
import { Link } from "react-router-dom"

const ContactDisplay = ({contactId}) => {
  const contact = useSelector(state => state.contacts.contacts).find(c => c.id === contactId)


  return (
    <div className="border border-info p-3 m-3 rounded">
      <div className="d-flex align-items-center">
        <h3>{contact.firstname} {contact.lastname}</h3>
        <Link to={`/contacts/edit/${contactId}?mode=edit`} className="ms-auto btn btn-outline-warning p-1 px-2"><i className="bi bi-pencil-square"></i></Link>
        <Link to={`/contacts/delete/${contactId}?mode=delete`} className="ms-2 btn btn-outline-danger p-1 px-2"><i className="bi bi-trash"></i></Link>
      </div>
      <hr />
      <ul>
        <li><b>Email: </b>{contact.email}</li>
        <li><b>Numéro de téléphone: </b>{contact.phone}</li>
      </ul>
    </div>
  )
}

export default ContactDisplay