package org.example.persistence;

import org.example.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class Useful {


    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpJPA");


    public static void createTodo() {
        Scanner scanner = new Scanner(System.in);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Todo todo = new Todo();
        System.out.println("Saisir le titre de la tâche : ");
        todo.setTitle(scanner.nextLine());
        todo.setAchieved(false);
        em.persist(todo);
        System.out.println("La tâche a été ajoutée à la liste");
        em.getTransaction().commit();
        em.close();
    }

    public static void showAllTodos(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Todo> todoList = null;
        todoList = em.createQuery("SELECT t FROM Todo t", Todo.class).getResultList();
        for (Todo t : todoList) {
            System.out.println(t);
        }
        em.getTransaction().commit();
        em.close();
    }

    public static void setTodoAchieved(){
        Scanner scanner = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Saisir l'id de la tâche à marquer comme terminée : ");
        Long id = scanner.nextLong();
        Todo todo = em.find(Todo.class, id);
        todo.setAchieved(true);
        System.out.println("La tâche a été marquée comme terminée");
        em.getTransaction().commit();
        em.close();
    }

    public static void deleteTodo(){
        Scanner scanner = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Saisir l'id de la tâche à supprimer : ");
        Long id = scanner.nextLong();
        Todo todo = em.find(Todo.class, id);
        em.remove(todo);
        System.out.println("La tâche a été supprimée");
        em.getTransaction().commit();
        em.close();

    }

    public static void quit() {
        System.out.println("Au revoir");
        emf.close();
    }


}
