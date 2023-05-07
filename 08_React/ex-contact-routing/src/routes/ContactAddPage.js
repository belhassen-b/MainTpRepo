import axios from "axios";
import {useRef} from "react";
import contactListPage from "./ContactListPage";


const ContactAddPage = () => {

    const nameRef = useRef();
    const emailRef = useRef();
    const phoneRef = useRef();

    const handleSubmit = (e) => {
        e.preventDefault();
        const id = Math.floor(Math.random() * 10000) + 1;
        const name = nameRef.current.value;
        const email = emailRef.current.value;
        const phone = phoneRef.current.value;
        const contact = {id, name, email, phone};
        console.log(contact);

       // push contact to contactListPage array
        contactListPage.push(contact);
        console.log(contactListPage);

    }

          return (

     <div>

        <h1>Contact Add Page</h1>
         <form>
              <div className="form-group">
                <label htmlFor="name">Name</label>
                <input type="text" className="form-control" id="name" placeholder="Enter name" ref={nameRef}  />
                  <hr/>
                  <label htmlFor="email">Email address</label>
                    <input type="email" className="form-control" id="email" placeholder="Enter email" ref={emailRef}  />
                    <hr/>
                    <label htmlFor="phone">Phone</label>
                    <input type="text" className="form-control" id="phone" placeholder="Enter phone" ref={phoneRef}/>
                    <hr/>
                  <button   className="btn btn-primary" onClick={handleSubmit}> </button>
     </div>
    </form>
    </div>

      );

}

export  default ContactAddPage;