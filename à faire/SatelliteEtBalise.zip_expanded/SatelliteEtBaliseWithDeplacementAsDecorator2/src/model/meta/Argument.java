package model.meta;

public class Argument extends MMEntity
{
  protected String variable;
  protected ValueAssign valueAssign;

  public Argument(String variable, ValueAssign valueAssign)
  {
    this.variable = variable;
    this.valueAssign = valueAssign;
  }

  public String getVariable()
  {
    return variable;
  }

  public void setVariable(String variable)
  {
    this.variable = variable;
  }

  public ValueAssign getValueAssign()
  {
    return valueAssign;
  }

  public void setValueAssign(ValueAssign valueAssign)
  {
    this.valueAssign = valueAssign;
  }

  @Override
  public void accept(Visitor visitor)
  {
    visitor.visitArgument(this);

  }

}
