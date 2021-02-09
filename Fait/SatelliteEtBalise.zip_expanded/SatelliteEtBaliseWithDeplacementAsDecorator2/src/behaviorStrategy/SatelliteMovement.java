package behaviorStrategy;

import java.awt.Point;

import model.ElementMobile;

public class SatelliteMovement extends Movement
{
  Integer start;
  Integer end;
  int speed;

  public SatelliteMovement(Integer start, Integer end, int speed)
  {
    this.start = start;
    this.end = end;
    this.speed = speed;
  }

  @Override
  public void move(ElementMobile target)
  {
    Point p = target.getPosition();
    int x = p.x;
    x += speed;
    if (x > end)
      x = start;
    target.setPosition(new Point(x, p.y));
  }

}
