package trianglePuzzle.controller;

import trianglePuzzle.boundary.TrianglePuzzleApp;
import trianglePuzzle.model.Model;
import trianglePuzzle.model.TrianglePuzzle;


public class ResetController {
    Model model;
    TrianglePuzzleApp app;
	public ResetController(Model m , TrianglePuzzleApp app) {
		// TODO Auto-generated constructor stub
		this.model = m;
		this.app = app;
	}
	public void reset(){
		 
		 app.getWinMsg().setVisible(false);
		 TrianglePuzzle p =model.getPuzzle();
		 app.getUnSelectAllNodesBtn().setEnabled(false);
		 
		 p.reset(); 
		 
		 app.getSwapEdgeBtn().setEnabled(false);
		 app. getPlayerScore().setText(p.getScore()+""); 
		 app.getPlayerMoves().setText(p.getMoves()+""); 
		 app.repaint();
				
	}

}
