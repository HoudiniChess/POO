package projet;
public class VariableUse extends UnaryExpr
{
  Variable val;

  public VariableUse(Variable val)
  {
    this.val = val;
  }

  public Variable getVal()
  {
    return val;
  }

  @Override
  public void accept(Visitor v)
  {
    v.visitValExpr(this);
  }

}