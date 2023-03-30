import firebase from 'firebase/compat/app';
import 'firebase/compat/auth';

const firebaseConfig = {
    apiKey: 'AIzaSyB_yN5HdfzgNt1Py8_7TNKSJzOw9Du0-8Y',
    authDomain: 'app bank-6eb3c.firebaseapp.com',
    databaseURL:
        'https://appbank-6eb3c-default-rtdb.europe-west1.firebasedatabase.app/',
    projectId: 'appbank-6eb3c',
    storageBucket: 'appbank-6eb3c.appspot.com',
    messagingSenderId: '675165589561',
    appId: '1:675165589561:web:542ac1a5e25caf0897fde8',
};

firebase.initializeApp(firebaseConfig);

export default firebase;