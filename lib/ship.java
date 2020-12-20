package lib;

import static java.lang.Math.*;
/**
 * Beschreiben Sie hier die Klasse AoC2020_12_ship.
 * 
 * @author Stefan
 * @version 20201212
 */
public class ship
{
    private int pos_x;      // Position X (West - Ost)
    private int pos_y;      // Position Y (Nord - Sued)

    private int start_x;    // Startposition X (West - Ost)
    private int start_y;    // Startposition Y (Nord - Sued)
    
    private int richtung;     // 0 = Ost, 1 = Süd, 2=West, 3 = Nord

    public ship()
    {
        this(0,0,0);
        
    }
    
    public ship(int startx, int starty, int richtung){
        pos_x = startx;
        pos_y = starty;
        
        start_x = startx;
        start_y = starty;
        
        this.richtung = richtung;
    }
    public void bewegen(String Anweisung){
        // Anweisung enthält 2 Werte
        // 1. Aktion
        // 2. Wert 
        /*
         * Action N means to move north by the given value.
         * Action S means to move south by the given value.
         * Action E means to move east by the given value.
         * Action W means to move west by the given value.
         * Action L means to turn left the given number of degrees.
         * Action R means to turn right the given number of degrees.
         * Action F means to move forward by the given value in the direction the ship is currently facing.
        */  
       
       char aktion = Anweisung.charAt(0);
       int wert = Integer.parseInt(Anweisung.substring(1));
       int index = 0;
       
       switch (aktion){
           case 'E':
            pos_x += wert;
            break;
           case 'S':
            pos_y += wert;
            break;
           case 'W':
            pos_x -= wert;
            break;
           case 'N':
            pos_y -= wert;
            break;
           case 'L':
            wert = wert/90;
            index = richtung - wert;
            if (index<0) {
                index = 4 + index;
            }
            richtung = index;
            break;
           case 'R':
            wert = wert/90;
            index = richtung + wert;
            if (index>3) {
                index = index - 4;
            }
            richtung = index;            
            break;
           case 'F':
            switch(richtung)
            {
                case 0:
                    bewegen("E"+wert);    
                    break;
                case 1:
                    bewegen("S"+wert);    
                    break;
                case 2:
                    bewegen("W"+wert);    
                    break;          
                case 3:
                    bewegen("N"+wert);    
                    break;                
            }
            break;
        }
    }
    
    public int distanz(){
     return (abs(pos_x)-abs(start_x)) + (abs(pos_y)-abs(start_y));        
    }
}
