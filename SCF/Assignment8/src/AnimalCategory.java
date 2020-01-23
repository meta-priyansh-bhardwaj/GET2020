
public enum AnimalCategory {
	MAMMAL("Mammal","Lion"),
	MAMMAL1("Mammal","BlackBear"),
	REPTILE1("Reptile","Snake"),
	REPTILE2("Reptile","Crocodile"),
	BIRD1("Bird","Peacock");


	String category;
	String type;

	private AnimalCategory(String category,String type) {
		this.category=category;
		this.type=type;
	}
    public String getCategoryEnum() {
    	return category;
    }
    public String getTypeEnum() {
    	return type;
    }
}
