import java.util.*;

/**
 * Beschreiben Sie hier die Klasse AoC2020_.
 * 
 * @author Stefan
 * @version 202012
 *   
   */

public class AoC2020_
{
    List<String> list;
    
    /**
     * Konstruktor für Objekte der Klasse AoC2019_03
     */
    public AoC2020_()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile("input.txt");
        list = a.gibArray();
        for (int y = 0; y < list.size(); y++)
        {
            System.out.println("Zeile "+y+" "+list.get(y));
        }
        
    }
}
