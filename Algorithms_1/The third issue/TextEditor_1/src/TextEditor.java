import java.io.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class TextEditor {
    Map<String, String> keywordDictionary ;

    public TextEditor() {
        keywordDictionary = new HashMap<>();

    }
    // دالة الحفظ في المعجم
    public Map<String, String> readKeywordsFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            // تفصيل سطر المعجم إلى كلمة مفتاحية ونوعها
            String[] parts = line.trim().split(":");
            if (parts.length == 2) {
                String keyword = parts[0].trim();
                String type = parts[1].trim();
                keywordDictionary.put(keyword, type);
            }
        }
        reader.close();
        return keywordDictionary;
    }
    public void saveDictionaryToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : keywordDictionary.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  دالة الكشف عن الخطأ
    public boolean isKeywordExists(String word) {
        if (keywordDictionary.containsKey(word)) {
            System.out.println("the keyword " + word + " _ is found");
            return true;
        }
        else {System.out.println("Error: Unknown keyword - " + word);}
        return false;
    }
    // دالة الكشف عن الخطأ

    // دالةاضافة متحولات جديدة
    public void addNewEntry(String key, String value,String filePath) {
        keywordDictionary.put(key, value);
        TextEditor e = new TextEditor();
        e.saveDictionaryToFile(filePath);
    }
    // دالة الإكمال التلقائي
    public void autoComplete(String prefix) {
        for (String word : keywordDictionary.keySet()) {
            if (word.startsWith(prefix)) {
                System.out.println(word);
            }
        }
    }

}

