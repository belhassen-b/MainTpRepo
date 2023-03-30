import React, {useState} from 'react';
import {View, StyleSheet, TextInput, Button} from 'react-native';
import {useNavigation} from '@react-navigation/native';
import firebase from '../config/firebaseConfig';

const LoginForm = () => {
    const [email, setMail] = useState('');
    const [password, setPassword] = useState('');
    const [name, setName] = useState('');
    const [user, setUser] = useState(null);
    const navigator = useNavigation();

     const handleLogin = async () => {
        try {
            const response = await firebase
                .auth()
                .signInWithEmailAndPassword(email, password);
            setUser(response.user);
            setName(response.user.displayName);
            console.log(user);
            console.log(name);
            if (user) {
                console.log('User logged in successfully');
            }
            await navigator.navigate('Home');
        } catch (error) {
            console.log(error);
        }
    };
    return (
        <View style={styles.container}>
            <TextInput
                label="Name"
                value={name}
                placeholder={'Enter your name'}
                onChangeText={(text) => setName(text)}
                style={styles.input}
            />
            <TextInput
                label="Email"
                value={email}
                placeholder={'Enter your email'}
                onChangeText={(text) => setMail(text)}
                style={styles.input}
            />
            <TextInput
                label="Password"
                value={password}
                placeholder={'Enter your password'}
                onChangeText={text => setPassword(text)}
                style={styles.input}
            />
            <Button mode="contained" onPress={handleLogin} style={styles.button} title={'Login'}>
                Login
            </Button>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        paddingHorizontal: 16,
        paddingTop: 32,
        paddingBottom: 32,
        flex: 1,
        justifyContent: 'center',
        // alignItems: 'center',
        borderRadius: 8,
    },
    input: {
        marginBottom: 16,
        borderWidth: 1,
        borderColor: '#ccc',
        padding: 8,
    },
    button: {
        marginTop: 16,
    },
});

export default LoginForm;