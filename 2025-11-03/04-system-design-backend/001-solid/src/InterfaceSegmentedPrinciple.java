/**
 * Interface Segregation Principle states that no client should be immplemented
 * to depend on methods it does not use.
 */

public class InterfaceSegmentedPrinciple {
    interface ResstaurentEmployee {
        void serveCustomer();
        void cookFood();
        void washDishes();
    }

    class Waiter implements ResstaurentEmployee {
        public void serveCustomer() {
            // serving logic
        }

        public void cookFood() {
            // not applicable for waiter
            throw new UnsupportedOperationException();
        }

        public void washDishes() {
            // not applicable for waiter
            throw new UnsupportedOperationException();
        }
    }

    class Chef implements ResstaurentEmployee {
        public void serveCustomer() {
            // not applicable for chef
            throw new UnsupportedOperationException();
        }

        public void cookFood() {
            // cooking logic
        }

        public void washDishes() {
            // not applicable for chef
            throw new UnsupportedOperationException();
        }
    }

    // better design using interface segregation principle
    interface CustomerService {
        void serveCustomer();
        void takeOrder();
    }

    interface FoodPreparation {
        void cookFood();
    }

    interface DishWashing {
        void washDishes();
    }

    class WaiterISP implements CustomerService {
        public void serveCustomer() {
            // serving logic
        }

        public void takeOrder() {
            // order taking logic
        }
    }

    class ChefISP implements FoodPreparation {
        public void cookFood() {
            // cooking logic
        }
    }

    class DishwasherISP implements DishWashing {
        public void washDishes() {
            // washing logic
        }
    }
}