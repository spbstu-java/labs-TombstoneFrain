import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main {
    static Map<String, String> dictionary = new HashMap<String, String>();
    static List<String> translatable = new ArrayList<String>();
    public static void main(String[] args)
    {
        loadDictionary();
        loadTranslatableData();

        for (String s: translatable)
        {
            findTranslate(s);
            System.out.println("");
        }
    }

    public static void loadDictionary()
    {
        String[] strAr;
        try(BufferedReader br = new BufferedReader(new FileReader("dictionary.txt")))
        {
            String str;
            while((str=br.readLine())!=null){
                strAr = str.split(" \\| ");
                dictionary.put(strAr[0], strAr[1]);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public static void loadTranslatableData()
    {
        try(BufferedReader br = new BufferedReader(new FileReader("text.txt")))
        {
            String str;
            while((str=br.readLine())!=null){
                translatable.add(str);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public static void findTranslate(String sentence)
    {
        String translate = "";
        String currentKey = "";
        sentence = sentence.toLowerCase();
        String[] inputArray = sentence.split( " ");

        int variantLength = 0;
        for (int i = 0; i< inputArray.length; i++) {
            translate = "";
            for (Map.Entry<String, String> e : dictionary.entrySet())
            {
                if (e.getKey().startsWith(inputArray[i]) && e.getKey().length()>translate.length()
                && sentence.contains(e.getKey()))
                {
                    translate = e.getValue();
                    currentKey = e.getKey();
                }

            }
            if (translate == "")
            {
                System.out.print(inputArray[i] + " ");
            }
            else
            {
                variantLength = currentKey.split(" ").length;
                i += variantLength == 0 ? 0 : variantLength-1;
                sentence = sentence.replace(currentKey, "");
                System.out.print(translate + " ");
            }

        }
    }
}