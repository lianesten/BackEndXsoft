package co.edu.udea.ingenieriaweb.xsoftbackend.bl;

import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;

public interface SessionBl {
	/**
	 * Metodo mediante el cual se verifica el logeo de un usuario en el sistema
	 * @param username
	 * @param password
	 * @return String con el token del usuario
	 */
	public String autenticar(String username, String password);
	
	/**
	 *Metodo mediante el cual se cierra la sesion de un usuario en la DB 
	 * @param usuario
	 */
	public void cerrarSesion(String idUsuario);
}
