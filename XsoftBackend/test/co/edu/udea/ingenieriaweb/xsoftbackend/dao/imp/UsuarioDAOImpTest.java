package co.edu.udea.ingenieriaweb.xsoftbackend.dao.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.ingenieriaweb.xsoftbackend.dao.UsuarioDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;

///*Le especificamos que correremos la prueba con el Junit de Spring*/
@RunWith(SpringJUnit4ClassRunner.class)
// @Transactional
// /*Le decimos cual es el archivo de configuraciones del Spring*/
@ContextConfiguration(locations = "classpath:/ConfigurationSpring.xml")
// /*Le decimos a Spring que en esta clase pueden haber cosas que deba
// inyectar*/
@Component
public class UsuarioDAOImpTest {

	@Autowired
	UsuarioDAO usuarioDAO;

	/**
	 * Prueba mediante la cual se verifica que se pueda ingresar un usuario en
	 * la DB
	 */
	@Test
	public void testGuardarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNombres("Kely");
		usuario.setApellidos("Lezcano");
		usuario.setNumeroId("1152690699");
		usuario.setEmail("kely.lezcano@gmail.com");
		usuario.setPassword("kely");
		usuario.setUsername("kely");
		usuario.setPrivilegio(1);

		try {
			usuarioDAO.guardarUsuario(usuario);
			assertTrue(usuario != null);
			Logger log = Logger.getLogger(this.getClass());
			log.info("Nombre Usuario: " + usuario.getNombres());
		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	/**
	 * Prueba realizada para revisar que pueda obtener un usuario por medio de
	 * su identificacion
	 */
	@Test
	public void testObtenerUsuario() {
		/**
		 * Identificacion del Uusario en la base de datos con nombre Pablo
		 * Andres
		 */
		String idUsuario = "1038481420";

		Usuario usuario = null;
		try {
			usuario = usuarioDAO.obtenerUsuario(idUsuario);
			assertTrue(usuario != null);
			Logger log = Logger.getLogger(this.getClass());
			log.info("Nombre Usuario: " + usuario.getNombres());
		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	/**
	 * Prueba realizada con el fin de verificar que se pueda actualizar un
	 * usuario
	 * 
	 * @throws DataBaseException
	 */
	@Test
	public void testActualizarUsuario() throws DataBaseException {
		/**
		 * Obtenemos el usuario que se desea modificar
		 */
		Usuario usuario = usuarioDAO.obtenerUsuario("1038481420");

		/**
		 * Llenamos los datos del Usuario, podemos cambiar todo excepto la
		 * identificacion
		 */
		usuario.setNombres("Joaquin");
		usuario.setApellidos("Hernandez");

		try {
			usuarioDAO.actualizarUsuario(usuario);
			assertTrue(usuario != null);
		} catch (DataBaseException e) {
			e.printStackTrace();
			System.out.println("Problema" + e.toString());
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prueba realizada para comprobar que se puedan obtener todos los usuarios
	 * de la DB
	 */
	@Test
	public void testObtenerUsuarios() {
		List usuarios = null;
		Logger log = Logger.getLogger(this.getClass());
		try {
			usuarios = usuarioDAO.obtenerUsuarios();
			assertTrue(usuarios != null);
			Usuario usuario = (Usuario) usuarios.get(0);
			log.info("Nombre Primer Usuario: " + usuario.getNombres());

		} catch (DataBaseException e) {
			e.printStackTrace();
			System.out.println("Problema" + e.toString());
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prueba realizada para verificar si se puede eliminar un Usuario de la DB
	 */
	@Test
	public void testEliminarUsuario() {
		/**
		 * Id del Usuario a eliminar
		 */
		String idClienteEliminar = "1152690699";
		try {
			usuarioDAO.eliminarUsuario(idClienteEliminar);
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
