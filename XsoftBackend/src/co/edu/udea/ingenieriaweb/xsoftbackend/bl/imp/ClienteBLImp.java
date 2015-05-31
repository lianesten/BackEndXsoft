package co.edu.udea.ingenieriaweb.xsoftbackend.bl.imp;

import java.util.Date;

import org.apache.log4j.Logger;

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.ClienteBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.dao.ClienteDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

/**
 * Clase que contiene la logica del negocio para realizar operaciones con la tabla Clientes 
 * en la Base de datos
 * @author Equipo Desarrollo Xsoft
 *
 */
public class ClienteBLImp  implements ClienteBl{

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
	
	/** Metodo encargado de llevar a cabo la logica del negocio para almacenar un 
	 * cliente en la base de datos, si se presenta algun error, este es capturado 
	 * con la excepcion DataBaseException o LogicException
	 * @param cliente
	 * @throws LogicException
	 * @throws {@link DataBaseException}
	 */
	@Override
	public void GuardarCliente(String numeroId,String nombres,
			 String apellidos, String telefonoFijo, String telefonoMovil, String email,
			 String direccion, Usuario usuarioCrea) throws DataBaseException, LogicException {
		
		if(numeroId==null|| "".equals(numeroId)){
			throw new LogicException("La cedula no puede ser vacia ni Nula");
		}
		/*Hacer todas las demas validaciones correspondientes a las reglas del necogio*/
		
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
		
		try{
		clienteDAO.guardarCliente(cliente);
		}catch(Exception e){
			Logger  log = Logger.getLogger(this.getClass());
			log.error("Error en el almacenamiento de Cliente: " +e);
			new DataBaseException(e,"Error almacenando el Cliente");
			
		}
		
	}
		

}
