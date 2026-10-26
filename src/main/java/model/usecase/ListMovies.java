package model.usecase;

import dao.DAOException;
import dao.MovieDAO;
import java.util.List;
import model.Movie;

public class ListMovies {

    public List<Movie> execute(MovieDAO dao) throws DAOException {
        return dao.findAll();
    }
}
