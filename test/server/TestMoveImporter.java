package server;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

public class TestMoveImporter {

	@Test
	public void testLineToMove() {
		Move move = MoveImporter.convertLineToMove("Move generation values Q4 to 74.00");
		assertEquals(new Point(15,3), move.point);
	}
	
	@Test
	public void testLineToMove2() {
		Move move = MoveImporter.convertLineToMove("Move generation values A1 to 74.00");
		assertEquals(new Point(0,0), move.point);
	}
	
	@Test
	public void testLineToValue() {
		Move move = MoveImporter.convertLineToMove("Move generation values A1 to 74.00");
		assertEquals("", move.value, 74.0, 0.001);
	}
	
	@Test
	public void testLineToValue2() {
		Move move = MoveImporter.convertLineToMove("Move generation values A1 to 0.00");
		assertEquals("", move.value, 0.0, 0.001);
	}
	
	@Test
	public void testGetMoves() {
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("Move generation values Q4 to 74.00");
		lines.add("Move generation values Q5 to 74.00");
		ArrayList<Move> moves= MoveImporter.convertLinesToMoves(lines);
		assertEquals(2, moves.size());
		assertEquals(new Point(15,3), moves.get(0).point);
		assertEquals(new Point(15,4), moves.get(1).point);
	}
	
	@Test
	public void testConvertMovesToJson() throws Exception {
		ArrayList<Move> moves = new ArrayList<Move>();
		moves.add(new Move(new Point(1,1),10.0));
		assertEquals("{\"moves\" : [{\"x\": \"1\", \"y\": \"1\", \"value\": \"10.0\"}]}", MoveImporter.convertMovesToJson(moves));
	}
	
	@Test
	public void testConvertMovesToJson2() throws Exception {
		ArrayList<Move> moves = new ArrayList<Move>();
		moves.add(new Move(new Point(2,2),20.0));
		assertEquals("{\"moves\" : [{\"x\": \"2\", \"y\": \"2\", \"value\": \"20.0\"}]}", MoveImporter.convertMovesToJson(moves));
	}
	
	@Test
	public void testConvertMovesToJson3() throws Exception {
		ArrayList<Move> moves = new ArrayList<Move>();
		moves.add(new Move(new Point(1,1),10.0));
		moves.add(new Move(new Point(2,2),20.0));
		assertEquals("{\"moves\" : [{\"x\": \"1\", \"y\": \"1\", \"value\": \"10.0\"},{\"x\": \"2\", \"y\": \"2\", \"value\": \"20.0\"}]}", MoveImporter.convertMovesToJson(moves));
	}
}
