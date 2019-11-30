
package model;

public class Item {

	private Story story;
	private int quantity;

	public Item() {
	}

	public Item(Story story, int quantity) {
		this.story = story;
		this.quantity = quantity;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
