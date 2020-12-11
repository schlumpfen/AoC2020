import java.util.*;

/**
 * Beschreiben Sie hier die Klasse AoC2020_.
 * 
 * @author Stefan
 * @version 202012
 *   
   */

public class AoC2020_11
{
    List<String> list;
    
    /**
     * Konstruktor für Objekte der Klasse AoC2019_03
     */
    public AoC2020_11()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile("input11test.txt");
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
        int zeile = list.size();
        int spalte = list.get(0).length();
        char [][] Sitze = new char[zeile][spalte];
        
        // Erstelle Array x,y aus Eingabedatei.
        for (int y = 0; y < zeile; y++)
        {
            for(int x = 0;x<spalte;x++){
                Sitze[y][x] = list.get(y).charAt(x);
            }
        }
        char [][] temp = Sitze.clone();
        for (int y = 0; y < zeile; y++)
        {
            for(int x = 0;x<spalte;x++){
                        check(Sitze, temp, x,y);
            }
        }
        
    }

    private void check(char[][] sitze, char[][]tempsitze, int x,int y){
        char platz = sitze[y][x];
        System.out.println(platz);
    }
    
    public void gold()
    {
    
    
    }
}
