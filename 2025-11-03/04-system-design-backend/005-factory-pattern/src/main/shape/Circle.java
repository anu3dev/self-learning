package main.shape;

public class Circle implements IShape {
	@Override
	public void computeArea() {
		System.out.println("calculating circle area.");
	}
	
	@Override
	public void draw() {
		System.out.println("drawing circle.");
	}
}
