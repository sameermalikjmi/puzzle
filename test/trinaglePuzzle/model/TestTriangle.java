package trinaglePuzzle.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import trianglePuzzle.model.Edge;
import trianglePuzzle.model.Node;
import trianglePuzzle.model.Triangle;
import trianglePuzzle.model.TrianglePuzzle;

class TestTriangle {

	@Test
	void test() {
		TrianglePuzzle p = new TrianglePuzzle();
        Node n1 = new Node(155, 34, 0, false);
       Node n2 = new Node(115, 112, 1, false);
        Node n3= (new Node( 200, 112, 2, false));
		Node n4 =(new Node(78, 180, 3, false));
		p.addNode(n1);
		p.addNode(n2);
		p.addNode(n3);
		
		Edge e1 = new Edge("red",1,p.getNodes().get(0),p.getNodes().get(1));
	    Edge e2 = (new Edge("green",2,p.getNodes().get(1),p.getNodes().get(2)));
		Edge e3 =(new Edge("red",3,p.getNodes().get(0),p.getNodes().get(2)));
		
		Triangle t1 = new Triangle(e1,e2,e3);
		t1.setLeft(e1);
		t1.setBottom(e2);
		t1.setRight(e3);
		assertEquals(e1,t1.getLeft());
		assertEquals(e2, t1.getBottom());
		assertEquals(e3,t1.getRight());
		

	}

}
