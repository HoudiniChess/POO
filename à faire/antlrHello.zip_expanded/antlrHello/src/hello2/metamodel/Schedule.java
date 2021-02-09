package hello2.metamodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Schedule implements MMEntity {
	private ArrayList<Day> days;

	public Schedule() {
		this.days = new ArrayList<Day>();
	}

	public void addDay(Day day) {
		this.days.add(day);
	}
	public void addAllDays (List<Day> days) {
		this.days.addAll(days);
	}
	public Iterator<Day> daysIterator() {
		return this.days.iterator();
	}

	public void accept(Visitor visitor) {
		visitor.visitSchedule(this);
	}

}
