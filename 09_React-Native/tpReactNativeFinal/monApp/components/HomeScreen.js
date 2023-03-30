import {View, Text, StyleSheet, Button, Pressable} from 'react-native';
import React from 'react';
import AllExpenses from "./AllExpenses";
import Available from "./Available";
import Budget from "./Budget";
import ExpenseDetails from "./ExpenseDetails";
import {useNavigation} from "@react-navigation/native";

const HomeScreen = () => {
    const navigator = useNavigation();

    return (
        <View style={styles.container}>
            <Text style={styles.title}>Bienvenue sur mon Application </Text>
            <View>
                <View style={styles.rowDisplay}>
                    <Pressable style={styles.button} onPress={() => navigator.navigate('Budget')}>
                        <Text>Définir mon budget</Text>
                    </Pressable>
                    <Available/>
                    <Pressable style={styles.button} onPress={() => navigator.navigate('All')}>
                        <Text>All Expenses</Text>
                    </Pressable>
                </View>
            </View>
                <View >
                    <ExpenseDetails/>
                </View>
            </View>

    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
        backgroundColor: '#F5FCFF',
    },
    rowDisplay: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        marginHorizontal: 20,
        marginVertical: 10,
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
        borderRadius: 10,
        padding: 10,
        shadowColor: '#000',
        shadowOffset: {width: 0, height: 2},
        shadowOpacity: 0.2,
        shadowRadius: 2,
        elevation: 1,
        width: 400,
    },
    rowDisplay2: {
        flexDirection: 'row',
        marginTop: 10,
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
        borderRadius: 10,
        padding: 10,
        shadowColor: '#000',
        shadowOffset: {width: 0, height: 2},
        shadowOpacity: 0.2,
        shadowRadius: 2,
        elevation: 1,
        width: 400,
    },
    title: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
});


export default HomeScreen;
