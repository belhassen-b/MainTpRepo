package org.centresportif;

import org.centresportif.controller.Ihm;
import org.centresportif.services.ActivityService;
import org.centresportif.services.CoachService;
import org.centresportif.services.MemberService;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        ActivityService  activity = new ActivityService();
        CoachService coach = new CoachService();
        MemberService member = new MemberService();

        Ihm ihm = new Ihm();
        ihm.start();

    }
}