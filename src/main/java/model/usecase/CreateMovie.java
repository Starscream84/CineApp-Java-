package model.usecase;

import dao.DAOException;
import dao.MovieDAO;
import model.Movie;
import model.ValidationException;

public class CreateMovie {

    public void execute(MovieDAO dao, Movie movie) throws DAOException, ValidationException {
        MovieValidation.validate(movie);
        dao.insert(movie);
    }
}
