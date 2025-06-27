package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Productos;

public class ArreglosProductos {
	
	private ArrayList<Productos> listaProductos;
	
	public ArreglosProductos() {
		listaProductos = new ArrayList<Productos>();
		cargarProductos();
	}
	
	public void adicionar(Productos x) {
		listaProductos.add(x);	
		grabarProductos();
	}
	
	public int tamanio() {
		return listaProductos.size();
	}
	
	public Productos obtener(int i) {
		return listaProductos.get(i);
	}
	
	public Productos buscarProductos(int codigo) {
		for (int i = 0; i < tamanio(); i++) {
			if(obtener(i).getCodigo()==codigo)
				return obtener(i);
		}
		return null;
	}
	
	public void eliminar (Productos x) {
		listaProductos.remove(x);
		grabarProductos();
	}
	
	private void cargarProductos() {
		try {
			BufferedReader br;
			String[] s;
			String linea, categoria, producto;
			int codigo;
			double precio;
			br = new BufferedReader(new FileReader("productos.txt"));
			while((linea=br.readLine())!=null) {
				s=linea.split(";");
	            codigo = Integer.parseInt(s[0]);
	            categoria = s[1];
	            producto = s[2];
	            precio = Double.parseDouble(s[3]);
				listaProductos.add(new Productos(codigo, categoria, producto, precio));
			}
			br.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void grabarProductos() {
		try {
			PrintWriter pw;
			String linea;
			Productos x;
			pw = new PrintWriter(new FileWriter("productos.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x=obtener(i);
				linea = x.getCodigo()+";"+
						x.getCategoria()+";"+
						x.getProducto()+";"+
						x.getPrecio();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void actualizarArchivo() {
		grabarProductos();
	}
}
