package hello2.metamodel;

public class Practice extends Activity {
	private String what;
	private Integer duration;
	
	public Practice(String what, Integer duration) {
		this.what = what;
		this.duration = duration;
	}
	public String getWhat() {
		return what;
	}
	public Integer getDuration() {
		return duration;
	}
	public void accept (Visitor visitor) {
		visitor.visitPratice(this);
	}

}
