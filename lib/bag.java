package lib;

import java.util.Map;
import java.util.HashMap;

/*
 * bag - Tasche
 * 
 * Eine Tasche hat eine Farbe
 * 
 * In einer Tasche können n verschiedene Taschen sein, mit einer bestimmten Anzahl.
 * 
 * "Farbe" -> Verweis auf weitere Tasche, "Anzahl"
 * 
 * 
 */

public class bag
{
    String color;           
    Map<bag, Integer> bags;
    public bag()
    {
        bags = new HashMap<bag, Integer>();
    }
    
    public bag(String color)
    {
        this();
        this.color = color;
    }
    
    private void add(bag bag){
        // check bags
    }
    
    public boolean check(bag bag)
    {
        return false;
    }
    
    public boolean check(String color)
    {
        return false;
    }
}
