package Model.Order;

import Model.Pallet;

public class PalletLoading {
	private int palletNo;
	private Pallet pallet;
	private Item item;
	private float x;
	private float y;
	private float angle;
	
	public PalletLoading() {
		//
	}
	
	public PalletLoading(int palletNo) {
		this.palletNo = palletNo;
	}
	
	public PalletLoading(int palletNo, Pallet pallet, Item item, float x, float y, float angle) {
		this(palletNo);
		this.pallet = pallet;
		this.item = item;
		this.x = x;
		this.y = y;
		this.angle = angle;
	}
	
	public int getPalletNo() {
		return this.palletNo;
	}
	
	public Pallet getPallet() {
		return this.pallet;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public float getAngle() {
		return this.angle;
	}
	
	public void setPallet(Pallet pallet) {
		this.pallet = pallet;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void setAngle(float angle) {
		this.angle = angle;
	}
}
