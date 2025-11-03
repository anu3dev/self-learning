package main.shape;

public class Square implements IShape {
	@Override
	public void computeArea() {
		System.out.println("calculating square area.");
	}
	
	@Override
	public void draw() {
		System.out.println("drawing square.");
	}
}
