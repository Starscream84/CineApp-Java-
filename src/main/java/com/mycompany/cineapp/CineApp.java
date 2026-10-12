package com.mycompany.cineapp;

import dao.DAOException;
import dao.MovieDAO;
import dao.MovieDAOJPA;
import jakarta.persistence.*;
import model.Movie;

public class CineApp {

    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("cinema");
        EntityManager em = emf.createEntityManager();

        MovieDAO dao = new MovieDAOJPA(em);

        try {
            dao.insert(new Movie("Toy Story 5", "Animacion", "ATP", 102, 2026));
            dao.insert(new Movie("La Odisea", "Aventura", "SP", 173, 2026));

            System.out.println("--- Todas --- ");
            for (Movie m : dao.findAll()) {
                System.out.println(m.getId() + " - " + m.getTitle());
            }

            System.out.println("--- Buscar 'toy' ---");
            for (Movie m : dao.findByTitle("toy")) {
                System.out.println(m.getId() + " - " + m.getTitle());
            }

        } catch (DAOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
