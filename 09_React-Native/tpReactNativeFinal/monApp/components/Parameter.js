import {View, Text, StyleSheet, Button, TextInput} from 'react-native';

const [budget, setBudget] = useState(0)


    // @ts-ignore
    return (
        <View style={styles.container}>
            <Text style={styles.text}>Parameter</Text>
            <Text style={styles.text}>Définir le budget </Text>
        <TextInput style={styles.input} placeholder="Budget" keyboardType="numeric"  value={
            budget
        } onChangeText={(text) => setBudget(text)} />
            <Button title="Valider" onPress={}> navigation.navigate('Home') </Button>
        </View>
    )


const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
    text: {
        fontSize: 20,
        color: 'black',
        fontWeight: 'bold',
        marginBottom: 10,
    },
    input: {
        height: 40,
        width: 200,
        margin: 12,
        borderWidth: 1,
        padding: 10,
    }
})

export default Parameter