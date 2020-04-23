package web;

import java.util.ArrayList;

public class Mybuy {
	private ArrayList<String> pid = new ArrayList<String>();
	private ArrayList<String> name = new ArrayList<String>();
	private ArrayList<String> price = new ArrayList<String>();
	private ArrayList<String> color = new ArrayList<String>();
	private ArrayList<String> size = new ArrayList<String>();
	private ArrayList<String> img = new ArrayList<>();
	private ArrayList<String> c = new ArrayList<String>();
	private ArrayList<String> buydate = new ArrayList<String>();
	private ArrayList<String> date = new ArrayList<String>();
	private int count = 0;
	public Mybuy() {
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
		return price.toArray(new String[price.size()]);
	}

	public void setPrice(int i,String price) {
		this.price.add(i,price);
	}

	public String[] getSize() {
		return size.toArray(new String[size.size()]);
	}

	public void setSize(int i,String size) {
		this.size.add(i,size);
	}

	public String[] getImg() {
		return img.toArray(new String[img.size()]);
	}

	public void setImg(int i,String img) {
		this.img.add(i,img);
	}

	public String[] getColor() {
		return color.toArray(new String[color.size()]);
	}

	public void setColor(int i,String color) {
		this.color.add(i,color);
	}
	
	public int getCount() {
		return pid.size();
	}

	public String[] getC() {
		return c.toArray(new String[c.size()]);
	}

	public void setC(int i , String c) {
		this.c.add(i,c);
	}

	public String[] getBuydate() {
		return buydate.toArray(new String[buydate.size()]);
	}

	public void setBuydate(int i , String date) {
		this.buydate.add(i, date);
	}
	public void setDate(int i , String date) {
		this.date.add(i,date);
	}
	public String[] getDate() {
		return date.toArray(new String[date.size()]);
	}
	
}
