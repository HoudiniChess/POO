package model;

import eventHandler.AbstractEvent;
import interfaces.ISatelliteDesynchronize;

public class SatelliteDesynchronize extends AbstractEvent
{

  public SatelliteDesynchronize(Object source)
  {
    super(source);
  }

  @Override
  public void runOn(Object target)
  {
    ISatelliteDesynchronize listener = (ISatelliteDesynchronize) target;
    listener.isDesynchronize(this);

  }

}
