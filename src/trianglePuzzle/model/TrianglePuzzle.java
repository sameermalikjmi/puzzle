package trianglePuzzle.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;





public class TrianglePuzzle {
    Node node;
    Edge edge;
    int pairs;
    public void setPairs(int pairs) {
		this.pairs = pairs;
	}

	int moves;
    int score;
    boolean win;
    ArrayList<Edge> commonEdges = new ArrayList<Edge>();
    public ArrayList<Edge> getCommonEdges() {
		return commonEdges;
	}

	public void setCommonEdges(ArrayList<Edge> commonEdges) {
		this.commonEdges = commonEdges;
	}

	ArrayList<Triangle> allTriangles = new ArrayList<Triangle>();
    
    
	public ArrayList<Node> getNodes() {
		return Nodes;
	}
	
	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ArrayList<Edge> getEdges() {
		return Edges;
	}
	public void setTriangle(ArrayList<Edge> e){
		Triangle t1 = new Triangle(e.get(0),e.get(1),e.get(2));
		Triangle t2 = new Triangle(e.get(3),e.get(4),e.get(5));
		Triangle t3 = new Triangle(e.get(6),e.get(7),e.get(8));
		Triangle t4 = new Triangle(e.get(9),e.get(10),e.get(11));
		Triangle t5 = new Triangle(e.get(12),e.get(13),e.get(14));
	    Triangle t6 = new Triangle(e.get(15),e.get(16),e.get(17));
	    allTriangles.add(t1);
	    
	    allTriangles.add(t2);
	    allTriangles.add(t3);
	    allTriangles.add(t4);
	    allTriangles.add(t5);
	    allTriangles.add(t6);
	    
	}
	public ArrayList<Triangle> getAllTriangles() {
		return allTriangles;
	}

	public void setAllTriangles(ArrayList<Triangle> allTriangles) {
		this.allTriangles = allTriangles;
	}

	public ArrayList<Edge> getOriginalEdges() {
		return OriginalEdges;
	}
	
	ArrayList<Node> Nodes = new ArrayList<Node>();
	ArrayList<Edge> Edges = new ArrayList<Edge>();
	ArrayList<Node> SelectedNodes = new ArrayList<Node>();
	ArrayList<Edge> OriginalEdges = new ArrayList<Edge>();
	public TrianglePuzzle() {
		// TODO Auto-generated constructor stub
		
			
	}
	public void addNode(Node n) {
		Nodes.add(n);
	}
	public void addEdge(Edge e) {
		Edges.add(e);
		OriginalEdges.add(e.copy());
	}
	public void unselectAll(){
		SelectedNodes.clear();
		for (Node n: Nodes) {
			if(n.isSelected())
				n.setSelected(false);
		}
	}
	
	public void reset() {
		unselectAll();
		buildEdges();
		SelectedNodes.clear();
		moves=0;
		score=0;
		allTriangles.clear();
		this.setTriangle(this.getEdges());
        setWin(false);		
		
	}
	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public void buildEdges() {
		Edges.clear();
		
		for(Edge edge: OriginalEdges ) {
			
			Edges.add(edge.copy());
		}
	//   Collections.copy(Edges,OriginalEdges);
	 
	}
	public ArrayList<Edge> generateEdges(Node n) {
		ArrayList <Edge> ownEdges = new ArrayList<Edge>();
		ArrayList <Edge> allEdges  = this.getEdges();
		
	  for(Edge e: allEdges) {
		  
		  if(e.startingNode.getId()==n.getId() || e.endNode.getId()==n.getId())
			  ownEdges.add(e);
	}
	  java.util.List<Edge> uniqueEdges = ownEdges.stream()
              .distinct()               // it will remove duplicate object, It will check duplicate using equals method
              .collect(Collectors.toList());
	  ArrayList<Edge> tmp = new ArrayList<Edge>(uniqueEdges);
	  return tmp;
	}
	public boolean enableSwap(){
		
		
	if(SelectedNodes.size()==3) {
      	ArrayList<Edge>e0,e1,e2;
            		
    	e0= generateEdges((SelectedNodes.get(0)));
    		
    		
		e1= generateEdges(SelectedNodes.get(1));
  		e2= generateEdges(SelectedNodes.get(2));
//		
      ArrayList<Edge> common = new ArrayList<Edge>();
   	  common.addAll(e0);
      common.addAll(e1);
	  common.addAll(e2);
//		  
//		  
		  boolean flag = checkCommon(common);
		  return flag;
	
//		
	}
    		
	
		return false;
		
	}
	
