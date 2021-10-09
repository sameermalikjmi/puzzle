package trianglePuzzle.controller;

import trianglePuzzle.boundary.TrianglePuzzleApp;
import trianglePuzzle.model.Model;

public class UnselectAllNodesController {
     Model model;
     TrianglePuzzleApp app;
	public UnselectAllNodesController(Model model, TrianglePuzzleApp app) {
		// TODO Auto-generated constructor stub
		this.model =model;
		this.app =app;
	}
	public void unselectAll(){
		
		 model.getPuzzle().unselectAll();
	     app.getUnSelectAllNodesBtn().setEnabled(false);
		 app.getSwapEdgeBtn().setEnabled(false);
         app.repaint();
	}

}
