package AoClib;
import java.io.*;
/**
 * Beschreiben Sie hier die Klasse Dateileser.
 * 
 * @author Stefan
 * @version 20201207
 *
 * Dateien werden unter inputXX.txt gespeichert
 * XX ist der Tag 01 bis 25
 * 
*/
public class Dateileser
{
    // Instanzvariablen 

    /**
     * Konstruktor für Objekte der Klasse Dateileser
     */
    public Dateileser(String Tag) throws IOException
    {
        // Datei im aktuellen Verzeichnis öffnen
        FileReader fr = new FileReader("input"+Tag+".txt");
        BufferedReader br = new BufferedReader(fr);
        
        String zeile = "";

        while( (zeile = br.readLine()) != null )
        {
            // System.out.println(zeile);
            
        }
        
        br.close();
    }
    
    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public int beispielMethode(int y)
    {
        // tragen Sie hier den Code ein
        return 0;
    }
}
