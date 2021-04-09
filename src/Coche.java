
public class Coche extends Thread {
	private int n;
	private String[] recorrido;
	private int tiempo;

	public Coche() {

	}

	public Coche(int n, int x, String[] calles, int t) {
		this.n = n;
		this.recorrido = new String[x];
		this.recorrido = calles;
		this.tiempo = t;
	}

	public void run() {

	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public String[] getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(String[] recorrido) {
		this.recorrido = recorrido;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

}
