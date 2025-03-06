package fecha;
/**
 * Clase Fecha
 */
public class Fecha {
	private static final int DIEZ = 10;

	/**
	 * Atributo privado que indicará el día.
	 */
	private int d; //d�a
	
	/**
	 * Atributo privado que indicará el mes.
	 */
	private int m; //mes
	
	/**
	 * Atributo privado que indicará el año.
	 */
	private int a; //a�o

	/**
	 * Constructor de clase Fecha vacío.
	 */
	public Fecha() {

	}

	/**
	 * Constructor de clase Fecha con atributos día, mes y anio(año).
	 * @param dia Parámetro de entrada que indicará el día.
	 * @param mes Parámetro de entrada que indicará el mes.
	 * @param anio Parámetro de entrada que indicará el año.
	 */
	public Fecha(int dia, int mes, int anio) {
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	
	/**
	 * Función que indicará si la fecha dada es correcta.
	 * @return Retorna un booleano indicando si la fecha es correcta o no.
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		boolean diaMayor1 = d >= 1;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && d <= 29;
			} else {
				diaCorrecto = diaMayor1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && d <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Función privada utilizada por el método fechaCorrecta(), indica si un año es bisiesto..
	 * @return Devuelve un booleano indicando si la fecha es bisiesta.
	 */
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	/**
	 * Función que incrementa en 1 el día.
	 */
	public void nextDay() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	/**
	 * Override de método toString().
	 */
	public String toString() {
		if (d < DIEZ && m < DIEZ) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < DIEZ && m >= DIEZ) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= DIEZ && m < DIEZ) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
