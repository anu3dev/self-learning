
//Functional Interface

@FunctionalInterface
interface Telusko
{
	void learning();
	
	//void job();
}
//This is the parent class where in i have define abstract level requirement about aero plane
//@Deprecated
class Plane
{
	public void fliesAThighHeight()
	{
		System.out.println("Plane flies at high height");
	}
	
}

//This is one of child class of plane which is implementing parent class plane and givening spefic cargoplane behaviour
//@Override
class CargoPlane extends Plane
{
	//i m overriding the method to suit child class requirement
	
	@Override
	public void fliesAThighHeight()
	{
		System.out.println("CargoPlane flies at little lower hieght then passenger plane");
	}
}


public class LaunchAn1 
{

	public static void main(String[] args) 
	{
		Plane plane=new CargoPlane();
		plane.fliesAThighHeight();
		
		Plane pl=new Plane();
		

	}

}
