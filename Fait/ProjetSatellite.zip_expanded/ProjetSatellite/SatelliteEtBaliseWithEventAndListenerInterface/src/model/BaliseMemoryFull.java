package model;

import eventHandler.AbstractEvent;
import interfaces.IBaliseMemoryFullListener;

public class BaliseMemoryFull extends AbstractEvent
{

  public BaliseMemoryFull(Balise source)
  {
    super(source);
  }

  @Override
  public void runOn(Object target)
  {
    IBaliseMemoryFullListener listener = (IBaliseMemoryFullListener) target;
    listener.baliseIsFull(this);

  }

}
