package lee.hg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class InsertSave
 */
@WebServlet("/insert/save")
public class InsertSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 넘어온 파라미터값을 받는 코드
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writerName = request.getParameter("writerName");
		
		// 객체에 정보를 집어넣는 코드
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setWriterName(writerName);
		
		// JSONObject 와 JSONArray 에 저장한다.
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject item = new JSONObject(board.toString());
		array.put(item);
		json.put("list", array);
		
		// 파일에 정보를 저장하는 코드
		FileControl fileControl=new FileControl();
		fileControl.writeFile(Board.FILENAME, json.toString());
		
		// 파일저장이 정상적으로 완료되었음을 알려주는 코드
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("작성이 완료되었습니다.");
	}

}
