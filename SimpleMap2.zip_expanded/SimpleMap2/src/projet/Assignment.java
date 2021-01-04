package projet;

public class Assignment extends Statement
{
  protected Variable var;
  protected IntExpr exp;

  public Assignment(Variable var, IntExpr exp)
  {
    this.var = var;
    this.exp = exp;
  }

  public void accept(Visitor v)
  {
    v.visitAssignment(this);
  }

  public Variable getVar()
  {
    return var;
  }

  public void setVar(Variable var)
  {
    this.var = var;
  }

  public IntExpr getExp()
  {
    return exp;
  }

  public void setExp(IntExpr exp)
  {
    this.exp = exp;
  }

}
