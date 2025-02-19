import java.io.FileWriter;
import java.io.IOException;

public class CreateInvoiceThroghText implements CreateInvoice {

    @Override
    public void CreateInvoice(order order) {

        try (FileWriter writer = new FileWriter("invoice.txt")) {
            writer.write("  Shop Invoice");

            for (TaskItem item : order.getItems()) {
                writer.write(item.getName() + " - $" + item.getPrice() );
            }

            writer.write("\nSubtotal: $" + order.calculateSubtotal() );
            writer.write("Tax: $" + order.calculateTax() + "\n");
            writer.write("Total Amount Due: $" + order.calculateTotal() + "\n");
            writer.write(" Enjoy your yogurt! ");

            System.out.println("Invoice created through text: 'invoice.txt'");
        } catch (IOException e) {
            System.out.println(" Error writing invoice: " + e.getMessage());
        }
    }
    }



