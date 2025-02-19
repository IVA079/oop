class Flavor implements TaskItem {
    private String name;
    private double pricePerScoop;
    private int quantity;

    public Flavor(String name, double pricePerScoop, int quantity) {
        this.name = name;
        this.pricePerScoop = pricePerScoop;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return name;
    }


    public int getQuantity() {
        return quantity;
    }

    // Calls getQuantity() inside getPrice() (avoids type check)



    @Override
    public double getPrice() {
        return pricePerScoop * getQuantity();
    }
}
