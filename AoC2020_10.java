import java.util.*;

/**
 * Beschreiben Sie hier die Klasse AoC2020_10.
 * 
 * @author Stefan
 * @version 202012
 *   
   */

public class AoC2020_10
{
    List<String> list;
    List<Integer> voltage=new ArrayList<>();
    
    /**
     * Konstruktor für Objekte der Klasse AoC2019_03
     */
    public AoC2020_10()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile("input10.txt");
        list = a.gibArray();
        
        // Collections.sort(list);
        for (int y = 0; y < list.size(); y++)
        {
            // System.out.println("Zeile "+y+" "+list.get(y));
            voltage.add(Integer.parseInt(list.get(y)));
        }
        Collections.sort(voltage);
        for (int y = 0; y < list.size(); y++)
        {
           System.out.println("Zeile "+y+" "+voltage.get(y));
        }
        silber();
        gold();
    }
    public void silber()
    {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        
        int i=0;
        voltage.add(0); 
        Collections.sort(voltage);
        while (i < voltage.size()){
            int start = voltage.get(i);
            System.out.println(start);
            boolean check = false;
            int j = 1;
            while(check==false && j < 4){
                if(voltage.contains(start+j)){;
                    check=true;
                }
                else{
                    j++;
                }
            }
            switch (j){
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                case 3:
                    count3++;
                    break;
                }
            // Neues i ermitteln. Position von wert aus start+j
            if (j<4){
                i = voltage.indexOf(start+j); 
            }
            else{
                i++;
            }
            // i=i+j;
        }
count3++;
        System.out.println(count1 +" " + count2+" " + count3);
        System.out.println("silber = " + count1 * count3);
    }
    public void gold()
    {
    
    
    }
}
