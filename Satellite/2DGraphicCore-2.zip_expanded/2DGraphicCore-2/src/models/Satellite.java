package models;

import graphicLayer.GRect;
import mouvement.IMove;

public class Satellite extends GRect
{

  private IMove movement;
  private String name;

  public Satellite(String name, IMove movement)
  {
    this.movement = movement;
    this.name = name;
  }

  public void moveSatellite()
  {
    this.position = this.movement.move(this.position);
  }

}