	public boolean checkCommon(ArrayList<Edge> common){
		pairs=0;
		
		commonEdges.clear();
        java.util.Set<Edge> uniqueSet = new HashSet<Edge>(common);
        for (Edge temp : uniqueSet) {
        // System.out.println(temp + ": " + Collections.frequency(common, temp));
         if(Collections.frequency(common, temp)==2|| Collections.frequency(common, temp)>2)
         { 
           commonEdges.add(temp);
           int t=Collections.frequency(common, temp)/2;
            pairs=pairs+t;
         }


     }
	     if(pairs>=2) {
	    	
	    	 return true;
	     }
	     return false; 
	}
	public int completeTriangles(ArrayList<Triangle> triangles) {
		int i =0;
		for(Triangle t : triangles) {
			if(t.getLeft().getColor().equals(t.getRight().getColor())&& t.getLeft().getColor().equals(t.getBottom().getColor())){
				i=i+1;
			}
		}
		return i;
	}
	public void swap() {
		moves = moves+1;
		score = score -1;
		if(pairs==2) {
			int initialTriangles= completeTriangles(allTriangles);
			String c1= commonEdges.get(0).getColor();
			String c2 = commonEdges.get(1).getColor();
			for(Edge edge: Edges) {
				if(edge.getId()==commonEdges.get(0).getId()) {
					edge.setColor(c2);
				}
				if(edge.getId()==commonEdges.get(1).getId()) {
					edge.setColor(c1);
				}
						
			}
			int finalTriangles = completeTriangles(allTriangles);
			
			if(initialTriangles>finalTriangles)
				score = score-10*(initialTriangles-finalTriangles);
			if(initialTriangles<finalTriangles)
				score =score +10*(finalTriangles-initialTriangles);
		}
		if(pairs>=3) {
			
			int initialTriangles= completeTriangles(allTriangles);
			Collections.sort(commonEdges);
			
			
			String c1_max = commonEdges.get(0).getColor();
			String c2_middle = commonEdges.get(1).getColor();
			String c3_min = commonEdges.get(2).getColor();
			
			for(Edge edge: Edges) {
				if(edge.getId()==commonEdges.get(2).getId())
						edge.setColor(c1_max);
				if(edge.getId()==commonEdges.get(1).getId())
					edge.setColor(c3_min);
				if(edge.getId()==commonEdges.get(0).getId())
					edge.setColor(c2_middle);
				
			}
			int finalTriangles = completeTriangles(allTriangles);
			
			if(initialTriangles>finalTriangles)
				score = score-10*(initialTriangles-finalTriangles);
			if(initialTriangles<finalTriangles)
				score =score +10*(finalTriangles-initialTriangles);
				
		}
		
		
		hasWon();
		unselectAll();
		
		
		
	}
	public ArrayList<Node> getSelectedNodes() {
		return SelectedNodes;
	}

	public void setSelectedNodes(ArrayList<Node> selectedNodes) {
		SelectedNodes = selectedNodes;
	}
    public boolean allEdgeSameColor(Triangle t,String color) {
    	if(t.getLeft().getColor().equals(color) && t.getLeft().getColor().equals(t.getRight().getColor())&& t.getLeft().getColor().equals(t.getBottom().getColor() )) {
    		return true;
    	}
    	else
    		return false;
    }
	public  boolean hasWon() {
		String[] arr = new String[] { "red", "blue", "green", "green", "red" , "blue" };
		for(int i =0;i<arr.length;i++) {
			boolean result = allEdgeSameColor(allTriangles.get(i),arr[i]);
			if(result == false) {
				System.out.println(i+"********");
				return false;
				}
			else
				continue;
		}
		setWin(true);
		return true;
	}
	public void whetherNodeOrNOT(Point p) {
		for(Node n: Nodes) {
			
			if(n.contains(p)) {
				
				
				changeStatus(n);
				if(n.isSelected())
					SelectedNodes.add(n);
				else
					SelectedNodes.removeIf(obj -> obj == n);
			}
		}
	}
   public void changeStatus(Node n) {
	   boolean status = n.isSelected();
	   n.setSelected(!status);
	   
   }
}
