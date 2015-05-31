package co.edu.udea.ingenieriaweb.xsoftbackend.exception;


/**
 * Clase que permite controlar las excepciones de datos faltantes producidas por el Usuario
 * @author JoaquinD
 *
 */
/**
 * Clase realizada para controlor los errores presentados por la falta de informacion ingresada
 * o incompleta, Ejemplo (Fecha en formato erroneo,datos faltantes)
 * @author Grupo de Desarrollo Xsoft
 *
 */
public class LogicException extends Exception {
	
	/**
	 * Constructor que recibe un mesaje y lo tira hacia la logica del negocio
	 * @param mensaje
	 */
	public LogicException(String mensaje) {
		super(mensaje);
	}

}
