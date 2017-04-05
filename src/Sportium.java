 
package practica4;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
/**
 *  Códigos:
 *      Tipo apuesta:
 *      Deporte:
 *      Competicón:
 *          Liga-----------13568
 *          Copa de Rey....13561
 *          Segunda--------13510
 *          Europa League..13814
 *          Champions------13844
 *  Parseo:
 *      Partido: <tr *</tr>
 *      Hora:   <span class="time">.</span>
 *      Fecha:  <span class="date">.</span>
 *      Equipo: <span class="seln-name">.</span>
 *      Precio: <span class="price dec">.</span>
 */
public class Sportium {

    private String url;
    
    public Sportium() {
        
    }

    public String parser(String url) throws MalformedURLException, IOException {   
        String res = "";
        String aux = "";
        String [] aux2;
        String aux3 = "";
        File file = new File("Sportium.txt");
        file.createNewFile();
        Scanner sc = new Scanner(file);
        // Bajamos url
            this.url = "http://sports.sportium.es/es/type-coupon?sb_type_ids="+url;
            FileUtils.copyURLToFile(new URL(this.url), file);
            while(sc.hasNext()) {
                aux = aux + sc.nextLine();
            }
            aux2 = aux.split("<tr");
            /*for(int i=0;i<aux2.length;i++) {
                System.out.println("Hemos leido: "+aux2[i]);
            }*/
        // Buscamos partidos
        for(int i=1;i<aux2.length;i++) {
            aux = aux2[i];
            // Hora
                Pattern pattern1 = Pattern.compile("<span class=\"time\">([^<]*)</span>");
                Matcher matcher1 = pattern1.matcher(aux);
                if(matcher1.find())
                    aux3 = matcher1.group(1);
                else
                    System.exit(-1);
            // Fecha        <span class="date">.</span>
                pattern1 = Pattern.compile("<span class=\"date\">([^<]*)</span>");
                matcher1 = pattern1.matcher(aux);
                if(matcher1.find())
                    aux3 = aux3+';'+matcher1.group(1);
                else
                    System.exit(-1);
                
            // Equipo 1     <span><span class="seln-name">.</span>
                pattern1 = Pattern.compile("<span class=\"seln-name\">([^<]*)</span>");
                matcher1 = pattern1.matcher(aux);
                if(matcher1.find())
                    aux3 = aux3+';'+matcher1.group(1);
                else
                    System.exit(-1);
                
            // Equipo 2
                if(matcher1.find())
                    aux3 = aux3+';'+matcher1.group(1);
                else
                    System.exit(-1);
                
            // Gana 1
                pattern1 = Pattern.compile("<span class=\"price dec\">([^<]*)</span>");
                matcher1 = pattern1.matcher(aux);
                if(matcher1.find())
                    aux3 = aux3+';'+matcher1.group(1);
                else
                    System.exit(-1);
            // Empate
                if(matcher1.find())
                    aux3 = aux3+';'+matcher1.group(1);
                else
                    System.exit(-1);
            // Gana 2
                if(matcher1.find())
                    aux3 = aux3+';'+matcher1.group(1);
                else
                    System.exit(-1);
                res = res + aux3 + '\n';
        }
        // System.out.println(res);

        sc.close();
        file.delete();
        return res;
    }

    public Partido[] StringToPartido(String str) {
        Partido [] res;
        String [] aux = str.split("\n");
        String [] aux2;

        res = new Partido[aux.length];
        for(int i=0;i<aux.length;i++) {
            res[i] = new Partido();
            aux2 = aux[i].split(";");
            res[i].casa = "Sportium";
            res[i].equipo1=aux2[2];
            res[i].equipo2=aux2[3];
            res[i].costeVictoria1=Double.parseDouble(aux2[4]); 
            res[i].costeEmpate=Double.parseDouble(aux2[5]);
            res[i].costeVictoria2=Double.parseDouble(aux2[6]);

            Calendar date = Calendar.getInstance();
            int month, day, hour, minutes;
            month = MonthToInt(aux2[1].substring(3,6))-1;
            day = Integer.parseInt(aux2[1].substring(0,2));
            hour = Integer.parseInt(aux2[0].substring(0,2));
            minutes = Integer.parseInt(aux2[0].substring(3,5));
            date.set(2016, month, day, hour, minutes, 0);

            //date.set(Calendar.YEAR, 2016);
            //date.set(Calendar.MONTH, );
            //System.out.println("Mes: "+aux2[1].substring(3,6));
            //date.set(Calendar.DAY_OF_MONTH, );
            //System.out.println("Dia: "+aux2[1].substring(0,2));
            //date.set(Calendar.HOUR_OF_DAY, );
            //System.out.println("Hora: "+aux2[0].substring(0,2));
            //date.set(Calendar.MINUTE, );
            //System.out.println("Minuto: "+aux2[0].substring(3,5));
            res[i].fecha = date;
            System.out.println("1 "+aux2[0]+" 2: "+aux2[1]+" 3 "+aux2[2]);
            SimpleDateFormat formatter=new SimpleDateFormat("DD-MMM-yyyy HH:mm"); 
                String currentDate = formatter.format(date.getTime());
                System.out.println("Fecha: "+currentDate);
            //System.out.println("Año "+ Integer.toString(date.get(Calendar.YEAR))+" Mes "+Integer.toString(date.get(Calendar.MONTH))+" Dia "+Integer.toString(date.get(Calendar.DAY_OF_MONTH))+" Hora"+Integer.toString(date.get(Calendar.HOUR_OF_DAY))+" Minutos "+Integer.toString(date.get(Calendar.MINUTE)));
        }
        return res;
    }

    private int MonthToInt(String str) {

        if(str.equalsIgnoreCase("Ene"))
            return 1;
        if(str.equalsIgnoreCase("Feb"))
            return 2;
        if(str.equalsIgnoreCase("Mar"))
            return 3;
        if(str.equalsIgnoreCase("Abr"))
            return 4;
        if(str.equalsIgnoreCase("May"))
            return 5;
        if(str.equalsIgnoreCase("Jun"))
            return 6;
        if(str.equalsIgnoreCase("Jul"))
            return 7;
        if(str.equalsIgnoreCase("Ago"))
            return 8;
        if(str.equalsIgnoreCase("Sep"))
            return 9;
        if(str.equalsIgnoreCase("Oct"))
            return 10;
        if(str.equalsIgnoreCase("Nov"))
            return 11;
        if(str.equalsIgnoreCase("Dec"))
            return 12;
        return 0;
    }

     static String toMonth(int get) {
        if(get==0)
            return "Ene";
        if(get==1)
            return "Feb";
        if(get==2)
            return "Mar";
        if(get==3)
            return "Abr";
        if(get==4)
            return "May";
        if(get==5)
            return "Jun";
        if(get==6)
            return "Jul";
        if(get==7)
            return "Ago";
        if(get==8)
            return "Sep";
        if(get==9)
            return "Oct";
        if(get==10)
            return "Nov";
        if(get==11)
            return "Dec";
        return "";
    }
}
