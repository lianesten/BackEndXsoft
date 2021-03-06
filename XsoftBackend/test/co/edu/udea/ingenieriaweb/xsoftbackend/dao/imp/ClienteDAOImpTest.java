package co.edu.udea.ingenieriaweb.xsoftbackend.dao.imp;

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

import co.edu.udea.ingenieriaweb.xsoftbackend.dao.ClienteDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;

/**
 * 
 * @author Equipo de Desarrollo Xsoft
 *
 */

// /*Le especificamos que correremos la prueba con el Junit de Spring*/
@RunWith(SpringJUnit4ClassRunner.class)
// @Transactional
// /*Le decimos cual es el archivo de configuraciones del Spring*/
@ContextConfiguration(locations = "classpath:/ConfigurationSpring.xml")
// /*Le decimos a Spring que en esta clase pueden haber cosas que deba
// inyectar*/
@Component
public class ClienteDAOImpTest {

	/* Inyectamos Un objeto de la clase ClienteDAO */

	@Autowired
	ClienteDAO clienteDAO;

	/**
	 * Prueba de integracion para obtener un Cliente desde la DB utilizando
	 * directamente un objeto ClienteDAO
	 */
	@Test
	public void testObtenerCliente() {
		Cliente cliente = null;
		/**
		 * Identificacion del Uusario en la base de datos con nombre Pablo
		 * Andres
		 */
		String identificacion = "120365485";
		try {
			cliente = clienteDAO.obtenerCliente(identificacion);
			System.out.println("Cliente: " + cliente);
			assertTrue(cliente.getNumeroId().equals("120365485"));
			Logger log = Logger.getLogger(this.getClass());
			log.info("Nombre Cliente: " + cliente.getNombres());
		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	/**
	 * 
	 * prueba de integración para ingresar un Cliente en la DB
	 * 
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
		cliente.setNombres("Juan ");
		cliente.setApellidos("Restrepo");
		cliente.setDireccion("Sur de Medellin");
		cliente.setEmail("pandres@gmail.com");
		cliente.setFechaCreacion(new Date());
		cliente.setNumeroId("47885");
		cliente.setTelefonoFijo("42566");
		cliente.setTelefonoMovil("3142563214");
		cliente.setUsuarioCrea(usuarioCrea);

		try {
			clienteDAO.guardarCliente(cliente);
			assertTrue(cliente != null);
		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Prueba realizada para verificar que un cliente se modifique correctamente
	 * 
	 * @throws DataBaseException
	 */
	@Test
	public void actualizarCliente() throws DataBaseException {
		/**
		 * Obtenemos el cliente que se desea modificar
		 */
		Cliente cliente = clienteDAO.obtenerCliente("1236");

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
		cliente.setApellidos("Mercado");

		try {
			clienteDAO.actualizarCliente(cliente);
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
	 * Test realizado para verificar que se puedeeliminar correctamente un
	 * Cliente en la DB
	 */
	@Test
	public void eliminarCliente() {
		/**
		 * Id del cliente a eliminar
		 */
		String idClienteEliminar = "47885";
		try {
			clienteDAO.eliminarCliente(idClienteEliminar);
			assertTrue(idClienteEliminar != null);
		} catch (DataBaseException e) {
			e.printStackTrace();
			System.out.println("Problema" + e.toString());
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prueba realizada para verificar que se pueda obtener la lista de todos
	 * los clientes
	 */
	@Test
	public void obtenerClientes() {
		List clientes = null;
		Logger log = Logger.getLogger(this.getClass());
		try {
			clientes = clienteDAO.obtenerClientes();
			assertTrue(clientes != null);
			Cliente cliente = (Cliente) clientes.get(0);
			log.info("Nombre Primer Cliente: " + cliente.getNombres());

		} catch (DataBaseException e) {
			e.printStackTrace();
			System.out.println("Problema" + e.toString());
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
