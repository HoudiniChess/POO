package model.meta.value;

import model.meta.Argument;
import model.meta.Assign;
import model.meta.Visitor;

public class SymbolValue extends Value
{

  protected String symbol;
  protected String variable;

  public SymbolValue(String symbol)
  {
    this.symbol = symbol;
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
    visitor.visitSymbol(this);

  }

  @Override
  public Object getValeur()
  {
    return this.variable;
  }

  public String getSymbol()
  {
    return symbol;
  }

  public void setSymbol(String symbol)
  {
    this.symbol = symbol;
  }

  public String getVariable()
  {
    return variable;
  }

  public void setVariable(String variable)
  {
    this.variable = variable;
  }

}
