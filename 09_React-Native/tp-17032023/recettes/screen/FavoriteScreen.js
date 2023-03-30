
import React from 'react';
import {View , Text , FlatList , StyleSheet , ScrollView , Button} from 'react-native';
import {useSelector} from "react-redux";
import {MEALS} from "../data/data";



export default function FavoriteScreen({navigation}) {
    const mealsFavorite = useSelector((state) => state.fav.id );

    const meals = MEALS.filter((meal) => {
        if (mealsFavorite.includes(meal.id)) {
            return item;
        }

        return (
            <View>
                <FlatList data={meals} renderItem={({item}) => <Text>{item.title}</Text>}
                          keyExtractor={(item , index) => index.toString()}/>
            </View>
        );
    });
const styles = StyleSheet.create({});


