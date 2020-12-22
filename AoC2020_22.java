import java.util.*;

/**
 * Beschreiben Sie hier die Klasse AoC2020_22.
 * 
 * @author Stefan
 * @version 202012
 *   
   */

public class AoC2020_22
{
    List<String> list;
    
    /**
     * Konstruktor für Objekte der Klasse AoC2019_03
     */
    public AoC2020_22()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile("input\\input22.txt");
        list = a.gibArray();
        /*
        for (int y = 0; y < list.size(); y++)
        {
            System.out.println("Zeile "+y+" "+list.get(y));
        }
        */
        silber();
        gold();
    }
    public void silber()
    {
        // : Spielername
        // leerzeichen neuer Block
        List<Queue<Integer>> spieler = new ArrayList<>();
        int i = -1;
        for (int y = 0; y < list.size(); y++)
        {
            
            String zeile = list.get(y);
            if(zeile.indexOf(":")>-1){
                // Neuer Spieler
                Queue<Integer> q = new LinkedList<>(); 
                spieler.add(q);
                i++;
            }
            else
            if(true)
            {
                if(zeile.length()>0){
                    spieler.get(i).add(Integer.parseInt(zeile));
                }
            }
        }
        while (spieler.get(0).size()>0&&spieler.get(1).size()>0){
            int value1 = spieler.get(0).poll();
            int value2 = spieler.get(1).poll();
            if(value1 > value2){
                spieler.get(0).add(value1);
                spieler.get(0).add(value2);
            }
            else {
                spieler.get(1).add(value2);
                spieler.get(1).add(value1);
            }
        }
        
        Queue<Integer> gewinner;
        if(spieler.get(0).size() > spieler.get(1).size())
        {
            // Spieler 1 hat gewonnen
            gewinner = spieler.get(0);
        }
        else
        {
            // Spieler2 hat gewonnen
            gewinner = spieler.get(1);
        }
        int points = 0;
        for(int j=gewinner.size(); j>0;j--){
            points += j * gewinner.poll(); 
        }
        System.out.println("silber: " + points);
    }
    public void gold()
    {
    
    
    }
}
