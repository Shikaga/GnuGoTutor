package server;

import java.util.ArrayList;

public class SGFWriter {

	public static String convertToSGF(ArrayList<Move> moves) {
		String sgf = "(;GM[1]FF[4]AP[glGo:1.4]ST[1]" +
				"" +
				"SZ[19]KM[6.5]" +
				"PW[GNU Go]PB[Black]DT[2011-09-30]";
				boolean isBlack = true;
				for (Move move : moves) {
					if (isBlack) {
						sgf += ";B";
					} else { 
						sgf += ";W";
					}
					sgf += move.toSgf(); 
					isBlack = !isBlack;
				}
				sgf += ")";
		return sgf;
	}
	
	

}
