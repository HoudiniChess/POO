package Application;

import java.awt.Color;
import java.awt.Dimension;

import graphicLayer.GBounded;
import graphicLayer.GSpace;
import models.Balise;
import models.Satellite;
import mouvement.IMove;
import mouvement.MoveHorizontal;
import mouvement.MoveVertical;

public class Main
{

  IMove move;

  public static void main(String[] args)
  {
    String satellite1 = "";
    String balise1 = "";
    MoveHorizontal horizontal = new MoveHorizontal();
    MoveVertical vertical = new MoveVertical();
    Satellite sat = new Satellite(satellite1, horizontal);
    Balise bal = new Balise(balise1, vertical);
    Dimension dim = new Dimension(40, 40);
    Dimension dim1 = new Dimension(10, 10);

    GSpace w = new GSpace("Un essai", new Dimension(800, 600));
    GBounded container = new GBounded();
    container.setColor(Color.white);
    container.setDimension(new Dimension(400, 300));
    w.addElement(container);

    sat.setColor(Color.red);
    sat.setDimension(dim);
    bal.setColor(Color.green);
    bal.setDimension(dim1);
    container.addElement(sat);
    container.addElement(bal);

    w.open();
    for (int i = 0; i <= 5; i++)
    {
      bal.moveBalise();
      sat.moveSatellite();
      w.revalidate();
      w.repaint();
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

  }
}
