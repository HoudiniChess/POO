package hello2.metamodel;

import java.util.Iterator;


public class PrettyPrinter extends BaseVisitor {

	private String result;

	public PrettyPrinter() {
		this.reset();
	}

	public void reset() {
		this.result = "";
	}
	
	public String result() {
		return this.result;
	}
	
	@Override
	public void visitSchedule(Schedule schedule) {
		Iterator<Day> itor = schedule.daysIterator();
		while (itor.hasNext()) {
			itor.next().accept(this);
		}
	}

	@Override
	public void visitDay(Day day) {
		result += day.getWhich() + " :";
		if (! day.haveActivities()) {
			result += " None;\n";
			return;
		}
		Iterator<Activity> itor = day.activitiesIterator();
		if (itor != null) {
			while (itor.hasNext()) {
				result += " ";
				itor.next().accept(this);
			}
		}
		result += "\n";
	}

	@Override
	public void visitMeeting(Meeting meeting) {
		result += "Meeting " + meeting.getWho() + ";";
	}

	@Override
	public void visitPratice(Practice practice) {
		result += "Practice " + practice.getWhat() + " " + practice.getDuration().toString() + ";";
	}

	@Override
	public void visitSleeping(Sleeping sleeping) {
		result += "Sleeping " + sleeping.getDuration().toString() + ";";
	}

}
