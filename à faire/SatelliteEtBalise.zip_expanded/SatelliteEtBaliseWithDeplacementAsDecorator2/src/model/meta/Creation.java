package model.meta;

public class Creation extends ValueAssign
{
  String variable;
  Arguments arguments;

  String name;

  public Creation(String variable, Arguments arguments)
  {
    this.variable = variable;
    this.arguments = arguments;
  }

  @Override
  public void accept(Visitor visitor, Assign assign)
  {
    this.name = assign.getVariable();
    visitor.visitCreation(this);
  }

  @Override
  public void accept(Visitor visitor, Argument argument)
  {
    this.name = argument.getVariable();
    visitor.visitCreation(this);

  }

  @Override
  public void accept(Visitor visitor)
  {
    // Not use

  }

  @Override
  public Object getValeur()
  {
    return this.name;
  }

  public String getVariable()
  {
    return variable;
  }

  public void setVariable(String variable)
  {
    this.variable = variable;
  }

  public Arguments getArguments()
  {
    return arguments;
  }

  public void setArguments(Arguments arguments)
  {
    this.arguments = arguments;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

}
