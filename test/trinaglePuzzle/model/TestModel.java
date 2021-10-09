package trinaglePuzzle.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import trianglePuzzle.model.Model;
import trianglePuzzle.model.TrianglePuzzle;

class TestModel {

	@Test
	void test() {
		Model m = new Model();
		TrianglePuzzle p = new TrianglePuzzle();
		m.setPuzzle(p);
		assertEquals(p, m.getPuzzle());
	}

}
