package fruit_manager.controller;

import fruit_manager.model.Fruit;
import fruit_manager.service.FruitService;
import fruit_manager.service.IFruitService;
import fruit_manager.view.FruitView;

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
                    boolean flagDisplay = true;
                    do {
                        System.out.println(
                                " 1. Hiển thị danh sách bằng keySet" +
                                "\n 2. Hiển thị danh sách bằng entrySet" +
                                "\n 3. Trở lại menu chính");
                        System.out.print("Chọn cách hiển thị: ");
                        int choiceDisplay = Integer.parseInt(scanner.nextLine());
                        switch (choiceDisplay){
                            case 1:
                                fruitService.displayByKeySet();
                                break;
                            case 2:
                                fruitService.displayByEntrySet();
                                break;
                            case 3:
                                flagDisplay = false;
                            default:
                                System.out.println("Vui lòng nhập từ 1-3 !");
                        }
                    }while (flagDisplay);
                    break;  
                case 2:
                    System.out.println("Nhập thông tin của trái cây");
                    int id;
                    do {
                        id = FruitView.inputId();
                        if (fruitService.isExist(id)){
                            System.out.println("Mã trái cây đã tồn tại!");
                        }
                    }while (fruitService.isExist(id));
                    Fruit fruit = FruitView.inputFruitInfo(id);
                    fruitService.add(fruit);
                    System.out.println("Thêm thành công!");
                    break;
                case 3:
                    int idToDelete = FruitView.inputId();
                    boolean isDelete = fruitService.findIdToDelete(idToDelete);
                    if (isDelete){
                        System.out.println("Xóa thành công!");
                    }else {
                        System.out.println("Không tìm thấy tên trái cây để xóa " + idToDelete);
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
                    int idToUpdate = FruitView.inputId();
                    if (fruitService.isExist(idToUpdate)){
                        Fruit fruit1 = FruitView.updateFruitInfo(idToUpdate);
                        fruitService.update(fruit1);
                    } else {
                        System.out.println("Tên trái cây " + idToUpdate + " không tồn tại !");
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
