import React, {useState} from 'react';
import {
    SafeAreaView,
    View,
    FlatList,
    StyleSheet,
    Text,
    StatusBar,
    Image
} from 'react-native';
import Data from  '../utils/Data';
import data from "../utils/Data";


const ExpenseDetails = () => {
    const [itemCount, setItemCount] = useState(3);
    const expenses = Data;
        const renderItem = ({item}) => (
        <View style={styles.item}>
            <Image style={styles.avatar} source={
                require('../assets/icons/vide.png')
            } />
            <Text style={styles.title}>{item.title}</Text>
            <Text style={styles.text}>{item.amount}</Text>
            <Text style={styles.text}>{item.date}</Text>
            <Text style={styles.text}>{item.category}</Text>
        </View>
    );

    return (
        <SafeAreaView style={styles.container}>
            <FlatList
                data={data.slice(0, itemCount)}
                renderItem={renderItem}
                keyExtractor={item => item.id}
                showsVerticalScrollIndicator={true}
            />
        </SafeAreaView>
    );
}


const styles = StyleSheet.create({
    container: {
        flex: 1,
        marginTop: StatusBar.currentHeight || 0,
    },
    item: {
        width: '100%',
    },
    avatar: {
          width: 100,
          height: 100,
          alignSelf: 'center',
    },
    title: {
        fontSize: 32,
    },
    text: {
        fontSize: 16,
    },
});

export default ExpenseDetails;