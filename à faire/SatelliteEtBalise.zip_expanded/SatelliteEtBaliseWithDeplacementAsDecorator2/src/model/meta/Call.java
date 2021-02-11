package model.meta;

public class Call extends ValueAssign implements ICommandLanguage
{

  String variable;
  String action;
  Arguments arguments;

  public Call(String variable, String action, Arguments arguments)
  {
    this.variable = variable;
    this.action = action;
    this.arguments = arguments;
  }

  @Override
  public void accept(Visitor visitor)
  {
    visitor.visitCall(this);
  }

  @Override
  public void accept(Visitor visitor, Assign assign)
  {
    // Not use

  }

  @Override
  public void accept(Visitor visitor, Argument argument)
  {
    // Not use

  }

  @Override
  public Object getValeur()
  {
    return this.variable;
  }

  public String getVariable()
  {
    return variable;
  }

  public void setVariable(String variable)
  {
    this.variable = variable;
  }

  public String getAction()
  {
    return action;
  }

  public void setAction(String action)
  {
    this.action = action;
  }

  public Arguments getArguments()
  {
    return arguments;
  }

  public void setArguments(Arguments arguments)
  {
    this.arguments = arguments;
  }

}
