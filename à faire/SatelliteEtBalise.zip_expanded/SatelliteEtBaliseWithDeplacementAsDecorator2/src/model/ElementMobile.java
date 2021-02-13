package model;

import java.awt.Point;

import eventHandler.AbstractEvent;
import eventHandler.EventHandler;
import events.PositionChanged;
import movementStrategy.Movement;

public class ElementMobile
{
  protected Movement movement;

  protected Memory memory;
  protected Point position;
  protected EventHandler eventHandler;

  public ElementMobile(Memory memory)
  {
    eventHandler = new EventHandler();
    this.position = new Point(0, 0);
    this.memory = memory;

  }

  // enregistrement des listeners
  public void registerListener(Class<? extends AbstractEvent> whichEventType, Object listener)
  {
    eventHandler.registerListener(whichEventType, listener);
  }

  public void unregisterListener(Class<? extends AbstractEvent> whichEventType, Object listener)
  {
    eventHandler.unregisterListener(whichEventType, listener);
  }

  // envoi des evenements
  public void send(AbstractEvent event)
  {
    eventHandler.send(event);
  }

  public void tick()
  {
    this.move();
  }

  public void readSensors()
  {
    if (getMovement().getSpeed() != 0)
    {
      memory.tick();
    }
  }

  public void move()
  {
    this.movement.move(this);
    this.send(new PositionChanged(this));
  }

  public void setPosition(Point position)
  {
    if (this.position.equals(position))
      return;
    this.position = position;
  }

  public Point getPosition()
  {
    return position;
  }

  public Movement getMovement()
  {
    return this.movement;
  }

  public void setMovement(Movement depl)
  {
    this.movement = depl;
  }

  public Memory getMemory()
  {
    return memory;
  }

}
