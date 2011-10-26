package server;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

public class TestSGFWriter {

	@Test
	public void test() {
		String sgf = "(;GM[1]FF[4]AP[glGo:1.4]ST[1]" +
		"" +
		"SZ[19]KM[6.5]" +
		"PW[GNU Go]PB[Black]DT[2011-09-30]" +
		";B[aa])";
		ArrayList<Move> moves = new ArrayList<Move>();
		moves.add(new Move(new Point(0,0)));
		assertEquals(sgf, SGFWriter.convertToSGF(moves));
	}
	
	@Test
	public void test2() {
		String sgf = "(;GM[1]FF[4]AP[glGo:1.4]ST[1]" +
				"" +
				"SZ[19]KM[6.5]" +
				"PW[GNU Go]PB[Black]DT[2011-09-30]" +
				";B[bb])";
		ArrayList<Move> moves = new ArrayList<Move>();
		moves.add(new Move(new Point(1,1)));
		assertEquals(sgf, SGFWriter.convertToSGF(moves));
	}
	
	@Test
	public void test3() {
		String sgf = "(;GM[1]FF[4]AP[glGo:1.4]ST[1]" +
				"" +
				"SZ[19]KM[6.5]" +
				"PW[GNU Go]PB[Black]DT[2011-09-30]" +
				";B[aa]" + 
				";W[bb])";
		ArrayList<Move> moves = new ArrayList<Move>();
		moves.add(new Move(new Point(0,0)));
		moves.add(new Move(new Point(1,1)));
		assertEquals(sgf, SGFWriter.convertToSGF(moves));
	}

}
