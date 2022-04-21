package logica;

public class Entrada {
	String nombre;
	String apellido;
	String rut;
	
	
	public Entrada() {
	}


	public Entrada(String nombre, String apellido, String rut) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getRut() {
		return rut;
	}


	public void setRut(String rut) {
		this.rut = rut;
	}


	@Override
	public String toString() {
		return "Entrada [nombre=" + nombre + ", apellido=" + apellido + ", rut=" + rut + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
}
