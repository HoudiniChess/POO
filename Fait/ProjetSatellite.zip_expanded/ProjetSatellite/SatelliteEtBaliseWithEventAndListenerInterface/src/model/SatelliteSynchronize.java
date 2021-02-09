package model;

import eventHandler.AbstractEvent;
import interfaces.ISatelliteSynchronize;

public class SatelliteSynchronize extends AbstractEvent
{

  public SatelliteSynchronize(Object source)
  {
    super(source);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void runOn(Object target)
  {
    ISatelliteSynchronize listener = (ISatelliteSynchronize) target;
    listener.isSynchronize(this);
  }

}
