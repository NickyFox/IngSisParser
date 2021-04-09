package common.FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class DefaultFileReader implements FileReader {
    @Override
    public String readFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new java.io.FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
                stringBuilder.append(st.replace("\n",""));
        } catch (RuntimeException | IOException e) {
            System.out.println(e);
        }
        return stringBuilder.toString();
    }
}
