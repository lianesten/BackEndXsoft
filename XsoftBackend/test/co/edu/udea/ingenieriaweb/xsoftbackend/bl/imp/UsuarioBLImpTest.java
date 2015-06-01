package co.edu.udea.ingenieriaweb.xsoftbackend.bl.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.UsuarioBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;


///*Le especificamos que correremos la prueba con el Junit de Spring*/
@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
///*Le decimos cual es el archivo de configuraciones del Spring*/
@ContextConfiguration(locations = "classpath:/ConfigurationSpring.xml")
///*Le decimos a Spring que en esta clase pueden haber cosas que deba
//inyectar*/
@Component
public class UsuarioBLImpTest {

	@Autowired
	UsuarioBl usuarioBl;
	
	/**
	 * Prueba mediante la cual se verifica que se pueda ingresar un usuario en
	 * la DB
	 * @throws LogicException 
	 */
	@Test
	public void testGuardarUsuario() throws LogicException {
		Usuario usuario = new Usuario();
		usuario.setNombres("Kely");
		usuario.setApellidos("Lezcano");
		usuario.setNumeroId("1152690699");
		usuario.setEmail("kely.lezcano@gmail.com");
		usuario.setPassword("kely");
		usuario.setUsername("kely");
		usuario.setPrivilegio(1);

		try {
			usuarioBl.guardarUsuario("1152690699", "Kely", "Lezcano", 1, "kely", "kely", "kely.lezcano@gmail.com");
			assertTrue(usuario != null);
			Logger log = Logger.getLogger(this.getClass());
			log.info("Nombre Usuario: " + usuario.getNombres());
		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	/**
	 * Prueba de integracion realizada para  comprobar que se puede obtener un usuario desde la DB
	 * @throws LogicException 
	 */
	@Test
	public void testObtenerUsuario() throws LogicException {
		/**
		 * Identificacion del Usuario en la base de datos con nombre Joaquin 
		 */
		String idUsuario = "1038481420";
		
		Usuario usuario = null;
		try {
			usuario = usuarioBl.obtenerUsuario(idUsuario);
			assertTrue(usuario != null);
			Logger log = Logger.getLogger(this.getClass());
			log.info("Nombre Usuario: " + usuario.getNombres());
		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	/**
	 * Prueba de integración realiada para verificar que se puede actualizar un usuario existente 
	 * en la DB
	 * @throws LogicException 
	 * @throws DataBaseException 
	 */
	@Test
	public void testActualizarUsuario() throws DataBaseException, LogicException {
		/**
		 * Obtenemos el usuario que se desea modificar
		 */
		Usuario usuario = usuarioBl.obtenerUsuario("1038481420");

		/**
		 * Llenamos los datos del Usuario, podemos cambiar todo excepto la
		 * identificacion
		 */
		usuario.setNombres("David");
		usuario.setApellidos("Hernandez");

		try {
			usuarioBl.actualizarUsuario(usuario.getNumeroId(), usuario.getNombres(), 
					usuario.getApellidos(), usuario.getPrivilegio(), usuario.getUsername(), 
					usuario.getPassword(), usuario.getEmail());
			assertTrue(usuario != null);
		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prueba de Integracion realizada para verificar que se puede obtener una lista de todos los
	 * usuarios existentes en la DB
	 */
	@Test
	public void testObtenerUsuarios() {
		List usuarios = null;
		Logger log = Logger.getLogger(this.getClass());
		try {
			usuarios = usuarioBl.obtenerUsuarios();
			assertTrue(usuarios != null);
			Usuario usuario = (Usuario) usuarios.get(0);
			log.info("Nombre Primer Usuario: " + usuario.getNombres());

		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prueba DE  integracion Realizada para Verificar que un usuario se puede eliminar de la DB
	 */
	@Test
	public void testEliminarUsuario() {
		/**
		 * Id del Usuario a eliminar
		 */
		String idUsuario = "1152690699";
		try {
			usuarioBl.eliminarUsuario(idUsuario);
			assertTrue(idUsuario != null);
		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
