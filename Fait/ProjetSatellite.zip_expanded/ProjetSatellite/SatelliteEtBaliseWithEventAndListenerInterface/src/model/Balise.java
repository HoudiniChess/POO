package model;

import interfaces.ISatelliteSynchronize;

public class Balise extends ElementMobile implements ISatelliteSynchronize
{

  private int memory = 0;

  @Override
  public void bouge()
  {
    if (this.memory == 50)
    {
      this.send(new BaliseMemoryFull(this));
      this.setDeplacement(new DeplUp());
      if (this.getPosition().y <= 150)
      {
        this.send(new BaliseStop(this));
      }
    }

    else
    {
      this.memory++;
    }

    super.bouge();
  }

  @Override
  public void isSynchronize(SatelliteSynchronize arg)
  {
    Satellite sat = (Satellite) arg.getSource();
    if (this.getPosition().x < sat.getPosition().x + 40 && this.getPosition().x > sat.getPosition().x - 40)
    {

      if (this.memory == 0)
      {
        this.setDeplacement(new DeplDown());
        if (this.getPosition().y == 500)
        {
          this.bouge();
        }
      }
      else
      {
        this.memory--;
      }
    }

  }

}
