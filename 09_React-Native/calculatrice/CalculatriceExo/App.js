import React from 'react';
import {
    Pressable,
    SafeAreaView,
    StyleSheet,
    Text, TextInput,
     View,
} from 'react-native';
import calculator, {initialState} from "./component/Calculation";

export default class App extends React.Component {
   state = initialState;

    HandleTap = (type, value) => {
        this.setState(state => calculator(type, value, state));
    }

    render() {
        return (
            <View style={styles.sectionContainer}>
                <SafeAreaView>
                    <TextInput style={styles.textInput} placeholder="Entrez un nombre:"> {this.state.currentValue}   </TextInput>

                    <Text style={styles.bottom}>
                    <Text style={styles.row}>
                        <Pressable onPress={() => this.HandleTap("clear")}>
                            <Text style={styles.pressableTop}>AC</Text>
                        </Pressable>
                        <Pressable onPress={() => this.HandleTap("pow", "^")} >
                            <Text style={styles.pressableTop}>^</Text>
                        </Pressable>
                        <Pressable onPress={()  => this.HandleTap("percentage")}>
                            <Text style={styles.pressableTop}>%</Text>
                        </Pressable>
                        <Pressable onPress={() => this.HandleTap("operator", "/")}>
                            <Text style={styles.pressableRight}>/</Text>
                        </Pressable>
                    </Text>
                    <Text style={styles.row}>
                        <Pressable onPress={() => this.HandleTap("number",7 )   }>
                            <Text style={styles.pressable}>7</Text>
                        </Pressable>
                        <Pressable onPress={() => this.HandleTap("number",8 )}>
                            <Text style={styles.pressable}>8</Text>
                        </Pressable>
                        <Pressable onPress={() => this.HandleTap("number", 9 )}>
                            <Text style={styles.pressable}>9</Text>
                        </Pressable>
                        <Pressable onPress={()  => this.HandleTap("operator", "*")}>
                            <Text style={styles.pressableRight}>*</Text>
                        </Pressable>
                    </Text>
                    <Text style={styles.row}>
                        <Pressable onPress={() =>  this.HandleTap("number",4 )}>
                            <Text style={styles.pressable}>4</Text>
                        </Pressable>
                        <Pressable onPress={() => this.HandleTap("number",5 )}>
                            <Text style={styles.pressable}>5</Text>
                        </Pressable>
                        <Pressable onPress={() => this.HandleTap("number",6 )}>
                            <Text style={styles.pressable}>6</Text>
                        </Pressable>
                        <Pressable onPress={() => this.HandleTap("operator", "-")}>
                            <Text style={styles.pressableRight}>-</Text>
                        </Pressable>
                    </Text>
                    <Text style={styles.row}>
                        <Pressable onPress={() => this.HandleTap("number",1 )}>
                            <Text style={styles.pressable}>1</Text>
                        </Pressable>
                        <Pressable onPress={() => this.HandleTap("number",2 )}>
                            <Text style={styles.pressable}>2</Text>
                        </Pressable>
                        <Pressable onPress={() => this.HandleTap("number",3 )}>
                            <Text style={styles.pressable}>3</Text>
                        </Pressable>
                        <Pressable onPress={() => this.HandleTap("operator", "+")}>
                            <Text style={styles.pressableRight}>+</Text>
                        </Pressable>
                    </Text>
                    <Text style={styles.row}>
                        <Pressable onPress={()  => this.HandleTap("number", ".")}>
                            <Text style={styles.pressable}>.</Text>
                        </Pressable>
                        <Pressable onPress={() => this.HandleTap("number",0 )}>
                            <Text style={styles.pressable}>0</Text>
                        </Pressable>
                        <Pressable onPress={() => this.HandleTap("clear")}>
                            <Text style={styles.pressable}>Del</Text>
                        </Pressable>
                        <Pressable onPress={() => this.HandleTap("equal", "=")}>
                            <Text style={styles.pressableRight}>=</Text>
                        </Pressable>
                    </Text>
                </Text>
                </SafeAreaView>

            </View>
        );
    }
}



const styles = StyleSheet.create({
    sectionContainer: {
        flex: 1,
        backgroundColor: "#010101",
        paddingVertical: 30,
        paddingHorizontal: 20,
    },
    textInput: {
        textAlign: "right",
        marginTop: 40,
        borderWidth: 1,
        padding: 10,
        color: "grey",
        fontSize: 75,
        height: 200,
    },
    bottom: {
      alignSelf: "center",
    },
    row: {
        flexDirection: "row",
        justifyContent: "space-around",
      alignItems: "center",
    },
    pressableRight: {
        backgroundColor: "#668983",
        borderRadius: 5,
        borderWidth: 1,
        color: "white",
        fontSize: 36,
      textAlign: "center",
      paddingTop: 10,
        width: 80,
        height: 80,
      marginBottom: 10,
    },
        value: {
            color: "#fff",
            fontSize: 42,
            textAlign: "right",
            marginRight: 20,
            marginBottom: 10,
        },
    pressableTop: {
        backgroundColor: "#2F2F39",
        borderRadius: 9,
        borderWidth: 1,
        color: "white",
        fontSize: 36,
        textAlign: "center",
      paddingTop: 10,
        width: 80,
        height: 80,
      marginBottom: 10,
      marginRight: 10,

    },
    pressable: {
        padding: 10,
        backgroundColor: "#fff",
        borderRadius: 1000,
        borderWidth: 1,
        borderColor: "#fff",
        color: "#010101",
        fontSize: 36,
      textAlign: "center",
      paddingTop: 10,
        width: 80,
        height: 80,
      marginBottom: 10,
      marginTop: 10,
      marginRight: 10,

    }
});


