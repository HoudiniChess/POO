package model;

import interfaces.IBaliseStopListener;

public class Satellite extends ElementMobile implements IBaliseStopListener
{

  @Override
  public void baliseIsStoped(BaliseStop arg)
  {
    Balise balise = (Balise) arg.getSource();
    int posSatelliteX = this.getPosition().x;
    if (posSatelliteX < balise.getPosition().x + 40 && posSatelliteX > balise.getPosition().x - 40)
    {
      this.send(new SatelliteSynchronize(this));
    }
    else
    {
      this.send(new SatelliteDesynchronize(this));
    }

  }
}
