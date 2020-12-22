import java.util.*;

/**
 * Beschreiben Sie hier die Klasse AoC2020_09.
 * 
 * @author Stefan
 * @version 202012
 *   
   */

public class AoC2020_09
{
    List<String> list;
    long[] zahlen;
    
    /**
     * Konstruktor für Objekte der Klasse AoC2019_09
     */
    public AoC2020_09()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile("input09.txt");
        list = a.gibArray();
        
        zahlen = new long[list.size()];
         
        for (int y = 0; y < list.size(); y++)
        {
            System.out.println("Zeile "+y+" "+list.get(y));
            zahlen[y] = Long.parseLong(list.get(y));
        }
        silber(25);
        gold();
    }
    public void silber(int pre)
    {
        // immer 26 Zahl mit 25 Block prüfen
        
        for (int i = 0; i<zahlen.length-pre;i++)
        {
            long[] preamble = new long[pre];
            for (int j=0;j<preamble.length;j++){
                preamble[j] = zahlen[i+j];
            }
            if(!check(zahlen[i+pre], preamble)){
                System.out.println("silber:" + zahlen[i+pre]);
                break;
            }
        }
    }
    public void gold()
    {
    
    
    }
    
    
    private boolean check(long zahl, long[] zahlen){
        boolean check =false;
        for (int k=0; k < zahlen.length;k++){
            for(int l=k+1;l<zahlen.length;l++){
                if(zahlen[k]+zahlen[l] == zahl){
                    check=true;
                    break;
                }
            }
            if(check)   
            {
                break;
            }
        }
        return check;
    }
    
}
