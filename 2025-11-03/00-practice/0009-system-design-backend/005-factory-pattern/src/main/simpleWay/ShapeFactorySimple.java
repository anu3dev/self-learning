package main.simpleWay;

import main.constant.ShapeType;
import main.shape.Circle;
import main.shape.IShape;
import main.shape.Square;

public class ShapeFactorySimple {
	public static IShape createShapeInstance(ShapeType type) {
		if(type == null) {
			return null;
		}
		
		switch(type) {
			case CIRCLE:
				return new Circle();
			case SQUARE:
				return new Square();
			default:
				throw new IllegalStateException("shape type doesn't exist!");
		}
	}
}
