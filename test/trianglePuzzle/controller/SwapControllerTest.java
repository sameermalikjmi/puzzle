package trianglePuzzle.controller;

import org.junit.jupiter.api.Test;

public class SwapControllerTest extends AppTestCase {
@Test

public void test() {
	SwapEdgeController se = new SwapEdgeController(model, app);
	se.swapEdges();
}
}
