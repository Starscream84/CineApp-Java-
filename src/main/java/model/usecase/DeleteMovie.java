package model.usecase;

import dao.DAOException;
import dao.MovieDAO;

public class DeleteMovie {

    public void execute(MovieDAO dao, Long id) throws DAOException {
        if (id == null || dao.findById(id) == null) {
            throw new IllegalArgumentException("La pelicula no existe.");
        }
        dao.delete(id);
    }
}
