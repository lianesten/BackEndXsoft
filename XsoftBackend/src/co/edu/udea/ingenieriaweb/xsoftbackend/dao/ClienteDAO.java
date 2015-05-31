package co.edu.udea.ingenieriaweb.xsoftbackend.dao;

import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;


/**
 * 
 * @author Equipo Desarrollo Xsoft 
 * Interfaces que contienelos metodo que permiten hacer operaciones de el DTO Cliente en la DB
 *
 */
public interface ClienteDAO {
	/**
	 * Metodo para alamcenar un Cliente en la DB
	 * @param cliente
	 * @throws DataBaseException
	 */
	public void guardarCliente(Cliente cliente) throws DataBaseException;
	/**
	 * Metodo para obtener un cliente con el Id
	 * @param identificacion
	 * @return
	 * @throws DataBaseException
	 */
	public Cliente obtenerCliente(String identificacion)  throws DataBaseException;
}
