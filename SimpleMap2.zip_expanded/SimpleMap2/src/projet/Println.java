package projet;

public class Println extends ProcCall
{

  public Println(Expr expr)
  {
    super(expr);
  }

  public void accept(Visitor v)
  {
    v.visitPrintln(this);
  }

}
