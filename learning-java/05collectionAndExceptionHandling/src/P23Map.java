import java.util.WeakHashMap;

class MapEx1Method1 {
	private int id;
	private String name;
	
	@Override
	public String toString() {
		return "Emp: [id=" + id + ", name=" + name + "]";
	}

	@Override
	public void finalize() {
		System.out.println("Obj cleaning by Garbage collector");
	}
}

class MapEx1 {
	@SuppressWarnings("unchecked")
	public MapEx1() {
		MapEx1Method1 emp = new MapEx1Method1();
		
		@SuppressWarnings("rawtypes")
		WeakHashMap hm = new WeakHashMap();
		
		hm.put(emp, "anurag");
			
		System.out.println(hm);		// {Emp: [id=0, name=null]=anurag}
						
		emp = null;	
		System.gc();
			
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		System.out.println(hm);		// {}
	}
}

public class P23Map {
	public static void main(String[] args) {
		new MapEx1();
	}
}
