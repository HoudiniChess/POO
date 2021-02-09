package model.meta.value;

public class NumberValue implements Value<Number>
{

  protected Number value;

  public NumberValue(Number nb)
  {
    this.value = nb;
  }

  @Override
  public Number getValue()
  {
    return value;
  }

  ;
}
