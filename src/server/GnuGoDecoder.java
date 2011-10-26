package server;

import java.awt.Point;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GnuGoDecoder {

	public static int convertLetterToNumber(String string) {
		char character = string.charAt(0);
		int value = (int)character - 65;
		if (value > 8) value--;
		return value;
	}

	public static Point convertStringToPosition(String string) {
		String xString = string.substring(1,2);
		String yString = string.substring(0,1);
		return new Point(convertLetterToNumber(yString),Integer.valueOf(xString)-1);
	}
	
	public static void writeSgf(ArrayList<Move> moves) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(Properties.pythonSgf));
			out.write(SGFWriter.convertToSGF(moves));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
