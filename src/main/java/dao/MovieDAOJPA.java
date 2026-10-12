package dao;

import jakarta.persistence.*;
import java.util.List;
import model.Movie;

public class MovieDAOJPA implements MovieDAO {

    private final EntityManager em;

    public MovieDAOJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public Movie findById(Long id) throws DAOException {
        try {
            return em.find(Movie.class, id);
        } catch (PersistenceException e) {
            throw new DAOException("No se pudo buscar la pelicula con id " + id, e);
        }
    }

    @Override
    public List<Movie> findByTitle(String title) throws DAOException {
        try {
            return em.find(Movie.class, title);
        } catch (PersistenceException e) {
            throw new DAOException("No se encontro la pelicula", e);
        }
    }

    // Add Movie
    @Override
    public void insert(Movie m) throws DAOException {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(m);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new DAOException("No se pudo agregar la pelicula.", e);
        }
    }

    // Show All Movies
    @Override
    public List<Movie> findAll() throws DAOException {
        try {
            TypedQuery<Movie> query = em.createQuery(
                    "SELECT m FROM Movie m", Movie.class);
            return query.getResultList();
        } catch (PersistenceException e) {
            throw new DAOException("No se pueden mostrar las peliculas", e);
        }
    }

    // Update Movie
    @Override
    public void update(Movie m) throws DAOException {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(m);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new DAOException("No se pudo actualizar la pelicula.", e);
        }
    }

    // Delete Movie
    @Override
    public void delete(Long id) throws DAOException {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Movie m = em.find(Movie.class, id);
            if (m != null) {
                em.remove(m);
            }
            tx.commit();
        } catch (PersistenceException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new DAOException("No se pudo eliminar la pelicula.", e);
        }
    }
}
