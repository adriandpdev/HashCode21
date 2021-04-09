import java.util.*;

public class Calle {

	// EMPIEZA TERMINA NOMBRE DURACION COCHES
	private int empieza, termina, duracion;
	private String nombre;
	private ArrayList<String> coches;

	public Calle(int empieza, int termina, int duracion, String nombre) {

		this.empieza = empieza;
		this.termina = termina;
		this.duracion = duracion;
		this.nombre = nombre;
	}

	public int getEmpieza() {
		return empieza;
	}

	public void setEmpieza(int empieza) {
		this.empieza = empieza;
	}

	public int getTermina() {
		return termina;
	}

	public void setTermina(int termina) {
		this.termina = termina;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getCoches() {
		return coches;
	}

	public void setCoches(ArrayList<String> coches) {
		this.coches = coches;
	}

}
