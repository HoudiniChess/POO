package model.meta;

public class Assign implements ICommandLanguage
{

  String variable;
  ValueAssign value;

  public Assign(String variable, ValueAssign value)
  {
    this.variable = variable;
    this.value = value;
  }

  @Override
  public void accept(Visitor visitor)
  {
    visitor.visitAssign(this);
  }

  /**
   * Getters et Setters.
   */

  public String getVariable()
  {
    return variable;
  }

  public void setVariable(String variable)
  {
    this.variable = variable;
  }

  public ValueAssign getValue()
  {
    return value;
  }

  public void setValue(ValueAssign value)
  {
    this.value = value;
  }

}
