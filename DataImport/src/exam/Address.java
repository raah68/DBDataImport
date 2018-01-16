package exam;

public class Address {
	
	//private String door_number;
	private String building_name;
	private String street_name;
	private String town_name;
	private String post_code;

	// Class Constructor
	public Address(String building_name, String street_name, String town_name, String post_code) {
		super();
		//this.door_number = door_number;
		this.building_name = building_name;
		this.street_name = street_name;
		this.town_name = town_name;
		this.post_code = post_code;
	}
	
/*	public String getDoor_number() {
		return door_number;
	}
	public void setDoor_number(String door_number) {
		this.door_number = door_number;
	}*/
	
	public String getBuilding_name() {
		return building_name;
	}
	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}
	
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	
	public String getTown_name() {
		return town_name;
	}
	public void setTown_name(String town_name) {
		this.town_name = town_name;
	}
	
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	
	
	
	
	

} // End of Class
