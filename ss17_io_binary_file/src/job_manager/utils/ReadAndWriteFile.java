package job_manager.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static void writeFileToBinary(String filePath, List<String> stringList, boolean append) {
        File file = new File(filePath);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String line : stringList) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("lỗi đóng file");
            }
        }
    }

    public static List<String> readFileToBinary(String filePath) {
        List<String> stringList = new ArrayList<>();
        File file = new File(filePath);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("lỗi không tìm thấy file");
        } catch (IOException e) {
            System.out.println("lỗi đọc file");
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Lỗi đóng file");
            }
        }
        return stringList;
    }
}
