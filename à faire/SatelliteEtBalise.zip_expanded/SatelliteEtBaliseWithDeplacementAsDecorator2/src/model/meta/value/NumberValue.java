package model.meta.value;

import model.meta.Visitor;

public class NumberValue extends Value
{

  protected Integer value;

  public NumberValue(Integer nb)
  {
    this.value = nb;
  }

  @Override
  public void accept(Visitor visitor)
  {
    visitor.visitNumber(this);

  }

  public Integer getValue()
  {
    return value;
  }

  public void setValue(Integer value)
  {
    this.value = value;
  }

}
