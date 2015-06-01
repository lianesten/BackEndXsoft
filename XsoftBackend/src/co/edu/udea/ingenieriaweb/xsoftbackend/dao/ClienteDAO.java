package co.edu.udea.ingenieriaweb.xsoftbackend.dao;

import java.util.List;

import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;


/**
 * 
 * @author Joaquin Hernandez
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
	 * @throws DataBaseException
	 */
	public Cliente obtenerCliente(String identificacion)  throws DataBaseException;
	
	/**
	 * Instancia del metodo que permite actualizar un cliente
	 * @param cliente
	 * @throws DataBaseException
	 */
	public void actualizarCliente(Cliente cliente) throws DataBaseException;
	
	/**
	 * Instancia del metodo que permite eliminar un cliente de la DB
	 * @param idCliente
	 * @throws DataBaseException
	 */
	public void eliminarCliente(String idCliente) throws DataBaseException;
	
	/**
	 * Instancia del metodo que permite obtener los Clientes en la DB
	 * @throws DataBaseException
	 */
	public List obtenerClientes() throws DataBaseException;
	
}
