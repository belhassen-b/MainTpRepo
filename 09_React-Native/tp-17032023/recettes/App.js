import React from "react";
import {NavigationContainer} from "@react-navigation/native";
import {createStackNavigator} from '@react-navigation/stack';
import { createDrawerNavigator } from '@react-navigation/drawer'



import HomeScreen from "./screen/home";
import FavoriteScreen from "./screen/FavoriteScreen";
import MealDetail from "./screen/mealDetail";
import MealsOverview from "./screen/mealsOverview";
import {CATEGORIES} from "./data/data";
import {Provider} from "react-redux";
import {store} from "./store/redux/store";


const Stack = createStackNavigator();
const Drawer = createDrawerNavigator();



function DrawerNavigator() {
    return (
        <Drawer.Navigator>
            <Drawer.Screen name="Categories" component={HomeScreen} options={{ title: 'All Categories' }} />
            <Drawer.Screen name="Favoris" component={FavoriteScreen} options={{ title: 'Mes recettes favorites' }} />
        </Drawer.Navigator>
    )

}

function App() {
const categoriesName = [CATEGORIES.title];
    return (
        <Provider store={store}>
        <NavigationContainer>
            <Stack.Navigator>
                {/*<Stack.Screen name="Mes recettes" component={HomeScreen}/>*/}
                <Stack.Screen name="Drawer" component={DrawerNavigator} options={{ headerShown: false }} />

                <Stack.Screen name="MealDetail" component={MealDetail}/>
                <Stack.Screen name="MealsOverview" component={MealsOverview}/>
            </Stack.Navigator>
        </NavigationContainer>
        </Provider>
    );
}

export default App;

