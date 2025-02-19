import java.util.ArrayList;
import java.util.List;

public class CustomerOrder implements order {
    private List<TaskItem> items = new ArrayList<>();
    private boolean glassJar;
    private static final double GLASS_JAR_FEE = 5.00;
    private static final double TAX_RATE = 0.08;

    public void addItem(TaskItem item) {///////////follow dip
        items.add(item);
        System.out.println(" adding item");
    }

    public void selectContainer(boolean useGlassJar) {
        this.glassJar = useGlassJar;
    }

    @Override
    public double calculateSubtotal() {
        double subtotal = 0.0;
        for (TaskItem item : items) {
            subtotal += item.getPrice();////no type cheking :no instance needed: follow lsp
        }
        if (glassJar) {
            subtotal += GLASS_JAR_FEE;
            System.out.println("subtotal with GLASS_JAR_FEE");
        }
        return subtotal;
    }

    @Override
    public double calculateTax() {
        System.out.println("calculation of tax");
        return Math.round(calculateSubtotal() * TAX_RATE * 100) / 100.0;
    }

    @Override
    public double calculateTotal() {
        System.out.println(" calculation of calculate total");
        return Math.round((calculateSubtotal() + calculateTax()) * 100) / 100.0;
    }

    @Override
    public List<TaskItem> getItems() {
        System.out.println("get item");
        return items;
    }

    @Override
    public boolean isGlassJar() {
        System.out.println(" check : is taking item through GLASS JAR  or not");
        return glassJar;
    }
}
