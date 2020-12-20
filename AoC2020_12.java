import java.util.*;
import lib.*;


/**
 * Beschreiben Sie hier die Klasse AoC2020_12.
 * 
 * @author Stefan
 * @version 202012
 *   
   */

public class AoC2020_12
{
    List<String> list;
    
    /**
     * Konstruktor für Objekte der Klasse AoC2019_03
     */
    public AoC2020_12()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile("input12.txt");
        list = a.gibArray();
        silber();
        gold();
    }
    public void silber()
    {   
        ship a = new ship();
        for (int y = 0; y < list.size(); y++)
        {
            a.bewegen(list.get(y));
        }        
        System.out.println("silber" + a.distanz());
    }
    public void gold()
    {
    
    
    }
}
