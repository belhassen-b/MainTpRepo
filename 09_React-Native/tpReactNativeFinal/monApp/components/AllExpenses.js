import React from 'react';
import {View, Text, StyleSheet, Image, SafeAreaView, Pressable} from "react-native";
import { FlatList } from 'react-native-gesture-handler';
import Data from '../utils/Data';
import {Avatar} from "react-native-elements";
import {useNavigation} from "@react-navigation/native";



const AllExpenses = () => {
    const expenses = Data;
    const navigation = useNavigation();

    const renderItem = ({item}) => {
        return (
            <View style={{flexDirection: 'row', alignItems: 'center', justifyContent: 'space-between', padding: 10, borderBottomWidth: 1, borderBottomColor: '#ccc'}}>
                <View style={{flexDirection: 'row', alignItems: 'center'}}>
                    <Pressable onPress={() => navigation.navigate('ExpenseItem', {item})}>
                    <Avatar rounded source={{uri: item.image}} />
                    <View style={{marginLeft: 10}}>
                        <Text style={styles.title}>{item.title}</Text>
                        <Text style={styles.text}>{item.date}</Text>
                    </View>
                    </Pressable>
                </View>
                <Text style={styles.text}>${item.amount}</Text>
            </View>
        );
    }




        return (
            <SafeAreaView style={styles.container}>
                <FlatList style={styles.list}
                    data={expenses}
                    renderItem={renderItem}
                    keyExtractor={item => item.id}
                />
            </SafeAreaView>
        );
    }

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
    list: {
        width: '100%',
        height: '100%',
        backgroundColor: '#fff',
        padding: 10,
    },
    title: {
        fontSize: 18,
        fontWeight: 'bold',
        color: '#000',
    },
    text: {
        fontSize: 16,
        color: '#000',
    }
});

export default AllExpenses;