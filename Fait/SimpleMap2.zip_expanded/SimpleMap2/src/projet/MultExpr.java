package projet;

public class MultExpr extends BinExpr {

	public MultExpr(Expr opg, Expr opd) {
		super(opg, opd);
	}

	@Override
	public void accept(Visitor v) {
		v.visitMultExpr(this);
	}

}
