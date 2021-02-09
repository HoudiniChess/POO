package simulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import graphicLayer.GSpace;
import model.Balise;
import model.DeplHorizontal;
import model.DeplVertical;

public class Simulation
{

  public static void main(String[] args)
  {
    GSpace w = new GSpace("Satellite & Balises", new Dimension(800, 600));
    Balise balH = new GrBalise();

    balH.setColor(Color.RED);
    balH.setPosition(new Point(100, 400));
    balH.setDeplacement(new DeplHorizontal());

    GrBalise balV = new GrBalise();
    balV.setPosition(new Point(400, 400));
    balV.setDeplacement(new DeplVertical(300, 580));

    w.addElement(balV);
    w.addElement(balH);

    w.open();
    while (true)
    {
      balH.bouge();
      balV.bouge();
      try
      {
        Thread.sleep(50);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

}
