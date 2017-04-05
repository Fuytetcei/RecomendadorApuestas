/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.util.Calendar;

/**
 *
 * @author Jakub
 */
public class Partido {
    String casa;
    String equipo1;
    String equipo2;
    Calendar fecha;

    double costeVictoria1;
    double costeEmpate;
    double costeVictoria2;

    @Override
    public boolean equals(Object obj) {
        Partido p2 = (Partido) obj;
        return (firstWord(equipo1).equals(firstWord(p2.equipo1))
                && firstWord(equipo2).equals(firstWord(p2.equipo2))
                // && fecha.get(Calendar.MONTH) == p2.fecha.get(Calendar.MONTH)
                && fecha.get(Calendar.DAY_OF_MONTH) == p2.fecha.get(Calendar.DAY_OF_MONTH)
                // && fecha.get(Calendar.MINUTE) == p2.fecha.get(Calendar.MINUTE)
                // && fecha.get(Calendar.HOUR) == p2.fecha.get(Calendar.HOUR)
                );
    }

    private String firstWord(String str) {
        String result = str;
        
        int pos = str.indexOf(" ");
        if (pos != -1) {
            result = str.substring(0, pos);
        }
        result = result.replace("á", "a");
        result = result.replace("é", "e");
        result = result.replace("í", "i");
        result = result.replace("ó", "o");
        result = result.replace("ú", "u");
        result = result.replace("Á", "A");
        result = result.replace("É", "E");
        result = result.replace("Í", "I");
        result = result.replace("Ó", "O");
        result = result.replace("Ú", "U");
        return result;
    }
}