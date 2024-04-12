package com.uned.programacion;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Funciones {

	/**
	 * 
	 * @param args Entrada. Array con las fechas
	 * @return true si el numero de parametros son 2, si no son 2 devuelve false
	 */
	public static boolean numeroArgsCorrecto(String[] args) {
		if(args.length!=2) {
			//System.out.println("Número argumentos erróneo");
			return false;
		}
		else {
			return true;
		}
	} 
	/**
	 * 
	 * @param args Entrada. Array con las fechas
	 * @return true si el caracter separador de dia,mes,año es "/", false si alguno no es el caracter "/"
	 */
	public static boolean formatoCorrecto(String[] args) {
		int nocorrecto=0; // variable que contabiliza si el caracter es diferente a "/"
		for (int x=0;x<args.length;x++)
			if(args[x].charAt(2)!='/' || args[x].charAt(5)!='/' || args[x].length()!=10) {
				nocorrecto++;
			}
		if(nocorrecto == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param args Entrada. Array con las fechas
	 * @return true si todos digitos son numéricos y false si alguno no es numérico
	 */
	public static boolean formatoCaracterNumerico(String[] args) {
		int caracter = 0;
		for(int x=0;x<args.length;x++) { // Recorre los argumentos 
			for(int y=0;y<args[x].length();y++) { // Recorre cada caracter de args[x]
				if(y!=2 && y!=5) {
					if (!Character.isDigit(args[x].charAt(y))){
						caracter++;
					}
				}				
		 }
		}
		if (caracter==0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * 
	 * @param args Entrada. Array con las fechas
	 * @return True si la fecha es correcta y false si no lo es
	 * Hace llamada al método compruebaFecha para comprobar si los datos introducidos de dd,mm,aaaa son correctos
	 */
	public static boolean fechaCorrecta(String[] args) {
		int dia=0;
		int mes=0;
		int anio=1900;
		String dias="";
		String mess="";
		String anios="";

		int fechaInCorrecta=0;
		for(int x=0;x<args.length;x++) {
			dias=(args[x].substring(0, 2));
			mess=(args[x].substring(3, 5));
			anios=(args[x].substring(6, 10));
			dia=Integer.parseInt(dias);
			mes=Integer.parseInt(mess);
			anio=Integer.parseInt(anios);
		    if(compruebaFecha(dia,mes,anio)==false) {
		    	fechaInCorrecta++;
		    }
		}
		if(fechaInCorrecta==0) {
			return true;
		}
		else {
			return false;
		}
	
	}
	
	/**
	 * 
	 * @param d Parámetro de entrada dia
	 * @param m Parámetro de entrada mes
	 * @param a Parámetro de entrada Año
	 * @return true si la fecha (dd,mm,aaaa) es correcta y false si no es correcta
	 * Hace llamada al método bisiesto para comprobar si el año es bisiesto o no
	 * 
	 */
	private static boolean compruebaFecha(int d,int m, int a) {

		if(d < 1 || d > 31) {
			return false;
		}
		if(m < 1 || m > 12) {
			return false;
		}
		if(bisiesto(a)) {
			if (m == 2 && d > 29) {
				return false;
			}
		}else {
			if (m == 2 && d > 28) {
				return false;
			}
		}
		
		return true;
	}
	/**
	 * 
	 * @param a Parámetro de entrada año
	 * @return True si el año es bisiesto y false si no es bisiesto
	 * 
	 */
	private static boolean bisiesto(int a) {
		if((a % 400==0) || ((a % 4==0) && (a % 100!=0))) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * 
	 * @param args Entrada. Array con las fechas
	 * @throws Exception, necesario. 
	 * - Se convierte los parámetros a Date
	 * - Se convierte cada fecha en un long
	 * - Chequea el mayor para hacer la diferencia y no salga en negativo
	 * - Calcula el número de dias con la fórmula Math.floor(diferencia / (1000 * 60 * 60 * 24))
	 * - Muestra el resultado 
	 * 
	 */
	public static void mostraDiferenciaDias(String[] args) throws Exception{    
              
        // Convierte String a Fecha (Date)
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormateada1 = formatoFecha.parse(args[0]);
        Date dataFormateada2 = formatoFecha.parse(args[1]);
        
        // Convierte las fechas en long
        long ldate1 = dataFormateada1.getTime();
        long ldate2 = dataFormateada2.getTime();
        
        // Consultar cual es la mayor y realizar la diferencia
        long diferencia = 0;
        if (ldate1 > ldate2) {
        	diferencia = ldate1 - ldate2;
        }else {
        	diferencia = ldate2 - ldate1;
        }
         
        // Calcular el nº de días entre las fechas e imprimirlas
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        System.out.println("Hay " + (int)dias + " dia/s entre " + formatoFecha.format(dataFormateada1) + " y " + formatoFecha.format(dataFormateada2));
    
	}
	
	
}
