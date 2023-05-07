import React from 'react';
import ReactDOM from 'react-dom/client';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import './index.css';
import App from './App';
import { Provider } from 'react-redux';
import store from "./Components/store/store";
import {Nav} from "react-bootstrap";
import NavbarAlbum from "./Components/NavbarAlbum/NavbarAlbum";


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
        <Provider store={store}>
            <App/>
        </Provider>
);


