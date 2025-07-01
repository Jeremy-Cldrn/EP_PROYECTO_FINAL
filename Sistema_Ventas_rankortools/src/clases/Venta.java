package clases;

public class Venta {
	private String categoria;
	private String producto;
	private double precio;
	private int cantidad;
	private double total;
	private Clientes cliente;

	public Venta(String categoria, String producto, double precio, int cantidad, Clientes cliente) {
	  this.categoria = categoria;
	  this.producto = producto;
	  this.precio = precio;
	  this.cantidad = cantidad;
	  this.total = precio * cantidad;
	  this.cliente = cliente;
	}


	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	
	

	public String BoletaSimple() {
		StringBuilder sb = new StringBuilder();

		// Encabezado de la boleta
		sb.append("            BOLETA DE VENTA\n");
		sb.append("----------------------------------------------------------------\n");

		// Datos del Cliente
		sb.append("=== DATOS DEL CLIENTE ===\n");
		sb.append(String.format("DNI \t: %s\n", cliente.getDni()));
		sb.append(String.format("Nombres \t: %s\n", cliente.getNombres()));
		sb.append(String.format("Apellidos\t: %s\n", cliente.getApellidos()));
		sb.append(String.format("Dirección\t: %s\n", cliente.getDireccion()));
		sb.append(String.format("Teléfono \t: %s\n\n", cliente.getTelefono()));

		// Detalle de Compra
		sb.append("=== DATOS DE LA COMPRA ===\n");
		sb.append("----------------------------------------------------------------\n");
		sb.append(String.format("%-15s\t| %-25s\n", "Categoría",categoria));
		sb.append(String.format("%-15s\t| %-25s\n", "Producto",producto));
		sb.append(String.format("%-15s\t| S/ %.2f\n", "Precio",precio));
		sb.append(String.format("%-15s\t| %d unidad%s\n", "Cantidad",cantidad, (cantidad > 1 ? "es" : "")));
		sb.append("----------------------------------------------------\n\n");

		// Total
		sb.append("=== TOTAL A PAGAR ===\n");
		sb.append("----------------------------------------------------------------\n");
		sb.append(String.format("Total a pagar \t: S/ %.2f\n", total));
		    
		  return sb.toString();
	}

	public String toArchivo() {
		return categoria + ";" + producto + ";" + precio + ";" + cantidad + ";" + total;
	}
}

	

