package fruit_manager.model;

import java.time.LocalDate;

public class Fruit {
    private int id;
    private String name;
    private String typeFruit;
    private LocalDate manufactureDate;
    private LocalDate expiryDate;
    private String placeOfOrigin;
    private Double price;

    public Fruit(int id, String name, String typeFruit, LocalDate manufactureDate, LocalDate expiryDate, String placeOfOrigin, Double price) {
        this.id = id;
        this.name = name;
        this.typeFruit = typeFruit;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.placeOfOrigin = placeOfOrigin;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeFruit() {
        return typeFruit;
    }

    public void setTypeFruit(String typeFruit) {
        this.typeFruit = typeFruit;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeFruit='" + typeFruit + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", expiryDate=" + expiryDate +
                ", placeOfOrigin='" + placeOfOrigin + '\'' +
                ", price=" + price +
                '}';
    }
}
