import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GuessTheWord {
    public static void main(String[] args) {
        String [] masWords = {"автомобиль","машина","тир"};
        ArrayList<String> words = new ArrayList<String>();


        String word = String.valueOf((int) (Math.random() * masWords.length));
        System.out.println(words.size());
        System.out.println(words);
        System.out.println(word);
        String maskWord = "-".repeat(word.length());
        Scanner input = new Scanner(System.in);
        StringBuilder repWord = new StringBuilder(maskWord);
        System.out.println("Угадайте слово из "+ word.length() +" букв.");
        System.out.println("Слово - \"" + maskWord+"\".");
        while (maskWord.contains("-")) {
            System.out.print("Введите букву, часть слова или слово целиком: ");
            String inLetter = input.nextLine().toLowerCase();
            if (inLetter.equals(""))   System.out.println("Вы не ввели букву.");
            else if (inLetter.length()> word.length() ) System.out.println("Вы ввели букв больше чем в слове");
            else if (word.equals(inLetter))  break;
            else if (word.contains(inLetter) || inLetter.length()>1) {
                for (int i = 0; i < inLetter.length(); i++) {
                    for (int j = 0; j < word.length(); j++) {
                        if (inLetter.charAt(i) == word.charAt(j)) {
                            repWord.setCharAt(j, inLetter.charAt(i));
                            System.out.println("Есть буква - \"" + inLetter.charAt(i) + "\"");
                        }
                    }
                }
                if (maskWord.equals(repWord.toString()))  System.out.println("Нет таких букв.");
            }
            else System.out.println("Нет такой буквы");
            maskWord = repWord.toString();
            System.out.println("Слово - \"" + maskWord+"\".");
        }
        System.out.println("Поздравляем!!! Вы угадали слово.");
        System.out.print("Введите слово для добавления в игру: ");
        String inWord = input.nextLine().toLowerCase();
        words.add(inWord);
        words.add("дождь");

        System.out.println(words);
        System.out.println(words.size());
    }
}












