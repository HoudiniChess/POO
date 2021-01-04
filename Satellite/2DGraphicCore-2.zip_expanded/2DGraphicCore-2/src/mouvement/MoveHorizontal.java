package mouvement;

import java.awt.Point;

public class MoveHorizontal implements IMove
{

  @Override
  public Point move(Point point)
  {
    point.y = point.y + 10;
    return point;
  }

}
