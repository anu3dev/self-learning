/**
 * open closed principle means that a class should be open for extension
 * but closed for modification.
 */ 

public class OpenClosePrincipal {
    class InvoiceDao{
        public void saveToDB(){
            // database logic
        }

        /**
         * this design violates open closed principle because every time we need
         * to add a new way to save invoice we need to modify this class
         */
        public void saveToFile(){
            // file logic
        }
    }

    // better design using interface to follow open closed principle
    public interface InvoiceDaoInterface {
        void save();
    }

    static class InvoiceSaveToDB implements InvoiceDaoInterface {
        @Override
        public void save() {
            // database logic
        }
    }

    static class InvoiceSaveToFile implements InvoiceDaoInterface {
        @Override
        public void save() {
            // file logic
        }
    }

    static class InvoiceSaveToCloud implements InvoiceDaoInterface {
        @Override
        public void save() {
            // cloud logic
        }
    }

    /**
     * in the above design we can add new ways to save invoice
     * without modifying existing code.
     */

    public static void main(String[] args) {
        InvoiceDaoInterface invoiceDB = new InvoiceSaveToDB();
        invoiceDB.save();

        InvoiceDaoInterface invoiceFile = new InvoiceSaveToFile();
        invoiceFile.save();

        InvoiceDaoInterface invoiceCloud = new InvoiceSaveToCloud();
        invoiceCloud.save();
    }
}