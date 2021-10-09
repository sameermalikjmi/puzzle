package trianglePuzzle.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ResetControllerTest extends AppTestCase {
@Test

public void testReset() {
	ResetController rc= new ResetController(model, app);
	
	rc.reset();
	assertEquals(0, model.getPuzzle().getScore());
	assertEquals(0,model.getPuzzle().getMoves());
	
}
}
