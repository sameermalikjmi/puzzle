package trianglePuzzle.model;

public class Edge implements Comparable<Edge> {
    String color;
    Node startingNode;
    Node endNode;
    int id;
    
	public Edge(String color,int id, Node startingNode, Node endNode) {
	this.color= color;
	this.startingNode = startingNode;
	this.endNode= endNode;	
	this.id = id;
	}
    public Edge copy() {
    	Edge e = new Edge(this.color,this.id,this.startingNode,this.endNode);
    	
    	return e;
    }
    
    @Override 
    public int compareTo(Edge compareEdge)
    {
        int compareid
            = ((Edge)compareEdge).getId();
  
        //  For Ascending order
        return   compareid-this.id;
  
        // For Descending order do like this
        // return compareage-this.studentage;
    }
	@Override
    public boolean equals(Object obj) {
		if (obj == this) { return true; } 
		if (obj == null || obj.getClass() != this.getClass()) { return false; }

	
        if (obj instanceof Edge) {
            return ((Edge) obj).id == id;
        }
        return false;
 }      
 
 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

@Override
    public int hashCode() {
        return this.id;
    }
	public String getColor() {
		return color;
	}
	



	public void setColor(String color) {
		this.color = color;
	}



	public Node getStartingNode() {
		return startingNode;
	}



	public void setStartingNode(Node startingNode) {
		this.startingNode = startingNode;
	}



	public Node getEndNode() {
		return endNode;
	}



	public void setEndNode(Node endNode) {
		this.endNode = endNode;
	}

}
