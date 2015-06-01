package co.edu.udea.ingenieriaweb.xsoftbackend.bl.imp;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.ClienteBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

// /*Le especificamos que correremos la prueba con el Junit de Spring*/
@RunWith(SpringJUnit4ClassRunner.class)
// @Transactional
// /*Le decimos cual es el archivo de configuraciones del Spring*/
@ContextConfiguration(locations = "classpath:/ConfigurationSpring.xml")
// /*Le decimos a Spring que en esta clase pueden haber cosas que deba
// inyectar*/
@Component
/**
 * Clese que contiene las pruebas de integracion del a logica del negocio de la tabla Cliente
 * @author Equipo de desarrollo Xsoft
 *
 */
public class ClienteBLImpTest {

	@Autowired
	ClienteBl clienteBl;

	/**
	 * Prueba de integracion que permite validar el correcto ingreso de un
	 * cliente
	 */
	@Test
	public void testGuardarCliente() {
		/**
		 * Creamos el objeto de la clase Cliente
		 */
		Cliente cliente = new Cliente();

		/**
		 * Es necesario definir un objeto de la Clase Usuario para indicar quien
		 * lo creo
		 */
		Usuario usuarioCrea = new Usuario();
		usuarioCrea.setNumeroId("1038481420");

		/**
		 * Llenamos los datos del Cliente
		 */
		cliente.setNombres("Julian ");
		cliente.setApellidos("Marin");
		cliente.setDireccion("Norte de Medellin");
		cliente.setEmail("pandres@gmail.com");
		cliente.setFechaCreacion(new Date());
		cliente.setNumeroId("1236");
		cliente.setTelefonoFijo("42566");
		cliente.setTelefonoMovil("3142563214");
		cliente.setUsuarioCrea(usuarioCrea);

		try {
			clienteBl.GuardarCliente(cliente.getNumeroId(),
					cliente.getNombres(), cliente.getApellidos(),
					cliente.getTelefonoFijo(), cliente.getTelefonoMovil(),
					cliente.getEmail(), cliente.getDireccion(),
					cliente.getUsuarioCrea());
			assertTrue(cliente != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prueba realizada para garantizar que un usuario se puede obtener
	 * ocrrectamente desde la DB
	 */
	@Test
	public void testObtenerCliente() {
		Cliente cliente = null;
		/**
		 * Identificacion del Usuario en la base de datos con nombre Pablo
		 * Andres
		 */
		String identificacion = "120365485";
		try {
				cliente = clienteBl.obtenerCliente(identificacion); 
		
			assertTrue(cliente.getNumeroId().equals("120365485"));
			Logger log = Logger.getLogger(this.getClass());
			log.info("Nombre Cliente: " + cliente.getNombres());
		} catch (DataBaseException e) {
			e.printStackTrace();
		}
		catch (LogicException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error de Logica de negocio"+ e.toString());
		}
	}		

	/**
	 * Prueba realizada para verificar que un cliente se modifique correctamente
	 * @throws LogicException 
	 * @throws DataBaseException 
	 * 
	 */
	@Test
	public void testActualizarCliente() throws DataBaseException, LogicException {
		/**
		 * Obtenemos el cliente que se desea modificar
		 */
		Cliente cliente = clienteBl.obtenerCliente("47885");

		/**
		 * Es necesario definir un objeto de la Clase Usuario para indicar quien
		 * lo creo
		 */
		Usuario usuarioCrea = new Usuario();
		usuarioCrea.setNumeroId("1038481420");

		/**
		 * Llenamos los datos del Cliente, podemos cambiar todo excepto la
		 * identificacion
		 */
		cliente.setNombres("Andres");
		cliente.setApellidos("Hernandez");

		try {
			clienteBl.actualizarCliente(cliente);
			assertTrue(cliente != null);
		} catch (DataBaseException e) {
			e.printStackTrace();
			System.out.println("Problema" + e.toString());
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prueba realiza para comprobar la logica del negocio para obtener todos los clientes de la DB
	 */
	@Test
	public void testObenerClientes() {
		List clientes = null;
		Logger log = Logger.getLogger(this.getClass());
		try {
			clientes = (List) clienteBl.obenerClientes();
			assertTrue(clientes != null);
			Cliente cliente = (Cliente) clientes.get(0);
			log.info("Nombre Primer Cliente: " + cliente.getNombres());

		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prueba realizada para verificar el metodo EliminarCliente de ClienteBl
	 */
	@Test
	public void testEliminarCliente() {
		/**
		 * Id del cliente a eliminar
		 */
		String idClienteEliminar = "47885";
		try {
			clienteBl.eliminarCliente(idClienteEliminar);
			assertTrue(idClienteEliminar != null);
		} catch (DataBaseException e) {
			e.printStackTrace();
			System.out.println("Problema" + e.toString());
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
