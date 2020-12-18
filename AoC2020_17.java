import java.util.*;

/**
 * Beschreiben Sie hier die Klasse AoC2020_17.
 * 
 * @author Stefan
 * @version 202012
 *   
   */

public class AoC2020_17
{
    List<String> list;
    
    /**
     * Konstruktor für Objekte der Klasse AoC2019_03
     */
    public AoC2020_17()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile("input17.txt");
        list = a.gibArray();
        for (int y = 0; y < list.size(); y++)
        {
            System.out.println("Zeile "+y+" "+list.get(y));
        }
        silber();
        gold();
    }
    public void silber()
    {
    
    }
    public void gold()
    {
    
    
    }
}
