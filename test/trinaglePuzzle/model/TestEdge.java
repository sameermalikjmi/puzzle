package trinaglePuzzle.model;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import trianglePuzzle.model.Edge;
import trianglePuzzle.model.Node;
import trianglePuzzle.model.TrianglePuzzle;

class TestEdge {

	@Test
	void testEdge() {
		TrianglePuzzle p = new TrianglePuzzle();
        Node n1 = new Node(155, 34, 0, false);
       Node n2 = new Node(115, 112, 1, false);
        Node n3= (new Node( 200, 112, 2, false));
		Node n4 =(new Node(78, 180, 3, false));
		p.addNode(n1);
		p.addNode(n2);
		p.addNode(n3);
		p.addNode(n4);
		Edge e = new Edge("red",1,p.getNodes().get(0),p.getNodes().get(1));
		assertEquals("red",e.getColor());
		assertEquals(1,e.getId());
		assertEquals(n1,e.getStartingNode());
		assertEquals(n2,e.getEndNode());
		e.setColor("blue");
		assertEquals("blue",e.getColor());
		e.setId(1);
		assertEquals(1,e.getId());
		e.setStartingNode(n1);
		assertEquals(n1,e.getStartingNode());
		e.setEndNode(n2);
		assertEquals(n1,e.getStartingNode());
		Edge e2_copy = e.copy();
		assertEquals(e2_copy.getId(),e.getId());
		assertEquals(1,e.hashCode());
		
		assertFalse (e.equals(null));
		assertFalse (e.equals("somehitn"));
		Edge e2 = new Edge("red",2,p.getNodes().get(2),p.getNodes().get(3));
		Edge e3 = new Edge("red",2,p.getNodes().get(2),p.getNodes().get(3));
		Edge e4 = new Edge("red",1,p.getNodes().get(2),p.getNodes().get(3));
		assertTrue(e.equals(e));
		assertTrue(e.equals(e4));
		assertFalse(e.equals(e3));
		assertEquals(0,e.compareTo(e));
		
		
			}
	
	
	
	

}
