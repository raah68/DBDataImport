package exam;

public class Product {

	private String name ;
	private String price;
	private String itemtype;
	private String id;
	
	
	
	public Product(String name, String price, String itemtype, String id) {
		super();
		this.name = name;
		this.price = price;
		this.itemtype = itemtype;
		this.id = id;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getItemtype() {
		return itemtype;
	}
	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	

} // end of class
