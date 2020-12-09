import java.util.*;

/**
 * Beschreiben Sie hier die Klasse AoC2019_06.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class AoC2019_06
{
    List<String> list;
    
    /**
     * Konstruktor für Objekte der Klasse AoC2019_06
     */
    public AoC2019_06()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile("input06.txt");
        list = a.gibArray();
        Map<String, String> map = new HashMap<>();
        map.clear();
        long calc =0;
        for (int y = 0; y < list.size(); y++)
        {

            String zeile = list.get(y);
            if (zeile.length()>0){
                System.out.println(zeile);
                for(int i =0;i<zeile.length();i++){
                    
                    if(!map.containsKey(zeile.charAt(i))){
                        map.put(String.valueOf(zeile.charAt(i)), String.valueOf(zeile.charAt(i)));
                    };
                }
            }
            else{
                            System.out.println(map.size() +  " -----");
                            calc += map.size();
                            map.clear();
            }
            
        }
        System.out.println(map.size() +  " -----");
         
        calc += map.size();
        System.out.println(calc +  " berechnet.");
    }
}
         

