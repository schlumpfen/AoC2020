import java.util.*;
import java.math.BigInteger;

/**
 * Beschreiben Sie hier die Klasse AoC2020_14.
 * 
 * @author Stefan
 * @version 202012
 *   
   */

public class AoC2020_14
{
    List<String> list;
    Map<Long, Long> map;
    
    /**
     * Konstruktor für Objekte der Klasse AoC2019_03
     */
    public AoC2020_14()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile("input14.txt");
        list = a.gibArray();
        map = new HashMap<>();
        silber();
        gold();
    }
    public void silber()
    {
        // list durcharbeiten und mask und mem unterscheiden.   
        // mask speichert bis nächste mask
        // mem verarbeiten laut vorschriften
        map.clear();
        String mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        for (int y = 0; y < list.size(); y++)
        {
            String[] teile = list.get(y).split(" = ");
            switch(teile[0]){
                case "mask":
                    mask = teile[1];
                break;
                default:
                    // Wert auslesen und maskieren
                    long wert = Long.parseLong(teile[1]);
                    long speicher = Long.parseLong(teile[0].substring(4, teile[0].length()-1));
                    String binstring = ("000000000000000000000000000000000000" + Long.toBinaryString(wert));
                    binstring = binstring.substring(binstring.length()-36);
                   
                    for(int i=0;i<mask.length();i++)
                    {
                        if(mask.charAt(i)!='X')
                        {
                            if(mask.charAt(i)!=binstring.charAt(i))
                            {
                                binstring = replace(binstring, i, mask.charAt(i));
                            }
                        }
                    }
                    wert = parseLong(binstring, 2);
                    // jetzt wert in Speicher packen.
                    map.put(speicher, wert);
                    
                break;
            }
        }
        long summe  = 0;
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            summe += entry.getValue();
        }
        System.out.println("silber: " + summe);
    }
    public void gold()
    {
        map.clear();
        String binstring=""; 
        Long wert = 0L;
        String mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
        for (int y = 0; y < list.size(); y++)
        {
            String[] teile = list.get(y).split(" = ");
            switch(teile[0]){
                case "mask":
                    mask = teile[1];
                break;
                default:
                    // Wert auslesen und maskieren
                    wert = Long.parseLong(teile[1]);
                    long speicher = Long.parseLong(teile[0].substring(4, teile[0].length()-1));
                    
                    binstring = ("000000000000000000000000000000000000" + Long.toBinaryString(speicher));
                    binstring = binstring.substring(binstring.length()-36);
                    
                    
                    for(int i=0;i<mask.length();i++)
                    {
                        switch(mask.charAt(i)){
                            // Übernehmen, nicht ändern
                            case '0':
                                break;

                            case '1':
                                binstring = replace(binstring, i, '1');
                                break;
                            
                            case 'X':
                                binstring = replace(binstring, i, 'X');
                                break;
                        }
                    }
                    // System.out.println(binstring+ "  " + wert);
                    // wert = parseLong(binstring, 2);
                    // jetzt wert in Speicher packen.
                    // map.put(speicher, wert);
                    setmemory(binstring, wert);
                break;
            }
            
        }
        long summe  = 0;
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            summe += entry.getValue();
        }
        System.out.println("gold: " + summe);
    }
    private void setmemory(String binstring, Long wert)
    {
        if(binstring.indexOf('X')>=0)
        {
            String binstring1 = replace(binstring,binstring.indexOf('X'),'1');
            setmemory(binstring1, wert);
            String binstring0 = replace(binstring,binstring.indexOf('X'),'0');
            setmemory(binstring0 ,wert);
        }
        else{
            map.put(parseLong(binstring, 2), wert);
        }
    } 
    
    private String replace(String str, int index, char replace){     
       if(str==null){
           return str;
       }else if(index<0 || index>=str.length()){
           return str;
       }
       char[] chars = str.toCharArray();
       chars[index] = replace;
       return String.valueOf(chars);       
    }
    
    private long parseLong(String s, int base) {
        return new BigInteger(s, base).longValue();
    }
}
