import java.io.BufferedReader; 
import java.io.File; 
import java.io.FileReader; 
import java.io.IOException; 
import java.util.ArrayList;
import java.util.List;

/**
 * Beschreiben Sie hier die Klasse ReadFile.
 * 
 * @author Stefan Roschewitz
 * @version 20191210
 */
public class ReadFile
{
    private List<String> list;
    /**
     * Konstruktor für Objekte der Klasse ReadFile
     */
    public ReadFile()
    {
        this("input.txt");
    }
    public ReadFile(String datName)
    {
        list = new ArrayList<>();
        ladeDatei(datName); 
        // System.out.println(list.size());
    }
    
    /**
     * Lese Datei in Arraylist
     * 
     * @param   datName Dateiname (ohne Pfad wenn im gleichen Verzeichnis)
     */
    private void ladeDatei(String datName) { 
        File file = new File(datName); 

        if (!file.canRead() || !file.isFile()) {
            System.out.println("Kann Datei nicht lesen oder ist nicht vorhanden.");
            System.exit(0); 
        }

        BufferedReader in = null; 
        try { 
            in = new BufferedReader(new FileReader(datName)); 
            String zeile = null; 
            while ((zeile = in.readLine()) != null) { 
                list.add(zeile);
                // System.out.println("Gelesene Zeile: " + zeile); 
            } 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } finally { 
            if (in != null) 
                try { 
                    in.close(); 
                } catch (IOException e) { 
                    // Fehler beim lesen.
                } 
        } 
    } 
    public List<String> gibArray(){
        return list;
    }
}
