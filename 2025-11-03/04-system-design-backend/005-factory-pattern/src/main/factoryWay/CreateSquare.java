package main.factoryWay;

import main.shape.IShape;
import main.shape.Square;

public class CreateSquare extends AbstractShapeFactory  {
	@Override
	public IShape createShape() {
		return new Square();
	}
}
