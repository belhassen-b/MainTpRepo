package org.centresportif.controller;


import org.centresportif.services.ActivityService;
import org.centresportif.services.CoachService;
import org.centresportif.services.MemberService;
import org.centresportif.entities.Activity;
import org.centresportif.entities.Category;
import org.centresportif.entities.Coach;
import org.centresportif.entities.Member;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Ihm {

    private final CoachService coachService;
    private final MemberService memberService;
    private final ActivityService activityService;

    private final Scanner scanner;

    public Ihm() {
        coachService = new CoachService();
        memberService = new MemberService();
        activityService = new ActivityService();
        scanner = new Scanner(System.in);
    }

    public void start() throws ParseException {
        int choice;
        do {
            System.out.println("1. Gestion des coachs");
            System.out.println("2. Gestion des membres");
            System.out.println("3. Gestion des activités");
            System.out.println("4. Quitter");
            System.out.println("Votre choix : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> coachMenu();
                case 2 -> memberMenu();
                case 3 -> activityMenu();
                case 4 -> System.out.println("Au revoir");
                default -> System.out.println("Choix incorrect");
            }
        } while (choice != 4);
    }

    private void coachMenu() {
        System.out.println("1. Ajouter un coach");
        System.out.println("2. Afficher les coachs");
        System.out.println("3. Supprimer un coach");
        System.out.println("4. Modifier un coach");
        System.out.println("5. Retour");
        System.out.println("Votre choix : ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> addCoach();
            case 2 -> showCoaches();
            case 3 -> deleteCoach();
            case 4 -> updateCoach();
            default -> System.out.println("Choix incorrect");
        }
    }

    private void addCoach() {
        System.out.println("Nom : ");
        String name = scanner.next();
        System.out.println("Prénom : ");
        String firstName = scanner.next();
        Coach coach = new Coach();
        coach.setLastName(name);
        coach.setFirstName(firstName);
        if (coachService.create(coach)) {
            System.out.println("Coach ajouté");
        } else {
            System.out.println("Erreur lors de l'ajout du coach");
        }
    }

    private void showCoaches() {
        List<Coach> coachList = coachService.findAll();
        System.out.println("Liste des coachs : ");
        System.out.println("#############################################");
        for (Coach coach : coachList) {
            System.out.println("Id : " + coach.getId() + " Nom : " + coach.getLastName() + " Prénom : " + coach.getFirstName());
            System.out.println("#############################################");
        }
    }


    private void deleteCoach() {
        System.out.println("Id du coach à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Coach c = coachService.findById(id);
        coachService.deleteById(id);
if (c != null) {
            System.out.println("Coach supprimé");
        } else {
            System.out.println("Erreur lors de la suppression du coach");
        }


    }

    private void updateCoach() {
        System.out.println("Id du coach à modifier : ");
        int id = scanner.nextInt();
        Coach coach = coachService.findById(id);
        if (coach != null) {
            System.out.println("Nom : ");
            String name = scanner.next();
            System.out.println("Prénom : ");
            String firstName = scanner.next();
            coach.setLastName(name);
            coach.setFirstName(firstName);
            if (coachService.update(coach)) {
                System.out.println("Coach modifié");
            } else {
                System.out.println("Erreur lors de la modification du coach");
            }
        } else {
            System.out.println("Coach non trouvé");
        }
    }

    private void memberMenu() {
        System.out.println("1. Ajouter un membre");
        System.out.println("2. Afficher les membres");
        System.out.println("3. Supprimer un membre");
        System.out.println("4. Modifier un membre");
        System.out.println("5. Affecter un membre à une activité");
        System.out.println("6. Retour");
        System.out.println("Votre choix : ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> addMember();
            case 2 -> showMembers();
            case 3 -> deleteMember();
            case 4 -> updateMember();
            case 5 -> affectMember();
            default -> System.out.println("Choix incorrect");
        }
    }

    private void affectMember() {
        System.out.println("Id du membre à affecter : ");
        showMembers();
        int id = scanner.nextInt();
        Member member = memberService.findById(id);
        System.out.println("Id de l'activité à affecter : ");
        showActivities();
        int idActivity = scanner.nextInt();
        Activity activity = activityService.findById(idActivity);
        if ( activity != null && member != null) {
            if (
                    activityService.addMemberToActivity
                    (activity.getId(), member.getId())) {
                System.out.println("Le membre a bien été ajouté à l'activité !");
            } else {
                System.out.println("Une erreur est survenue lors de l'ajout du membre à l'activité !");
            }
        } else {
            System.out.println("L'activité ou le membre n'existe pas !");
        }
    }

    private void addMember() {
        System.out.println("Nom : ");
        String name = scanner.next();
        System.out.println("Prénom : ");
        String firstName = scanner.next();
        Member member = new Member();
        member.setLastName(name);
        member.setFirstName(firstName);
        if (memberService.create(member)) {
            System.out.println("Membre ajouté");
        } else {
            System.out.println("Erreur lors de l'ajout du membre");
        }
    }

    private void showMembers() {
        System.out.println("Liste des membres : ");
        System.out.println("#############################################");
        List<Member> memberList = memberService.findAll();
        for (Member member : memberList) {
            System.out.println("Id: " + member.getId() + "Nom :" + member.getLastName() + " Prénom : " + member.getFirstName());
            System.out.println("#############################################");
        }
    }

    private void updateMember() {
        System.out.println("Id du membre à modifier : ");
        int id = scanner.nextInt();
        Member member = memberService.findById(id);
        if (member != null) {
            System.out.println("Nom : ");
            String name = scanner.next();
            System.out.println("Prénom : ");
            String firstName = scanner.next();
            member.setLastName(name);
            member.setFirstName(firstName);
            if (memberService.update(member)) {
                System.out.println("Membre modifié");
            } else {
                System.out.println("Erreur lors de la modification du membre");
            }
        } else {
            System.out.println("Membre non trouvé");
        }
    }

    private void deleteMember() {
        System.out.println("Id du membre à supprimer : ");
        int id = scanner.nextInt();
        Member m = memberService.findById(id);
        if (m != null) {
            if (memberService.delete(m)) {
                System.out.println("Membre supprimé");
            } else {
                System.out.println("Erreur lors de la suppression du membre");
            }
        } else {
            System.out.println("Membre non trouvé");
        }
    }


    private void activityMenu() throws ParseException {
        System.out.println("1. Ajouter une activité");
        System.out.println("2. Afficher les activités");
        System.out.println("3. Supprimer une activité");
        System.out.println("4. Modifier une activité");
        System.out.println("5. Retour");
        System.out.println("Votre choix : ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> addActivity();
            case 2 -> showActivities();
            case 3 -> deleteActivity();
            case 4 -> updateActivity();
            case 5 -> start();
            default -> System.out.println("Choix incorrect");
        }
    }


    private void addActivity() throws ParseException {
        System.out.println("Nom : ");
        String name = scanner.next();
        System.out.println("Description : ");
        String description = scanner.next();
        System.out.println("Date de début : ");
        String startDate = scanner.next();
        System.out.println("Heure de début : ");
        String startTime = scanner.next();
        System.out.println("Durée : ");
        int duration = scanner.nextInt();
        System.out.println("Emplacement : ");
        String location = scanner.next();
        System.out.println("Selectionner le coach : ");
        showCoaches();
        int idCoach = scanner.nextInt();
        Coach coach = coachService.findById(idCoach);
        System.out.println("Selectionner une catégorie : ");
        for (Category activityType : Category.values()) {
            System.out.println(activityType.ordinal() + " - " + activityType.name());
        }
        int idCategory = scanner.nextInt();
        scanner.nextLine();
        Activity activity = new Activity();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
        Time time = new Time(new SimpleDateFormat("HH:mm").parse(startTime).getTime());
        activity.setName(name);
        activity.setDescription(description);
        activity.setDate(date);
        activity.setTime(time);
        activity.setDuration(duration);
        activity.setLocation(location);
        activity.setCoach(coach);
        activity.setCategory(Category.values()[idCategory]);
        if (activityService.create(activity)) {
            System.out.println("Activité ajoutée");
        } else {
            System.out.println("Erreur lors de l'ajout de l'activité");
        }
    }


    private void showActivities() {
        List<Activity> activityList = activityService.findAll();
        System.out.println("Liste des activités : ");
        System.out.println("#############################################");
        for (Activity activity : activityList) {
            System.out.println("Id : " + activity.getId() + " -  Nom : " + activity.getName() + " - Description : " + activity.getDescription() + " - Date : " + activity.getDate() + " - Heure : " + activity.getTime() + " - Durée : " + activity.getDuration() + " Min " + " - Emplacement : " + activity.getLocation() + " - Coach : " + activity.getCoach().getFullName()+ " - Catégorie : " + activity.getCategory());
            System.out.println("#############################################");
        }
    }

    private void deleteActivity() {
        System.out.println("Id de l'activité à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Activity a = activityService.findById(id);
        if (a != null) {
            if (activityService.delete(a)) {
                System.out.println("Activité supprimée");
            } else {
                System.out.println("Erreur lors de la suppression de l'activité");
            }
        } else {
            System.out.println("Activité non trouvée");
        }
    }

    private void updateActivity() throws ParseException {
        System.out.println("Id de l'activité à modifier : ");
        int id = scanner.nextInt();
        Activity activity = activityService.findById(id);
        if (activity != null) {
            System.out.println("Nom : ");
            String name = scanner.next();
            System.out.println("Description : ");
            String description = scanner.next();
            System.out.println("Date de début : ");
            String startDate = scanner.next();
            System.out.println("Heure de début : ");
            String startTime = scanner.next();
            System.out.println("Durée : ");
            int duration = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Emplacement : ");
            String location = scanner.next();
            System.out.println("Selectionner le coach : ");
            showCoaches();
            int idCoach = scanner.nextInt();
            Coach coach = coachService.findById(idCoach);
            System.out.println("Selectionner une catégorie : ");
            for (Category activityType : Category.values()) {
                System.out.println(activityType.ordinal() + " - " + activityType.name());
            }
            int idCategory = scanner.nextInt();
            scanner.nextLine();
            activity = new Activity();
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
            Time time = new Time(new SimpleDateFormat("HH:mm").parse(startTime).getTime());
            activity.setName(name);
            activity.setDescription(description);
            activity.setDate(date);
            activity.setTime(time);
            activity.setDuration(duration);
            activity.setLocation(location);
            activity.setCoach(coach);
            activity.setCategory(Category.values()[idCategory]);
            if (activityService.update(activity)) {
                System.out.println("Activité modifiée");
            } else {
                System.out.println("Erreur lors de la modification de l'activité");
            }
        } else {
            System.out.println("Activité non trouvée");
        }
    }
}

