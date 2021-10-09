package trinaglePuzzle.model;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;


import trianglePuzzle.model.Node;

class TestNode {

	@Test
	void testConstruction() {
		
		Node n = new Node(155,34,0,false);
		assertEquals (155, n.getX());
		assertEquals (34, n.getY());
		assertEquals (0, n.getId());
		assertFalse ( n.isSelected());
			}
	
	@Test
	void testContain() {
		Node n = new Node(155,34,0,false);
		assertEquals(true, n.contains(new Point(155,34)));
		assertEquals(false, n.contains(new Point(0,0)));
	}
	
	@Test
	void testContains() {
		Node n = new Node(155,34,0,false);
		
		
		n.setId(0);
		assertEquals(0,n.getId());
		n.setX(2);
		assertEquals (2, n.getX());
		n.setY(1);
		n.setSelected(false);
		assertEquals (1, n.getY());
		assertEquals(false,n.isSelected());
	}

}
