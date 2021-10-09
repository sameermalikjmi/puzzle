package trianglePuzzle.model;

import java.awt.Point;
import java.util.ArrayList;

public class Node {
    boolean selected;
    int id;
    int x,y;
    
    
    
	public Node(int x,int y,int id,boolean selected) {
		this.selected =selected;
		this.id =id;
		
		this.x=x;
		this.y=y;
	}
	
	

	public boolean isSelected() {
		return selected;
	}
  public boolean contains( Point p) {
	  if(p.x>=x && p.x<=x+15 && p.y>=y && p.y<=y+15)
		  return true;
	  
	  else 
		  return false;
   }
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	 

	

	
}
