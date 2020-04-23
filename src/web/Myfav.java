package web;

import java.util.ArrayList;

public class Myfav {
	private ArrayList<String> pid = new ArrayList<String>();
	private ArrayList<String> name = new ArrayList<String>();
	private ArrayList<String> price = new ArrayList<String>();
	private ArrayList<String> img = new ArrayList<String>();
	private ArrayList<String> date = new ArrayList<String>();
	private int count = 0;
	public Myfav() {
		
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
	public void setName(int i, String name) {
		this.name.add(name);
	}
	public String[] getPrice() {
		return price.toArray(new String[price.size()]);
	}
	public void setPrice(int i ,String price) {
		this.price.add(i,price);
	}
	public String[] getImg() {
		return img.toArray(new String[img.size()]);
	}
	public void setImg(int i,String img) {
		this.img.add(i,img);
	}
	
	public int getCount() {
		return pid.size();
	}
	public String[] getDate() {
		return date.toArray(new String[date.size()]);
	}
	public void setDate(int i, String date) {
		this.date.add(i,date);
	}
}
