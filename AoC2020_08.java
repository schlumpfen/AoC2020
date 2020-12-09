import java.util.*;

/**
 * Beschreiben Sie hier die Klasse AoC2020_08.
 * 
 * @author Stefan
 * @version 202012
 *   
   */

public class AoC2020_08
{
    List<String> list;
    List<Integer> pointerhist = new ArrayList<Integer>();
    int pointer = 0;
    int acc = 0;
    /**
     * Konstruktor für Objekte der Klasse AoC2019_03
     */
    public AoC2020_08()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile("input08.txt");
        list = a.gibArray();
        for (int y = 0; y < list.size(); y++)
        {
            // System.out.println("Zeile "+y+" "+list.get(y));
            // check(list.get(pointer));
            // pointer++;
        }
        boolean infinity = false;
        while(!infinity){
            pointerhist.add(pointer);
            check(list.get(pointer));
            if(pointerhist.contains(pointer)){infinity = true;}
            // Pointer History kontrollieren
            
        }
        System.out.println(acc);
        
    }
    void check(String zeile){
        // zerlegen der Zeile in einzel Werte
        // command die 3 ersten Zeichen
        String command=zeile.substring(0, 3);
        int value = Integer.parseInt(zeile.substring(4));
        switch(command){
            case "nop":
                // Nichts
                pointer++;
                break;
            case "acc":
                // Akku erhöhen
                acc += value;
                pointer++;
                break;
            case "jmp":
                // Pointer verändern
                pointer += value;
                break;
        }
    } 
}
