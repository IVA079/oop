import java.util.List;

public interface order {
    double calculateSubtotal();
    double calculateTax();
    double calculateTotal();
    List<TaskItem> getItems();
    boolean isGlassJar();
}
