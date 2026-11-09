package controller;

import dao.DAOException;
import dao.MovieDAO;
import model.Movie;
import model.ValidationException;
import model.usecase.CreateMovie;
import model.usecase.UpdateMovie;
import view.FrmAddMovie;

public class AddMovieController {

    private final FrmAddMovie view;
    private final MovieDAO dao;
    private final Long editingId;
    private final Runnable onSaved;

    public AddMovieController(FrmAddMovie view, MovieDAO dao, Movie movie, Runnable onSaved) {
        this.view = view;
        this.dao = dao;
        this.onSaved = onSaved;

        if (movie != null) {
            this.editingId = movie.getId();
            view.fillForm(movie);
            view.setEditMode();
        } else {
            this.editingId = null;
        }

        view.getBtnSave().addActionListener(e -> save());
    }

    private void save() {
        try {
            int duration = parseNumber(view.getDurationText(), "La duracion");
            int year = parseNumber(view.getYearText(), "El año");

            Movie m = new Movie(
                    view.getTitleText().trim(),
                    view.getGenreText().trim(),
                    view.getRatingText().trim(),
                    duration,
                    year);

            if (editingId == null) {
                new CreateMovie().execute(dao, m);
                view.clearForm();
                view.showMessage("Pelicula guardada.");
            } else {
                m.setId(editingId);
                new UpdateMovie().execute(dao, m);
                view.showMessage("Pelicula actualizada.");
                view.dispose();
            }

            if (onSaved != null) {
                onSaved.run();
            }
        } catch (ValidationException e) {
            view.showMessage(e.getMessage());
        } catch (DAOException e) {
            view.showError(e.getMessage());
        }
    }

    private int parseNumber(String text, String fieldName) throws ValidationException {
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            throw new ValidationException(fieldName + " tiene que ser un numero.");
        }
    }
}
