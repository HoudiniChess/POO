package model.meta.value;

import model.meta.ValueAssign;
import model.meta.Visitor;

public abstract class Value extends ValueAssign
{
  @Override
  public abstract void accept(Visitor visitor);

}
