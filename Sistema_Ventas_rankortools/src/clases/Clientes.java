package clases;

public class Clientes {
	private int dni;
	private String nombres, apellidos, direccion;
	private int telefono;
	
	public Clientes(int dni, String nombres, String apellidos, String direccion, int telefono) {
		super();
		this.dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	// metodo publico
	public String nombreCompleto() {
		return nombres + apellidos + "";
	}

	}
