package trianglePuzzle.controller;

import org.junit.jupiter.api.Test;

public class UnselectAllNodeTest extends AppTestCase {

@Test
public void test() {
	UnselectAllNodesController us = new UnselectAllNodesController(model, app);
	us.unselectAll();
}

}
