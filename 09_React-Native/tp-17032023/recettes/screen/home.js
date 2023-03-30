import React from "react";

import {FlatList , Pressable , StyleSheet , Text , View} from "react-native";


import {CATEGORIES} from "../data/data";

function HomeScreen({navigation}) {

    return (
        <View style={styles.container}>

            <FlatList
                data={CATEGORIES}
                renderItem={({item}) => <Pressable onPress={() => navigation.navigate('MealsOverview' , {
                    title: item.title ,
                    id: item.id ,
                    imageUrl: item.imageUrl
                })} style={
                    {
                        backgroundColor: item.color ,
                        padding: 10 ,
                        margin: 10 ,
                        borderRadius: 10 ,
                        borderWidth: 1 ,
                        height: 140 ,
                        width: 140 ,
                        justifyContent: 'center' ,
                        alignItems: 'center' ,
                    }
                }>
                    <Text style={styles.text}>{item.title}</Text>
                </Pressable>}
                keyExtractor={item => item.id}
                numColumns={2}
            />
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1 ,
        backgroundColor: '#fff' ,
        alignItems: 'center' ,
        justifyContent: 'center' ,
    } ,
    text: {
        fontSize: 20 ,
        fontWeight: 'bold' ,
    }
});

export default HomeScreen;