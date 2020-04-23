package web;

import java.util.ArrayList;
import java.util.HashMap;

public class Pinfo {
	
	private ArrayList<String> pid = new ArrayList<String>();
	private ArrayList<String> name = new ArrayList<String>();
	private ArrayList<String> price = new ArrayList<String>();
	private ArrayList<Integer> stock = new ArrayList<Integer>();
	private ArrayList<String> color = new ArrayList<String>();
	private ArrayList<String> size = new ArrayList<String>();
	private ArrayList<String> type = new ArrayList<String>();
	private ArrayList<String> img = new ArrayList<>();
	private ArrayList<Integer> favorite = new ArrayList<Integer>();
	private ArrayList<Integer> comment = new ArrayList<Integer>();
	
	public Pinfo() {
		// TODO Auto-generated constructor stub
	}

	public String[] getPid() {
		return pid.toArray(new String[pid.size()]);
	}

	public void setPid(int i,String pid) {
		this.pid.add(i,pid);
	}

	public String[] getName() {
		return name.toArray(new String[name.size()]);
	}

	public void setName(int i,String name) {
		this.name.add(i,name);
	}

	public String[] getPrice() {
		return price.toArray(new String[name.size()]);
	}

	public void setPrice(int i,String price) {
		this.price.add(i,price);
	}

	public String[] getStock() {
		return stock.toArray(new String[stock.size()]);
	}

	public void setStock(int i,Integer stock) {
		this.stock.add(i,stock);
	}

	public String[] getColor() {
		return color.toArray(new String[color.size()]);
	}

	public void setColor(int i,String color) {
		this.color.add(i,color);
	}

	public String[] getSize() {
		return size.toArray(new String[size.size()]);
	}

	public void setSize(int i,String size) {
		this.size.add(i,size);
	}

	public String[] getType() {
		return type.toArray(new String[type.size()]);
	}

	public void setType(int i,String type) {
		this.type.add(i,type);
	}

	public String[] getImg() {
		return img.toArray(new String[img.size()]);
	}

	public void setImg(int i,String img) {
		this.img.add(i,img);
	}

	public Integer[] getFavorite() {
		return favorite.toArray(new Integer[favorite.size()]);
	}

	public void setFavorite(int i,Integer favorite) {
		this.favorite.add(i,favorite);
	}

	public Integer[] getComment() {
		return comment.toArray(new Integer[comment.size()]);
	}

	public void setComment(int i,Integer comment) {
		this.comment.add(i,comment);
	}
	public int getListSize() {
		return pid.size();
	}

}
