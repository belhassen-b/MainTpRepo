import {Button , Image , Modal , Pressable , StyleSheet , Text , TextInput , View} from 'react-native';
import React , {useState} from 'react';


export default function AddArtModal(props) {
    const [text , setText] = useState('');
    const [id , setId] = useState(0);


    function addArt() {
        let article = {
            id: id ,
            text: text
        }
        if (text.length > 0) {
            props.addToTab(article);
            setId(id + 1);
        }
        setText('');
        props.onHide();
    }


    return (
        <Modal visible={props.visible}>
            <View style={styles.container}>


                <Text style={styles.text}>Ajouter votre article</Text>
                <Pressable style={styles.pressed} onPress={props.onHide}>
                    <Image source={
                        require('./assets/caddie.jpeg')
                    }
                           style={{width: 100 , height: 100 , resizeMode: 'contain'}}

                    />
                </Pressable>

                <TextInput style={styles.text} id="article" placeholder="Saisir l'article"
                           onChangeText={text => setText(text)}/>
            </View>
            <View style={styles.row}>
                <Pressable style={styles.buttons} onPress={() => {
                    addArt();
                }}><Text style={styles.text}>Ajouter</Text>
                </Pressable>
                <Pressable style={styles.buttons} color="warning" title="Annuler" onPress={props.onHide}>
                    <Text style={styles.text}>Annuler</Text>
                </Pressable>
            </View>
        </Modal>
    );
}


const styles = StyleSheet.create({
    container: {
        flex: 1 ,
        backgroundColor: 'lightgrey' ,
        alignItems: 'center' ,
        justifyContent: 'center' ,
    } ,
    text: {
        color: '#fff' ,
        fontSize: 25 ,
        textAlign: 'center' ,
    } ,
    pressed: {
        alignItems: 'center' ,
        justifyContent: 'center' ,
        width: 100 ,
        height: 100 ,
        marginRight: 10 ,
        paddingTop: 10 ,
        paddingBottom: 10 ,
        borderRadius: 10 ,
        elevation: 3 ,
        backgroundColor: 'orange'
    } ,
    row: {
        flex: 1 ,
        flexDirection: 'row' ,
        justifyContent: 'center' ,
        alignItems: 'center' ,
    } ,
    buttons: {
        alignItems: 'center' ,
        justifyContent: 'center' ,
        width: 120 ,
        height: 50 ,
        marginRight: 10 ,
        paddingTop: 10 ,
        paddingBottom: 10 ,
        borderRadius: 10 ,
        elevation: 3 ,
        backgroundColor: 'orange'
    }
});





