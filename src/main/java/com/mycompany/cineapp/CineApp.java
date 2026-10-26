package com.mycompany.cineapp;

import dao.MovieDAO;
import dao.MovieDAOJPA;
import controller.MovieController;
import jakarta.persistence.*;
import view.FormMovie;

public class CineApp {

    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("cinema");
        EntityManager em = emf.createEntityManager();

        MovieDAO dao = new MovieDAOJPA(em);
        FormMovie view = new FormMovie();
        new MovieController(view, dao);
        view.setVisible(true);
        view.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                em.close();
                emf.close();
            }
        });
    }
}
