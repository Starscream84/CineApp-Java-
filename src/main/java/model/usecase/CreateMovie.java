package model.usecase;

import dao.DAOException;
import dao.MovieDAO;
import model.Movie;

public class CreateMovie {

    public void execute(MovieDAO dao, Movie movie) throws DAOException {
        MovieValidation.validate(movie);
        dao.insert(movie);
    }
}
