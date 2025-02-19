import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class test {


    @Test
    void testAddItemToOrder() {
        System.out.println("Check wheather item added or not");
        order order = new CustomerOrder();
        Flavor chocolate = new Flavor("Chocolate Fudge", 3.00, 1);
        ((CustomerOrder) order).addItem(chocolate);
        assertFalse(order.getItems().isEmpty(), "Item should be added to the order.");
    }


    @Test
    void testCalculateSubtotal() {
        System.out.println("Calculate Subtoal");
        CustomerOrder order = new CustomerOrder();
        order.addItem(new Flavor("Chocolate Fudge", 3.00, 1));
        order.addItem(new Flavor("Pistachio Delight", 3.25, 1));
        order.addItem(new Topping("Sprinkles", 0.30));

        double expectedSubtotal = 3.00 + 3.25 + 0.30;
        assertEquals(expectedSubtotal, order.calculateSubtotal(), "Subtotal should be 6.55");
    }


    @Test
    void testInvoiceFileCreated() throws IOException {

        System.out.println("Printing Process: ");
        CustomerOrder order = new CustomerOrder();
        order.addItem(new Flavor("Chocolate Fudge", 3.00, 1));
        order.addItem(new Flavor("Pistachio Delight", 3.25, 1));
        order.addItem(new Topping("Sprinkles", 0.30));

        CreateInvoice invoice = new CreateInvoiceThroghText();
        invoice.CreateInvoice(order);

        File file = new File("invoice.txt");
        assertTrue(file.exists(), "Invoice file should be created.");
    }

    @Test
    void testTaxCalculation() {
        System.out.println("Tax Calculation");
        CustomerOrder order = new CustomerOrder();
        order.addItem(new Flavor("Chocolate Fudge", 3.00, 1));
        order.addItem(new Flavor("Pistachio Delight", 3.25, 1));
        order.addItem(new Topping("Sprinkles", 0.30));

        double expectedTax = Math.round((6.55 * 0.08) * 100) / 100.0;
        assertEquals(expectedTax, order.calculateTax(), "Tax should be 0.52");
    }


    @Test
    void testTotalAmountCalculation() {
        System.out.println(" Total Amount");
        CustomerOrder order = new CustomerOrder();
        order.addItem(new Flavor("Chocolate Fudge", 3.00, 1));
        order.addItem(new Flavor("Pistachio Delight", 3.25, 1));
        order.addItem(new Topping("Sprinkles", 0.30));

        double expectedTotal = 6.55 + 0.52;
        assertEquals(expectedTotal, order.calculateTotal(), "Total amount should be 7.07");
    }
}
