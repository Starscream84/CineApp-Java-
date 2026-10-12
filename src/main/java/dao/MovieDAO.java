package dao;

import java.util.List;
import model.Movie;

public interface MovieDAO extends DAO<Movie, Long> {

    List<Movie> findByTitle(String title) throws DAOException;
}
