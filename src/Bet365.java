/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TreeMap;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Jakub
 */
class Bet365 implements Pagina {

    @Override
    public Partido[] parser(String url) throws FileNotFoundException, MalformedURLException, IOException {
        ArrayList<Partido> resultado = new ArrayList<>();
        HashMap<String, Partido> partidos = new HashMap<>();
        TreeMap<String, String> claves = new TreeMap<>();
        
        File file = new File("cache365");
        
        if (!file.exists()) {
            FileUtils.copyURLToFile(new URL(url), file);
        }

        String contents = FileUtils.readFileToString(file);
        //String[] pageParts = contents.split("\\<h3\\>");
        String[] pageParts = contents.split("\\|");

        for (String line : pageParts) {
            String lineParts[] = line.split(";");
            claves.clear();
            
            for (String part : lineParts) {
                if (part.length() < 3) continue;
                String key = part.substring(0, 2);
                String value = part.substring(3);
                claves.put(key, value);
            }
            
            if (claves.containsKey("FI")) {
                // tenemos un partido
                String idPartido = claves.get("FI");
                
                if (claves.containsKey("NA")) {
                    // informacion general (nombre, fecha)
                    Partido partido = new Partido();
                    
                    String nombresStr = claves.get("NA");
                    //byte[] bytes = nombresStr.getBytes("LATIN1");
                    //nombresStr = new String(bytes, "UTF-8");
                    
                    String nombres[] = nombresStr.split(" v ");
                    String fecha = claves.get("BC");
                            
                    partido.equipo1 = nombres[0].trim();
                    partido.equipo2 = nombres[1].trim();
                    partido.fecha = Calendar.getInstance();
                    partido.casa = "Bet365";
                    
                    int year = Integer.parseInt(fecha.substring(0, 4));
                    int month = Integer.parseInt(fecha.substring(4, 6)) - 1;
                    int day = Integer.parseInt(fecha.substring(6, 8));
                    int hour = Integer.parseInt(fecha.substring(8, 10));
                    int minutes = Integer.parseInt(fecha.substring(10, 12));
                    partido.fecha.set(year, month, day, hour, minutes);
                    partido.costeVictoria1 = -1;
                    partido.costeVictoria2 = -1;
                    partido.costeEmpate = -1;
                    
                    partidos.put(idPartido, partido);
                }
                else {
                    
                    String fraccion[] = claves.get("OD").split("/");
                    Partido partido = partidos.get(idPartido);
                    
                    double valor = 1.0 + Double.parseDouble(fraccion[0])
                            / Double.parseDouble(fraccion[1]);
                    
                    valor = Math.round(valor * 100.0) / 100.0;
                    
                    if (partido.costeVictoria1 == -1) {
                        partido.costeVictoria1 = valor;
                    }
                    else if (partido.costeEmpate == -1) {
                        partido.costeEmpate = valor;
                    }
                    else if (partido.costeVictoria2 == -1) {
                        partido.costeVictoria2 = valor;
                        resultado.add(partido);
                        System.out.printf("%s %f %f %f %s\n", partido.equipo1, partido.costeVictoria1, partido.costeEmpate, partido.costeVictoria2, partido.equipo2);
                    }
                    
                }
                
            }
        }
        return resultado.toArray(new Partido[partidos.size()]);
    }
    
}
