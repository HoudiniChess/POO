package simulation;

import interfaces.IBaliseMemoryFullListener;
import interfaces.IBaliseStopListener;
import model.BaliseMemoryFull;
import model.BaliseStop;
import model.ElementMobile;

public class GrBalise extends GrElementMobile implements IBaliseMemoryFullListener, IBaliseStopListener
{

  @Override
  public void setModel(ElementMobile model)
  {
    super.setModel(model);
    model.registerListener(BaliseMemoryFull.class, this);
    model.registerListener(BaliseStop.class, this);
  }

  @Override
  public void baliseIsStoped(BaliseStop arg)
  {
    this.setColor(color.RED);
    this.repaint();
  }

  @Override
  public void baliseIsFull(BaliseMemoryFull arg)
  {
    this.setColor(color.BLACK);
    this.repaint();
  }

}
