package co.edu.udea.ingenieriaweb.xsoftbackend.bl.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;




import co.edu.udea.ingenieriaweb.xsoftbackend.bl.ClienteBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.dao.ClienteDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

/**
 * Clase que contiene la logica del negocio para realizar operaciones con la
 * tabla Clientes en la Base de datos
 * 
 * @author Equipo Desarrollo Xsoft
 *
 */
public class ClienteBLImp implements ClienteBl {

	/**
	 * Objeto que permite realizar las operaciones sobre la tabla Cliente
	 */
	ClienteDAO clienteDAO;

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	/**
	 * Metodo encargado de llevar a cabo la logica del negocio para almacenar un
	 * cliente en la base de datos, si se presenta algun error, este es
	 * capturado con la excepcion DataBaseException o LogicException
	 * 
	 * @param cliente
	 * @throws LogicException
	 * @throws {@link DataBaseException}
	 */
	@Override
	public void GuardarCliente(String numeroId, String nombres,
			String apellidos, String telefonoFijo, String telefonoMovil,
			String email, String direccion, Usuario usuarioCrea)
			throws DataBaseException, LogicException {

		if (numeroId == null || "".equals(numeroId)) {
			throw new LogicException("La cedula no puede ser vacia ni Nula");
		}
		if (!numeroId.matches("[0-9]*")){
			throw new LogicException("La cedula no puede contener letras");
		}
		if (nombres == null || "".equals(nombres)) {
			throw new LogicException("Los nombres no pueden ser vacio ni Nulo");
		}
		if (apellidos == null || "".equals(apellidos)) {
			throw new LogicException("Los apellidos no pueden ser vacio ni Nulo");
		}
		if (!telefonoFijo.matches("[0-9]*")){
			throw new LogicException("El telefono fijo no puede letras");
		}
		if (telefonoFijo == null || "".equals(email)) {
			throw new LogicException("El email no puede ser vacio ni Nulo");
		}
		if (telefonoMovil == null || "".equals(telefonoMovil)) {
			throw new LogicException("El telefono Movil no puede ser vacio ni Nulo");
		}
		if (!telefonoMovil.matches("[0-9]*")){
			throw new LogicException("El telefono Movil no puede ser letras");
		}
		if (email == null || "".equals(email)) {
			throw new LogicException("El email no puede ser vacio ni Nulo");
		}
		
		if (direccion == null || "".equals(direccion)) {
			throw new LogicException("La direccion no puede ser vacio ni Nulo");
		}
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Boolean b = email.matches(EMAIL_REGEX);
		if (b == false ) {
			throw new LogicException("El email no tiene un formato valido");
		}
		if (usuarioCrea == null) {
			throw new LogicException("El usuario no puede ser null");
		}
		
		
	

		Cliente cliente = new Cliente();
		cliente.setNumeroId(numeroId);
		cliente.setApellidos(apellidos);
		cliente.setNombres(nombres);
		cliente.setTelefonoFijo(telefonoFijo);
		cliente.setTelefonoMovil(telefonoMovil);
		cliente.setEmail(email);
		cliente.setDireccion(direccion);
		cliente.setUsuarioCrea(usuarioCrea);
		cliente.setFechaCreacion(new Date());

		try {
			clienteDAO.guardarCliente(cliente);
		} catch (Exception e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error en el almacenamiento de Cliente: " + e);
			new DataBaseException(e, "Error almacenando el Cliente");

		}

	}
	
	

	/**
	 * Metodo en la logica del negocio mediante el cual se obtiene un cliente de
	 * la DB
	 * 
	 * @param idCliente
	 * @throws DataBaseException
	 * @throws LogicException
	 */
	@Override
	public Cliente obtenerCliente(String idCliente) throws DataBaseException,
			LogicException {
		if (idCliente == null || "".equals(idCliente)) {
			throw new LogicException(
					"Se debe digitar la identificacion del Cliente a obtener");
		}
		Cliente cliente = null;
		try {
			cliente = clienteDAO.obtenerCliente(idCliente);
		} catch (DataBaseException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error en el almacenamiento de Cliente: " + e);
			throw new DataBaseException(e,
					"Error almacenando un cliente en la DB");

		} catch (Exception e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error en el almacenamiento de Cliente: " + e);
			throw new DataBaseException(e,
					"Error general almacenando un Cliente en la DB");
		}
		return cliente;
	}

	/**
	 * Metodo que permite actualizar un cliente en la DB
	 * 
	 * @param cliente
	 * @throws DataBaseException
	 * 
	 */
	@Override
	public void actualizarCliente(Cliente cliente) throws DataBaseException,
			LogicException {
		try {
			clienteDAO.actualizarCliente(cliente);
		} catch (DataBaseException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error actualizando cliente: " + e);
			throw new DataBaseException(e,
					"Error actualizando un cliente en la BD");

		} catch (Exception e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error actualizando usuario: " + e);
			throw new DataBaseException(e,
					"Error actualizando un cliente en la BD");
		}

	}

	/**
	 * Metodo mediante el cual se obtiene la lista de todos los clientes
	 * almacenados en la DB
	 * 
	 * @throws DataBaseException
	 * @throws Logic
	 *             Exception
	 */
	@Override
	public List obenerClientes() throws DataBaseException, LogicException {
		// TODO Auto-generated method stub
		List listaClientes = new ArrayList<Cliente>();
		try {
			listaClientes = (List) clienteDAO.obtenerClientes();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataBaseException(e,
					"Error obteniendo los clientes de la BD");
		}
		return listaClientes;
	}

	/**
	 * Metodo en la logica del negocio mediante el cual se elimina un cliente de
	 * la DB
	 * 
	 * @param idCliente
	 * @throws DataBaseException
	 */
	@Override
	public void eliminarCliente(String idCliente) throws DataBaseException,
			LogicException {

		if (idCliente == null || "".equals(idCliente)) {
			throw new LogicException(
					"Se debe digitar la identificacion del cliente a eliminar");
		}

		try {
			clienteDAO.eliminarCliente(idCliente);
		} catch (DataBaseException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error eliminando cliente: " + e);
			throw new DataBaseException(e,
					"Error eliminando un cliente en la BD");

		}

	}

}
