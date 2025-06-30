package arreglos;

import java.io.BufferedReader;
import java.util.ArrayList;

import clases.Clientes;

public class ArreglosClientes {
	private ArrayList<Clientes> listaClientes;
	
	public ArreglosClientes() {
		listaClientes = new ArrayList<Clientes>();
	}
	
	public void adicionar(Clientes c) {
		listaClientes.add(c);
	}
	
	public int tamanio() {
		return listaClientes.size();
	}
	
	public Clientes obtener(int i) {
		return listaClientes.get(i);
	}
	
	public Clientes buscarClientes(int dni) {
		for (int i = 0; i < tamanio(); i++) {
			if(obtener(i).getDni()==dni)
				return obtener(i);
		}
		return null;
	}
	
	public void eliminar(Clientes c) {
		listaClientes.remove(c);
	}
	
	/*private void cargarClientes() {
		try {
			BufferedReader br;
			String[] s;
			String linea, nombres, apellidos, direccionString;
			int telefono;
			br= new BufferedReader(br);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/
}

