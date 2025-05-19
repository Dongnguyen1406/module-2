package fruit_manager.view;

import fruit_manager.model.Fruit;
import fruit_manager.service.FruitService;
import fruit_manager.service.IFruitService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FruitView {
    private static final Scanner scanner = new Scanner(System.in);
    private static IFruitService fruitService = new FruitService();
    
    public static void display(List<Fruit> fruits){
        if (fruits.isEmpty()){
            System.out.println("Danh sách rỗng!");
        }
        for (Fruit fruit : fruits){
            System.out.println(fruit);
        }
    }

    public static String inputName(){
        System.out.println("Nhập tên trái cây: ");
        return scanner.nextLine();
    }
    
    public static Fruit inputFruitInfo(){
        String inputName;
        while (true){
            System.out.print("Nhập tên trái cây: ");
            inputName = scanner.nextLine();
            if (fruitService.isExist(inputName)){
                System.out.println("Tên trái cây đã tồn tại !");
            } else {
                break;
            }
        }
        
        String inputTypeFruit;
        System.out.print("Nhập loại trái cây: ");
        inputTypeFruit = scanner.nextLine();

        LocalDate manufactureDate;
        System.out.print("Nhập ngày sản xuất: ");
        manufactureDate = LocalDate.parse(scanner.nextLine());
        
        LocalDate expiryDate;
        System.out.print("Nhập hạn sử dụng: ");
        expiryDate = LocalDate.parse(scanner.nextLine());
        
        String placeOfOrigin;
        System.out.print("Nhập xuất sứ: ");
        placeOfOrigin = scanner.nextLine();
        
        Double price;
        System.out.print("Nhập giá: ");
        price = Double.parseDouble(scanner.nextLine());
        
        return new Fruit(inputName, inputTypeFruit, manufactureDate, expiryDate, placeOfOrigin, price);
    }

    public static Fruit updateFruitInfo(String inputName){
        
        String inputTypeFruit;
        System.out.print("Nhập loại trái cây: ");
        inputTypeFruit = scanner.nextLine();

        LocalDate manufactureDate;
        System.out.print("Nhập ngày sản xuất: ");
        manufactureDate = LocalDate.parse(scanner.nextLine());

        LocalDate expiryDate;
        System.out.print("Nhập hạn sử dụng: ");
        expiryDate = LocalDate.parse(scanner.nextLine());

        String placeOfOrigin;
        System.out.print("Nhập xuất sứ: ");
        placeOfOrigin = scanner.nextLine();

        Double price;
        System.out.print("Nhập giá: ");
        price = Double.parseDouble(scanner.nextLine());

        return new Fruit(inputName, inputTypeFruit, manufactureDate, expiryDate, placeOfOrigin, price);
    }
}
