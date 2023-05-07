import React from 'react';
import './CardAlbum.css';
import Card from "react-bootstrap/Card";
import {ListGroup} from "react-bootstrap";
import StarRates from "../StarRate/StarRates";


const CardAlbumDisplay = (props) => {
const url2 = props.album.cover.replace(/'/g, '"');


            return (
            <>
                <Card style={{ width: "17rem", padding : "0"}}>
                    <Card.Body style={{ backgroundColor: "black" , color:"white"}}>

                        <Card.Title >{props.album.name}</Card.Title>

                        <Card.Img variant="top" src={url2} />
                        <hr/>
                         <ListGroup  variant="flush">
                            <ListGroup.Item style={{ backgroundColor: "black" , color:"white"}}>Artist: {props.album.artist}</ListGroup.Item>
                            <hr/>
                            <ListGroup.Item style={{ backgroundColor: "black" , color:"white"}}>Release date: {props.album.releaseDate}</ListGroup.Item>
                            <hr/>
                            <ListGroup.Item style={{ backgroundColor: "black" , color:"white"}}>Rate:
                                <StarRates/></ListGroup.Item>
                            <hr/>
                            <ListGroup.Item style={{ backgroundColor: "black" , color:"white"}}>Price: {props.album.price}</ListGroup.Item>
                        </ListGroup>
                    </Card.Body>
                </Card>
            </>
            );
            }

export default CardAlbumDisplay;

