package org.example.entity;


import javax.persistence.*;

@Entity
//annotation @Table(name = "person") optionnelle par défaut le nom de la table est le nom de la classe
public class Person {

    @Id
    // annotation @Id pour indiquer que la propriété id est la clé primaire de la table
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    // spécfier la génération automatique des valeurs d'une propriété identifiée comme clé primaire ou clé unique²²²²²²²²²²²²²
    private Long id;

    @Basic
    //annotation @Basic pour indiquer que la propriété name est une colonne de la table falcutative par défaut
    @Column  (name = "name")
// annotation @Column optionnelle par défaut le nom de l'attribut est le nom de la colonne
    private String name;

    private String firstName;

    @Transient
    // annotation @Transient pour indiquer que la propriété age n'est pas une colonne de la table
    private int age;

//on doit créer un constructeur vide pour que hibernate puisse instancier la classe
// puis les setters et getters pour accéder aux propriétés de la classe
    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, String firstName) {
        this.name = name;
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
