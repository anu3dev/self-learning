package main.factoryWay;

import main.shape.Circle;
import main.shape.IShape;

public class CreateCircle extends AbstractShapeFactory {
	@Override
	public IShape createShape() {
		return new Circle();
	}
}
