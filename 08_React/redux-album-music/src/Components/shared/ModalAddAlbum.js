import React , {useRef , useState} from "react";
import {Button , Form , Modal} from "react-bootstrap";
import StarRates from "../StarRate/StarRates";



const ModalAddAlbum = (props) => {

function handleSubmit(event) {
    event.preventDefault();
const album = {
    name: event.target[0].value,
    artist: event.target[1].value,
    releaseDate: event.target[2].value,
    rate: event.target[3].value,
    price: event.target[4].value,
    cover: event.target[5].value,
}
props.addAlbum(album)
    props.onHide()
}



    return (
        <Modal show={props.show} onHide={props.onHide}>
            <Modal.Header closeButton>
                <Modal.Title>Add Album</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form onSubmit={handleSubmit}>
                    <Form.Group className="mb-3" controlId="formBasic">
                        <Form.Label>Album Name</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Enter album name"
                        />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="formBasic">
                        <Form.Label>Artist Name: </Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Enter artist name"
                        />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="formBasic">
                        <Form.Label>Release Date</Form.Label>
                        <Form.Control
                            type="date"
                            placeholder="Enter release date"
                        />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="formBasic">
                        <Form.Label>Rate</Form.Label>
                        <Form.Control
                            type="number"
                            placeholder="Enter rate"
                            id="rate" onClick=setRate(index

                                            </Form.Group>
                    <Form.Group className="mb-3" controlId="formBasic">
                        <Form.Label>Price:</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Enter price"
                        />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="formBasic">
                        <Form.Label>Album Image</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Enter album image url"

                        />
                    </Form.Group>
                    <Button variant="primary" type="submit" >
                        Add
                    </Button>
                    <Button variant="secondary">
                        Close
                    </Button>
                </Form>
            </Modal.Body>

        </Modal>
    );
}

export default ModalAddAlbum;