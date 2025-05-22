package fruit_manager.repository;

import fruit_manager.model.Fruit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FruitRepo implements IFruitRepo {
    private static final List<Fruit> fruits = new ArrayList<>();

    static {
        fruits.add(new Fruit("Xoài", "Qủa", LocalDate.of(2025, 5, 19), LocalDate.of(2025, 5, 20), "DN", 12000.0));
        fruits.add(new Fruit("Bưởi", "Qủa", LocalDate.of(2025, 5, 20), LocalDate.of(2025, 5, 25), "DN", 12000.0));
        fruits.add(new Fruit("Chuối", "Qủa", LocalDate.of(2025, 5, 22), LocalDate.of(2025, 5, 29), "DN", 12000.0));
    }

    @Override
    public List<Fruit> getAll() {
        return fruits;
    }

    @Override
    public void add(Fruit fruit) {
        fruits.add(fruit);
    }

    @Override
    public boolean isExist(String name) {
        for (Fruit fruit1 : fruits) {
            if (fruit1.getName().toLowerCase().equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean findNameToDelete(String name) {
        for (int i = 0; i < fruits.size(); i++) {
            if (fruits.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                fruits.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Fruit> searchByName(String name) {
        List<Fruit> result = new ArrayList<>();
        for (Fruit fruit1 : fruits) {
            if (fruit1.getName().toLowerCase().contains(name.toLowerCase())) {
               result.add(fruit1);
            }
        }
        return result;
    }

    @Override
    public void update(Fruit fruit) {
        List<Fruit> fruitList = getAll();
        for (int i = 0; i < fruitList.size(); i++) {
            if (fruitList.get(i).getName().toLowerCase().equals(fruit.getName())) {
                fruitList.set(i, fruit);
            }
        }
        List<Fruit> result = new ArrayList<>();
        for (Fruit fruit1 : fruitList){
            result.add(fruit1);
        }
    }

}
