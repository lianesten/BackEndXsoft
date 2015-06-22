package co.edu.udea.ingenieriaweb.xsoftbackend.bl.imp;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.SessionBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.dao.UsuarioDAO;

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
@Component
public class SessionBLImpTest {
	
	@Autowired
	UsuarioDAO usuarioDAO;
	@Autowired
	SessionBl  sesionBl;

	/**
	 * Prueba realizada para comprobar que los token de usuario si se estan generando correctamente
	 */
//	@Test
	public void testAutenticar() {
		String username = "jodaheca";
		String password = "12345";
		
		try{
			String token = sesionBl.autenticar(username, password);
			/**
			 * Realizamos la comparacion con el Token equivalente a los datos pasados como parametros
			 */
			assertTrue(token.equals("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VySWQiOiIxMDM4NDgxNDIwIiwicm9sIjoiMSIsInVzZXJuYW1lIjoiam9kYWhlY2EifQ.7rQmg4iYjCTxu4eoImx2UwDzu_i5R3NIyNKkuZd8SiKIlx8Y2AA7q8Z2TcQUPAIJauDMLbs8_PHwReAk92OMAg"));
			Logger log = Logger.getLogger(this.getClass());
			log.info("Token: "+ token);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Prueba realizada para verificar que se cierre correctamente una sesion
	 */
	@Test
	public void testCerrarSesion() {
		
		String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VySWQiOiIxMDM4NDgxNDIwIiwicm9sIjoiMSIsInVzZXJuYW1lIjoiam9kYWhlY2EifQ.7rQmg4iYjCTxu4eoImx2UwDzu_i5R3NIyNKkuZd8SiKIlx8Y2AA7q8Z2TcQUPAIJauDMLbs8_PHwReAk92OMAg";
		try{
		sesionBl.cerrarSesion(token);
		assertTrue(usuarioDAO.obtenerUsuario("1038481420").getToken()==null);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
