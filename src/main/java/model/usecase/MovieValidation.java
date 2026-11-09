package model.usecase;

import java.time.Year;
import model.Movie;
import model.ValidationException;

class MovieValidation {

    private static final int MIN_YEAR = 1888;

    private MovieValidation() {
    }

    static void validate(Movie movie) throws ValidationException {
        if (movie.getTitle() == null || movie.getTitle().isBlank()) {
            throw new ValidationException("El titulo es obligatorio.");
        }
        if (movie.getGenre() == null || movie.getGenre().isBlank()) {
            throw new ValidationException("Elija un genero.");
        }
        if (movie.getDuration() <= 0) {
            throw new ValidationException("La duracion tiene que ser mayor a 0.");
        }
        if (movie.getFilmRating() == null || movie.getFilmRating().isBlank()) {
            throw new ValidationException("Elija una clasificacion.");
        }
        int maxYear = Year.now().getValue() + 2;
        if (movie.getYear() < MIN_YEAR || movie.getYear() > maxYear) {
            throw new ValidationException(
                    "El año tiene que estar entre " + MIN_YEAR + " y " + maxYear + ".");
        }
    }
}
