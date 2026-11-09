package model.usecase;

import dao.DAOException;
import dao.MovieDAO;
import dao.ShowtimeDAO;

public class DeleteMovie {

    public void execute(MovieDAO dao, ShowtimeDAO showtimeDao, Long id) throws DAOException {
        if (id == null || dao.findById(id) == null) {
            throw new IllegalArgumentException("La pelicula no existe.");
        }
        long count = showtimeDao.countByMovie(id);
        if (count > 0) {
            throw new IllegalArgumentException("No se puede eliminar: la pelicula tiene "
                    + count + " funcion(es) programada(s). Elimine primero sus funciones.");
        }
        dao.delete(id);
    }
}
