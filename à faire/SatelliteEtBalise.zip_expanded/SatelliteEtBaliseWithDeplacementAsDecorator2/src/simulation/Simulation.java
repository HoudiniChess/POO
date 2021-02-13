package simulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import graphicLayer.GBounded;
import graphicLayer.GRect;
import graphicLayer.GSpace;
import model.Beacon;
import model.ManagerBis;
import model.Memory;
import model.Satellite;
import movementStrategy.Movement;
import movementStrategy.SatelliteMovement;

public class Simulation
{
  GSpace world;
  GRect sky;
  GRect sea;

  public Simulation()
  {
    this.initWorld();
  }

  public void mainLoop()
  {
    while (true)
    {
      ManagerBis.getInstance().tick();
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

  public void addBeacon(String var, GBounded sea, Point startPos, Movement depl, Memory memory)
  {
    Beacon bal = new Beacon(memory);
    bal.setPosition(startPos);
    bal.setCollectMovement(depl);
    bal.setStandartDeepness(startPos.y);
    ManagerBis.getInstance().addBeacon(var, bal);
    GrBeacon grbal = new GrBeacon();
    grbal.setModel(bal);
    sea.addElement(grbal);
  }

  public void addBeacon(String variable, Point startPos, Movement depl, Memory memory)
  {

    this.addBeacon(variable, sea, startPos, depl, memory);
  }

  public void addSatellite(String var, GBounded sky, Point startPos, int vitesse, Memory memory)
  {
    Satellite sat = new Satellite(memory);
    sat.setPosition(startPos);
    sat.setMovement(new SatelliteMovement(-10, 1000, vitesse));
    ManagerBis.getInstance().addSatellite(var, sat);
    GrSatellite grSat = new GrSatellite();
    grSat.setModel(sat);
    sky.addElement(grSat);
  }

  public void addSatellite(String var, Point startPos, int vitesse, Memory memory)
  {

    this.addSatellite(var, sky, startPos, vitesse, memory);

  }

  public void launch()
  {

    this.world.open();
    this.mainLoop();
  }

  private void initWorld()
  {
    this.world = new GSpace("Satellite & Balises", new Dimension(800, 600));

    this.sky = new GRect();
    this.sky.setColor(Color.WHITE);
    this.sky.setDimension(new Dimension(800, 300));

    this.sea = new GRect();
    this.sea.setColor(Color.blue);
    this.sea.setDimension(new Dimension(800, 300));
    this.sea.setPosition(new Point(0, 300));

    this.world.addElement(this.sea);
    this.world.addElement(this.sky);
  }

  public static void main(String[] args)
  {
    new Simulation().launch();
  }

}