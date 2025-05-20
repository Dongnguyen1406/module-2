package fruit_manager.service;

import fruit_manager.model.Fruit;
import fruit_manager.repository.FruitRepo;
import fruit_manager.repository.IFruitRepo;

import java.util.List;


public class FruitService implements IFruitService{
    private static final IFruitRepo fruitRepo = new FruitRepo();
    
    
    @Override
    public List<Fruit> getAll() {
        return fruitRepo.getAll();
    }

    @Override
    public void add(Fruit fruit) {
        fruitRepo.add(fruit);
    }

    @Override
    public boolean isExist(int id) {
        return fruitRepo.isExist(id);
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepo.searchByName(name);
    }

    @Override
    public void update(Fruit fruit) {
        fruitRepo.update(fruit);
    }

    @Override
    public void displayByKeySet() {
        fruitRepo.displayByKeySet();
    }

    @Override
    public void displayByEntrySet() {
        fruitRepo.displayByEntrySet();
    }

    @Override
    public boolean findIdToDelete(int id) {
        return fruitRepo.findIdToDelete(id);
    }
}
