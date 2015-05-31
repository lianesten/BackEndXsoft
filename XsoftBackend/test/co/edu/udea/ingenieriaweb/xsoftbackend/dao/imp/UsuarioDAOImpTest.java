package co.edu.udea.ingenieriaweb.xsoftbackend.dao.imp;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.ingenieriaweb.xsoftbackend.dao.ClienteDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dao.UsuarioDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;


///*Le especificamos que correremos la prueba con el Junit de Spring*/
@RunWith (SpringJUnit4ClassRunner.class)

//@Transactional
///*Le decimos cual es el archivo de configuraciones del Spring*/
@ContextConfiguration (locations ="classpath:/ConfigurationSpring.xml")

///*Le decimos a Spring que en esta clase pueden haber cosas que deba inyectar*/
@Component
public class UsuarioDAOImpTest {

	@Autowired
	UsuarioDAO usuarioDAO;

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
		
		try{
			usuarioDAO.guardarUsuario(usuario);
			assertTrue(usuario!=null);
			Logger  log = Logger.getLogger(this.getClass());
			log.info("Nombre Usuario: " + usuario.getNombres());
		}
		catch(DataBaseException e){
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	@Test
	public void testObtenerUsuario() {
		/**
		 * Identificacion del Uusario en la base de datos con nombre Pablo Andres
		 */
		 String idUsuario = "1038481420";

			Usuario usuario = null;
		 try{
				 usuario = usuarioDAO.obtenerUsuario(idUsuario);
				assertTrue(usuario!=null);
				Logger  log = Logger.getLogger(this.getClass());
				log.info("Nombre Usuario: " + usuario.getNombres());
			}catch(DataBaseException e){
				e.printStackTrace();
				fail("Not yet implemented");
			}
	}

	@Test
	public void testActualizarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerUsuarios() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarUsuario() {
		fail("Not yet implemented");
	}

}
