import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

/**
 * Beschreiben Sie hier die Klasse AoC2019_10.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class AoC2019_10
{
    List<String> list;

    /**
     * Konstruktor für Objekte der Klasse AoC2019_10
     */
    public AoC2019_10()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile();
        list = a.gibArray();
        List<Point> Asteroids = new ArrayList<Point>();
        for (int y = 0; y < list.size(); y++)
        {
                for (int x = 0; x < list.get(y).length(); x++)
                {
                    String b =list.get(y).substring(x,x+1);
                    if (list.get(y).substring(x,x+1).equals("#"))
                        Asteroids.add(new Point(x, y));
                }
        }
        
        Point Best = new Point(0, 0);
        int Highest = 0;
        int BestIdx = 0;

        for (int c = 0; c < Asteroids.size(); c++)
        {
            List<Float> Angles = new ArrayList<Float>();
            int Count = 0;
            Point Source = Asteroids.get(c);
            for (int d = 0; d < Asteroids.size(); d++)
            {
                if (c == d)
                {
                    continue;
                }

                float Angle = (float)Math.atan2((float)Asteroids.get(c).getX() - (float)Asteroids.get(d).getX(), (float)Asteroids.get(c).getY() - (float)Asteroids.get(d).getY());
                if (!Angles.contains(Angle))
                {
                    Angles.add(Angle);
                    Count++;
                }
            }

            if (Count > Highest)
            {
                Best = Asteroids.get(c);
                Highest = Count;
                BestIdx = c;
            }
        }
        System.out.println(Best.getX()+" "+Best.getY()+" "+ Highest); 
    }


    private float Distance(Point a, Point b)
    {
            return (float)Math.sqrt(Math.pow((double)(a.getX() - b.getX()), 2) + Math.pow((double)(a.getY() - b.getY()), 2));
    }
}
         

