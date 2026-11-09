package dao;

import model.Room;

public interface RoomDAO extends DAO<Room, Long> {

    // Returns the room with that number, or null if it does not exist
    Room findByNumber(int number) throws DAOException;
}
