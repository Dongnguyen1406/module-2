package fruit_manager.view;

import fruit_manager.common.FruitValidate;
import fruit_manager.model.Fruit;
import fruit_manager.service.FruitService;
import fruit_manager.service.IFruitService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FruitView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void display(List<Fruit> fruits) {
        if (fruits.isEmpty()) {
            System.out.println("Danh sách rỗng!");
        }
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }
    }

    public static String inputName() {
        String name;
        while (true) {
            try {
                System.out.println("Nhập tên trái cây: ");
                name = scanner.nextLine();
                FruitValidate.validateTypeFruit(name);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return name;
    }

    public static int inputId() {
        String input;
        while (true) {
            try {
                System.out.print("Nhập mã trái cây: ");
                input = scanner.nextLine();
                FruitValidate.validateIdFruit(input);
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Fruit inputFruitInfo(int id) {
        String inputName;
        while (true) {
            try {
                System.out.print("Nhập tên trái cây: ");
                inputName = scanner.nextLine();
                FruitValidate.validateTypeFruit(inputName);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String inputTypeFruit;
        while (true) {
            try {
                System.out.print("Nhập loại trái cây: ");
                inputTypeFruit = scanner.nextLine();
                FruitValidate.validateTypeFruit(inputTypeFruit);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        LocalDate manufactureDate;
        while (true) {
            try {
                System.out.print("Nhập ngày sản xuất: ");
                manufactureDate = LocalDate.parse(scanner.nextLine());
                if (!manufactureDate.isBefore(LocalDate.now())) {
                    System.out.println("Ngày sx không được vượt qua ngày hiện tại!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập theo định dạng (yyyy-MM-dd)");
            }
        }

        LocalDate expiryDate;
        while (true) {
            try {
                System.out.print("Nhập hạn sử dụng: ");
                expiryDate = LocalDate.parse(scanner.nextLine());
                if (expiryDate.isBefore(LocalDate.now())) {
                    System.out.println("Hạn sử dụng tính từ ngày hiện tại trở đi!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập theo định dạng (yyyy-MM-dd)");
            }
        }

        String placeOfOrigin;
        while (true) {
            try {
                System.out.print("Nhập xuất sứ: ");
                placeOfOrigin = scanner.nextLine();
                FruitValidate.validateTypeFruit(placeOfOrigin);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Double price;
        while (true) {
            try {
                System.out.print("Nhập giá: ");
                price = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số !");
            }
        }

        return new Fruit(id, inputName, inputTypeFruit, manufactureDate, expiryDate, placeOfOrigin, price);
    }

    public static Fruit updateFruitInfo(int id) {

        String inputName;
        while (true) {
            try {
                System.out.print("Nhập tên trái cây: ");
                inputName = scanner.nextLine();
                FruitValidate.validateTypeFruit(inputName);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String inputTypeFruit;
        while (true) {
            try {
                System.out.print("Nhập loại trái cây: ");
                inputTypeFruit = scanner.nextLine();
                FruitValidate.validateTypeFruit(inputTypeFruit);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        LocalDate manufactureDate;
        while (true) {
            try {
                System.out.print("Nhập ngày sản xuất: ");
                manufactureDate = LocalDate.parse(scanner.nextLine());
                if (!manufactureDate.isBefore(LocalDate.now())) {
                    System.out.println("Ngày sx không được vượt qua ngày hiện tại!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập theo định dạng (yyyy-MM-dd)");
            }
        }

        LocalDate expiryDate;
        while (true) {
            try {
                System.out.print("Nhập hạn sử dụng: ");
                expiryDate = LocalDate.parse(scanner.nextLine());
                if (expiryDate.isBefore(LocalDate.now())) {
                    System.out.println("Hạn sử dụng tính từ ngày hiện tại trở đi!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập theo định dạng (yyyy-MM-dd)");
            }
        }

        String placeOfOrigin;
        while (true) {
            try {
                System.out.print("Nhập xuất sứ: ");
                placeOfOrigin = scanner.nextLine();
                FruitValidate.validateTypeFruit(placeOfOrigin);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Double price;
        while (true) {
            try {
                System.out.print("Nhập giá: ");
                price = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số !");
            }
        }

        return new Fruit(id, inputName, inputTypeFruit, manufactureDate, expiryDate, placeOfOrigin, price);
    }
}
