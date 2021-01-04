package mouvement;

import java.awt.Point;

public class MoveVertical implements IMove
{

  @Override
  public Point move(Point point)
  {
    point.x = point.x + 10;
    return point;
  }

}
