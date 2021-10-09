package trinaglePuzzle.model;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import trianglePuzzle.model.Edge;
import trianglePuzzle.model.Node;



class TestTrianglePuzzle extends TestModelType {

	
	@Test
	public void testInitialState( ) {
		assertEquals (0, model.getPuzzle().getScore());
		assertEquals(0,model.getPuzzle().getSelectedNodes().size());
		assertEquals(false,model.getPuzzle().isWin());
		// no moves available.
		assertEquals (0, model.getPuzzle().getMoves());
	}
	@Test
	public void reset() {
		model.getPuzzle().reset();
		assertEquals (0, model.getPuzzle().getScore());
	}
	
	@Test
	public void swap() {
		model.getPuzzle().setPairs(2);
		ArrayList<Edge> e = new ArrayList<Edge>();
		e.add(model.getPuzzle().getEdges().get(0));
		e.add(model.getPuzzle().getEdges().get(1));
		e.add(model.getPuzzle().getEdges().get(2));
		model.getPuzzle().setCommonEdges(e);
		model.getPuzzle().swap();
		model.getPuzzle().setPairs(3);
		model.getPuzzle().swap();
	}
    @Test
    public void generateEdge() {
    	ArrayList<Node> a= model.getPuzzle().getNodes();
    	
    	model.getPuzzle().generateEdges(a.get(0));
    }
    @Test
    public void enableSwapTest() {
    	ArrayList<Node> a= model.getPuzzle().getNodes();
		a.get(0).setSelected(true);
		a.get(1).setSelected(true);
		a.get(2).setSelected(true);
		
		System.out.println(model.getPuzzle().getSelectedNodes().size());
		ArrayList<Node> b = new ArrayList<Node>();
		b.add(a.get(0));
		b.add(a.get(1));
		b.add(a.get(2));
		model.getPuzzle().setSelectedNodes(b);
		System.out.println(model.getPuzzle().getSelectedNodes().size());
    	model.getPuzzle().enableSwap();
    }
    @Test
    public void checkNode() {
    	model.getPuzzle().whetherNodeOrNOT(new Point(3,4));
    }
    @Test
    public void changeStatusTest() {
    	model.getPuzzle().changeStatus(model.getPuzzle().getNodes().get(7));
    }
    
}
