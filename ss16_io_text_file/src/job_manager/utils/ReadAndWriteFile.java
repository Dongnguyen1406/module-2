package job_manager.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static void writeFileToCSV(String filePath, List<String> stringList, boolean append) {
        try (BufferedWriter write = new BufferedWriter(new FileWriter(filePath, append))) {
            for (String data : stringList) {
                write.write(data);
                write.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readFileToCSV(String filePath) {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(filePath))) {
            String data = "";
            while ((data = read.readLine()) != null){
                stringList.add(data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringList;
    }
}
