package lee.hg;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BoardControl {

	public Board getBoard(String input, int id) {
		Board user = null;
		
		JSONObject json = new JSONObject(input);
		JSONArray array = json.getJSONArray("list");
		int i = 0;
		while(user == null) {
			if(id == i) {
				JSONObject item = array.getJSONObject(i);
				user = Board.parse(item);
			}
			i++;
		}
		user.setId(id);
		return user;
	}
	
	public List<Board> getBoardsFromString(String input)
		throws JSONException{
		List<Board> result = new ArrayList<Board>();
		
		JSONObject obj = new JSONObject(input);
		JSONArray array = obj.getJSONArray("list");
		for(int i=0; i<array.length(); i++) {
			Board user = new Board();
			JSONObject item = array.getJSONObject(i);
			user = Board.parse(item);
			result.add(user);
		}
		return result;
	}
}
