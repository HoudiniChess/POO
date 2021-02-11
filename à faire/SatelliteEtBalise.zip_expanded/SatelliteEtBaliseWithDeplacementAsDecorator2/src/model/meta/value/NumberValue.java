package model.meta.value;

import model.meta.Argument;
import model.meta.Assign;
import model.meta.Visitor;

public class NumberValue extends Value
{

  protected Integer value;
  protected String variable;

  public NumberValue(Integer nb)
  {
    this.value = nb;
  }

  @Override
  public void accept(Visitor visitor, Assign assign)
  {
    this.variable = assign.getVariable();
    this.accept(visitor);

  }

  @Override
  public void accept(Visitor visitor, Argument argument)
  {
    this.variable = argument.getVariable();
    this.accept(visitor);
  }

  @Override
  public void accept(Visitor visitor)
  {
    visitor.visitNumber(this);

  }

  public String getVariable()
  {
    return variable;
  }

  public void setVariable(String variable)
  {
    this.variable = variable;
  }

  public Integer getValue()
  {
    return value;
  }

  public void setValue(Integer value)
  {
    this.value = value;
  }

  @Override
  public Object getValeur()
  {
    return this.variable;
  }

}
