package model.meta.value;

import model.meta.Visitor;

public class SymbolValue extends Value
{

  protected String symbol;

  public SymbolValue(String symbol)
  {
    this.symbol = symbol;
  }

  @Override
  public void accept(Visitor visitor)
  {
    // TODO Auto-generated method stub

  }

  public String getSymbol()
  {
    return symbol;
  }

  public void setSymbol(String symbol)
  {
    this.symbol = symbol;
  }

}
