package j005dependencyInversion;

/**
 * Depend on abstractions, not concrete classes.
 */



// bad example - if PostGres or MogoDB then we have to do code change.
class MySQLDatabase01 {
	void save() {}
}
class UserService01 {
	private MySQLDatabase01 db = new MySQLDatabase01();
}



// good example
interface Database {
	void save();
}
class MySQLDatabase implements Database {
	public void save() {}
}
class MongoDatabase implements Database {
	public void save() {}
}
class UserService {
	private Database db;
	
	public UserService(Database db) {
		this.db = db;
	}
}



public class DependencyInversion {
	public static void main(String[] args) {}
}
