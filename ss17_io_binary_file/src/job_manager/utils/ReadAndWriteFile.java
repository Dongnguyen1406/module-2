package job_manager.utils;

import job_manager.entity.Expense;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static void writeFileToBinary(String filePath, List<Expense> expenses) {
       try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
           oos.writeObject(expenses);
       }catch (IOException e){
           System.out.println("Lỗi ghi file nhị phân: " + e.getMessage());           
       }
    }

    public static List<Expense> readFileToBinary(String filePath) {
        List<Expense> expenses = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) {
            return expenses;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            expenses = (List<Expense>) ois.readObject();
        } catch (IOException e) {
            System.out.println("Lỗi đọc file nhị phân: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Lỗi không tìm thấy class: " + e.getMessage());
        }
        return expenses;
    }

}
