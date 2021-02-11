package model.meta;

public abstract class ValueAssign
{
  public abstract void accept(Visitor visitor, Assign assign);

  public abstract void accept(Visitor visitor, Argument argument);

  public abstract void accept(Visitor visitor);

  public abstract Object getValeur();

}
