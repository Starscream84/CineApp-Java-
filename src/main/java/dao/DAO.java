package dao;

import java.util.List;

public interface DAO<T, ID> {

    void insert(T entity) throws DAOException;

    T findById(ID id) throws DAOException;

    List<T> findAll() throws DAOException;

    void update(T entity) throws DAOException;

    void delete(ID id) throws DAOException;
}
