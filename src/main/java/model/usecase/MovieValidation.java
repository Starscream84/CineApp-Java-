package model.usecase;

import java.time.Year;
import model.Movie;

class MovieValidation {

    private static final int MIN_YEAR = 1888;

    private MovieValidation() {
    }

    static void validate(Movie movie) {
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
            throw new IllegalArgumentException("Elija una clasificacion.");
        }
        int maxYear = Year.now().getValue() + 2;
        if (movie.getYear() < MIN_YEAR || movie.getYear() > maxYear) {
            throw new IllegalArgumentException(
                    "El año tiene que estar entre " + MIN_YEAR + " y " + maxYear + ".");
        }
    }
}
