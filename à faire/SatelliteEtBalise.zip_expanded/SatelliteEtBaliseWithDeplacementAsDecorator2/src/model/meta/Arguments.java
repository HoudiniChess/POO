package model.meta;

import java.util.ArrayList;
import java.util.List;

public class Arguments extends MMEntity
{
  List<Argument> arguments;

  public Arguments()
  {
    this.arguments = new ArrayList<>();
  }

  public void addAll(List<Argument> arguments)
  {
    this.arguments = arguments;
  }

  public List<Argument> getArguments()
  {
    return arguments;
  }

  public void setArguments(List<Argument> arguments)
  {
    this.arguments = arguments;
  }

  @Override
  public void accept(Visitor visitor)
  {
    visitor.visitArguments(this);

  }

}
