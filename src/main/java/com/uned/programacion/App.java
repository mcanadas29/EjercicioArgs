package com.uned.programacion;



/**
 * Programa que recibe 2 párametros en formato dd/mm/aaaa y comprueba las fechas
 * y nos muestra el número de dias que hay entre las fechas. Si el formato y/o numero de argumentos 
 * y/o la fecha es incorrecta muestra un mensaje por consola indicándolo
 * 
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
    	if(Funciones.numeroArgsCorrecto(args) 
    		&& Funciones.formatoCorrecto(args) 
    		&& Funciones.formatoCaracterNumerico(args)
    		&& Funciones.fechaCorrecta(args)) { 
    		
    			System.out.println("Número argumentos (" + args.length + ") y formato correcto" );
    			Funciones.mostraDiferenciaDias(args);
    	}
    	else {
    		System.out.println("Número argumentos y/o formato y/o fecha Incorrecto/a. El Formato correcto es dd/mm/aaaa ");
    		System.out.println("Ejemplo 01/02/2024 ");
    	}
    	
    }
    
    
}
