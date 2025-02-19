class Topping implements TaskItem {
    private String name;
    private double price;

    public Topping(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
//flavor and topping implement taskitem and follow both lsp and ocp beacause we can extend
//without modifying existing code and both class subtyping parent class does not violate any method