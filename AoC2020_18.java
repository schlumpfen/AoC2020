import java.util.*;
import java.math.BigInteger;

/**
 * Beschreiben Sie hier die Klasse AoC2020_18.
 * 
 * @author Stefan
 * @version 202012
 *   
   */

public class AoC2020_18
{
    List<String> list;
    
    /**
     * Konstruktor für Objekte der Klasse AoC2019_03
     */
    public AoC2020_18()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile("input18.txt");
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
        BigInteger summe =BigInteger.valueOf(0);
        for (int y = 0; y < list.size(); y++)
        {
            System.out.println("\nStart "+list.get(y));
            summe = summe.add(calc(list.get(y)));
        }
        
        System.out.println("silber: " + summe);
    }
    public void gold()
    {
    
    
    }
    
    private BigInteger calc(String zeile){
        BigInteger value = BigInteger.valueOf(0);
        
        // Innere Klammern finden
        while(zeile.indexOf("(")>-1)
        {
            // innerste Klammer auf 
            int klammerauf = zeile.lastIndexOf("(");
            int klammerzu = zeile.indexOf(")", klammerauf+1);
            // System.out.println(zeile.substring(klammerauf+1,klammerzu));
            value = calc(zeile.substring(klammerauf+1,klammerzu));
            // Klammerauswertung in zeile ersetzen
            zeile = zeile.substring(0, klammerauf) + value + zeile.substring(klammerzu+1);
        }
        String[] ops = zeile.split(" ");
        BigInteger wert = BigInteger.valueOf(Integer.parseInt(ops[0]));
        for(int j=1; j<ops.length;j+=2){
            switch (ops[j]){
                case "+":
                    wert = wert.add(BigInteger.valueOf(Integer.parseInt(ops[j+1])));
                break;
                case "*":
                    wert = wert.multiply(BigInteger.valueOf(Integer.parseInt(ops[j+1])));
                break;
            }
        }    
        // Zerlegen in Operatoren und Operanden
        System.out.println(zeile + " " + wert);
        return wert;
    }
    
}
