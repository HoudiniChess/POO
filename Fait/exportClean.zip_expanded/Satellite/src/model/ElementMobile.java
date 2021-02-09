package model;
import java.awt.Point;
import java.util.Observable;

public class ElementMobile extends Observable {
	Deplacement depl;
	Point position;
	
	
	
	public void bouge () {
		this.depl.bouge(this);
		this.setChanged();
		this.notifyObservers(this);
	
	}
	
	public void setDeplacement(Deplacement depl) {
		this.depl = depl;
	}
	
	public Point getPosition() {
		return this.position;
	}
	
	public void setPosition(Point position) {
		this.position = position;
	}

}
