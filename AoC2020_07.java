import java.util.*;
import lib.*;

/**
 * Beschreiben Sie hier die Klasse AoC2020_07.
 * 
 * @author Stefan
 * @version 202012
 *   
 */

public class AoC2020_07
{
    List<String> list;
    bag Tasche;
    /**
     * Konstruktor für Objekte der Klasse AoC2019_03
     */
    public AoC2020_07()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile("input07test.txt");
        list = a.gibArray();
        
        bag Tasche = new bag("root");

        for (int y = 0; y < list.size(); y++)
        {
            String zeile = list.get(y);

            int colorpos = zeile.indexOf("bags contain");
            if(colorpos > -1){
                String bagcolor = zeile.substring(0,colorpos-1);
                System.out.println("Farbe ###" + bagcolor + "###");
                boolean b = Tasche.check(Tasche);
                
                
                
                // Testen ob Tasche schon irgendwo drin steckt
                
            }
            // Taschelist bauen
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
