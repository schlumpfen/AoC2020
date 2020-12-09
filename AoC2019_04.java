import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Beschreiben Sie hier die Klasse AoC2019_04.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class AoC2019_04
{
    List<String> list;
    
    /**
     * Konstruktor für Objekte der Klasse AoC2019_04
     */
    public AoC2019_04()
    {
        // Datei holen und Zeilenweise speichern
        ReadFile a =new ReadFile("input04.txt");
        list = a.gibArray();
        String zeile ="";
        String[] code ={"byr","iyr","eyr","hgt","hcl","ecl","pid","cid"};
        Map<String, String> map = new HashMap<>();
        map.clear();
        int valid =0;
        for (int y = 0; y < list.size(); y++)
        {
            if(list.get(y).length()>0){
                zeile = zeile + list.get(y) + " ";
            }
            else    {
                // Zeile nach leerzeichen aufteilen
                String[] arrOfStr = zeile.split(" ");
                // Einzelwerte nach : zerteilen
                for (int z = 0; z < arrOfStr.length; z++){
                    String[] arrOfStri = arrOfStr[z].split(":");
                    map.put(arrOfStri[0],arrOfStri[1]);
                    // System.out.println(arrOfStri[0] + "+++"+ arrOfStri[1]);
                }
                // System.out.println(map.size());
                if(map.size()>6){
                    // 7 oder 8 Elemente
                    // bei 7 kann CID fehlen
                    int count = 0;
                    for (int i = 0; i < code.length; i++){
                        if(map.containsKey(code[i])){
                            // System.out.println(code[i]);
                            count++;
                        }
                    }
                    if (count == 7 && !map.containsKey("cid") || count == 8){
                        // 7 Werte und CID fehlt oder 8
                        // jetzt Werte testen!
            
                       boolean ok = false;
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            if(check(entry.getKey(), entry.getValue())){
                                ok = true;
                            }
                            else{
                                ok =false;
                                break;
                            }
                        }
                        if (ok) {
                            valid++;
                        }
                    }
                }
                // System.out.println(zeile);
                zeile = "";
                map.clear();
            }
        }
         System.out.println(valid);
    }
    
    boolean check(String k, String v){
        // Alle Keys testen.
                    /*
                         * byr (Birth Year) - four digits; at least 1920 and at most 2002.
                         * iyr (Issue Year) - four digits; at least 2010 and at most 2020.
                         * eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
                         * 
                         * hgt (Height) - a number followed by either cm or in:
                         * If cm, the number must be at least 150 and at most 193.
                         * If in, the number must be at least 59 and at most 76.
                         * 
                         * hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
                         * ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
                         * pid (Passport ID) - a nine-digit number, including leading zeroes.
                         * cid (Country ID) - ignored, missing or not.
                        */
        boolean rueckgabe = false;
        switch(k){
            case "byr":
                // byr (Birth Year) - four digits; at least 1920 and at most 2002.
                if (v.length()==4 && Integer.parseInt(v)>=1920 &&  Integer.parseInt(v)<=2002) {
                    rueckgabe = true;
                }
                break;
            case "iyr":
                // iyr (Issue Year) - four digits; at least 2010 and at most 2020.
                if (v.length()==4 && Integer.parseInt(v)>=2010 &&  Integer.parseInt(v)<=2020) {
                    rueckgabe = true;
                }            
                break;
            case "eyr":
                // eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
                if (v.length()==4 && Integer.parseInt(v)>=2020 &&  Integer.parseInt(v)<=2030) {
                    rueckgabe = true;
                }            
                break;
            case "hgt":
                // hgt (Height) - a number followed by either cm or in:
                // If cm, the number must be at least 150 and at most 193.
                // If in, the number must be at least 59 and at most 76.
                
                String StrZahl = "0"+v.substring(0,v.length()-2);
                
                int Zahl = Integer.parseInt(StrZahl);
                
                // Aufteilen in Zahl und Einheit 
                // hinteren beiden Zeichen abschneiden.
                switch (v.substring(v.length()-2, v.length())){
                    case "cm":
                        if (Zahl>=150 && Zahl <=193){
                            rueckgabe = true;
                        }
                        break;
                        
                    case"in":
                        if (Zahl>=59 && Zahl <= 76){
                            rueckgabe = true;
                        }
                        break;
                        
                    default:
                        rueckgabe =false;
                        break;
                }
                rueckgabe = true;
                break;            
            case "hcl":
                // hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
                rueckgabe = Pattern.matches("^#([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$", v);
                break;            
            case "ecl":
                // ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
                switch(v){
                    case "amb":
                    case "blu":
                    case "brn":
                    case "gry":
                    case "grn":
                    case "hzl":
                    case "oth":
                        rueckgabe = true;
                        break;
                    default:
                        rueckgabe = false;
                        break;
                }
                break;            
            case "pid":
                // pid (Passport ID) - a nine-digit number, including leading zeroes.
                 if (v.length()==9) {
                     System.out.println(v);
                    rueckgabe = true;
                    
                }  
                break; 
            case "cid":
                rueckgabe = true;
                break;
            default:
                rueckgabe = false;
                break;
        }
        
        return rueckgabe;
    }
}
         

