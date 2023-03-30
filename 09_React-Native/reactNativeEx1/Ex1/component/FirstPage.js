import {Button , FlatList , Image , StyleSheet , Text , View} from 'react-native'
import React , {useState, useEffect} from 'react'
import AddArtModal from "./addArt";
import ArticlesList from "./articlesList";



export default function FirstPage() {
    const [showModal , setShowModal] = useState(false)
    const [tab, setTab]= useState([])

    useEffect(() => {
    } , []);

    const  addToTab = (article) => {
        setTab({...tab, article })
        console.log(tab)
    }



    return (
        <View style={styles.container}>
            <Text >Liste de course !</Text>

            <Text style={styles.instructions}>Cliquer sur le bouton pour ajouter un article sur votre liste de
                course </Text>
            <Button style={styles.button} title="Ajouter Courses" onPress={(
                () => {
                    setShowModal(true)
                }
            )}/>
            <AddArtModal
                visible={showModal}
                onHide={() => setShowModal(false)}
                addToTab={addToTab}
            />
            <FlatList
                data={tab}
                renderItem={({item}) => {
                    return (
                        <View>
                            <Text>Hello</Text>
                            <Text style = {styles.monTexte}>{tab.text}</Text>
                            <Text>{tab.id}</Text>
                        </View>
                    )
                }}
                keyExtractor={tab => tab.id}
            />
        </View>

    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1 ,
        marginTop: '20%' ,
        backgroundColor: '#fff' ,
        alignItems: 'center' ,
        justifyContent: 'center' ,
    } ,
    monTexte: {
        color: '#FF0000' ,
        fontSize: 20 ,
        textAlign: 'center' ,
        marginBottom: 20 ,
    } ,
    // welcome: {
    //     flex: 1 ,
    //     fontSize: 20 ,
    //     textAlign: 'center' ,
    //     marginBottom: 20 ,
    // } ,
    // instructions: {
    //
    //     color: '#333333' ,
    //     marginBottom: 5 ,
    //     marginTop: 30 ,
    // } ,
    button: {
        backgroundColor: '#FF0000' ,
        padding: 10 ,
        borderRadius: 5 ,
        marginTop: 10 ,
    }
});


