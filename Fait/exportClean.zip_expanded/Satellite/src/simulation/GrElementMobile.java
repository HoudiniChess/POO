package simulation;

import java.util.Observable;
import java.util.Observer;

import graphicLayer.GRect;
import model.ElementMobile;

public class GrElementMobile extends GRect implements Observer {
	ElementMobile model;

	
	
	@Override
	public void update(Observable o, Object arg) {
		
		this.setPosition(model.getPosition());
		this.repaint();
	}
	
	public void setModel(ElementMobile model) {
		this.model = model;
		model.addObserver(this);
	}
}