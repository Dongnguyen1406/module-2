package thuc_hanh;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        // Tạo một LinkedHashMap
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // Thêm các cặp key-value
        linkedHashMap.put("Banana", 1);
        linkedHashMap.put("Apple", 3);
        linkedHashMap.put("Orange", 2);

        // Duy trì thứ tự chèn
        System.out.println("Thứ tự chèn:");
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Kết quả:
        // Thứ tự chèn:
        // Banana : 1
        // Apple : 2
        // Orange : 3

        // Thêm một cặp key-value nữa
        linkedHashMap.put("Watermelon", 4);

        // Thứ tự vẫn được duy trì sau khi thêm phần tử
        System.out.println("\nThứ tự chèn sau khi thêm phần tử:");
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Kết quả:
        // Thứ tự chèn sau khi thêm phần tử:
        // Banana : 1
        // Apple : 2
        // Orange : 3
        // Watermelon : 4
    }
}