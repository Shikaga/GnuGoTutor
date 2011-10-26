package server;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class TestMove {

	@Test
	public void testGetJson() {
		Move move = new Move(new Point(0,0));
		String json = move.toJson();
		assertEquals("{\"x\": \"0\", \"y\": \"0\"}", json);
	}

	@Test
	public void testGetJson2() {
		Move move = new Move(new Point(1,1));
		String json = move.toJson();
		assertEquals("{\"x\": \"1\", \"y\": \"1\"}", json);
	}
	
	@Test
	public void testJsonWithValue() throws Exception {
		Move move = new Move(new Point(1,1), 10.1);
		String json = move.toJson();
		assertEquals("{\"x\": \"1\", \"y\": \"1\", \"value\": \"10.1\"}", json);	
	}
	
	@Test
	public void testJsonWithValue2() throws Exception {
		Move move = new Move(new Point(1,1), 10.0);
		String json = move.toJson();
		assertEquals("{\"x\": \"1\", \"y\": \"1\", \"value\": \"10.0\"}", json);	
	}
	
	@Test
	public void testSgf() throws Exception {
		Move move = new Move(new Point(0,0));
		
		assertEquals("[aa]",move.toSgf());
	}

	@Test
	public void testSgf2() throws Exception {
		Move move = new Move(new Point(1,1));	
		assertEquals("[bb]",move.toSgf());
	}

	@Test
	public void testSgf3() throws Exception {
		Move move = new Move(new Point(18,18));	
		assertEquals("[ss]",move.toSgf());
	}

}
