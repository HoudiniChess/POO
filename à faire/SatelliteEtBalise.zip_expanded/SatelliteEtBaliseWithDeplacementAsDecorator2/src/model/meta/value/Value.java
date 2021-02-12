package model.meta.value;

import model.meta.Argument;
import model.meta.Assign;
import model.meta.ValueAssign;
import model.meta.Visitor;

public class Value extends ValueAssign
{
  protected String valeur;
  protected String variable;

  public Value(String valeur)
  {
    this.valeur = valeur;
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
    visitor.visitValue(this);

  }

  public String getVariable()
  {
    return variable;
  }

  public void setVariable(String variable)
  {
    this.variable = variable;
  }

  public String getValeur()
  {
    return valeur;
  }

  public void setValeur(String valeur)
  {
    this.valeur = valeur;
  }

}
