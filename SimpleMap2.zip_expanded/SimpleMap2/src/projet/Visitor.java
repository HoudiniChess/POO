package projet;

public class Visitor
{
  public void visitIntExpr(IntExpr intExpr)
  {}

  public void visitMultExpr(MultExpr multExpr)
  {}

  public void visitPlusExpr(PlusExpr plusExpr)
  {}

  public void visitValExpr(VariableUse variableUse)
  {}

  public void visitPrintln(Println print)
  {}

  public void visitAssignment(Assignment assign)
  {}

  public void visitVariable(Variable var)
  {}

}
