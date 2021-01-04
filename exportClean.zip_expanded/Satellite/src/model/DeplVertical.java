package model;


public class DeplVertical extends Deplacement {

	Integer min;
	Integer max;
	Boolean monte = false;

	public DeplVertical(Integer min, Integer max) {
		this.min = min;
		this.max = max;
		
	}
	
	@Override
	public void bouge(ElementMobile target) {
		int y = target.position.y;
		if (monte) {
			y -= 3;
			if (y < min) monte = false;
		} else {
			y += 3;
			if (y > max) monte = true;
		}
		target.position.setLocation(target.position.x, y);
	}

}
