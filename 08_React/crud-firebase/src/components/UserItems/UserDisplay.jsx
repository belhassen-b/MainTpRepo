import React , {useState} from 'react'
import {createPortal} from "react-dom";
import {ModalUpdateComponent} from "../shared/ModalUpdate";


const UserDisplay = (props) => {
    const [modalVisible, setModalVisible] = useState(false)

    const user = props.user
  return (
    <div className="container d-flex">
    <div className="card border border-light w-100 bg bg-dark  " >
        <div className="card-body text-white m-3 ">
 <div>
    <img src={user.image} alt="user" className="rounded-circle w-25 float-start me-3" />
   <hr className="vertical"/>

 </div>
    <h5 className="ms-3 d-inline-flex w-auto card-title">{user.name} {user.firstName}</h5>
            <hr/>
    <ul className="card-text">
    <li>Age: {user.age}</li>
    <li>Email: {user.email}</li>
    <li>Téléphone: {user.phone}</li>
      </ul>
    <button className="btn btn-warning" onClick={()=>setModalVisible(true)} >Modifier</button>
    <button className="btn btn-danger" onClick={()=>props.deleteUser(props.user.id)}>Supprimer</button>
    </div>
    </div>
        {modalVisible && createPortal(
            <ModalUpdateComponent closeModal={()=>setModalVisible(false)}>
                <div className="container">
                    <div className="row">
                        <div className="col-12">
                            <h1>Modal Update</h1>



    </div>
    </div>
    </div>
    </ModalUpdateComponent>, document.getElementById('modal-root'))}
    </div>

    )
}

export default UserDisplay