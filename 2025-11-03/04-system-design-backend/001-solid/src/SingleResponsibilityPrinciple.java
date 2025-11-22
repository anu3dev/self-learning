/**
 * single responsibility principle means that a class should have 
 * only one reason to change.
 */

// marker entity to demonstrate single responsibility principle
public class SingleResponsibilityPrinciple {
    class Marker {
        private String color;
        private int price;

            public Marker(String color, int price) {
                this.color = color;
            this.price = price;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    class Invoice {
        public Marker marker;
        public int quantity;

        public Invoice(Marker marker, int quantity) {
            this.marker = marker;
            this.quantity = quantity;
        }

        public int calculateTotalPrice(){
            return marker.getPrice() * quantity;
        }

        public void printInvoice(){
            // printing logic
        }

        public void saveToDB(){
            // database logic
        }
    }

    /**
    * in the above invoice class we have multiple reasons to change
    * 1. if there is a change in the calculation logic
    * 2. if there is a change in the printing logic
    * 3. if there is a change in the database logic
    * 
    * so to follow single responsibility principle we can separate these
    * responsibilities into different classes.
    */

    /**
     * created separate class for invoice calculation
     * only reason to change in this class is if there is a change
     * in the calculation logic.
     */
    class InvoiceCalculator {
        public Marker marker;
        public int quantity;

        public InvoiceCalculator(Marker marker, int quantity) {
            this.marker = marker;
            this.quantity = quantity;
        }

        public int calculateTotalPrice(){
            return marker.getPrice() * quantity;
        }
    }

    /**
     * created separate class for invoice printing
     * only reason to change in this class is if there is a change
     * in the printing logic.
     */
    class InvoicePrinter {
        public void printInvoice(InvoiceCalculator calculator){
            // printing logic
        }
    }

    /**
     * created separate class for invoice database operations
     * only reason to change in this class is if there is a change
     * in the database logic.
     */
    class InvoiceRepository {
        public void saveToDB(InvoiceCalculator calculator){
            // database logic
        }
    }

    /**
     * now each class has only one reason to change
     */
}