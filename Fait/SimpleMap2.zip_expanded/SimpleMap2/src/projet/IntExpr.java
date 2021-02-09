package projet;

public class IntExpr extends UnaryExpr
{
  int val;

  public IntExpr(Integer val)
  {
    this.val = val;
  }

  public int getVal()
  {
    return val;
  }

  @Override
  public void accept(Visitor v)
  {
    v.visitIntExpr(this);
  }

}
