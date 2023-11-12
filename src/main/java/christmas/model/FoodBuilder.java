package christmas.model;

public class FoodBuilder {
    private String category;
    private String name;
    private int price;

    public FoodBuilder category(String category) {
        this.category = category;
        return this;
    }

    public FoodBuilder name(String name) {
        this.name = name;
        return this;
    }

    public FoodBuilder price(int price) {
        this.price = price;
        return this;
    }

    public Food build() {
        return new Food(category, name, price);
    }

}
