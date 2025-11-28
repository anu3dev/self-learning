/**
 * Class should depend on interfaces or abstract classes
 * rather than concrete implementations.
 */
public class DependencyInversion {
    interface Keyboard {
        void type();
    }

    interface Mouse {
        void click();
    }

    class WiredKeyboard implements Keyboard {
        public void type() {
            // typing logic
        }
    }

    class WiredMouse implements Mouse {
        public void click() {
            // clicking logic
        }
    }

    // this is wrong design as macbook is depending on concrete implementations
    class MacBook {
        @SuppressWarnings("unused")
        private final WiredKeyboard keyboard;
        @SuppressWarnings("unused")
        private final WiredMouse mouse;

        public MacBook() {
            keyboard = new WiredKeyboard();
            mouse = new WiredMouse();
        }
    }

    // better design using dependency inversion principle
    class MacBookDIP {
        @SuppressWarnings("unused")
        private final Keyboard keyboard;
        @SuppressWarnings("unused")
        private final Mouse mouse;

        /**
         * here I can pass any implementation of keyboard and mouse
         * to macbook without changing its code.
         */
        public MacBookDIP(Keyboard keyboard, Mouse mouse) {
            this.keyboard = keyboard;
            this.mouse = mouse;
        }
    }
}
