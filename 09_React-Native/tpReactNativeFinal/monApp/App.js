import React from "react";
import { Provider } from 'react-redux'
import { store } from './store/store'
import LoginForm from "./components/LoginForm";
import {NavigationContainer} from '@react-navigation/native'
import {createNativeStackNavigator} from '@react-navigation/native-stack'
import HomeScreen from "./components/HomeScreen";
import AllExpenses from "./components/AllExpenses";
import ExpenseItem from "./components/ExpenseItem";
import Budget from "./components/Budget";


const Stack = createNativeStackNavigator()

export default function App() {
    return (
        <Provider store={store}>
        <NavigationContainer>
            <Stack.Navigator initialRouteName='Home'>
                <Stack.Screen name="Home" component={HomeScreen}/>
                <Stack.Screen name="Login" component={LoginForm}/>
                <Stack.Screen name="Budget" component={Budget}/>
                <Stack.Screen name="All" component={AllExpenses}/>
                <Stack.Screen name="ExpenseItem" component={ExpenseItem}/>
            </Stack.Navigator>
        </NavigationContainer>
        </Provider>

    );
}