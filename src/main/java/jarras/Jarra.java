package jarras;


/**
 * En esta clase "simulamos" el uso de una jarra de agua. Suponemos que
 * disponemos de una fuente y un sumidero de tal manera que podemos llenar la
 * jarra (entera) y vaciarla (entera también). Otra operación permitida es
 * llenar una jarra con el agua que haya en otra jarra (sin que llegue a
 * rebosar).
 */
public class Jarra {
	/**
	 * Contenido de líquido (en litros) de la jarra.
	 */
	private int contenido;

	/**
	 * Capacidad de la jarra (en litros).
	 */
	private final int capacidad;

	/**
	 * Constructor para crear una jarra a partir de su capacidad.
	 * 
	 * @param capac
	 *            capacidad que va a tener la jarra.
	 */
	public Jarra(int capac) {
		if (capac <= 0) 
			throw new RuntimeException("La capacidad de la jarra debe ser positiva");
		capacidad = capac;
		contenido = 0;
	}

	/**
	 * Devolvemos la capacidad de la jarra.
	 * 
	 * @return int con la capacidad de la jarra.
	 */
	public int capacidad() {
		return capacidad;
	}

	/**
	 * Devolvemos la cantidad de líquido que hay en la jarra.
	 * 
	 * @return int con la cantidad de líquido que hay en la jarra.
	 */
	public int contenido() {
		return contenido;
	}

	/**
	 * Llenamos por completo la jarra.
	 */
	public void llena() {
		contenido = capacidad;
	}

	/**
	 * Vaciamos por completo la jarra.
	 */
	public void vacia() {
		contenido = 0;
	}

	/**
	 * Llenamos la jarra con el contenido de otra jarra. Llenamos hasta
	 * que no quepa más agua o hasta que la otra jarra se vacíe.
	 * 
	 * @param j
	 *            Jarra desde la que volcar el agua.
	 */
	public void llenaDesde(Jarra j) {
		if (this==j)
			throw new RuntimeException("No es posible volcar una jarra sobre sí misma");
		int cantidadAVerter = Math.min(capacidad - contenido, j.contenido());
		contenido = contenido + cantidadAVerter;
		j.contenido = j.contenido - cantidadAVerter;
	}

	/**
	 * Representamos una jarra mediante:
	 * 		J(contenido, capacidad)
	 */
	@Override
	public String toString() {
		return "J(" + capacidad + ", " + contenido + ")";
	}
}
