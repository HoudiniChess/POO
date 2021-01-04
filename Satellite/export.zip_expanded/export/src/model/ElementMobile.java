package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import simulation.GrElementMobile;

public class ElementMobile extends Observable
{
  Deplacement depl;
  Point position;
  protected List<GrElementMobile> observers;

  /**
   * Ajoute l'observeur en param�tre aux observeurs.
   * 
   * @param observer
   *          Observeur � ajouter.
   */
  public void addObserver(GrElementMobile observer)
  {
    if (observer != null)
    {
      this.observers.add(observer);
    }
  }

  /**
   * Enl�ve l'observeur en param�tre des observeurs.
   * 
   * @param observer
   *          Observeur � enlever.
   */
  public void removeObserver(GrElementMobile observer)
  {
    if (observer != null)
    {
      this.observers.remove(observer);
    }
  }

  /**
   * Notifie le changement de nom de la correspondance.
   */
  protected void notifyObserver()
  {
    List<GrElementMobile> copyObservers = new ArrayList<>(this.observers);

    for (GrElementMobile observer : copyObservers)
    {
      observer.update(this, this);
    }
  }

  public void bouge()
  {
    this.depl.bouge(this);
    this.notifyObservers(this);
  }

  public void setDeplacement(Deplacement depl)
  {
    this.depl = depl;
  }

}
