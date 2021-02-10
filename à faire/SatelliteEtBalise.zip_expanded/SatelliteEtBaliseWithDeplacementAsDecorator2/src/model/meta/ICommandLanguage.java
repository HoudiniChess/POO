package model.meta;

public abstract class ICommandLanguage implements MMEntity
{
  @Override
  public abstract void accept(Visitor visitor);
}
