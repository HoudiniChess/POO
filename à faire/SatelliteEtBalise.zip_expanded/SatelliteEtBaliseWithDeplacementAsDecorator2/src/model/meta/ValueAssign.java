package model.meta;

public abstract class ValueAssign implements MMEntity
{
  @Override
  public abstract void accept(Visitor visitor);
}
