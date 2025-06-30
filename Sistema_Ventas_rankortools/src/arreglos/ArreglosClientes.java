package arreglos;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


import clases.Clientes;

public class ArreglosClientes {
	
	private ArrayList<Clientes> listaClientes;
	
	public ArreglosClientes() {
		listaClientes = new ArrayList<Clientes>();
		cargarClientes();
	}
	
	public void adicionar(Clientes c) {
		listaClientes.add(c);
		grabarClientes();
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
		grabarClientes();
	}
	
	private void cargarClientes() {
		try {
			BufferedReader br;
			String[] s;
			String linea, nombres, apellidos, direccion;
			int dni, telefono;
			br= new BufferedReader(new FileReader("clientes.txt"));
				while((linea=br.readLine())!=null) {
					s=linea.split(";");
					dni = Integer.parseInt(s[0]);
					nombres = s[1];
					apellidos = s[2];
					direccion =  s[3];
					telefono = Integer.parseInt(s[4]);
					listaClientes.add(new Clientes(dni, nombres, apellidos, direccion, telefono));
				}
				br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void grabarClientes() {	
		try {
			PrintWriter pw;
			String linea;
			Clientes x;
			pw = new PrintWriter(new FileWriter("clientes.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x=obtener(i);
				linea = x.getDni()+";"+
						x.getNombres()+";"+
						x.getApellidos()+";"+
						x.getDireccion()+";"+
						x.getTelefono();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

