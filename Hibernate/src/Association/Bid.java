package Association;

public class Bid {

	private int id; // will update automatically as in id tab and in generator tab we used "class="increment""
	private float amount;
	private int itemId; // FK will be updated automatically as in Bid.hbm.xml class in property tag we used "insert="false""

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

}
