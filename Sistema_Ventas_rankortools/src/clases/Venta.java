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

	    public Clientes getCliente() {
			return cliente;
		}

		public void setCliente(Clientes cliente) {
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

		public String formatoBoleta() {
		    return String.format("""
		            BOLETA DE VENTA

		            === DATOS DEL CLIENTE ===
		            DNI       : %d
		            Nombres   : %s
		            Apellidos : %s
		            Dirección : %s
		            Teléfono  : %d

		            === DETALLE DE COMPRA ===
		            Categoría : %s
		            Producto  : %s
		            Precio    : S/ %.2f
		            Cantidad  : %d unidad%s

		            Total a pagar : S/ %.2f
		            """,
		            cliente.getDni(),
		            cliente.getNombres(),
		            cliente.getApellidos(),
		            cliente.getDireccion(),
		            cliente.getTelefono(),
		            categoria, producto, precio, cantidad, (cantidad > 1 ? "es" : ""), total
		    );
		}


	    public String toArchivo() {
	        return categoria + ";" + producto + ";" + precio + ";" + cantidad + ";" + total;
	    }
}

	

