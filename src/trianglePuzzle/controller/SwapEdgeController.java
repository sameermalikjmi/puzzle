package trianglePuzzle.controller;

import trianglePuzzle.boundary.TrianglePuzzleApp;
import trianglePuzzle.model.Model;

public class SwapEdgeController {
    Model m;
    TrianglePuzzleApp app;
	public SwapEdgeController(Model m, TrianglePuzzleApp app ) {
		this.m = m;
		this.app = app;
		
	}
   public void swapEdges(){
		m.getPuzzle().swap();
		 app.getSwapEdgeBtn().setEnabled(false);
		 app.getUnSelectAllNodesBtn().setEnabled(false);
		 app.getPlayerMoves().setText(m.getPuzzle().getMoves()+ "");
		 app.getPlayerScore().setText(m.getPuzzle().getScore()+ "");
	     if( m.getPuzzle().isWin()) {
	    	 app.getWinMsg().setVisible(true);
	     }
	    	 
		app.repaint();
		
	}

}
