package model;
import java.sql.*;
public class News {
	private int id;
	private String title,description,content,image;
	public News() {
		// TODO Auto-generated constructor stub
	}
	public News(String title,String decription,String content,String image, int id) {
		super();
		this.id = id;
		this.title = title;
		this.content= content;
		this.description = decription;
		this.image = image;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
}
