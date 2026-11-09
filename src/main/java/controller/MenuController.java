package controller;

import dao.MovieDAO;
import dao.RoomDAO;
import dao.ShowtimeDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import view.FrmMenu;
import view.FrmViewFunction;
import view.FrmViewMovie;
import view.FrmViewRoom;

public class MenuController {

    private final FrmMenu view;
    private final MovieDAO movieDao;
    private final ShowtimeDAO showtimeDao;
    private final RoomDAO roomDao;
    private final Runnable onExit;

    public MenuController(FrmMenu view, MovieDAO movieDao, ShowtimeDAO showtimeDao,
            RoomDAO roomDao, Runnable onExit) {
        this.view = view;
        this.movieDao = movieDao;
        this.showtimeDao = showtimeDao;
        this.roomDao = roomDao;
        this.onExit = onExit;

        view.getBtnMovies().addActionListener(e -> openMovies());
        view.getBtnFunctions().addActionListener(e -> openFunctions());
        view.getBtnRooms().addActionListener(e -> openRooms());
        view.getBtnExit().addActionListener(e -> exit());

        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
    }

    private void openMovies() {
        FrmViewMovie window = new FrmViewMovie();
        new ViewMovieController(window, movieDao, showtimeDao);
        window.setLocationRelativeTo(view);
        window.setVisible(true);
    }

    private void openFunctions() {
        FrmViewFunction window = new FrmViewFunction();
        new ViewShowtimeController(window, showtimeDao, movieDao, roomDao);
        window.setLocationRelativeTo(view);
        window.setVisible(true);
    }

    private void openRooms() {
        FrmViewRoom window = new FrmViewRoom();
        new ViewRoomController(window, roomDao, showtimeDao);
        window.setLocationRelativeTo(view);
        window.setVisible(true);
    }

    private void exit() {
        if (!view.confirm("¿Salir de la aplicacion?")) {
            return;
        }
        onExit.run();
        System.exit(0);
    }
}
