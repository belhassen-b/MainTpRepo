

// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";
import { getDatabase } from "firebase/database";

import firebase from "firebase/compat/app";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
    apiKey: "AIzaSyCJ3KzjFkHkXHnKiGfQSA2LX2ONVGcTpbM",
    authDomain: "m2i-demo-auth.firebaseapp.com",
    databaseURL: "https://m2i-demo-auth-default-rtdb.europe-west1.firebasedatabase.app",
    projectId: "m2i-demo-auth",
    storageBucket: "m2i-demo-auth.appspot.com",
    messagingSenderId: "62821629701",
    appId: "1:62821629701:web:40c555e3ee3abba63d816c"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const database = getDatabase();
export const auth = getAuth(app);
export default database

