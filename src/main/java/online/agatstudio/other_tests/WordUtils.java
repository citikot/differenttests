package online.agatstudio.other_tests;

public class WordUtils {
    public static String reverseWords(String inputText) {
        String[] words = inputText.trim().split(" ");
        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            result = result + " " + words[i];
        }
        return result.trim();
    }

    private WordUtils() {}

    public static void main(String[] args) {
        System.out.println("Ввод пустой строки - " + WordUtils.reverseWords(""));
        System.out.println("Ввод одного слова - " + WordUtils.reverseWords("word"));
        System.out.println("Ввод двух слов - " + WordUtils.reverseWords("четыре нафиг каких-то слова"));
    }
}
