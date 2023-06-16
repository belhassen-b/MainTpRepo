package com.example.tp_hopital;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.PatientService;
import util.Definition;
import java.io.IOException;


@WebServlet(name="patients", value ="/patients")
public class PatientServlet extends HttpServlet {
    private PatientService service;

    public void init() {
        service = new PatientService();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("nom_patient") != null) {
            String nom_patient = request.getParameter("nom_patient");
            String prenom_patient = request.getParameter("prenom_patient");
            String mail_patient = request.getParameter("mail_patient");
            String tel_patient = request.getParameter("tel_patient");
            entities.Patient patient = new entities.Patient(nom_patient, prenom_patient, mail_patient, tel_patient);
            if (service.create(patient)) {
                response.sendRedirect("patients");
            }
        } else {
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt((request.getParameter("id")));
            entities.Patient patient = service.findById(id);
            request.setAttribute("patient", patient);
            request.getRequestDispatcher(Definition.VIEW_PATH + "patient.jsp").forward(request, response);
        } else {
            request.setAttribute("patients", service.findAll());
            request.getRequestDispatcher(Definition.VIEW_PATH + "patients.jsp").forward(request, response);
        }

    }
}



