import java.util.*;

/**
 * Beschreiben Sie hier die Klasse AoC2020_16.
 * 
 * @author Stefan
 * @version 202012
 *   
   */

public class AoC2020_16
{
    List<String> list;
    int[] merker;
    /**
     * Konstruktor für Objekte der Klasse AoC2019_03
     */
    public AoC2020_16()
    {
        // Datei holen und Zeilenweise speichern
        merker = new int[1000];
        ReadFile a =new ReadFile("input16.txt");
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
        boolean found=false;
        int silber=0;
        for (int y = 0; y < list.size(); y++)
        {
            String zeile = list.get(y);
           
            if(zeile.indexOf(":") > 0 && zeile.length()>0 && !found){
                // : gefunden

                if (zeile.equals("your ticket:")){
                    found=true;
                }    
                else 
                {
                    zeile = zeile.substring(zeile.indexOf(":")+2);
                    // \d{1,3}-\d{1,3} or \d{1,3}-\d{1,3}
                    String[] test = zeile.split("[- ]+");
                    for (int i = Integer.parseInt(test[0]);i<=Integer.parseInt(test[1]);i++)
                    {
                        merker[i]=1;
                    }
                    for (int i = Integer.parseInt(test[3]);i<=Integer.parseInt(test[4]);i++)
                    {
                        merker[i]=1;
                    }

                }
            }
            else {
                // Kein doppelpunkt
                if (zeile.equals("nearby tickets:") || zeile.length()==0){
                    // found=true;
                }
                else
                {
                    String[] punkte = zeile.split(",");
                    
                    for(int i=0;i<20;i++)
                    {
                       if(merker[Integer.parseInt(punkte[i])]!=1)
                       {
                           silber +=Integer.parseInt(punkte[i]);
                       }
                    }
                }
            }
            // System.out.println("Zeile "+y+" "+list.get(y));
        }
        System.out.println("silber "+silber);
    }
    public void gold()
    {
    
    
    }
}
