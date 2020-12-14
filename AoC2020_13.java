import java.util.*;

/**
 * Beschreiben Sie hier die Klasse AoC2020_13.
 * 
 * @author Stefan
 * @version 202012
 *   
   */

public class AoC2020_13
{
    List<String> list;
    
    /**
     * Konstruktor für Objekte der Klasse AoC2019_03
     */
    public AoC2020_13()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile("input13.txt");
        list = a.gibArray();
        long kleinster = Long.parseLong(list.get(0));
        List<Long> busse = new ArrayList<>();
        for (String bus : list.get(1).split(",")) {
            if(bus.equals("x"))
            {
                busse.add(Long.parseLong("-1"));
            }
            else
            {
                busse.add(Long.parseLong(bus));
            }
        }
        
        silber(kleinster, busse);
        
        gold(busse);
    }
    /**
     * Methode silber für silbernen Stern
     * 
     * @param kleinster Kleinster Abfahrttermin
     * @param busse Liste der Buslinien -1 nicht vorhandene Zeit
     */
    public void silber(long kleinster, List<Long> busse)
    {
        long abfahrt = kleinster;
        while (true) {
            for (long bus : busse) {
                if (bus < 0) {
                    continue;
                }
                if (abfahrt % bus == 0) {
                    System.out.println("silber: " + bus * (abfahrt - kleinster));
                    // While abbrechen, Ergebnis gefunden
                    return;
                }
            }
            abfahrt++;
        }
    }
    /**
     * Methode gold für goldenen Stern
     * 
     * @param busse Liste der Buslinien -1 für Versatz
     */
    public void gold(List<Long> busse)
    {
        long kgv = -1;
        long zeit = -1;
        int index = 0;
        while(true) {
            long bus = busse.get(index);
            if (bus == -1) 
            {
                index++;
                continue;
            }

            if (kgv == -1) 
            {
                kgv = bus;
                zeit = bus - index;
                index++;
                continue;
            }

            if ((zeit + index) % bus == 0) 
            {
                if (++index >= busse.size()) 
                {
                    System.out.println("gold: " + zeit);
                    return;
                }
                kgv *= bus;
                continue;
            }
            zeit += kgv;
        }
    }
}
