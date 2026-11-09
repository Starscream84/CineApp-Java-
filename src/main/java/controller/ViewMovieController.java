package controller;

import dao.DAOException;
import dao.MovieDAO;
import dao.ShowtimeDAO;
import java.util.List;
import model.Movie;
import model.ValidationException;
import model.usecase.DeleteMovie;
import model.usecase.FindMovie;
import model.usecase.ListMovies;
import view.FrmAddMovie;
import view.FrmViewMovie;

public class ViewMovieController {

    private final FrmViewMovie view;
    private final MovieDAO dao;
    private final ShowtimeDAO showtimeDao;

    public ViewMovieController(FrmViewMovie view, MovieDAO dao, ShowtimeDAO showtimeDao) {
        this.view = view;
        this.dao = dao;
        this.showtimeDao = showtimeDao;

        view.getBtnAdd().addActionListener(e -> openAdd());
        view.getBtnEdit().addActionListener(e -> edit());
        view.getBtnDelete().addActionListener(e -> delete());

        loadTable();
    }

    private void loadTable() {
        try {
            List<Movie> movies = new ListMovies().execute(dao);
            view.showMovies(movies);
        } catch (DAOException e) {
            view.showError("No se pudieron cargar las peliculas: " + e.getMessage());
        }
    }

    private void openAdd() {
        FrmAddMovie window = new FrmAddMovie();
        new AddMovieController(window, dao, null, this::loadTable);
        window.setLocationRelativeTo(view);
        window.setVisible(true);
    }

    private void edit() {
        Long id = view.getSelectedId();
        if (id == null) {
            view.showMessage("Selecciona una pelicula de la tabla.");
            return;
        }
        try {
            Movie m = new FindMovie().execute(dao, id);

            FrmAddMovie window = new FrmAddMovie();
            new AddMovieController(window, dao, m, this::loadTable);
            window.setLocationRelativeTo(view);
            window.setVisible(true);
        } catch (ValidationException e) {
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
            new DeleteMovie().execute(dao, showtimeDao, id);
            loadTable();
            view.showMessage("Pelicula eliminada.");
        } catch (ValidationException e) {
            view.showMessage(e.getMessage());
        } catch (DAOException e) {
            view.showError(e.getMessage());
        }
    }
}
