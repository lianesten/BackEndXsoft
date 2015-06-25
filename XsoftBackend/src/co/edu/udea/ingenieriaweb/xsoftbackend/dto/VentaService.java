package co.edu.udea.ingenieriaweb.xsoftbackend.dto;

public class VentaService {
	
	private String nombreUsuario;
	private String nombreCliente;
	private String userNameUsuario;
	private String numerIdUsuario;
	private String numerIdCliente;
	private int numeroIdVenta;
	private String apellidosCliente;
	private String direccionCliente;
	private String emailCliente;
	private String telefonoMovilCliente;
	
	public VentaService(String nombreUsuario, String nombreCliente,
			String userNameUsuario, String numerIdUsuario,
			String numerIdCliente, int numeroIdVenta, String apellidosCliente,
			String direccionCliente, String emailCliente,
			String telefonoMovilCliente, String telefonofijoCliente) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.nombreCliente = nombreCliente;
		this.userNameUsuario = userNameUsuario;
		this.numerIdUsuario = numerIdUsuario;
		this.numerIdCliente = numerIdCliente;
		this.numeroIdVenta = numeroIdVenta;
		this.apellidosCliente = apellidosCliente;
		this.direccionCliente = direccionCliente;
		this.emailCliente = emailCliente;
		this.telefonoMovilCliente = telefonoMovilCliente;
		this.telefonofijoCliente = telefonofijoCliente;
	}
	private String telefonofijoCliente;
	
}
