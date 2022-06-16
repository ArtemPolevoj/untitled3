import java.io.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class FileHangling {
    File directory = new File("WordSafe");
    static File file = new File("WordSafe/wordsafe.txt");


    public static void writingWordFiel(String[] words) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print("Добавте слово: ");
            String inWorrd = scanner.nextLine().toLowerCase(Locale.ROOT);
            if (Arrays.asList(words).contains(inWorrd)) System.out.println("Есть такое слово.");
            else {
                String[] newWords = new String[words.length + 1];
                System.arraycopy(words, 0, newWords, 0, words.length);
                newWords[newWords.length - 1] = inWorrd;
                words = newWords;
                System.out.println(Arrays.toString(words));
                try (OutputStream outputStream = new FileOutputStream(file,true)) {
                    inWorrd = ", " + inWorrd;
                    outputStream.write(inWorrd.getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public static String[] fileReading() {
        StringBuilder result = new StringBuilder();
        try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
            char[] array = new char[128];
            int count = reader.read(array);
            while (count > 0) {
                result.append(new String(array, 0, count));
                count = reader.read(array);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString().split(", ");
    }
}
