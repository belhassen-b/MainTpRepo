import React , {useState} from "react";
import tabs from "./addArt.js";
import {FlatList , Text , View} from "react-native";


export default function ArticlesList() {

 const {list, setList} = useState([tabs]);

return (
    <FlatList data={list} renderItem={({item}) => <View>{item}
    <Text>Hello</Text></View>} />
    );
}









