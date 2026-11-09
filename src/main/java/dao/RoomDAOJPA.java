package dao;

import jakarta.persistence.*;
import java.util.List;
import model.Room;

public class RoomDAOJPA implements RoomDAO {

    private final EntityManager em;

    public RoomDAOJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(Room r) throws DAOException {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(r);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new DAOException("No se pudo agregar la sala.", e);
        }
    }

    @Override
    public Room findById(Long id) throws DAOException {
        try {
            return em.find(Room.class, id);
        } catch (PersistenceException e) {
            throw new DAOException("No se pudo buscar la sala con id " + id, e);
        }
    }

    @Override
    public Room findByNumber(int number) throws DAOException {
        try {
            List<Room> result = em.createQuery(
                    "SELECT r FROM Room r WHERE r.number = :number", Room.class)
                    .setParameter("number", number)
                    .getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (PersistenceException e) {
            throw new DAOException("No se pudo buscar la sala numero " + number, e);
        }
    }

    @Override
    public List<Room> findAll() throws DAOException {
        try {
            return em.createQuery("SELECT r FROM Room r ORDER BY r.number", Room.class)
                    .getResultList();
        } catch (PersistenceException e) {
            throw new DAOException("No se pueden mostrar las salas.", e);
        }
    }

    @Override
    public void update(Room r) throws DAOException {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(r);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new DAOException("No se pudo actualizar la sala.", e);
        }
    }

    @Override
    public void delete(Long id) throws DAOException {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Room r = em.find(Room.class, id);
            if (r != null) {
                em.remove(r);
            }
            tx.commit();
        } catch (PersistenceException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new DAOException("No se pudo eliminar la sala.", e);
        }
    }
}
