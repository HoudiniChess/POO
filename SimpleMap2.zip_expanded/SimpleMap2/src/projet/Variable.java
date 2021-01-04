package projet;

public class Variable
{
  String name;

  public Variable(String name)
  {
    this.name = name;
  }

  public void accept(Visitor v)
  {
    v.visitVariable(this);
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
