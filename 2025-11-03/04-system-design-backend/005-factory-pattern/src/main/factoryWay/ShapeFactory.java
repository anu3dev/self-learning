package main.factoryWay;

import main.constant.ShapeType;
import main.shape.IShape;

public class ShapeFactory {
	public static IShape createShapeInstance(ShapeType type) {
		IShape shape = null;
		
		if(type == null) {
			return null;
		}
		
		switch(type) {
		case CIRCLE:
			AbstractShapeFactory circleCreator = new CreateCircle();
			shape = circleCreator.createShape();
			break;
		case SQUARE:
			AbstractShapeFactory squareCreator = new CreateSquare();
			shape = squareCreator.createShape();
			break;
		default:
			throw new IllegalStateException("shape type doesn't exist!"); 
		}
		return shape;
	}
}
