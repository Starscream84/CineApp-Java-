package com.mycompany.cineapp;

import controller.MenuController;
import dao.MovieDAO;
import dao.MovieDAOJPA;
import dao.RoomDAO;
import dao.RoomDAOJPA;
import dao.ShowtimeDAO;
import dao.ShowtimeDAOJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.FrmMenu;

public class CineApp {

    public static void main(String[] args) {
        // Java's standard look (Metal), so the button colors are shown on every
        // operating system: the native macOS look ignores button backgrounds
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ReflectiveOperationException | UnsupportedLookAndFeelException e) {
            // If it cannot be applied, the default look is used
        }

        EntityManagerFactory emf;
        try {
            emf = Persistence.createEntityManagerFactory("cinema", databaseOverrides());
        } catch (PersistenceException e) {
            JOptionPane.showMessageDialog(null,
                    "No se pudo conectar a la base de datos.\nRevisa que MySQL este corriendo y que el usuario\ny la contraseña sean correctos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        EntityManager em = emf.createEntityManager();
        MovieDAO movieDao = new MovieDAOJPA(em);
        ShowtimeDAO showtimeDao = new ShowtimeDAOJPA(em);
        RoomDAO roomDao = new RoomDAOJPA(em);

        FrmMenu view = new FrmMenu();
        new MenuController(view, movieDao, showtimeDao, roomDao, () -> {
            em.close();
            emf.close();
        });
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    // Reads the database user and password from -Ddb.user and -Ddb.password,
    // so the real credentials are not stored in persistence.xml
    private static Map<String, String> databaseOverrides() {
        Map<String, String> overrides = new HashMap<>();
        String user = System.getProperty("db.user");
        String password = System.getProperty("db.password");
        if (user != null) {
            overrides.put("jakarta.persistence.jdbc.user", user);
        }
        if (password != null) {
            overrides.put("jakarta.persistence.jdbc.password", password);
        }
        return overrides;
    }
}
