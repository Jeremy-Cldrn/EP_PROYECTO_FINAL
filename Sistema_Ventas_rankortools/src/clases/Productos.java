package clases;

public class Productos {
	
	private int codigo;
	private String categoria, producto;
	private double precio;
	
	public Productos(int codigo, String categoria, String producto, double precio) {
		this.codigo = codigo;
		this.categoria = categoria;
		this.producto = producto;
		this.precio = precio;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
}
