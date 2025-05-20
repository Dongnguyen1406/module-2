package fruit_manager.repository;

import fruit_manager.model.Fruit;

import java.util.List;

public interface IFruitRepo {
    List<Fruit> getAll();
    void add(Fruit fruit);
    boolean isExist(int id);
    boolean findIdToDelete(int id);
    List<Fruit> searchByName(String name);
    void update(Fruit fruit);
    void displayByKeySet();
    void displayByEntrySet();
}
