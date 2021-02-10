package model.meta;

public class Call implements ICommandLanguage
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
    // TODO Auto-generated method stub

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
