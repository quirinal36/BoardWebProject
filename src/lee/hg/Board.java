package lee.hg;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.json.JSONException;
import org.json.JSONObject;

public class Board {
	public static final String FILENAME = "board.txt";
	
	private int id;
	private String title;
	private String content;
	private String wdate;
	private String writerName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
	
	public static Board parse(JSONObject item) {
		Board board = new Board();
		if(item.has("title")) {
			try {
				board.setTitle(item.getString("title"));
			}catch(JSONException e) {
				
			}
		}
		if(item.has("content")) {
			try {
				board.setContent(item.getString("content"));
			}catch(JSONException e) {
				
			}
		}
		if(item.has("wdate")) {
			try {
				board.setWdate(item.getString("wdate"));
			}catch(JSONException e) {
				
			}
		}
		if(item.has("writerName")) {
			try {
				board.setWriterName(item.getString("writerName"));
			}catch(JSONException e) {
				
			}
		}
		return board;
	}
}
