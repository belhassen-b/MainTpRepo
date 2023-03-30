import React, { Component } from 'react';
import {
  StyleSheet,
  Text,
  View,
  TouchableOpacity,
} from 'react-native';

export default class SecondDemo extends Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <TouchableOpacity style={styles.button} onPress={() => {}}>
          <Text style={styles.buttonText}>
            Press Me
          </Text>
        </TouchableOpacity>
      </View>
    );
  }

  static navigationOptions = {
    title: 'Second Demo',
  };
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  } ,
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  } ,
  button: {
    backgroundColor: '#337AB7',
    padding: 10,
    borderRadius: 4,
  }
});

