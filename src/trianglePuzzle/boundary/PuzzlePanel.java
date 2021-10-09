package trianglePuzzle.boundary;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.JPanel;



import trianglePuzzle.model.Edge;
import trianglePuzzle.model.Model;
import trianglePuzzle.model.Node;

public class PuzzlePanel extends JPanel {
    Model model;
	
	public PuzzlePanel(Model model) {
      this.model=model;	
	}

	
	
	@Override
 public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (model==null) {
			return;
		}
		
		//initates projects here
	ArrayList<Edge>	e = model.getPuzzle().getEdges();
	for(Edge edge:e) {
		Color color;
		try {
		    Field field = Class.forName("java.awt.Color").getField(edge.getColor());
		    color = (Color)field.get(null);
		} catch (Exception ex) {
		    color = null; // Not defined
		}
		g.setColor(color);
		g.drawLine(edge.getStartingNode().getX()+15/2  , edge.getStartingNode().getY()+15/2,edge.getEndNode().getX()+15/2  , edge.getEndNode().getY()+15/2 );
		
	}
	ArrayList<Node> n = model.getPuzzle().getNodes();
	ArrayList<Node> selectedNode = model.getPuzzle().getSelectedNodes();
	for(Node node : n) {
		if(node.isSelected()) { 
			g.setColor(Color.black);
			g.fillRect(node.getX(), node.getY(), 15, 15);
		}  
		else {
			g.setColor(Color.black);
			g.drawRect(node.getX(), node.getY(), 15, 15);
		} 
			
		
		
			
		
	}
	
	}
}
