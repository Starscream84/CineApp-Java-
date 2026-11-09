package controller;

import dao.DAOException;
import dao.RoomDAO;
import model.Room;
import model.ValidationException;
import view.FrmAddRoom;

public class AddRoomController {

    private final FrmAddRoom view;
    private final RoomDAO dao;
    private final Long editingId;
    private final Runnable onSaved;

    public AddRoomController(FrmAddRoom view, RoomDAO dao, Room room, Runnable onSaved) {
        this.view = view;
        this.dao = dao;
        this.onSaved = onSaved;

        if (room != null) {
            this.editingId = room.getId();
            view.fillForm(room);
            view.setEditMode();
        } else {
            this.editingId = null;
        }

        view.getBtnSave().addActionListener(e -> save());
    }

    private void save() {
        try {
            int number = parseNumber(view.getNumberText(), "El numero de sala");
            if (number <= 0) {
                throw new ValidationException("El numero de sala tiene que ser mayor a 0.");
            }

            int capacity = parseNumber(view.getCapacityText(), "La capacidad");
            if (capacity <= 0) {
                throw new ValidationException("La capacidad tiene que ser mayor a 0.");
            }

            String type = view.getTypeText();
            if (type.isBlank()) {
                throw new ValidationException("Elija un tipo de sala.");
            }

            // The room number must be unique (except for the room being edited)
            Room existing = dao.findByNumber(number);
            if (existing != null && !existing.getId().equals(editingId)) {
                throw new ValidationException("Ya existe la sala " + number + ".");
            }

            Room r = new Room(number, capacity, type);

            if (editingId == null) {
                dao.insert(r);
                view.clearForm();
                view.showMessage("Sala guardada.");
            } else {
                r.setId(editingId);
                dao.update(r);
                view.showMessage("Sala actualizada.");
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
