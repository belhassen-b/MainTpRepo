import React from 'react';
import { View, Text, StyleSheet } from'react-native';
import { useSelector } from 'react-redux'





const Available = () => {
    // show myBudget from redux store here

    // const myBudget  = useSelector(state => state.budgetSlice.myBudget);


    return (
      <View style={styles.container}>
        <Text style={styles.text}>Available</Text>
      </View>
  );
}

const styles = StyleSheet.create({
  container : {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF'
  },
    text: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
    amount: {
        fontSize: 30,
        textAlign: 'center',
        margin: 10,
    }

});

export default Available;