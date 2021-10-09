package trianglePuzzle.controller;

import java.awt.Point;

public class SelectNodeControllerTest extends AppTestCase {

@org.junit.jupiter.api.Test
public void Test() {
	SelectUnselectNodeController sc = new SelectUnselectNodeController(model, app);
	
	sc.process(new Point(3,4));
	
	
}

}
