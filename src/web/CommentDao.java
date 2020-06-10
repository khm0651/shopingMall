package web;

import java.util.ArrayList;

public class CommentDao {
	
	private ArrayList<String> id = new ArrayList<String>();
	private ArrayList<String> title = new ArrayList<String>();
	private ArrayList<String> content = new ArrayList<String>();
	private ArrayList<String> date = new ArrayList<String>();
	public CommentDao() {
		// TODO Auto-generated constructor stub
	}
	public String [] getId() {
		return id.toArray(new String [id.size()]);
	}
	public void setId(int i, String s) {
		id.add(i, s);
	}
	public String [] getTitle() {
		return title.toArray(new String [title.size()]);
	}
	public void setTitle(int i, String s) {
		title.add(i, s);
	}
	public String [] getContent() {
		return content.toArray(new String [content.size()]);
	}
	public void setContent(int i, String s) {
		content.add(i, s);
	}
	public String [] getDate() {
		return date.toArray(new String [date.size()]);
	}
	public void setDate(int i, String s) {
		date.add(i, s);
	}
	public int getListSize() {
		return id.size();
	}

}
