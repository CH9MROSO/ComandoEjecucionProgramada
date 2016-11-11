/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comandoejecucionprogramada;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 *
 * @author ADRI
 */
public class ComandoEjecucionProgramada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Date horaDespertar = new Date(System.currentTimeMillis());
		
		Calendar c = Calendar.getInstance();
		c.setTime(horaDespertar);
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		// Si la hora es posterior a las 8am se programa la alarma para el dia siguiente
		if (c.get(Calendar.HOUR_OF_DAY) >= 22) {
			c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + 1);
		}
		
		c.set(Calendar.HOUR_OF_DAY, 8);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		horaDespertar = c.getTime();
		System.out.println(horaDespertar);
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		// El despertador suena cada 24h (una vez al dia)
		int tiempoRepeticion = 86400000; 
		
		// Programamos el despertador para que "suene" a las 8am todos los dias 
		Timer temporizador = new Timer();
		temporizador.schedule(new Temporizador(), horaDespertar, tiempoRepeticion);
		
	}
    
}
