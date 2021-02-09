package hello2.metamodel;

public class Sleeping extends Activity {
	private Integer duration;

	public Sleeping(Integer duration) {
		this.duration = duration;
	}

	public Integer getDuration() {
		return duration;
	}

	public void accept (Visitor visitor) {
		visitor.visitSleeping(this);
	}

}
