package trianglePuzzle.model;

public class Triangle {
    Edge left;
    Edge right;
    Edge bottom;
	public Triangle(Edge l, Edge b, Edge r) {
		this.left=l;
		this.right =r;
		this.bottom = b;	
	}
	public Edge getLeft() {
		return left;
	}
	public void setLeft(Edge left) {
		this.left = left;
	}
	public Edge getRight() {
		return right;
	}
	public void setRight(Edge right) {
		this.right = right;
	}
	public Edge getBottom() {
		return bottom;
	}
	public void setBottom(Edge bottom) {
		this.bottom = bottom;
	}

}
