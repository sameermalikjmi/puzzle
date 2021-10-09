package trianglePuzzle.controller;

import java.awt.Point;

import trianglePuzzle.boundary.TrianglePuzzleApp;
import trianglePuzzle.model.Model;
import trianglePuzzle.model.Node;
import trianglePuzzle.model.TrianglePuzzle;

public class SelectUnselectNodeController {
    Model model;
    TrianglePuzzleApp app;
	public SelectUnselectNodeController(Model m, TrianglePuzzleApp app) {
		this.model= m;
		this.app = app;
	}
  public void process(Point p) {
	  
	  TrianglePuzzle puzzle = model.getPuzzle();
	  if(!puzzle.isWin()) {
	  puzzle.whetherNodeOrNOT(p);
	  if(puzzle.getSelectedNodes().size()>0)
		  app.getUnSelectAllNodesBtn().setEnabled(true);
	  else
		  app.getUnSelectAllNodesBtn().setEnabled(false);
	  boolean swapEnabled = puzzle.enableSwap();
	  	
	  app.getSwapEdgeBtn().setEnabled(swapEnabled);
      
	  
	  app.repaint();}
		  
	  //do some process to check whether it lies on node or not if yes check whether that node is selected or not if selected then unselect
	  //alter state and update selected nodes list.
	  // repaint app.
	  
  }
}
