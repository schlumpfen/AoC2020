import java.util.*;

/**
 * Beschreiben Sie hier die Klasse AoC2019_06.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class AoC2020_06
{
    List<String> list;
    
    /**
     * Konstruktor für Objekte der Klasse AoC2019_06
     */
    public AoC2020_06()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile("input06.txt");
        list = a.gibArray();
        
        // silver
        Map<String, Integer> map = new HashMap<>();
        map.clear();
        long calc =0;
        for (int y = 0; y < list.size(); y++)
        {

            String zeile = list.get(y);
            if (zeile.length()>0){
                // System.out.println(zeile);
                for(int i =0;i<zeile.length();i++){
                    
                    if(!map.containsKey(zeile.charAt(i))){
                        map.put(String.valueOf(zeile.charAt(i)), 1);
                    };
                }
            }
            else{
                            // System.out.println(map.size() +  " -----");
                            calc += map.size();
                            map.clear();
            }
            
        }
        //        System.out.println(map.size() +  " -----");
         
        calc += map.size();
        System.out.println("silber " + calc +  " berechnet.");
        
        // gold
        map.clear();
        calc =0;
        int zeilenzaehler = 0;
        for (int y = 0; y < list.size(); y++)
        {
            
            String zeile = list.get(y);
            if (zeile.length()>0){
                // System.out.println(zeile);
                for(int i =0;i<zeile.length();i++){
                    
                    if(!map.containsKey(String.valueOf(zeile.charAt(i)))){
                        map.put(String.valueOf(zeile.charAt(i)), 1);
                    }
                    else {
                        int temp = map.get(String.valueOf(zeile.charAt(i)));
                        temp++;
                        map.put(String.valueOf(zeile.charAt(i)), temp);
                    }
                }
                zeilenzaehler++;
            }
            else{
                            // System.out.println(map.size() +  " -----");
                            // System.out.println(zeilenzaehler +  " -----");
                            // Wenn Zeihlenzaehler = der Antwort anzahl dann haben alle yes gesagt zu der Frage.
                            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                                if((entry.getValue()==zeilenzaehler)){
                                   // System.out.println(entry.getKey() +  " ----- " + entry.getValue());
                                   calc++;
                                }
                            }
                            // calc += map.size();
                            map.clear();
                            zeilenzaehler = 0;
                     }
        }             
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if((entry.getValue()==zeilenzaehler)){
               // System.out.println(entry.getKey() +  " ----- " + entry.getValue());
               calc++;
            }
        }
                    // calc += map.size();
                            map.clear();
                            zeilenzaehler = 0;
            
        
        //        System.out.println(map.size() +  " -----");

        System.out.println("gold " + calc +  " berechnet.");
    }
}
         

