import React, {useState} from 'react';
import {Text, View, StyleSheet, TextInput, Button} from "react-native";
import {useDispatch} from "react-redux";



const Budget = () => {
    const dispatch = useDispatch();
    const [budget, setBudget] = useState('0');

    function addBudget(){
        dispatch({type: 'ADD_BUDGET', budget: budget})
    }

    return (
        <View style={styles.container}>
            <Text style={StyleSheet.text}>Mon Budget</Text>
            <Text style={StyleSheet.text}>{budget}</Text>
            <TextInput
                style={styles.input}
                onChangeText={text => setBudget(text)}
                value={budget}
                placeholder="Budget"
                keyboardType="numeric"
            />
            <Button
                title="Ajouter"
                onPress={() => addBudget()}
            />
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF'
    },
    text: {
        fontSize: 13,
        color: 'red',
    },
});

export default Budget;