package clases;

public class Venta {

	    private String categoria;
	    private String producto;
	    private double precio;
	    private int cantidad;
	    private double total;

	    public Venta(String categoria, String producto, double precio, int cantidad) {
	        this.categoria = categoria;
	        this.producto = producto;
	        this.precio = precio;
	        this.cantidad = cantidad;
	        this.total = precio * cantidad;
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
	                
	                Categoría\t : %s
	                Producto \t : %s
	                Precio \t : S/ %.2f
	                Cantidad \t : %d unidad%s

	                Total a pagar \t : S/ %.2f
	                """, categoria, producto, precio, cantidad, (cantidad > 1 ? "es" : ""), total);
	    }

	    public String toArchivo() {
	        return categoria + ";" + producto + ";" + precio + ";" + cantidad + ";" + total;
	    }
}

	

