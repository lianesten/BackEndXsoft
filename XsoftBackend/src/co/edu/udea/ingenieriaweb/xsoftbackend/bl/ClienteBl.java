package co.edu.udea.ingenieriaweb.xsoftbackend.bl;

import java.util.List;

import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

/**
 * Interface que contiene la logica del negocio que se va a implementar sobre la tabla Clientes 
 * en la Base de Datos
 * @author Joaquin Hernandez
 *
 */
public interface ClienteBl {
	
	/**
	 *  Metodo que permite ingresar Un Cliente en la BD, en caso de ocurrir un error es capturado
	 * con la excepción DataBaseException
	 * @param numeroId
	 * @param nombres
	 * @param apellidos
	 * @param telefonoFijo
	 * @param telefonomovil
	 * @param email
	 * @param direccion
	 * @param usuarioCrea
	 * @throws DataBaseException
	 * @throws LogicException
	 */
	 public void GuardarCliente(String numeroId,String nombres,
			 String apellidos, String telefonoFijo, String telefonomovil, String email,
			 String direccion, Usuario usuarioCrea) throws DataBaseException, LogicException;										
	 /**
	  * Matodo de la logica del cliente mediante el cual se obtiene un cliente desde la DB
	  * @param idCliente
	  * @return Cliente
	  * @throws DataBaseException
	  * @throws LogicException
	  */
	 public Cliente obtenerCliente(String idCliente)throws DataBaseException, LogicException;
	 
	 /**
	  * Metodo de la logica del negocio mediante el cual se actualiza un cliente
	  * @param cliente
	  * @throws DataBaseException
	  * @throws LogicException
	  */
	 public void actualizarCliente(Cliente cliente)throws DataBaseException, LogicException;
	 
	 /**
	  * Metodo que permite obtener una lista con todos los clientes que estan en la DB
	  * @return
	  * @throws DataBaseException
	  * @throws LogicException
	  */
	 public List obenerClientes()throws DataBaseException, LogicException;
	 
	 /**
	  * Metodo de la logica del negocio que permite eliminar un cliente de la DB
	  * @param idCliente
	  * @throws DataBaseException
	  * @throws LogicException
	  */
	 public void eliminarCliente(String idCliente)throws DataBaseException, LogicException; 
}

