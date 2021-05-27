package paquete1;

/**
 * El programa Enteros, se basa en la realizacion de varias operaciones matematicas sobre un numero(n), tendremos
 * como opciones, ver si es un factorial, mostrar una cadena de enteros del reves, averiguar si la cadena es capicua,
 * los multiplos del numero, si es primo, etc.
 * @author Fran Cespedes Sanchez
 */
public class Enteros {
	/**
	 * Este apartado devuelve, tras una condicion sobre el entero, en caso de ser 0, un 1, y en caso de
	 * que no sea 0, devuelve el resultado de n * r_factorial(n -1)
	 * @param n El parametro n hace referencia al entero con el cual realizaremos la operacion en cuestion
	 * @return En caso de ser 0, un 1, y en caso de que no sea 0, devuelve el resultado de n * r_factorial(n -1)
	 */
	public static int r_factorial(int n) {
		int resultado;
		//La condicion de que n sea igual a 0, devolverá un 1
		if (n == 0) {
			resultado = 1;
		} else {
			//La condicion contraria, devolverá el resultado de la operacion.
			resultado = n * r_factorial(n - 1);
		}
		return resultado; //Devuelve n * r_factorial(n-1)
}

	/**
	 * Este metodo calcula el factorial del numero que introducimos como parametro.
	 * @param n De nuevo, el parametro hace referencia al entero que usaremos en el programa.
	 * @return Devuelve el factorial del numero en cuestion
	 */
	public static int factorial(int n) {
		int resultado;

		resultado = 1; //Se inicializa el resultado para que en caso de que no exista, devuelva 1
		// Bucle que calcula el factorial del numero n
		for (int i = 2; i <= n; i++) {
			resultado = resultado * i;
		}
		return resultado; //Devuelve factorial
}

	/**
	 * Con este metodo podremos imprimir una cadena de enteros en orden inverso.
	 * @param cadena Esta es la cadena que utilizaremos para darle la vuelta a la misma.
	 * @return Devuelve dicha cadena en orden inverso.
	 */
	public static String alreves(String cadena) {
		String resultado = ""; //Inicializamos la cadena
		//Bucle que rellena la cadena
		for (int i = cadena.length() - 1; i >= 0; i--) {
			resultado = resultado + cadena.charAt(i);
		}
		return resultado; //Devuelve la cadena
}

	/**
	 * El metodo capicua averigua si la cadena de enteros introducida es capicua con respecto a la cadena
	 * del reves o no.
	 * @param n Es el entero que se pide y rellena la cadena.
	 * @return Devuelve true si es capicua en referencia a la otra cadena o false si no lo es
	 */
	public static boolean capicua(int n) {
		//Inicializar los atributos
		boolean resultado;
		String cadena;
		//Volcamos la cadena de enteros en un String
		cadena = Integer.toString(n);
		//Comprobar si la cadena es capicua
		if (cadena.equals(alreves(cadena))) {
			resultado = true;
		} else {
			resultado = false;
		}

		return resultado; //Devuelve boolean segun condicion true o false
}

	/**
	 * Con este metodo podremos averiguar si un numero des divisible por otro, ambos introducidos por el usuario
	 * @param multiplo Es el numero que queremos averiguar si es divisible por el otro numero.
	 * @param divisor Este será el numero que divida al primero
	 * @return Devuelve true si multiplo es divisible por divisor y false si no lo es
	 */
	public static boolean divisible(int multiplo, int divisor) {
		boolean resultado; //Inicializa atributo boolean
		//Comprobar si es divisor
		if (multiplo % divisor == 0) {
			resultado = true;
		} else {
			resultado = false;
		}

		return resultado; //Devuelve boolean segun resultado
}

	/**
	 * Este metodo es parecido al anterior, pero averigua si divisor es multiplo de mult.
	 * @param mult Indica el numero sobre el que queremos averiguar si divisor es multiplo.
	 * @param divisor Indica el numero con el que realizaremos la operacion
	 * @return Devuelve true si es multiplo y false si no lo es
	 */
	public static boolean multiplo(int mult, int divisor) {
		boolean resultado; //Inicializa atributo
		//Probar si es multiplo
		try {
			if (mult % divisor == 0) {
				resultado = true;
			} else {
				resultado = false;
			}
			//En caso de error imprimir una advertencia y el resultado seria false
		} catch (ArithmeticException e) {
			resultado = false;
		}
		return resultado; //Devuelve boolean del resultado
}

	/**
	 * Con este metodo averiguaremos si un entero(n) es un numero primo o no.
	 * @param n Indica el numero que queremos averiguar si es primo
	 * @return Devuelve true en caso de ser primo y false en caso de no serlo
	 */
	public static boolean esPrimo(int n) {
		boolean primo; //Inicializa el atriburo
		//Comprueba si el numero es primo
		if (n <= 1) {
			primo = false; //Primo comienza como false
		} else {
			primo = true;
			int i = 2;
			while (primo && i <= n / 2) {
				if (divisible(n, i)) {
					primo = false;
				} else {
					i++;
				}
			}
		}
		return primo; //Devuelve boolean segun resultado de operacion
}

	/**
	 * En este metodo introduciremos un numero de maximo y averiguaremos los numeros primos hasta dicho numero.
	 * @param n Indica el numero hasta el cual se realizará dicha comprobacion
	 * @return Devuelve el numero de primos que hay hasta el numero en cuestion
	 */
	public static int n_primos(int n) {
		int resultado = 0; //Inicializa el entero
		//Comprobar si los numeros hasta n son primos
		for (int i = 2; i <= n; i++) {
			if (esPrimo(i)) {
				resultado++;
			}
		}
		return resultado; //Devuelve los numeros primos hasta n
}

	/**
	 * El metodo primosHasta, crea un array en el cual añadiremos los numeros primos hasta n del metodo n_primos, y
	 * posteriormente los mostrara
	 * @param n Indica el numero hasta el cual se realizará dicha comprobacion
	 * @return Devuelve el array con los numeros primos que hay en dicho espacio hasta el numero n.
	 */
	public static int[] primosHasta(int n) {
		int[] resultado; //Inicializa el array
		//Da un valor inicial a partir del array anterior a resultado
		resultado = new int[n_primos(n)];
		int cont = 0;
		//Almacena los primos en el array
		for (int i = 2; i <= n; i++) {
			if (esPrimo(i)) {
				resultado[cont] = i;
				cont++;
			}
		}

		return resultado; //Devuelve el array
}

	/**
	 * Con el metodo primerosPrimos, comprobaremos de nuevo hasta n crearemos un contador que ira incrementandose
	 * y comnprobando a partir de i, que es un contador que se incrementa igual, si dicho numero es primo
	 * @param n Indica el numero hasta el cual se realizará dicha comprobacion
	 * @return Devuelve el array con los numeros que ha guardado en la comprobacion de los primos
	 */
	public static int[] primerosPrimos(int n) {
		int[] resultado = new int[(n < 0) ? 0 : n]; //Da un valor al array
		//Inicia los contadores
		int cont = 0;
		int i = 2;
		//Mientras cont < n comprueba los primos
		while (cont < n) {
			if (esPrimo(i)) {
				resultado[cont] = i;
				cont++;
			}
			i++;
		}

		return resultado; //Devuelve el array
	}
}
