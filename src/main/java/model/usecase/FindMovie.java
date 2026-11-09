package model.usecase;

import dao.DAOException;
import dao.MovieDAO;
import model.Movie;
import model.ValidationException;

public class FindMovie {

    public Movie execute(MovieDAO dao, Long id) throws DAOException, ValidationException {
        Movie m = dao.findById(id);
        if (m == null) {
            throw new ValidationException("La pelicula no existe.");
        }
        return m;
    }
}
