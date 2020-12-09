import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

/**
 * Beschreiben Sie hier die Klasse AoC2019_03.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class AoC2019_03
{
    List<String> list;
    char[][] trees;
    
    /**
     * Konstruktor für Objekte der Klasse AoC2019_03
     */
    public AoC2019_03()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile("input03.txt");
        list = a.gibArray();
        trees = new char[list.size()][list.get(0).length()];
        for (int y = 0; y < list.size(); y++)
        {
            trees[y] = list.get(y).toCharArray();
            // System.out.println(list.get(y));
        }
        // 3 nach rechts 
        // 1 nach unten
        int count;
        int i;
        int j;
        
        int offset[][]={{1,1},{3,1},{5,1},{7,1},{1,2}};
        long alle =1;
        for(int offsets =0;offsets<offset.length;offsets++){
            i = 0;
            j = 0;
            count =0;
    
            while (i<trees.length){
                j = j + offset[offsets][0];
                i = i + offset[offsets][1];
               
                    if (i<trees.length){
                     if (j >= trees[i].length)
                {
                    j = j -trees[i].length;
                }
                    if(trees[i][j]=='#')
                    {
                        count++;
                    }
                    // System.out.println(i+" "+j+" " + trees[i][j]);
                }
            }
            System.out.println("Bäume:"+count);
            alle *= count;
            System.out.println("alle:"+alle);
        }
        System.out.println("alle:"+alle);
        /*        
        for (int i =0;i<trees.length;++i){
            for (int j =0;j<trees[i].length;j++){
                System.out.print(i+"/"+j+" ");
                System.out.print(trees[i][j]);
            }      
        }
        */
    }
}
         

