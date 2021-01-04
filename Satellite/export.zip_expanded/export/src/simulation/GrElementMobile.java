package simulation;

import java.util.Observable;
import java.util.Observer;

import graphicLayer.GRect;
import model.ElementMobile;

public class GrElementMobile extends GRect implements Observer
{
  ElementMobile model;

  @Override
  public void update(Observable o, Object arg)
  {
    // mettre à jour la position à partir du modele
    this.repaint();
    System.out.println();
  }
}