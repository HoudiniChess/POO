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
import movementStrategy.HorizontalMovement;
import movementStrategy.Movement;
import movementStrategy.SatelliteMovement;

public class Simulation
{
  GSpace world;
  GRect sky;
  GRect sea;
  Point pointBeacon = new Point(0, 160); // mettre ça en random
  Point pointSatellite = new Point(10, 50);
  Integer vitesse = 2; // random

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

  public void addBeacon(Beacon beacon)
  {
    beacon.setPosition(pointBeacon);
    beacon.setCollectMovement(new HorizontalMovement(4, 50, 750));
    beacon.setStandartDeepness(pointBeacon.y);
    GrBeacon grbal = new GrBeacon();
    grbal.setModel(beacon);
    sea.addElement(grbal);
  }

  public void addBeacon(GBounded sea, Point startPos, Movement depl, Memory memory)
  {
    Beacon bal = new Beacon(memory);
    bal.setPosition(startPos);
    bal.setCollectMovement(depl);
    bal.setStandartDeepness(startPos.y);
    GrBeacon grbal = new GrBeacon();
    grbal.setModel(bal);
    sea.addElement(grbal);
  }

  public void addBeacon(Point startPos, Movement depl, Memory memory)
  {
    this.addBeacon(sea, startPos, depl, memory);
  }

  public void addSatellite(Satellite satellite)
  {
    satellite.setPosition(pointSatellite);
    satellite.setMovement(new SatelliteMovement(-10, 1000, vitesse));
    GrSatellite grSat = new GrSatellite();
    grSat.setModel(satellite);
    sky.addElement(grSat);
  }

  public void addSatellite(GBounded sky, Point startPos, int vitesse, Memory memory)
  {
    Satellite sat = new Satellite(memory);
    sat.setPosition(startPos);
    sat.setMovement(new SatelliteMovement(-10, 1000, vitesse));
    GrSatellite grSat = new GrSatellite();
    grSat.setModel(sat);
    sky.addElement(grSat);
  }

  public void addSatellite(Point startPos, int vitesse, Memory memory)
  {
    this.addSatellite(sky, startPos, vitesse, memory);
  }

  public void launch()
  {
//    this.addSatellite(sky, new Point(10, 50), 2, new Memory(1000));
//    this.addSatellite(sky, new Point(100, 10), 1, new Memory(1000));
//    this.addSatellite(sky, new Point(400, 90), 3, new Memory(1000));
//    this.addSatellite(sky, new Point(500, 140), 4, new Memory(1000));
//    this.addSatellite(sky, new Point(600, 10), 1, new Memory(1000));
//    this.addBeacon(sea, new Point(400, 200), new HorizontalMovement(4, 50, 750), new Memory(300));
//    this.addBeacon(sea, new Point(100, 100), new VerticalMovement(3, 50, 200), new Memory(400));
//    this.addBeacon(sea, new Point(0, 160), new HorizontalMovement(2, 0, 800), new Memory(200));
//    this.addBeacon(sea, new Point(200, 100), new VerticalMovement(5, 130, 270), new Memory(500));
//    this.addBeacon(sea, new Point(300, 100), new SinusoidaleMovement(3, 100, 700, 50, 200), new Memory(150));
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