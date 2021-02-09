package projet;

abstract public class BinExpr extends Expr {
	Expr opg;
	Expr opd;
	
	public BinExpr(Expr opg, Expr opd) {
		this.opg = opg;
		this.opd = opd;
	}

	public Expr getOpg() {
		return opg;
	}

	public Expr getOpd() {
		return opd;
	}
	
}
