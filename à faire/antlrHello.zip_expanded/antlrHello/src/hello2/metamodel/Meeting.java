package hello2.metamodel;

public class Meeting extends Activity {
	private String who;

	public Meeting(String who) {
		this.who = who;
	}

	public String getWho() {
		return who;
	}

	public void accept (Visitor visitor) {
		visitor.visitMeeting(this);
	}

}
