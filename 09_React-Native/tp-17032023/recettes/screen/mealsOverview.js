import {FlatList , Image , Pressable , StyleSheet , Text , View} from "react-native";
import React , {useEffect} from "react";
import {MEALS} from "../data/data";


function MealsOverview(props) {
    const item = props.route.params;
    const selectedMeal = MEALS.find(meal => meal.categoryIds.includes(item.id));
    const title = props.route.params.title;


    useEffect(() => {
        props.navigation.setOptions({
            title: title ,
        });
    } , [title , props.navigation]);

    return (
        <View style={styles.screen}>
            <FlatList data={
                MEALS.filter(meal => meal.categoryIds.includes(item.id))} renderItem={
                ({item}) =>
                    <Pressable style={styles.press} onPress={() => {
                props.navigation.navigate('MealDetail' , {mealId: item.id}) }}>
                        <Image style={styles.image} source={{uri: item.imageUrl}}/>
                        <Text style={styles.text} onPress={() => props.navigation.navigate('MealDetail' , {mealId: item.id})}>{item.title}</Text>
                        <Text style={styles.textBis} onPress={() => props.navigation.navigate('MealDetail' , {mealId: item.id})}>{item.duration} min {item.complexity} {item.affordability}</Text>
                    </Pressable>
            } keyExtractor={(item , index) => index.toString()} key={

                ({item}) => item.id
            }
            />
        </View>
    );
}


const styles = StyleSheet.create({
    screen: {
        backgroundColor: '#F2F2F2' ,
        marginTop: 30 ,
        alignItems: 'center' ,
        justifyContent: 'center' ,
        borderRadius: 20 ,


    } ,
    press: {
        backgroundColor: '#FFFF' ,
        padding: 0 ,
        marginLeft: 10 ,
        margin: 10 ,
        height: 260 ,
        borderRadius: 10 ,
        alignItems: 'center' ,

    } ,
    text: {
        color: 'grey' ,
        fontSize: 15 ,
        fontWeight: 'bold' ,
        textAlign: 'center' ,
        marginTop: 10 ,

    } ,
    textBis: {
        color: 'grey' ,
        fontSize: 12.5 ,
        fontWeight: 'bold' ,
        textAlign: 'center' ,
        marginTop: 5 ,
        marginBottom: 5 ,
    } ,

    image: {
        width: 300 ,
        height: 200 ,
        borderTopLeftRadius: 10 ,
        borderTopRightRadius: 10 ,

    }
});


export default MealsOverview;
