package jarras;

/**
 * La clase Mesa representa objetos que contienen dos jarras.
 */
public class Mesa {
	/**
	 * Permite indicar la posición que ocupa una jarra en la mesa.
	 */
	public enum Posicion {
		Izquierda, Derecha
	};

	/**
	 * Variable de instancia que representa la jarra de la izquierda
	 */
	private Jarra jarraIz;

	/**
	 * Variable de instancia que representa la jarra de la derecha
	 */
	private Jarra jarraDr;

	/**
	 * Constructor para crear mesas con dos jarras con capacidades indicadas por los
	 * enteros que se pasan como argumento.
	 * 
	 * @param cIz Capacidad de la primera jarra
	 * @param cDr Capacidad de la segunda jarra
	 */
	public Mesa(int cIz, int cDr) {
		jarraIz = new Jarra(cIz);
		jarraDr = new Jarra(cDr);
	}

	/**
	 * Constructor para crear mesas con las dos jarras que se pasan como argumento.
	 * que se pasan como argumento.
	 * 
	 * @param jIz Jarra izquierda
	 * @param jDr Jarra derecha
	 */
	public Mesa(Jarra jIz, Jarra jDr) {
		if (jIz == jDr)
			throw new RuntimeException("Las jarras no pueden ser la misma");
		jarraIz = jIz;
		jarraDr = jDr;
	}

	/**
	 * Método para obtener el contenido de la jarra indicada en el argumento.
	 * 
	 * @param pos Posición de la jarra
	 * @return Contenido de la jarra
	 */
	public int contenido(Posicion pos) {
		/* Solución con if 
		int res = 0; 
		if (pos == Posicion.Izquierda) 
			res = jarraIz.contenido(); 
		else 
			res = jarraDr.contenido(); 
		return res;
		*/
		 
		/* Solución con operador ternario 
		return (pos == Posicion.Izquierda) ? jarraIz.contenido() : jarraDr.contenido();
		*/
		
		// Solución con switch funcional
		return switch (pos) {
		case Izquierda -> jarraIz.contenido();
		case Derecha -> jarraDr.contenido();
		};
	}

	/**
	 * Método para obtener el contenido de la jarra indicada en el argumento.
	 * 
	 * @param pos Posición de la jarra
	 * @return Capacidad de la jarra
	 */
	public int capacidad(Posicion pos) {
		return switch (pos) {
		case Izquierda -> jarraIz.capacidad();
		case Derecha -> jarraDr.capacidad();
		};
	}

	/**
	 * Método para llenar la jarra indicada en el argumento.
	 * 
	 * @param pos Posición de la jarra
	 */
	public void llena(Posicion pos) {
		/* Solución con if
		if (pos == Posicion.Izquierda) 
			jarraIz.llena();
		else
			jarraDr.llena();
		*/
		// Solución con switch
		switch (pos) {
		case Izquierda:
			jarraIz.llena();
			break;
		case Derecha:
			jarraDr.llena();
			break;
		}
	}

	/**
	 * Método para vaciar la jarra indicada en el argumento.
	 * 
	 * @param pos Posición de la jarra
	 */
	public void vacia(Posicion pos) {
		switch (pos) {
		case Izquierda:
			jarraIz.vacia();
			break;
		case Derecha:
			jarraDr.vacia();
		}
		;
	}

	/**
	 * Método para llenar una jarra sobre la otra. La jarra que se vuelca sobre la
	 * otra es la que se indica en el argumento.
	 * 
	 * @param pos Posición de la jarra que se vuelca
	 */
	public void llenaDesde(Posicion pos) {
		/* Solución con if 
		if (pos == Posicion.Izquierda) 
			jarraDr.llenaDesde(jarraIz);
		else 
			jarraIz.llenaDesde(jarraDr);
		 */
		// Solución con switch
		switch (pos) {
		case Izquierda:
			jarraDr.llenaDesde(jarraIz);
			break;
		case Derecha:
			jarraIz.llenaDesde(jarraDr);
		}
	}

	/**
	 * Redefinición del método toString para devolver la representación textual de
	 * una mesa de la forma siguiente: M(jarraIz, jarraDr)
	 */
	@Override
	public String toString() {
		return "M(" + jarraIz + ", " + jarraDr + ")";
	}
}
