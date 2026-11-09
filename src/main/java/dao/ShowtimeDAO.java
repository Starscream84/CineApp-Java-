package dao;

import model.Showtime;

public interface ShowtimeDAO extends DAO<Showtime, Long> {

    long countByMovie(Long movieId) throws DAOException;
}
