package hello2.metamodel;

public abstract class Activity implements MMEntity {
	public abstract void accept (Visitor visitor);
}
