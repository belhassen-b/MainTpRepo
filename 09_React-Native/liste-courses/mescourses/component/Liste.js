import {Button, FlatList, StyleSheet, Text, View} from 'react-native';
import React, {useEffect, useState} from 'react';
import ModalInput from './ModalInput';
import Article from './Article';
import AsyncStorage from '@react-native-async-storage/async-storage';

export default function Liste() {
  const [modalIsVisible, setModalIsVisible] = useState(false); // state pour ma modal
  const [articles, setArticles] = useState([]);

  useEffect(() => {
    if (articles.length <= 0) {
      getData();
    } else {
      SetData();
    }
  }, [articles]);

  const getData = async () => {
    try {
      const mesArticles = await AsyncStorage.getItem('articles');
      if (mesArticles !== null) {
        setArticles(JSON.parse(mesArticles));
      }
    } catch (e) {
      console.log(e);
    }
  };

  const SetData = async () => {
    try {
      const mesArticles = JSON.stringify(articles);
      await AsyncStorage.setItem('articles', mesArticles);
    } catch (e) {
      console.log(e);
    }
  };

  function openModale() {
    console.log('clique sur bouton ajouter article');
    setModalIsVisible(true);
  }

  function closeModale() {
    console.log('clique sur bouton de ma modal pour fermer ma modal');
    setModalIsVisible(false);
  }

  function addArticle(article) {
    AsyncStorage.setItem('articles', JSON.stringify(articles));
    setArticles(articlesCurrent => {
      return articlesCurrent.concat([
        {text: article, id: Math.random().toString()},
      ]);
    });
    console.log('Ajout d un article à ma liste : ' + article);

    setModalIsVisible(false); // closeModale()
  }

  function deleteArticle() {
    setArticles(articlesCurrent => {
      return articlesCurrent.filter(item => item.id != id);
    });
    console.log('Suppression d un article à ma liste : ' + id);
  }

  return (
    <View>
      <Text>Liste des articles</Text>

      <Button title="Ajouter Article" onPress={openModale} />
      <ModalInput
        visible={modalIsVisible}
        closeModale={closeModale}
        addArticle={addArticle}
      />
      <FlatList
        data={articles}
        renderItem={itemData => {
          return (
            <Article
              text={itemData.item.text}
              id={itemData.item.id}
              item={itemData.item}
              deleteArticle={deleteArticle}
            />
          );
        }}
        keyExtractor={(item, index) => {
          return item.id;
        }}
      />
    </View>
  );

  const styles = StyleSheet.create({
    container: {
      flex: 1,
      paddingTop: 20,
      paddingHorizontal: 16,
    },
  });
}
