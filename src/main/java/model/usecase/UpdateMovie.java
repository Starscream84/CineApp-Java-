package model.usecase;

import dao.DAOException;
import dao.MovieDAO;
import model.Movie;

public class UpdateMovie {

    public void execute(MovieDAO dao, Movie movie) throws DAOException {
        if (movie.getId() == null || dao.findById(movie.getId()) == null) {
            throw new IllegalArgumentException("La pelicula no existe.");
        }
        MovieValidation.validate(movie);
        dao.update(movie);
    }
}
