package org.example.controller;


import com.sun.jdi.request.VMDeathRequest;
import org.example.dao.impl.ActivityDAOImpl;
import org.example.dao.impl.CoachDAOImpl;
import org.example.dao.impl.MemberDAOImpl;
import org.example.model.Activity;
import org.example.model.Category;
import org.example.model.Coach;
import org.example.model.Member;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import  java.util.Scanner;

public class AppConsole {

    private static CoachDAOImpl coachDAO;
    private static ActivityDAOImpl activityDAO;
    private static MemberDAOImpl memberDAO;


    public static void main() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("centreSportif");
        coachDAO = new CoachDAOImpl(emf);
        activityDAO = new ActivityDAOImpl(emf);
        memberDAO = new MemberDAOImpl(emf);

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Gestion des membres");
            System.out.println("2. Gestion des activités");
            System.out.println("3. Gestion des coachs");
            System.out.println("4. Gestion des salles");
            System.out.println("0. Quitter");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> menuMember(sc);
                case 2 -> menuActivity(sc);
                case 3 -> menuCoach(sc);
                case 0 -> {
                    System.out.println("Au revoir !");
                    emf.close();
                }
                default -> System.out.println("Veuillez saisir un choix valide !");
            }
        } while (choice != 0);
    }


    // menu de gestion des membres
    private static void menuMember(Scanner sc) {
        int choice;
        do {
            System.out.println("1. Ajouter un membre");
            System.out.println("2. Modifier un membre");
            System.out.println("3. Supprimer un membre");
            System.out.println("4. Afficher les membres");
            System.out.println("0. Quitter");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> createMember(sc);
                case 2 -> updateMember(sc);
                case 3 -> deleteMember(sc);
                case 4 -> showMembers();
                case 0 -> System.out.println("Retour au menu principal");
                default -> System.out.println("Veuillez saisir un choix valide !");
            }
        } while (choice != 0);
    }


    // Ajout d'un membre + choix d'une activité
    private static void createMember(Scanner sc) {
        System.out.println("Veuillez saisir le nom du membre : ");
        String name = sc.nextLine();
        System.out.println("Veuillez saisir le prénom du membre : ");
        String firstName = sc.nextLine();
        Member member = new Member();
        member.setLastName(name);
        member.setFirstName(firstName);
        if (memberDAO.createMemberDAO(member)) {
            System.out.println("Le membre a bien été ajouté !");
        } else {
            System.out.println("Une erreur est survenue lors de l'ajout du membre !");
        }
        System.out.println("Voulez-vous ajouter une autre activité ? (y/n)");
        String choice = sc.nextLine();
        if (choice.equals("y")) {
            createMember(sc);
        } else {
            System.out.println("Retour au menu principal");
            main();
        }
    }

    // Modification d'un membre
    private static void updateMember(Scanner sc) {
        System.out.println("Veuillez saisir l'id du membre à modifier : ");
        showMembers();
        Long id = sc.nextLong();
        sc.nextLine();
        Member member = memberDAO.getMemberDAOById(id);
        if (member != null) {
            System.out.println("Veuillez saisir le nouveau nom du membre : ");
            String name = sc.nextLine();
            System.out.println("Veuillez saisir le nouveau prénom du membre : ");
            String firstName = sc.nextLine();
            member.setLastName(name);
            member.setFirstName(firstName);
            if (memberDAO.updateMemberDAO(member)) {
                System.out.println("Le membre a bien été modifié !");
            } else {
                System.out.println("Une erreur est survenue lors de la modification du membre !");
            }
        } else {
            System.out.println("Le membre n'existe pas !");
            main();
        }
    }

    // Suppression d'un membre
    private static void deleteMember(Scanner sc) {
        System.out.println("Veuillez saisir l'id du membre à supprimer : ");
        showMembers();
        Long id = sc.nextLong();
        sc.nextLine();
        Member member = memberDAO.getMemberDAOById(id);
        if (member != null) {
            if (memberDAO.deleteMemberDAO(member.getId())) {
                System.out.println("Le membre a bien été supprimé !");
            } else {
                System.out.println("Une erreur est survenue lors de la suppression du membre !");
            }
        } else {
            System.out.println("Le membre n'existe pas !");
            main();
        }
    }

    // Affichage des membres
    private static void showMembers() {
        List<Member> members = memberDAO.getAllMembersDAO();
        for (Member member : members) {
            System.out.println("Id : " + member.getId() + " Nom : " + member.getLastName() + " Prénom : " + member.getFirstName() + " Activité : " + member.getActivities());
        }
    }


    // menu de gestion des coachs
    private static void menuCoach(Scanner sc) {
        int choice;
        do {
            System.out.println("1. Ajouter un coach");
            System.out.println("2. Modifier un coach");
            System.out.println("3. Supprimer un coach");
            System.out.println("4. Afficher les coachs");
            System.out.println("0. Quitter");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> createCoach(sc);
                case 2 -> updateCoach(sc);
                case 3 -> deleteCoach(sc);
                case 4 -> showCoaches();
                case 0 -> System.out.println("Retour au menu principal");
                default -> System.out.println("Veuillez saisir un choix valide !");
            }
        } while (choice != 0);
    }


    // creation d'un coach
    private static void createCoach(Scanner sc) {
        System.out.println("Veuillez saisir le nom du coach : ");
        String name = sc.nextLine();
        System.out.println("Veuillez saisir le prénom du coach : ");
        String firstName = sc.nextLine();
        Coach coach = new Coach();
        coach.setLastName(name);
        coach.setFirstName(firstName);
        if (coachDAO.createCoachDAO(coach)) {
            System.out.println("Le coach a bien été ajouté !");
        } else {
            System.out.println("Une erreur est survenue lors de l'ajout du coach !");
        }
    }

    // Modification d'un coach
    private static void updateCoach(Scanner sc) {
        System.out.println("Veuillez saisir l'id du coach à modifier : ");
        showCoaches();
        Long id = sc.nextLong();
        sc.nextLine();
        Coach coach = coachDAO.getCoachDAOById(id);
        if (coach != null) {
            System.out.println("Veuillez saisir le nouveau nom du coach : ");
            String name = sc.nextLine();
            System.out.println("Veuillez saisir le nouveau prénom du coach : ");
            String firstName = sc.nextLine();
            coach.setLastName(name);
            coach.setFirstName(firstName);
            if (coachDAO.updateCoachDAO(coach)) {
                System.out.println("Le coach a bien été modifié !");
            } else {
                System.out.println("Une erreur est survenue lors de la modification du coach !");
            }
        }
    }


    // Suppression d'un coach
    private static void deleteCoach(Scanner sc) {
        System.out.println("Veuillez saisir l'id du coach à supprimer : ");
        showCoaches();
        Long idCoach = sc.nextLong();
        sc.nextLine();
        Coach coach = coachDAO.getCoachDAOById(idCoach);
        if (coach != null) {
            if (coachDAO.deleteCoachDAO(coach.getId())) {
                System.out.println("Le coach a bien été supprimé !");
            } else {
                System.out.println("Une erreur est survenue lors de la suppression du coach !");
            }
        }
    }

    // Affichage des coachs
    private static void showCoaches() {
        List<Coach> coaches = coachDAO.getAllCoachesDAO();
        for (Coach coach : coaches) {
            System.out.println("Id : " + coach.getId() + " Nom : " + coach.getLastName() + " Prénom : " + coach.getFirstName() );
        }
    }


    // menu de gestion des activités
    private static void menuActivity(Scanner sc) {
        int choice;
        do {
            System.out.println("1. Ajouter une activité");
            System.out.println("2. Modifier une activité");
            System.out.println("3. Supprimer une activité");
            System.out.println("4. Afficher les activités");
            System.out.println("5. Ajouter un membre à une activité");
            System.out.println("0. Quitter");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> createActivity(sc);
                case 2 -> updateActivity(sc);
                case 3 -> deleteActivity(sc);
                case 4 -> showActivities();
                case 5 -> addMemberToActivity(sc);
                case 0 -> System.out.println("Retour au menu principal");
                default -> System.out.println("Veuillez saisir un choix valide !");
            }
        } while (choice != 0);
    }


    // creation d'une activité
    private static void createActivity(Scanner sc) {
        System.out.println("Veuillez saisir le nom de l'activité : ");
        String name = sc.nextLine();
        System.out.println("Veuillez saisir la description de l'activité : ");
        String description = sc.nextLine();
        System.out.println("Veuillez saisir la date de l'activité :  format dd/MM/yyyy");
        String date = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println("Heure de début de l'activité :  format HH:mm ");
        String startTime = sc.nextLine();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.parse(startTime, formatter2);
        System.out.println("Veuillez saisir la durée de l'activité :  en minutes");
        int duration = sc.nextInt();
        sc.nextLine();
        System.out.println("Selectionner le coach de l'activité : ");
        showCoaches();
        Long coachId = sc.nextLong();
        sc.nextLine();
        System.out.println("Selectionner le type d'activité : ");
for (Category activityType : Category.values()) {
            System.out.println(activityType.ordinal() + " - " + activityType.name());
        }
int activityType = sc.nextInt();
sc.nextLine();
        Activity activity = new Activity();
        activity.setName(name);
        activity.setDescription(description);
        activity.setDate(localDate);
        activity.setTime(localTime);
        activity.setDuration(duration);
        activity.setCategory(Category.values()[activityType]);
        activity.setCoach(coachDAO.getCoachDAOById(coachId));
        if (activityDAO.createActivityDAO(activity)) {
            System.out.println("L'activité a bien été ajoutée !");
        } else {
            System.out.println("Une erreur est survenue lors de l'ajout de l'activité !");
        }
    }


    // Modification d'une activité
    private static void updateActivity(Scanner sc) {
        System.out.println("Veuillez saisir l'id de l'activité à modifier : ");
        showActivities();
        Long id = sc.nextLong();
        sc.nextLine();
        Activity activity = activityDAO.getActivityDAOById(id);
        if (activity != null) {
            System.out.println("Veuillez saisir le nouveau nom de l'activité : ");
            String name = sc.nextLine();
            System.out.println("Veuillez saisir la nouvelle description de l'activité : ");
            String description = sc.nextLine();
            System.out.println("Veuillez saisir la nouvelle date de l'activité : ");
            String date = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(date, formatter);
            System.out.println("Heure de début de l'activité : ");
            String startTime = sc.nextLine();
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime localTime = LocalTime.parse(startTime, formatter2);
            System.out.println("Veuillez saisir la nouvelle durée de l'activité : ");
            int duration = sc.nextInt();
            sc.nextLine();
            System.out.println("Salle de l'activité : ");
            String room = sc.nextLine();
            System.out.println("Selectionner le nouveau coach de l'activité : ");
            showCoaches();
            Long coachId = sc.nextLong();
            sc.nextLine();
            activity.setName(name);
            activity.setDescription(description);
            activity.setDate(localDate);
            activity.setTime(localTime);
            activity.setDuration(duration);
            activity.setLocation(room);
            activity.setCoach(coachDAO.getCoachDAOById(coachId));
            if (activityDAO.updateActivityDAO(activity)) {
                System.out.println("L'activité a bien été modifiée !");
            } else {
                System.out.println("Une erreur est survenue lors de la modification de l'activité !");
            }
        }
    }

    // Suppression d'une activité
    private static void deleteActivity(Scanner sc) {
        System.out.println("Veuillez saisir l'id de l'activité à supprimer : ");
        showActivities();
        Long id = sc.nextLong();
        sc.nextLine();
        Activity activity = activityDAO.getActivityDAOById(id);
        if (activity != null) {
            if (activityDAO.deleteActivityDAO(activity.getId())) {
                System.out.println("L'activité a bien été supprimée !");
            } else {
                System.out.println("Une erreur est survenue lors de la suppression de l'activité !");
            }
        }

    }

    // Affichage des activités
    private static void showActivities() {
        List<Activity> activities = activityDAO.getAllActivitiesDAO();
        if (activities.isEmpty()) {
            System.out.println("Aucune activité n'est disponible !");
        } else {
            for (Activity activity : activities) {
                System.out.println("Id : " + activity.getId() + " Nom : " + activity.getName() + " Description : " + activity.getDescription() + " Date : " + activity.getDate() + " Heure : " + activity.getTime() + " Durée : " + activity.getDuration() + " Salle : " + activity.getLocation() + " Coach : " + activity.getCoach().getLastName() + " " + activity.getCoach().getFirstName());
            }
        }
    }
 // Ajouter un membre à une activté
 private static void addMemberToActivity(Scanner sc) {
     System.out.println("Veuillez saisir l'id de l'activité : ");
        showActivities();
        Long id = sc.nextLong();
        sc.nextLine();
        Activity activity = activityDAO.getActivityDAOById(id);

     System.out.println("Selectionner le membre à ajouter : ");
     showMembers();
     Long memberId = sc.nextLong();
        sc.nextLine();
        Member member = memberDAO.getMemberDAOById(memberId);
        if ( activity != null && member != null) {
            if (activityDAO.addMemberToActivity(activity.getId(), member.getId())) {
                System.out.println("Le membre a bien été ajouté à l'activité !");
            } else {
                System.out.println("Une erreur est survenue lors de l'ajout du membre à l'activité !");
            }
        }
 }




}


