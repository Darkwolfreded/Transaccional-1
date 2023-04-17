package pe.edu.upao.transaccional1.models;

public class Food {

    String name;
    String description;
    double price;

    public Food() {
    }

    public Food(String name) {
        this.name = name;
    }

    public Food(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Food(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
