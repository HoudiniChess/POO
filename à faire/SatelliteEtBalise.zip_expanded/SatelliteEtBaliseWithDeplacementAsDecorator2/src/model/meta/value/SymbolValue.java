package model.meta.value;

public class SymbolValue implements Value<String>
{

  protected String symbol;

  public SymbolValue(String symbol)
  {
    this.symbol = symbol;
  }

  @Override
  public String getValue()
  {
    return symbol;
  }

}
