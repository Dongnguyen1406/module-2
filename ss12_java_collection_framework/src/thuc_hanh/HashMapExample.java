package thuc_hanh;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // Tạo một HashMap
        HashMap<String, Integer> ageMap = new HashMap<>();

        // Thêm các phần tử (khóa-giá trị) vào HashMap
        ageMap.put("Alice", 25);
        ageMap.put("Bob", 30);
        ageMap.put("Charlie", 22);

        // Truy cập giá trị bằng khóa
        System.out.println("Alice's age: " + ageMap.get("Alice")); // Output: Alice's age: 25
        System.out.println("Charlie's age: " + ageMap.get("Charlie")); // Output: Charlie's age: 22

        // Kiểm tra xem một khóa có tồn tại hay không
        if (ageMap.containsKey("Bob")) {
            System.out.println("Bob's age: " + ageMap.get("Bob")); // Output: Bob's age: 30
        }

        // Xóa một phần tử
        ageMap.remove("Bob");

        // Lặp lại tất cả các phần tử trong HashMap
        for (String key : ageMap.keySet()) {
            System.out.println(key + ": " + ageMap.get(key));
        }
    }
}
