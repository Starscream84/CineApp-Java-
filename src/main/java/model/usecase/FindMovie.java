package model.usecase;

import dao.DAOException;
import dao.MovieDAO;
import model.Movie;

public class FindMovie {
    public Movie execute(MovieDAO dao, Long id) throws DAOException {
        Movie m = dao.findById(id);
        if(m == null) {
            throw new IllegalArgumentException("La pelicula no existe.");
        }
        return m;
    }
}
