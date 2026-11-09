package controller;

import dao.DAOException;
import dao.ShowtimeDAO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;
import model.Movie;
import model.Room;
import model.Showtime;
import view.FrmAddFunction;

public class AddShowtimeController {

    private static final DateTimeFormatter DATE
            = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
    private static final DateTimeFormatter HOUR = DateTimeFormatter.ofPattern("HH:mm");

    private final FrmAddFunction view;
    private final ShowtimeDAO showtimeDao;
    private final Long editingId;
    private final Runnable onSaved;

    public AddShowtimeController(FrmAddFunction view, ShowtimeDAO showtimeDao,
            List<Movie> movies, List<Room> rooms, Showtime showtime, Runnable onSaved) {
        this.view = view;
        this.showtimeDao = showtimeDao;
        this.onSaved = onSaved;

        view.setMovies(movies);
        view.setRooms(rooms);

        if (showtime != null) {
            this.editingId = showtime.getId();
            view.fillForm(showtime);
            view.setEditMode();
        } else {
            this.editingId = null;
        }

        view.getBtnSave().addActionListener(e -> save());
    }

    private void save() {
        try {
            Movie movie = view.getSelectedMovie();
            if (movie == null) {
                throw new IllegalArgumentException("Elija una pelicula.");
            }

            LocalDate date = parseDate(view.getDateText());
            if (date.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("La fecha no puede ser anterior a hoy.");
            }

            LocalTime time = parseTime(view.getHourText());

            Room room = view.getSelectedRoom();
            if (room == null) {
                throw new IllegalArgumentException("Elija una sala.");
            }

            BigDecimal price = parsePrice(view.getPriceText());

            Showtime s = new Showtime(movie, date, time, room, price);

            if (editingId == null) {
                showtimeDao.insert(s);
                view.clearForm();
                view.showMessage("Funcion guardada.");
            } else {
                s.setId(editingId);
                showtimeDao.update(s);
                view.showMessage("Funcion actualizada.");
                view.dispose();
            }

            if (onSaved != null) {
                onSaved.run();
            }
        } catch (IllegalArgumentException e) {
            view.showMessage(e.getMessage());
        } catch (DAOException e) {
            view.showError(e.getMessage());
        }
    }

    private LocalDate parseDate(String text) {
        try {
            return LocalDate.parse(text.trim(), DATE);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La fecha tiene que tener el formato dd/mm/aaaa.");
        }
    }

    private LocalTime parseTime(String text) {
        try {
            return LocalTime.parse(text.trim(), HOUR);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("La hora tiene que tener el formato hh:mm.");
        }
    }

    private BigDecimal parsePrice(String text) {
        BigDecimal price;
        try {
            price = new BigDecimal(text.trim().replace(",", "."));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El precio tiene que ser un numero.");
        }
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio tiene que ser mayor a 0.");
        }
        return price;
    }
}
