package item.dto;

import java.util.UUID;

import org.hibernate.validator.constraints.NotBlank;

public class Item {

	
	private int itemNo;
	@NotBlank
	private String itemCode;
	@NotBlank
	private String itemName;
	@NotBlank
	private String itemDetail;
	private int price;
	private int stock;

	public Item() {
	}
	
	public Item(/* String itemCode, */String itemName, String itemDetail, int price, int stock) {

		//this.itemNo = itemNo;
//		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemDetail = itemDetail;
		this.price = price;
		this.stock = stock;
	}


//	private int option1_no;	
//	private String option1_name;
//	private int option1_price; 		
//	private int option1_stock; 	
//		
//	private int option2_no;		
//	private String option2_name;
//	private int option2_price; 		
//	private int option2_stock;
//	
	
	
//	public ItemCommand(int itemNo, String itemCode, String itemName, String itemDetail, int price, int stock, int option1_no,
//			String option1_name, int option1_price, int option1_stock, int option2_no, String option2_name,
//			int option2_price, int option2_stock) {
//		super();
//		this.itemNo = itemNo;
//		this.itemCode = itemCode;
//		this.itemName = itemName;
//		this.itemDetail = itemDetail;
//		this.price = price;
//		this.stock = stock;
//		this.option1_no = option1_no;
//		this.option1_name = option1_name;
//		this.option1_price = option1_price;
//		this.option1_stock = option1_stock;
//		this.option2_no = option2_no;
//		this.option2_name = option2_name;
//		this.option2_price = option2_price;
//		this.option2_stock = option2_stock;
//	}
	
	
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String one) {
		this.itemCode = one;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDetail() {
		return itemDetail;
	}
	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
//	public int getOption1_no() {
//		return option1_no;
//	}
//	public void setOption1_no(int option1_no) {
//		this.option1_no = option1_no;
//	}
//	public String getOption1_name() {
//		return option1_name;
//	}
//	public void setOption1_name(String option1_name) {
//		this.option1_name = option1_name;
//	}
//	public int getOption1_price() {
//		return option1_price;
//	}
//	public void setOption1_price(int option1_price) {
//		this.option1_price = option1_price;
//	}
//	public int getOption1_stock() {
//		return option1_stock;
//	}
//	public void setOption1_stock(int option1_stock) {
//		this.option1_stock = option1_stock;
//	}
//	public int getOption2_no() {
//		return option2_no;
//	}
//	public void setOption2_no(int option2_no) {
//		this.option2_no = option2_no;
//	}
//	public String getOption2_name() {
//		return option2_name;
//	}
//	public void setOption2_name(String option2_name) {
//		this.option2_name = option2_name;
//	}
//	public int getOption2_price() {
//		return option2_price;
//	}
//	public void setOption2_price(int option2_price) {
//		this.option2_price = option2_price;
//	}
//	public int getOption2_stock() {
//		return option2_stock;
//	}
//	public void setOption2_stock(int option2_stock) {
//		this.option2_stock = option2_stock;
//	} 	
	
}
