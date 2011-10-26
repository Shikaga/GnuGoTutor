package server;

import java.awt.Point;

public class Move {
	public Point point;
	public Double value;
	
	public Move(Point point) {
		this.point = point;
	}

	public Move(Point point, Double value) {
		this.point = point;
		this.value = value;
	}

	public String toJson() {
		String returnString = "{";
		returnString += "\"x\": \"" + point.x +"\"";
		returnString += ", \"y\": \"" + point.y + "\"";
		if (value != null) {
			returnString += ", \"value\": \"" + value + "\"";
		}
		returnString += "}";
		return returnString;
	}

	public String toSgf() {
		char x = (char)(point.x+97);
		char y = (char)(point.y+97);
		return "[" + x + y + "]";
	}
	
	

}
