package controller;

import dao.DAOException;
import dao.MovieDAO;
import model.Movie;
import model.usecase.CreateMovie;
import view.FormMovie;
import java.util.List;
import model.usecase.ListMovies;
import model.usecase.FindMovie;
import model.usecase.DeleteMovie;
import model.usecase.UpdateMovie;

public class MovieController {

    private final FormMovie view;
    private final MovieDAO dao;

    public MovieController(FormMovie view, MovieDAO dao) {
        this.view = view;
        this.dao = dao;

        view.getBtnSave().addActionListener(e -> save());
        view.getBtnEdit().addActionListener(e -> update());
        view.getBtnDelete().addActionListener(e -> delete());
        view.getBtnClear().addActionListener(e -> view.clearForm());

        view.getTable().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                selectMovie();
            }
        });
        loadTable();
    }

    private void save() {
        try {
            String title = view.getTitleText();

            String genre = view.getGenreText();

            String filmRating = view.getRatingText();

            int duration = parseNumber(view.getDurationText(), "La duracion");

            int year = parseNumber(view.getYearText(), "El año");

            Movie m = new Movie(title.trim(), genre.trim(), filmRating.trim(), duration, year);
            new CreateMovie().execute(dao, m);

            loadTable();
            view.clearForm();
            view.showMessage("Pelicula guardada.");
        } catch (IllegalArgumentException e) {
            view.showMessage(e.getMessage());
        } catch (DAOException e) {
            view.showError(e.getMessage());
        }
    }

    private void selectMovie() {
        Long id = view.getSelectedId();
        if (id == null) {
            return;
        }
        try {
            Movie m = new FindMovie().execute(dao, id);
            view.fillForm(m);
        } catch (IllegalArgumentException e) {
            view.showMessage(e.getMessage());
        } catch (DAOException e) {
            view.showError(e.getMessage());
        }
    }

    private void update() {
        Long id = view.getSelectedId();
        if (id == null) {
            view.showMessage("Selecciona una pelicula de la tabla.");
            return;
        }
        try {
            int duration = parseNumber(view.getDurationText(), "La duracion");
            int year = parseNumber(view.getYearText(), "El año");

            Movie m = new Movie(view.getTitleText().trim(), view.getGenreText().trim(), view.getRatingText().trim(), duration, year);
            m.setId(id);

            new UpdateMovie().execute(dao, m);

            loadTable();
            view.clearForm();
            view.showMessage("Pelicula Actualizada.");
        } catch (IllegalArgumentException e) {
            view.showMessage(e.getMessage());
        } catch (DAOException e) {
            view.showError(e.getMessage());
        }
    }

    private void delete() {
        Long id = view.getSelectedId();
        if (id == null) {
            view.showMessage("Selecciona una pelicula de la tabla.");
            return;
        }
        if (!view.confirm("¿Eliminar la pelicula seleccionada?")) {
            return;
        }
        try {
            new DeleteMovie().execute(dao, id);
            loadTable();
            view.clearForm();
            view.showMessage("Pelicula eliminada.");
        } catch (IllegalArgumentException e) {
            view.showMessage(e.getMessage());
        } catch (DAOException e) {
            view.showError(e.getMessage());
        }
    }

    private void loadTable() {
        try {
            List<Movie> movies = new ListMovies().execute(dao);
            view.showMovies(movies);
        } catch (DAOException e) {
            view.showError("No se pudieron cargar las peliculas: " + e.getMessage());
        }
    }

    private int parseNumber(String text, String fieldName) {
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " tiene que ser un numero.");
        }
    }
}
