
package practica4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public interface Pagina {
    public Partido[] parser (String url) throws FileNotFoundException, MalformedURLException, IOException; // Pasas una URL y te devuelve 
}
