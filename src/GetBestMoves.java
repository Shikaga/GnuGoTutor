import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getBestMoves
 */
public class GetBestMoves extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String workspaceLoction = "C:\\Users\\Shikaga7\\workspace\\GnuGoTutor"; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBestMoves() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Runtime r = Runtime.getRuntime();
		//Process p = r.exec("cmd /c dir");
		String execString = "python " + workspaceLoction + "\\GnuGO\\moveExtractor.py";
		System.out.println(execString);
		Process p = r.exec(execString);
//		Process p = r.exec("python C:\\GnuGO\\temp.py");
		p.waitFor();
		BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
		String line=reader.readLine(); 
		while(line!=null) 
		{ 
		System.out.println(line); 
		line=reader.readLine(); 
		} 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		String returnMessage = "{\"Hello\": \"Goodbye\"}";
		System.out.println(returnMessage);
		PrintWriter out = response.getWriter();
	    out.println(returnMessage);
	    out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
