package model;


public class DeplHorizontal extends Deplacement {

	@Override
	public void bouge(ElementMobile target) {
		target.position.setLocation(target.position.getX()+ 3, target.position.getY());
	}

}
