import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.GnuGoDecoder;
import server.Move;
import server.MoveImporter;
import server.Properties;
import server.SGFWriter;


/**
 * Servlet implementation class getBestMoves
 */
public class GetBestMoves extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
       
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
		String requestString = request.getQueryString().replaceAll("%2C", ",");
		if (requestString != "") {
			System.out.println(requestString.substring(6));
			String[] pointsString = requestString.substring(6).split("\\+");
			System.out.println("XXX");
			ArrayList<Move> moves = new ArrayList<Move>();
			for (String point : pointsString) {
				System.out.println(point);
				String[] points = point.split(",");
				Move move = new Move(new Point(Integer.parseInt(points[0]),Integer.parseInt(points[1])));
				moves.add(move);
			}
			GnuGoDecoder.writeSgf(moves);
		}
		
		try {
		Runtime r = Runtime.getRuntime();
		String execString = "python " + Properties.pythonMoveExtractor;
		System.out.println(execString);
		Process p = r.exec(execString);
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
		
		String returnMessage = MoveImporter.getMovesAsJSON();
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
