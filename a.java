import java.util.*;
import java.util.regex.Pattern;
import java.io.*; 
/**
 * Beschreiben Sie hier die Klasse a.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class a
{
private static boolean checkSingleID(String[] id) {
		String IDType = id[0];
		switch(IDType) {
		case "byr":
			return Pattern.matches("(19[2-9]\\d)|(200[012])", id[1]);
		case "iyr":
			return Pattern.matches("20(1\\d)|(20)", id[1]);
		case "eyr":
			return Pattern.matches("20(2\\d)|(30)", id[1]);
		case "hgt":
			return Pattern.matches("(1([5-8]\\d|9[0-3])cm)|(59|6\\d|7[0-6]in)", id[1]);
		case "hcl":
			return Pattern.matches("#\\p{XDigit}{6}", id[1]);
		case "ecl":
			return Pattern.matches("amb|blu|brn|gry|grn|hzl|oth", id[1]);
		case "pid":
			return Pattern.matches("\\d{9}", id[1]);
		default:
			return false;
		}
	}

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("input04.txt"));
			
			ArrayList<String> passports = new ArrayList<String>();
			StringBuilder sb = new StringBuilder();
			while(s.hasNextLine()) {
				String nl = s.nextLine();
				if(nl.length() != 0) {
					sb.append(nl);
					sb.append(' ');
				} else {
					passports.add(sb.toString());
					sb = new StringBuilder();
				}
			}
			passports.add(sb.toString());
			
			s.close();
			
			int validPassports = 0;
			
			for(int i = 0; i < passports.size(); i++) {
				s = new Scanner(passports.get(i));
				int ids = 0;
				while(s.hasNext()) {
					String[] id = s.next().split(":");
					if(checkSingleID(id)) ids++;
				}
				if(ids == 7)
					validPassports++;
				s.close();
			}
			
			System.out.println(validPassports + " valid passports");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
