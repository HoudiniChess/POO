package model;

import java.awt.Point;

public class DeplDown extends Deplacement
{

  @Override
  public void bouge(ElementMobile target)
  {
    Point p = target.getPosition();
    int y = p.y;
    if (y >= 149)
    {
      y += 3;
      target.setPosition(new Point(p.x, y));
    }

  }

}
