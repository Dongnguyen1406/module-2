package fruit_manager.controller;

import fruit_manager.model.Fruit;
import fruit_manager.service.FruitService;
import fruit_manager.service.IFruitService;
import fruit_manager.view.FruitView;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FruitController {
    private static Scanner scanner = new Scanner(System.in);
    static final IFruitService fruitService = new FruitService();

    public static void displayMenu() {
        boolean flag = true;
        do {
            System.out.println("-----Quản lý trái cây-----" +
                    "\n 1. Hiển thị danh sách" +
                    "\n 2. Thêm" +
                    "\n 3. Xóa" +
                    "\n 4. Tìm kiếm" +
                    "\n 5. Sửa" +
                    "\n 6. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Danh sách trái cây");
                    List<Fruit> fruitList = fruitService.getAll();
                    FruitView.display(fruitList);
                    break;  
                case 2:
                    System.out.println("Nhập thông tin của trái cây");
                    String name;
                    do {
                        name = FruitView.inputName();
                        if (fruitService.isExist(name)){
                            System.out.println("Tên trái cây đã tồn tại!");
                        } 
                    }while (fruitService.isExist(name));
                    Fruit fruit = FruitView.inputFruitInfo(name);
                    fruitService.add(fruit);
                    System.out.println("Thêm thành công!");
                    break;
                case 3:
                    String nameToDelete = FruitView.inputName();
                    boolean isDelete = fruitService.findNameToDelete(nameToDelete);
                    if (isDelete){
                        System.out.println("Xóa thành công!");
                    }else {
                        System.out.println("Không tìm thấy tên trái cây để xóa " + nameToDelete);
                    }
                    break;
                case 4:
                    String nameToSearch = FruitView.inputName();
                    List<Fruit> fruits = fruitService.searchByName(nameToSearch);
                    if (fruits.isEmpty()){
                        System.out.println("Không tìm thấy trái cây tên" + nameToSearch);
                    } else {
                        for (Fruit fruit1 : fruits){
                            System.out.println(fruit1);
                        }
                    }
                    break;
                case 5:
                    String nameToUpdate = FruitView.inputName();
                    if (fruitService.isExist(nameToUpdate)){
                        Fruit fruit1 = FruitView.updateFruitInfo(nameToUpdate);
                        fruitService.update(fruit1);
                    } else {
                        System.out.println("Tên trái cây " + nameToUpdate + " không tồn tại !");
                    }
                    break;
                case 6:
                    flag = false;
                    System.out.println("Thoát chương trình thành công!");
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1-5 !");
            }
        } while (flag);
    }
}
