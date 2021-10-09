package trianglePuzzle.controller;

import org.junit.jupiter.api.BeforeEach;


import trianglePuzzle.boundary.TrianglePuzzleApp;
import trinaglePuzzle.model.TestModelType;

public abstract class AppTestCase extends TestModelType {

	
	protected TrianglePuzzleApp app;
@BeforeEach
public void createApp() {
	app = new TrianglePuzzleApp(model);
	app.setVisible(true);
}

}
