package server;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

import server.GnuGoDecoder;


public class TestGnuGoDecoder {
	
	@Test
	public void testLetterAIs0() throws Exception {
		int number = GnuGoDecoder.convertLetterToNumber("A");
		assertEquals(0, number);
	}
	
	@Test
	public void testLetterBIs1() throws Exception {
		int number = GnuGoDecoder.convertLetterToNumber("B");
		assertEquals(1, number);
	}
	
	@Test
	public void testLetterHIs7() throws Exception {
		int number = GnuGoDecoder.convertLetterToNumber("H");
		assertEquals(7, number);
	}
	
	@Test
	public void testLetterJIs8() throws Exception {
		int number = GnuGoDecoder.convertLetterToNumber("J");
		assertEquals(8, number);
	}

	@Test
	public void testLetterQIs16() throws Exception {
		int number = GnuGoDecoder.convertLetterToNumber("Q");
		assertEquals(15, number);
	}
	
	@Test
	public void testA1Is00() throws Exception {
		Point point = GnuGoDecoder.convertStringToPosition("A1");
		assertEquals(new Point(0,0), point);
	}
	
	@Test
	public void testA2Is01() throws Exception {
		Point point = GnuGoDecoder.convertStringToPosition("A2");
		assertEquals(new Point(0,1), point);
	}
	
	@Test
	public void testB1Is10() throws Exception {
		Point point = GnuGoDecoder.convertStringToPosition("B1");
		assertEquals(new Point(1,0), point);
	}
	
	@Test
	public void testQ16Is1515() throws Exception {
		Point point = GnuGoDecoder.convertStringToPosition("Q16");
		assertEquals(new Point(15,15), point);
	}
	
	@Test
	public void testWriteSgf() throws Exception {
		ArrayList<Move> moves = new ArrayList<Move>();
		moves.add(new Move(new Point(0,0)));
		GnuGoDecoder.writeSgf(moves);
	}

}
