public class Main {
    public static void main(String[] args) {

        FreqDict dictionary = new FreqDict();

        if (dictionary.read()) {
            dictionary.write();
        }

    }
}