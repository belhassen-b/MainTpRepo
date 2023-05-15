package org.example.demo;

import org.example.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Demo1 {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("GenericDBAdapter");


    public static void main() {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person = new Person("Doe", "John");
        System.out.println("Id de la personne avant la sauvegarde / persist : " + person.getId());
        em.persist(person);
        System.out.println("Id de la personne après la sauvegarde / persist : " + person.getId());
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void main2(){
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, 1L);
        System.out.println(person.getName());
        em.close();
        emf.close();
    }

    public static void remove(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, 1L);
        em.remove(person);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void createquery(){
        EntityManager em = emf.createEntityManager();
em.getTransaction().begin();

Person person = new Person("Doe", "John");
Person person2 = new Person("Dowey", "Jimmy");

em.persist(person);
em.persist(person2);

List<Person> personList = null;
personList = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
for (Person p : personList) {
    System.out.println(p);
}


em.getTransaction().commit();
em.close();
emf.close();
    }

}
