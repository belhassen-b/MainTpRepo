import React , {useLayoutEffect} from 'react';
import {Button , Image , ScrollView , StyleSheet , Text , View} from 'react-native';
import {useNavigation , useRoute} from '@react-navigation/native';
import {MEALS} from "../data/data";



function MealDetail() {

    const navigation = useNavigation();
    const route = useRoute();
    const {mealId} = route.params;
    const selectedMeal = MEALS.find(meal => meal.id === mealId);
    const selectedTitle = selectedMeal.title;


    // set title to header
    useLayoutEffect(() => {
        navigation.setOptions({
            title: selectedTitle ,
        });
    } , [selectedTitle , navigation]);
//---


        return (
            <View style={styles.container}>
                <Image source={{uri: selectedMeal.imageUrl}} style={styles.image}/>
                <Button title={'ajouter aux favoris'} onPress={() => dispatch(addIds({ id : getFavorite.id}))}/>
                <Text style={styles.title}>{selectedMeal.title}</Text>
                <Text>{selectedMeal.duration} min {selectedMeal.complexity} {selectedMeal.affordability}</Text>
                <ScrollView>
                    <Text style={styles.subtitle}>Ingredients</Text>
                    <Text style={styles.hr}>----------------------</Text>

                    {
                        selectedMeal.ingredients.map(
                            (ingredient , index) => <Text key={index} style={styles.txtingredients}>{ingredient}</Text>
                        )
                    }
                    <Text style={styles.subtitle}>Steps</Text>
                    <Text style={styles.hr}>----------------------</Text>
                    {selectedMeal.steps.map((step , index) => <Text key={index}
                                                                    style={styles.txtingredients}>{step}</Text>)}
                </ScrollView>
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
        title: {
            fontSize: 20 ,
            fontWeight: 'bold' ,
            color: '#000' ,
            marginTop: 20 ,
            marginBottom: 20 ,
        } ,
        subtitle: {
            fontSize: 16 ,
            fontWeight: 'bold' ,
            color: '#E6B796' ,
            marginTop: 20 ,
            marginBottom: 5 ,
            textAlign: "center" ,
            padding: 0 ,
        } ,
        ingredients: {
            marginTop: 20 ,
            marginBottom: 20 ,
        } ,
        hr: {
            height: 2 ,
            width: '100%' ,
            backgroundColor: '#E6B796' ,
            marginBottom: 10 ,

        } ,
        txtingredients: {
            fontSize: 14 ,
            color: '#000' ,
            fontWeight: 'bold' ,
            marginBottom: 20 ,
            backgroundColor: '#E6B796' ,
            textAlign: 'center' ,
            padding: 10 ,
            borderRadius: 10 ,

            width: 350 ,
        } ,
        image: {
            width: '95%' ,
            height: '40%' ,
        } ,

    });


    export default MealDetail;
