import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Glossary {

    public static void main(String args[]) {
        SortedMap<String, String> glossary = new TreeMap<String, String>();
        Scanner scanner = new Scanner(System.in);

        String word;
        while (!(word = scanner.nextLine()).equals("ZZZ")) {
            String def = scanner.nextLine();
            glossary.put(word, def);
            if (def.equals("ZZZ")) break;
        }

        for (String key : glossary.keySet()) {
            System.out.println(key);
            System.out.println(glossary.get(key));
        }


    }
}