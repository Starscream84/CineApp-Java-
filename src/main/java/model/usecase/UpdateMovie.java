package model.usecase;

import dao.DAOException;
import dao.MovieDAO;
import model.Movie;

public class UpdateMovie {

    public void execute(MovieDAO dao, Movie movie) throws DAOException {
        if (movie.getId() == null || dao.findById(movie.getId()) == null) {
            throw new IllegalArgumentException("La pelicula no existe.");
        }
        if (movie.getTitle() == null || movie.getTitle().isBlank()) {
            throw new IllegalArgumentException("El titulo es obligatorio.");
        }
        if (movie.getGenre() == null || movie.getGenre().isBlank()) {
            throw new IllegalArgumentException("Elija un genero.");
        }
        if (movie.getDuration() <= 0) {
            throw new IllegalArgumentException("La duracion tiene que ser mayor a 0.");
        }
        if (movie.getFilmRating() == null || movie.getFilmRating().isBlank()) {
            throw new IllegalArgumentException("Elija una clasificación.");
        }
        dao.update(movie);
    }
}
