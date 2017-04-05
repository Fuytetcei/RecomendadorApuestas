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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author usuario_local
 */
public class WilliamHill implements Pagina {

    /**
     * @param url
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.net.MalformedURLException
     */
    public Partido[] parser(String url) throws FileNotFoundException, MalformedURLException, IOException {

        ArrayList<Partido> partidos = new ArrayList<>();
        
        File file = new File("cache");
        
        final String[] monthNames = new String[]
        {"Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"};

        //if (!file.exists()) {
            FileUtils.copyURLToFile(new URL(url), file);
        //}

        String contents = FileUtils.readFileToString(file);
        contents = contents.replace("\n", "").replace("\r", "").replace("\t", "").replace("&nbsp;", "");

        //String[] pageParts = contents.split("\\<h3\\>");
        String[] pageParts = contents.split("<tr class=\"rowOdd\"  id=\"ip_row_");

        //System.out.println(pageParts.length);
        for (int i = 1; i < pageParts.length; i++) {
            String row = pageParts[i];
            row = row.substring(row.indexOf(">") + 1);
            row = row.substring(0, row.indexOf("</tr>"));
            String cols[] = row.split("</td>");

            for (int j = 0; j < cols.length - 1; j++) {
                cols[j] = cols[j].trim().replaceAll("\\<.*?>", "");
                //System.out.println(j + "-" + cols[j]);
            }
            String[] names = cols[2].split("₋");
            String name1 = names[0].trim();
            String name2 = names[1].trim();

            Double win1 = Double.parseDouble(cols[4]);
            Double tie = Double.parseDouble(cols[5]);
            Double win2 = Double.parseDouble(cols[6]);
            
            if (cols[0].length() == 0 || cols[0].indexOf("Directo") != -1) {
                continue;
            }
            
            int day, month;
            
            if (cols[0].indexOf("Hoy") == -1) {
                day = Integer.parseInt(cols[0].substring(0, 2).trim());
                month = java.util.Arrays.asList(monthNames).indexOf(cols[0].substring(2).trim());
            }
            else {
                day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                month = Calendar.getInstance().get(Calendar.MONTH);
            }

            String[] hourMinutes = cols[1].split(":");
            
            int hour = Integer.parseInt(hourMinutes[0]) + 1;
            int minutes = Integer.parseInt(hourMinutes[1].substring(0, 2).trim());
            
            Calendar cal = Calendar.getInstance();
            cal.set(cal.get(Calendar.YEAR), month, day, hour, minutes);
            // cal.add(Calendar.HOUR, 1);
            
            Partido partido = new Partido();
            partido.casa = "William Hill";
            partido.equipo1 = name1;
            partido.equipo2 = name2;
            partido.fecha = cal;
            partido.costeVictoria1 = win1;
            partido.costeVictoria2 = win2;
            partido.costeEmpate = tie;
            partidos.add(partido);
            
            SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm"); 
                String currentDate = formatter.format(cal.getTime());
            
            //System.out.printf("%s %s (%f) - (%f) - (%f) %s\n", currentDate, name1, win1, tie, win2, name2);
        }
        
        return partidos.toArray(new Partido[partidos.size()]);
    }

}
