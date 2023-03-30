import React from 'react';
import {View, Text, StyleSheet, Button} from "react-native";

const ExpenseItem = (item) => {
    return (
        <View style={styles.expenseItem}>
            <Button title={'cc'} onPress={() => console.log(item.id)}>Delete</Button>
            <Text>{item.title}</Text>
            <Text>{item.amount}</Text>
            <Text>{item.date}</Text>
        </View>
    )
}

const styles = StyleSheet.create({
    expenseItem: {
        backgroundColor: 'red',
        padding: 10,
        marginVertical: 10,
        marginHorizontal: 20,
        borderRadius: 10,
    }
})

export default ExpenseItem;