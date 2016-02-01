package person;

public class PersonBuilder {
	
	 	public static final int LEGAL_AGE = 18;
	    public static final String GENDER_FEMALE = "F";
	    public static final String GENDER_MALE = "M";

	    private String name="Tiit";
	    private Address address = new Address("Akadeemia tee 2", "Tallinn");
	    private String gender= GENDER_MALE;
	    private int age;


    public PersonBuilder withAge(int age) {
        this.age=age;
        return this;
    }
    
    public PersonBuilder withGender(String gender) {
        this.gender=gender;
        return this;
    }
    
    public PersonBuilder withAddress(Address address) {
        this.address=address;
        return this;
    }
    

    public Person build() {
        Person p = new Person(this.name, this.age, this.gender, this.address);
        return p;
    }
}
