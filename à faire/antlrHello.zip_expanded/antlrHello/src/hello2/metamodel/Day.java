package hello2.metamodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Day implements MMEntity {
	private ArrayList<Activity> activities;
	private String which;
	
	public Day(String which) {
		this.activities = null;
		this.which = which;
	}

	public String getWhich() {
		return which;
	}

	private void initActivitiesIfNeeded() {
		if (this.activities != null) return;
		this.activities = new ArrayList<Activity>();
	}
	
	public void addActivity(Activity activity) {
		this.initActivitiesIfNeeded();
		this.activities.add(activity);
	}
	
	public Activity [] getActivitiesArray () {
		return this.activities == null ? null : this.activities.toArray(new Activity [this.activities.size()]);
	}
	
	public void addAllActivities(List<Activity> activities) {
		this.initActivitiesIfNeeded();
		this.activities.addAll(activities);
	}
	
	public Boolean haveActivities() {
		return this.activities != null && this.activities.size() > 0;
	}
	
	Iterator<Activity> activitiesIterator() {
		return this.activities == null ? null : this.activities.iterator();
	}
	
	public void accept (Visitor visitor) {
		visitor.visitDay(this);
	}
}
