import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        // Create an instance of TextEditor
        TextEditor editor = new TextEditor();
        String path="keyword_dictionary.txt";
        // Save the dictionary to a file
        editor.readKeywordsFromFile(path);
        System.out.print("Enter a keyword: ");
        String userInput = in.next();
        editor.isKeywordExists(userInput);
        System.out.println("If you want to add a new word, enter the number 1 and if you do not want enter 0 ");
        int num= in.nextInt();
        if (num==1) {
            // Add new entry
            System.out.print("Enter a newkeyword : ");
            String newkeyword = in.next();
            System.out.print("Enter the type of the keyword: ");
            String keywordType = in.next();
            editor.addNewEntry(newkeyword, keywordType, path);
            editor.saveDictionaryToFile(path);
        }
        // Auto-completion
        System.out.println("enter prefix :");
        String prefix = in.next();
        System.out.print(" auto-completion: ");
        editor.autoComplete(prefix);
    }
}