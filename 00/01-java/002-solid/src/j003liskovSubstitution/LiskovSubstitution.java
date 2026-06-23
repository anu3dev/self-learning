package j003liskovSubstitution;

/**
 * Child class should be replaceable by parent class without breaking behavior.
 */



// below is example of bad code as -> Bird bird = new Penguin(); -> bird.fly(); -> Parent expectation broken. -> LSP violated.
class Bird01 {
	void fly() {}
}
class Penguin01 extends Bird01 {
	@Override
	void fly() {
		// code
	}
}



// good example
class Bird{}
interface Flyable{
	void fly();
}
class Sparrow extends Bird implements Flyable {
	public void fly() {}
}
class Penguin extends Bird{}



public class LiskovSubstitution {
	public static void main(String[] args) {}
}
