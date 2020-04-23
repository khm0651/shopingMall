package web;

import java.util.ArrayList;

public class View {
	
	private String pid = null;
	private String name =null;
	private String price = null;
	private String img = null;
	private ArrayList<String> color = new ArrayList<String>();
	private String type = null;
	private ArrayList<String> size = new ArrayList<String>();
	private int commnet =0;
	private int stock = 0;
	private int favorite = 0;
	public View() {
		// TODO Auto-generated constructor stub
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String[] getColor() {
		return color.toArray(new String[color.size()]);
	}
	public void setColor(int i,String color) {
		this.color.add(i,color);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String[] getSize() {
		return size.toArray(new String[size.size()]);
	}
	public void setSize(int i ,String size) {
		this.size.add(i,size);
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getFavorite() {
		return favorite;
	}
	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}
	public int getComment() {
		return favorite;
	}
	public void setComment(int favorite) {
		this.favorite = favorite;
	}
	public int getSizeCount() {
		return size.size();
	}
	public int getColorCount() {
		return color.size();
	}
}
