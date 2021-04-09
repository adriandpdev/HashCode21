import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static int tiempo = 0;
	public static int segundos = 0;
	public static String[] ficheros = { "a", "b", "c", "d", "e", "f" };

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 6; i++) {
			leerfichero("inputs/"+ficheros[i]);
			cantidadSemaforos();
			escribirFichero("submit_" + ficheros[i]);
			System.out.println("Listo");
		}
	}

	public static int segundosTotales = 0;
	public static int interseccionComienzo = 0;
	public static int interseccionFinal = 0;
	public static int totalIntersecciones = 0;
	public static int totalCalles = 0;
	public static int totalCoches = 0;
	public static int puntos = 0;
	public static int tiempoTarda = 0;
	public static String calle;
	public static String[] nombreCalles;
	public static Coche[] coches;
	public static Calle[] calles;
	public static int banderas = 0;
	public static ArrayList<Integer> semaforos = new ArrayList<Integer>();

	public static void leerfichero(String name) throws IOException {
		File f = new File(name + ".txt");

		if (f.exists()) {
			FileReader fr = new FileReader(f);
			BufferedReader BRF = new BufferedReader(fr);

			String linea;
			linea = BRF.readLine();
			int cont = 0;
			int contadorCoche = 0;
			int contadorCalles = 0;

			String[] datos;
			while (linea != null) {
				if (cont == 0) {
					datos = linea.split(" ");
					segundosTotales = Integer.parseInt(datos[0]);
					totalIntersecciones = Integer.parseInt(datos[1]);
					totalCalles = Integer.parseInt(datos[2]);
					totalCoches = Integer.parseInt(datos[3]);
					puntos = Integer.parseInt(datos[4]);
					coches = new Coche[totalCoches];
					calles = new Calle[totalCalles];
				} else if (cont <= totalCalles) {
					datos = linea.split(" ");
					interseccionComienzo = Integer.parseInt(datos[0]);
					interseccionFinal = Integer.parseInt(datos[1]);
					calle = datos[2];
					tiempoTarda = Integer.parseInt(datos[3]);
					calles[contadorCalles] = new Calle(interseccionComienzo, interseccionFinal, tiempoTarda, calle);
					contadorCalles++;
				} else {
					nombreCalles = linea.split(" ");
					coches[contadorCoche] = new Coche(contadorCoche, nombreCalles.length - 1, nombreCalles, 0);
					contadorCoche++;
				}
				linea = BRF.readLine();
				cont++;
			}
			BRF.close();
			fr.close();
		}
	}

	public static void cantidadSemaforos() {
		banderas = 0;
		semaforos.clear();
		for (int i = 0; i < totalIntersecciones; i++) {
			int termina = 0;
			for (int j = 0; j < calles.length; j++) {
				if (i == calles[j].getTermina()) {
					termina++;
				}
			}
			if (termina >= 1) {
				banderas++;
				semaforos.add(i);
			}
		}
	}

	public static void escribirFichero(String string) throws IOException {

		FileWriter fw = new FileWriter("outputs/"+ string + ".txt", false);
		PrintWriter pw = new PrintWriter(fw);

		pw.println(banderas);

		for (int j = 0; j < banderas; j++) {

			pw.println(semaforos.get(j));
			ArrayList<String> listado = contarCarreteras(semaforos.get(j));
			pw.println(listado.size());
			Collections.reverse(listado);
			for (String dato : listado) {

				pw.println(dato + " " + 1);

			}

		}
		pw.close();
		fw.close();

	}

	public static ArrayList<String> contarCarreteras(int numero) {
		ArrayList<String> listado = new ArrayList<String>();
		for (int j = 0; j < calles.length; j++) {
			if (numero == calles[j].getTermina()) {
				listado.add(calles[j].getNombre());
			}
		}

		return listado;

	}

}
