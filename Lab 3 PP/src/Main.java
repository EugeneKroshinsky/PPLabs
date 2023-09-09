// Крошинский Евгений 2 курс 7 группа
// 5.После каждого слова текста, заканчивающегося заданной под-строкой, вставить указанное слово.
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        Scanner textIn = new Scanner(new File("input.txt"));

        // текст считываем из файла "input.txt"
        ArrayList<StringTokenizer> textStrings = new ArrayList<StringTokenizer>();
        while (textIn.hasNext()) {
            textStrings.add(new StringTokenizer(textIn.nextLine(), " "));
        }

        // с консоли вводим под-строку, котороую надо проверить и слово, которое надо вставить
        System.out.println("Enter substring: ");
        String subStr = in.next();
        System.out.println("Enter new string: ");
        String newStr = in.next();

        // проходим каждое слово и смотрим является ли заданная подстрока концом слова
        for (StringTokenizer text : textStrings){
            String resultString = "";
            while (text.hasMoreTokens()){
                String currentWord = text.nextToken();
                if (currentWord.lastIndexOf(subStr) == (currentWord.length() - subStr.length())){
                    resultString = resultString.concat(currentWord + " " + newStr + " ");
                }
                else {
                    resultString = resultString.concat(currentWord + " ");
                }
            }
            System.out.println(resultString);
        }
    }
}