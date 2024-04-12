package com.uned.programacion;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;



import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

 

@TestMethodOrder( MethodOrderer.DisplayName.class )
public class AppTest 
{
	  /**
     * Test Unitarios de App con Argumentos fechas
     */
	
	
 
    @Test
    public void numeroArgsCorrecto() {
    	String[] args = {"31/12/1969","09/04/2024"};
    	assertTrue(Funciones.numeroArgsCorrecto(args));
    }
    @Test
    public void numeroArgsIncorrectoUno() {
    	String[] args = {"09/04/2024"};
    	assertFalse(Funciones.numeroArgsCorrecto(args)); 	
    }
    @Test
    public void numeroArgsIncorrectoTres() {
    	String[] args = {"09/04/2024","09/04/2024","09/04/2024"};
    	assertFalse(Funciones.numeroArgsCorrecto(args)); 	
    }
    @Test
    public void numeroArgsIncorrectoNinguno() {
    	String[] args = {};
    	assertFalse(Funciones.numeroArgsCorrecto(args)); 	
    }   
    @Test
    public void formatoCorrecto() {
    	String[] args = {"31/12/1969","09/04/2024"};
    	assertTrue(Funciones.formatoCorrecto(args));
    }
    @Test
    public void formatoCorrectoLongitudCorrecta() {
    	String[] args = {"31/12/1969","09/04/2024"};
    	assertTrue(Funciones.formatoCorrecto(args));
    }
    @Test
    public void formatoCorrectoLongitudInCorrecta() {
    	String[] args = {"31/12/196","09/04/2024"};
    	assertFalse(Funciones.formatoCorrecto(args));
    }
    @Test
    public void formatoCorrectoCaracterCorrecto() {
    	String[] args = {"31/12/1969","09/04/2024"};
    	assertTrue(Funciones.formatoCorrecto(args));
    }
    @Test
    public void formatoCorrectoCaracterIncorrecto() {
    	String[] args = {"31&12&1969","09&04&2024"};
    	assertFalse(Funciones.formatoCorrecto(args));
    }
    @Test
    public void formatoCaracterNumerico() {
    	String[] args = {"31/12/1969","09/04/2024"};
    	assertTrue(Funciones.formatoCaracterNumerico(args));
    }
    @Test
    public void formatoCaracterNumericoIncorrecto() {
    	String[] args = {"31/12/1969","09/04/aaaa"};
    	assertFalse(Funciones.formatoCaracterNumerico(args));
    }
    @Test
    public void fechaCorrecta() {
    	String[] args = {"31/12/1969","09/04/2024"};
    	assertTrue(Funciones.fechaCorrecta(args));
    }
    @Test
    public void fechaIncorrecta() {
    	String[] args = {"30/02/1969","09/04/2024"};
    	assertFalse(Funciones.fechaCorrecta(args));
    }
}