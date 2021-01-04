package projet;

abstract public class Expr {
	public abstract void accept(Visitor v);
	Expr valeur( ) { return null; }
}
