package app.model.parsers;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileReader  {
    public String readFile(String path){
        StringBuilder stringBuilder = new StringBuilder();
        try (
                InputStream is = this.getClass().getResourceAsStream(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is))
        ) {
            String line = reader.readLine();
            while (line != null){
                stringBuilder.append(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public void writeFile(String path, String content){
        File file = new File(System.getProperty("user.dir") + path);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
        }
        }
        try (
            OutputStream os = new FileOutputStream(System.getProperty("user.dir") + path);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os))
        ){
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
