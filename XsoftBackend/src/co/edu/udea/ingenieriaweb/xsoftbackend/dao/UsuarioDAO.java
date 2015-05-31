package co.edu.udea.ingenieriaweb.xsoftbackend.dao;

import java.util.List;

import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;

public interface UsuarioDAO {
	/**
	 * Se define el metodo encargado de guardar un nuevo usuario en la base de datos
	 * @param usuario POJO que contiene todos los datos de nuevo usuario a almacenar
	 * @throws DataBaseException
	 */
	public void guardarUsuario(Usuario usuario) throws DataBaseException;
	/**
	 * Definicion del metodo que permite obtener un solo usuario de la base de datos dado 
	 * su numero de identificacion
	 * @param numeroId es el numero unico de identificacion de cada persona con el roll usuario
	 * @return
	 * @throws DataBaseException
	 */
	public Usuario obtenerUsuario(String numeroId) throws DataBaseException;
	/**
	 * Definicion del metodo obtener usuario el cual permite obtener todos los usuarios de la bd
	 * @return un lista con todos los usuarios que se encuentran almacenados en la bd
	 * @throws DataBaseException
	 */
	public List<Usuario> obtenerUsuarios() throws DataBaseException;
	/**
	 * DEfinicion del metodo actualizar usuario utilizando el patron de diseño DAO.
	 * En caso de alguna excepcion, esta es capturada con DataBseException
	 * El parametro usuario es el usuario a actualizar en la BD
	 * @param usuario
	 * @throws DataBaseException
	 */
	public void actualizarUsuario(Usuario usuario) throws DataBaseException;
	/**
	 * Definicion del metodo eliminar usuario de la BD
	 * @param numeroId es la identificacion del usuario a eliminar
	 * @throws DataBaseException
	 */
	public void eliminarUsuario(String numeroId) throws DataBaseException;
	
}
