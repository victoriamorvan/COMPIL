package Application;

public class Disease {
	String name;
	String db;
	
	public Disease(String name,String db){
		this.name=name;
		this.db=db;
	}
	public Disease(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}


}
