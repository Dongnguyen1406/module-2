package fruit_manager.repository;

import fruit_manager.model.Fruit;

import java.util.List;

public interface IFruitRepo {
    List<Fruit> getAll();
    void add(Fruit fruit);
    boolean isExist(String name);
    boolean findNameToDelete(String name);
    List<Fruit> searchByName(String name);
    void update(Fruit fruit);
}
