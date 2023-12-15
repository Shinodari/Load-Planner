package Model.Order;

public class Item {
	private int itemID;
	private String name;
	private float weight;
	
	public Item() {
		//
	}
	
	public Item(int itemID) {
		this.itemID = itemID;
	}
	
	public Item(int itemID, String name, float weight) {
		this(itemID);
		this.name = name;
		this.weight = weight;
	}
	
	public int getItemID() {
		return this.itemID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public float getWeight() {
		return this.weight;
	}
	
	public void set(String name, float weight) {
		setName(name);
		setWeight(weight);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
}
