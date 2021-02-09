package simulation;


import graphicLayer.GRect;
import model.ElementMobile;
import model.PositionChangeListener;
import model.PositionChanged;

public class GrElementMobile extends GRect implements PositionChangeListener {
	ElementMobile model;

	Object getModel() { return this.model; }
	
	public void setModel(ElementMobile model) {
		this.model = model;
		model.registerListener(PositionChanged.class, this);
		this.setPosition(this.model.getPosition());
		this.repaint();		
	}

	@Override
	public void whenPositionChanged(PositionChanged arg) {
		this.setPosition(this.model.getPosition());
		this.repaint();				
	}
}