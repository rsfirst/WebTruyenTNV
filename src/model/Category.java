
package model;

public class Category {
	private long categoryID;
	private String categoryName;
	private int menuId;
	private String linkMenu;
	private String status;
	private String orderNumber;

	public Category() {
	}

	public Category(long categoryID, String categoryName) {
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}

	public long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getLinkMenu() {
		return linkMenu;
	}

	public void setLinkMenu(String linkMenu) {
		this.linkMenu = linkMenu;
	}

}
