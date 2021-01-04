package simulation;

import interfaces.ISatelliteDesynchronize;
import interfaces.ISatelliteSynchronize;
import model.ElementMobile;
import model.SatelliteDesynchronize;
import model.SatelliteSynchronize;

public class GrSatellite extends GrElementMobile implements ISatelliteSynchronize, ISatelliteDesynchronize
{

  @Override
  public void setModel(ElementMobile model)
  {
    super.setModel(model);
    model.registerListener(SatelliteSynchronize.class, this);
    model.registerListener(SatelliteDesynchronize.class, this);

  }

  @Override
  public void isSynchronize(SatelliteSynchronize arg)
  {
    this.setColor(color.BLUE);
    this.repaint();
  }

  @Override
  public void isDesynchronize(SatelliteDesynchronize arg)
  {
    this.setColor(color.GREEN);
    this.repaint();
  }

}
