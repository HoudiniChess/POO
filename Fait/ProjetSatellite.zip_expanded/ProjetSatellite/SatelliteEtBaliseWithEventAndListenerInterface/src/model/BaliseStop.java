package model;

import eventHandler.AbstractEvent;
import interfaces.IBaliseStopListener;

public class BaliseStop extends AbstractEvent
{

  public BaliseStop(Balise source)
  {
    super(source);
  }

  @Override
  public void runOn(Object target)
  {
    IBaliseStopListener listener = (IBaliseStopListener) target;
    listener.baliseIsStoped(this);
  }

}
