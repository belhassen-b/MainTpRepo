import React , {useRef , useState} from "react";
import {Button , Form , Modal} from "react-bootstrap";
import {useDispatch} from "react-redux";
import {signInAction , signUpAction} from "../reducer/authSlice";

const ModalLogin = (props) => {


    const [signFormMode , setSignFormMode] = useState(true)

    const emailRef = useRef()
    const passwordRef = useRef()
    const dispatch = useDispatch()
    const onSigningHandler = async (event) => {
        event.preventDefault()
        const email = emailRef.current.value
        const password = passwordRef.current.value
        const credentials = {
            email , password , returnSecureToken: true
        }
        emailRef.current.value = ""
        passwordRef.current.value = ""
        if (signFormMode) {
           await dispatch(signInAction(credentials))
        } else {
            await dispatch(signUpAction(credentials))
        }
      props.islogged(true)
        props.onHide()
    }

    return (<>
        <Modal
            show={props.show}
            onHide={props.onHide}
            backdrop="static"
            keyboard={false}
        >
            <Modal.Header closeButton>
                <Modal.Title>{signFormMode?'Connexion' : 'Inscription'}</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form onSubmit={onSigningHandler}>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Email address</Form.Label>
                        <Form.Control type="email" placeholder="Enter email" ref={emailRef}/>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label>Password</Form.Label>
                        <Form.Control type="password" placeholder="Password" ref={passwordRef}/>
                    </Form.Group>
                    <div className="d-flex bd-highlight mb-3">
                        <Button className="p-2 bd-highlight" variant="link"
                                onClick={() => setSignFormMode(!signFormMode)}>{signFormMode ? 'Creer un compte' : 'Se connecter'}</Button>
                        <Button className="ms-auto p-2 bd-highlight" variant="primary"
                                type="submit">{signFormMode ? 'Signin' : 'Signup'}</Button>
                    </div>
                </Form>
            </Modal.Body>
        </Modal>
    </>);
}

export default ModalLogin