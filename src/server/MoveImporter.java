package server;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MoveImporter {
	
	public static String getMovesAsJSON() throws FileNotFoundException {
		ArrayList<String> fileArray = importFile();
		ArrayList<String> moveGeneration = new ArrayList<String>();
		for (String move: fileArray) {
			if (move.matches(".*Move generation values.*")) { 
				moveGeneration.add(move);
			}
		}
		ArrayList<Move> moves = convertLinesToMoves(moveGeneration);
		String returnJson = convertMovesToJson(moves);
		return returnJson;
	}	
	
	
	
	private static ArrayList<String> importFile() throws FileNotFoundException {
		ArrayList<String> fileArray = new ArrayList<String>();
		try {
			FileReader input = new FileReader(Properties.pythonMovesList);
			BufferedReader bufferedReader = new BufferedReader(input);
			
			String line = bufferedReader.readLine();
			while (line != null) {
				fileArray.add(line);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
			
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IOException thrown in MoveImporter.java");
		}
		return fileArray;		
	}

	public static Move convertLineToMove(String line) {
		String[] lineArray = line.split(" ");
		try {
		return new Move(GnuGoDecoder.convertStringToPosition(lineArray[3]), Double.parseDouble(lineArray[5]));
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
			System.out.println(" LINE : " + line);
			throw e;
		}
		catch (NumberFormatException e) {
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
			System.out.println(" LINE : " + line);
			throw e;
		}
	}



	public static ArrayList<Move> convertLinesToMoves(ArrayList<String> lines) {
		ArrayList<Move> moves = new ArrayList<Move>();
		for (String line: lines) {
			moves.add(convertLineToMove(line));
		}
		return moves;
	}



	public static String convertMovesToJson(ArrayList<Move> moves) {
		String returnJson = "";
		returnJson += "{\"moves\" : [";
		boolean firstMove = true;
		for (Move move : moves) {
			if (!firstMove) {
				returnJson += ",";
			}
			returnJson += move.toJson();
			firstMove = false;
		}
		returnJson += "]}";
		return returnJson;
	}
}
