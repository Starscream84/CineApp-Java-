package model.usecase;

import dao.DAOException;
import dao.MovieDAO;
import dao.ShowtimeDAO;
import model.ValidationException;

public class DeleteMovie {

    public void execute(MovieDAO dao, ShowtimeDAO showtimeDao, Long id) throws DAOException, ValidationException {
        if (id == null || dao.findById(id) == null) {
            throw new ValidationException("La pelicula no existe.");
        }
        long count = showtimeDao.countByMovie(id);
        if (count > 0) {
            throw new ValidationException("No se puede eliminar: la pelicula tiene "
                    + count + " funcion(es) programada(s). Elimine primero sus funciones.");
        }
        dao.delete(id);
    }
}
