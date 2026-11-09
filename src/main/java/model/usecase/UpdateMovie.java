package model.usecase;

import dao.DAOException;
import dao.MovieDAO;
import model.Movie;
import model.ValidationException;

public class UpdateMovie {

    public void execute(MovieDAO dao, Movie movie) throws DAOException, ValidationException {
        if (movie.getId() == null || dao.findById(movie.getId()) == null) {
            throw new ValidationException("La pelicula no existe.");
        }
        MovieValidation.validate(movie);
        dao.update(movie);
    }
}
