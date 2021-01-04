package models;

import graphicLayer.GRect;
import mouvement.IMove;

public class Balise extends GRect
{

  private IMove movement;
  private String name;

  public Balise(String name, IMove movement)
  {
    this.movement = movement;
    this.name = name;
  }

  public void moveBalise()
  {
    this.position = this.movement.move(this.position);
  }

}
