import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FreqDict {
    private Map<Character, Integer> dictionary = new HashMap<Character, Integer>();

    public boolean read() {

        System.out.println("Enter input filename:");
        Scanner in = new Scanner(System.in);
        String filename1 = in.nextLine();

        try(FileReader reader = new FileReader(filename1))
        {
            int c;
            while((c=reader.read())!=-1){
                if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                    if (dictionary.containsKey((char)c)) {
                        int cur = dictionary.get((char)c);
                        dictionary.put((char)c, cur + 1);
                    } else {
                        dictionary.put((char)c, 1);
                    }
                }
            }
            return true;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }

    }

    public void write() {

        System.out.println("Output filename:");
        Scanner in = new Scanner(System.in);
        String filename2 = in.nextLine();

        try (FileWriter writer = new FileWriter(filename2, false)) {
            for (int i = 65; i <= 90; i++) {
                if (dictionary.containsKey((char) i)) {
                    String word = (char) i + " : " + dictionary.get((char) i);
                    writer.write(word);
                    writer.append('\n');
                }

            }
            for (int i = 97; i <= 122; i++) {
                if (dictionary.containsKey((char) i)) {
                    String word = (char) i + " : " + dictionary.get((char) i);
                    writer.write(word);
                    writer.append('\n');
                }
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
