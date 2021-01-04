package model;

import java.awt.Point;

import eventHandler.AbstractEvent;
import eventHandler.EventHandler;

public class ElementMobile {
	Deplacement depl;
	Point position;
	EventHandler eventHandler = new EventHandler();
	
	// enregistrement des listeners
	public void registerListener(Class<? extends AbstractEvent> whichEventType, Object listener) {
		eventHandler.registerListener(whichEventType, listener);
	}
	
	// envoi des evenements
	public void send (AbstractEvent event) {
		eventHandler.send(event);
	}
	
	public ElementMobile() {
		this.position = new Point(0,0);
	}
	
	public void bouge () {
		this.depl.bouge(this);
		this.send(new PositionChanged(this));		
	}
	
	public void setPosition(Point position) {
		if (this.position.equals(position)) return;
		this.position = position;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public void setDeplacement(Deplacement depl) {
		this.depl = depl;
	}

}
