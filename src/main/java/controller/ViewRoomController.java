package controller;

import dao.DAOException;
import dao.RoomDAO;
import dao.ShowtimeDAO;
import model.Room;
import view.FrmAddRoom;
import view.FrmViewRoom;

public class ViewRoomController {

    private final FrmViewRoom view;
    private final RoomDAO roomDao;
    private final ShowtimeDAO showtimeDao;

    public ViewRoomController(FrmViewRoom view, RoomDAO roomDao, ShowtimeDAO showtimeDao) {
        this.view = view;
        this.roomDao = roomDao;
        this.showtimeDao = showtimeDao;

        view.getBtnAdd().addActionListener(e -> openForm(null));
        view.getBtnEdit().addActionListener(e -> edit());
        view.getBtnDelete().addActionListener(e -> delete());

        loadTable();
    }

    private void loadTable() {
        try {
            view.showRooms(roomDao.findAll());
        } catch (DAOException e) {
            view.showError("No se pudieron cargar las salas: " + e.getMessage());
        }
    }

    private void edit() {
        Long id = view.getSelectedId();
        if (id == null) {
            view.showMessage("Selecciona una sala de la tabla.");
            return;
        }
        try {
            Room r = roomDao.findById(id);
            if (r == null) {
                view.showMessage("La sala no existe.");
                return;
            }
            openForm(r);
        } catch (DAOException e) {
            view.showError(e.getMessage());
        }
    }

    // room == null -> add mode; room != null -> edit mode
    private void openForm(Room room) {
        FrmAddRoom window = new FrmAddRoom();
        new AddRoomController(window, roomDao, room, this::loadTable);
        window.setLocationRelativeTo(view);
        window.setVisible(true);
    }

    private void delete() {
        Long id = view.getSelectedId();
        if (id == null) {
            view.showMessage("Selecciona una sala de la tabla.");
            return;
        }
        if (!view.confirm("¿Eliminar la sala seleccionada?")) {
            return;
        }
        try {
            long count = showtimeDao.countByRoom(id);
            if (count > 0) {
                view.showMessage("No se puede eliminar: la sala tiene " + count
                        + " funcion(es) programada(s). Elimine primero sus funciones.");
                return;
            }
            roomDao.delete(id);
            loadTable();
            view.showMessage("Sala eliminada.");
        } catch (DAOException e) {
            view.showError(e.getMessage());
        }
    }
}
