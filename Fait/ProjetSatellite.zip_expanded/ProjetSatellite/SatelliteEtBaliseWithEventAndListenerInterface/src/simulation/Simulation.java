package simulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import graphicLayer.GSpace;
import model.Balise;
import model.BaliseStop;
import model.DeplHorizontal;
import model.Satellite;
import model.SatelliteSynchronize;

public class Simulation
{

  public static void main(String[] args)
  {

    // Mise en place du modele
    Balise balH = new Balise();
    balH.setPosition(new Point(100, 500));
    balH.setDeplacement(new DeplHorizontal(50, 600));

    Satellite sat = new Satellite();
    sat.setPosition(new Point(50, 50));
    sat.setDeplacement(new DeplHorizontal(300, 650));

    // Mise en place de la partie graphique
    GrBalise grbalH = new GrBalise();
    grbalH.setColor(Color.WHITE);
    grbalH.setModel(balH);

    GrSatellite grSat = new GrSatellite();
    grSat.setColor(Color.GREEN);
    grSat.setModel(sat);

    balH.registerListener(BaliseStop.class, sat);
    sat.registerListener(SatelliteSynchronize.class, balH);

    GSpace w = new GSpace("Satellite & Balises", new Dimension(800, 600));
    w.repaint();
    w.addElement(grSat);
    w.addElement(grbalH);

    w.open();

    while (true)
    {
      balH.bouge();
      sat.bouge();
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
