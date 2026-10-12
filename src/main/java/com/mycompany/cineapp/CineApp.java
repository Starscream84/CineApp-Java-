package com.mycompany.cineapp;

import jakarta.persistence.*;

public class CineApp {

    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("cinema");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist();
        em.getTransaction().commit();
    }
}
