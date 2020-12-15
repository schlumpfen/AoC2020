import java.util.*;

/**
 * Beschreiben Sie hier die Klasse AoC2020_15.
 * 
 * @author Stefan
 * @version 202012
 *   
   */

public class AoC2020_15
{
    List<String> list;
    List<Integer> nummern;
    /**
     * Konstruktor für Objekte der Klasse AoC2019_03
     */
    public AoC2020_15()
    {
        nummern = new ArrayList<>();
        // 1,20,8,12,0,14.
        
        nummern.add(1);
        nummern.add(20);
        nummern.add(8);
        nummern.add(12);
        nummern.add(0);
        nummern.add(14);
        
        silber();
        gold();
    }
    public void silber()
    {
        // Array mit 2020 Feldern für Rundenspeicher
        int[] runden = new int[2020];
        // Vorhandene Nummern mit TURN Zahl in Array
        for (int i = 0; i < nummern.size(); i++) {
            runden[nummern.get(i)] = i + 1;
	}
	
	// Nächster Turn
	int turn = nummern.size() + 1;
	// nächste Wert 0
	int naechster = 0;
	
	while (turn < 2020) {
	    if (runden[naechster] == 0) 
	    {
	        runden[naechster] = turn;
		naechster = 0;
            }
            else 
            {
		int temp = runden[naechster];
		runden[naechster] = turn;
		naechster = turn - temp;
            }
            turn++;
	}
	
	System.out.println("silber: " + naechster);
    }
    public void gold()
    {
        // Array mit 2020 Feldern für Rundenspeicher
        int[] runden = new int[30000000];
        // Vorhandene Nummern mit TURN Zahl in Array
        for (int i = 0; i < nummern.size(); i++) {
            runden[nummern.get(i)] = i + 1;
	}
	
	// Nächster Turn
	int turn = nummern.size() + 1;
	// nächste Wert 0
	int naechster = 0;
	
	while (turn < 30000000) {
	    if (runden[naechster] == 0) 
	    {
	        runden[naechster] = turn;
		naechster = 0;
            }
            else 
            {
		int temp = runden[naechster];
		runden[naechster] = turn;
		naechster = turn - temp;
            }
            turn++;
	}
	
	System.out.println("gold: " + naechster);    
    }
}
