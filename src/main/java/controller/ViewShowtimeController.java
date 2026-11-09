package controller;

import dao.DAOException;
import dao.MovieDAO;
import dao.ShowtimeDAO;
import java.util.List;
import model.Movie;
import model.Showtime;
import view.FrmAddFunction;
import view.FrmViewFunction;

public class ViewShowtimeController {

    private final FrmViewFunction view;
    private final ShowtimeDAO showtimeDao;
    private final MovieDAO movieDao;

    public ViewShowtimeController(FrmViewFunction view, ShowtimeDAO showtimeDao, MovieDAO movieDao) {
        this.view = view;
        this.showtimeDao = showtimeDao;
        this.movieDao = movieDao;

        view.getBtnAdd().addActionListener(e -> openForm(null));
        view.getBtnEdit().addActionListener(e -> edit());
        view.getBtnDelete().addActionListener(e -> delete());

        loadTable();
    }

    private void loadTable() {
        try {
            view.showShowtimes(showtimeDao.findAll());
        } catch (DAOException e) {
            view.showError("No se pudieron cargar las funciones: " + e.getMessage());
        }
    }

    private void edit() {
        Long id = view.getSelectedId();
        if (id == null) {
            view.showMessage("Selecciona una funcion de la tabla.");
            return;
        }
        try {
            Showtime s = showtimeDao.findById(id);
            if (s == null) {
                view.showMessage("La funcion no existe.");
                return;
            }
            openForm(s);
        } catch (DAOException e) {
            view.showError(e.getMessage());
        }
    }

    // showtime == null -> add mode; showtime != null -> edit mode
    private void openForm(Showtime showtime) {
        try {
            List<Movie> movies = movieDao.findAll();
            if (movies.isEmpty()) {
                view.showMessage("Primero carga al menos una pelicula.");
                return;
            }
            FrmAddFunction window = new FrmAddFunction();
            new AddShowtimeController(window, showtimeDao, movies, showtime, this::loadTable);
            window.setLocationRelativeTo(view);
            window.setVisible(true);
        } catch (DAOException e) {
            view.showError("No se pudieron cargar las peliculas: " + e.getMessage());
        }
    }

    private void delete() {
        Long id = view.getSelectedId();
        if (id == null) {
            view.showMessage("Selecciona una funcion de la tabla.");
            return;
        }
        if (!view.confirm("¿Eliminar la funcion seleccionada?")) {
            return;
        }
        try {
            showtimeDao.delete(id);
            loadTable();
            view.showMessage("Funcion eliminada.");
        } catch (DAOException e) {
            view.showError(e.getMessage());
        }
    }
}
