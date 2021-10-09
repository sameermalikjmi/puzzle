package trinaglePuzzle.model;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

import trianglePuzzle.model.Edge;
import trianglePuzzle.model.Model;
import trianglePuzzle.model.Node;
import trianglePuzzle.model.TrianglePuzzle;

public abstract class TestModelType {
    protected Model model;
    
	@BeforeEach
	public void setUp() {
		model = new Model();
		TrianglePuzzle p = new TrianglePuzzle();
		p.addNode(new Node(155, 34, 0, false));
		p.addNode(new Node(115, 112, 1, false));
		p.addNode(new Node( 200, 112, 2, false));
		p.addNode(new Node(78, 180, 3, false));
		p.addNode(new Node(162, 180, 4, false));
		p.addNode(new Node(250, 180, 5, false));
     	
    	p.addNode(new Node(40,  240, 6, false));
    	p.addNode(new Node(115, 240, 7, false));
		p.addNode(new Node(200, 240, 8, false));
		p.addNode(new Node(290, 240, 9, false));
		
		p.addEdge(new Edge("red",1,p.getNodes().get(0),p.getNodes().get(1)));
		p.addEdge(new Edge("green",2,p.getNodes().get(1),p.getNodes().get(2)));
		p.addEdge(new Edge("red",3,p.getNodes().get(0),p.getNodes().get(2)));
		
		p.addEdge(new Edge("red",4,p.getNodes().get(1),p.getNodes().get(3)));
		p.addEdge(new Edge("green",5,p.getNodes().get(3),p.getNodes().get(4)));
		p.addEdge(new Edge("blue",6,p.getNodes().get(1),p.getNodes().get(4)));
		
		p.addEdge(new Edge("blue",7,p.getNodes().get(2),p.getNodes().get(4)));
		p.addEdge(new Edge("green",8,p.getNodes().get(4),p.getNodes().get(5)));
		p.addEdge(new Edge("red",9,p.getNodes().get(2),p.getNodes().get(5)));
		
		p.addEdge(new Edge("red",10,p.getNodes().get(3),p.getNodes().get(6)));
		p.addEdge(new Edge("green",11,p.getNodes().get(6),p.getNodes().get(7)));
		p.addEdge(new Edge("blue",12,p.getNodes().get(3),p.getNodes().get(7)));
		
		p.addEdge(new Edge("blue",13,p.getNodes().get(7),p.getNodes().get(4)));
		p.addEdge(new Edge("green",14,p.getNodes().get(7),p.getNodes().get(8)));
		p.addEdge(new Edge("blue",15,p.getNodes().get(4),p.getNodes().get(8)));
		
		p.addEdge(new Edge("blue",16,p.getNodes().get(5),p.getNodes().get(8)));
		p.addEdge(new Edge("green",17,p.getNodes().get(8),p.getNodes().get(9)));
		p.addEdge(new Edge("red",18,p.getNodes().get(5),p.getNodes().get(9)));
		
		p.setTriangle(p.getEdges());
		
		model.setPuzzle(p);
	
		
		
	}

}
