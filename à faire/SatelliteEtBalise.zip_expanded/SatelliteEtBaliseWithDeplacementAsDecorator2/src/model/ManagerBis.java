package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import events.SatelliteMoved;
import model.meta.Argument;
import model.meta.ManagerVariable;
import simulation.Simulation;
import state.BeaconStateSynchro;

public class ManagerBis
{
  protected String PointX;
  protected String PointY;
  protected String mouvement;
  protected String memory;
  protected String speed;
  protected HashMap<String, Beacon> bals;
  protected HashMap<String, Satellite> sats;
  private static ManagerBis instance;
  protected Simulation simulation;
  protected String elementMobile;

  private ManagerBis()
  {
    this.bals = new HashMap<>();
    this.sats = new HashMap<>();
  }

  public void addBeacon(String variable, Beacon beacon)
  {
    if (variable != null && beacon != null)
    {
      this.bals.put(variable, beacon);
    }
  }

  public void addSatellite(String variable, Satellite satellite)
  {
    if (variable != null && satellite != null)
    {
      this.sats.put(variable, satellite);

    }
  }

  public static ManagerBis getInstance()
  {
    if (instance == null)
    {
      instance = new ManagerBis();
    }
    return instance;
  }

  public void tick()
  {
    for (Entry<String, Beacon> entry : bals.entrySet())
    {
      entry.getValue().tick();
    }
    for (Entry<String, Satellite> entry : sats.entrySet())
    {
      entry.getValue().tick();
    }
  }

  public void beaconReadyForSynchro(BeaconStateSynchro b)
  {
    for (Entry<String, Satellite> entry : sats.entrySet())
    {
      entry.getValue().registerListener(SatelliteMoved.class, b);
    }
  }

  public void beaconSynchroDone(BeaconStateSynchro b)
  {
    for (Entry<String, Satellite> entry : sats.entrySet())
    {
      entry.getValue().unregisterListener(SatelliteMoved.class, b);
    }
  }

  public void setUpAssign(List<Argument> args)
  {

    this.PointX = ManagerVariable.getInstance().getValues().get(args.get(0).getVariable());
    this.PointY = ManagerVariable.getInstance().getValues().get(args.get(1).getVariable());
    this.mouvement = ManagerVariable.getInstance().getValues().get(args.get(2).getVariable());
    this.memory = ManagerVariable.getInstance().getValues().get(args.get(3).getVariable());

  }

  public void setUpCall(List<Argument> args)
  {
    this.speed = ManagerVariable.getInstance().getValues().get(args.get(0).getVariable());
  }

  public void setUpInstance(String elementMobile)
  {
    this.elementMobile = elementMobile;
  }

  public String getElementMobile()
  {
    return elementMobile;
  }

  public String getPointX()
  {
    return PointX;
  }

  public void setPointX(String pointX)
  {
    PointX = pointX;
  }

  public String getPointY()
  {
    return PointY;
  }

  public void setPointY(String pointY)
  {
    PointY = pointY;
  }

  public String getMouvement()
  {
    return mouvement;
  }

  public void setMouvement(String mouvement)
  {
    this.mouvement = mouvement;
  }

  public String getMemory()
  {
    return memory;
  }

  public void setMemory(String memory)
  {
    this.memory = memory;
  }

  public String getSpeed()
  {
    return speed;
  }

  public void setSpeed(String speed)
  {
    this.speed = speed;
  }

  public HashMap<String, Beacon> getBals()
  {
    return bals;
  }

  public void setBals(HashMap<String, Beacon> bals)
  {
    this.bals = bals;
  }

  public HashMap<String, Satellite> getSats()
  {
    return sats;
  }

  public void setSats(HashMap<String, Satellite> sats)
  {
    this.sats = sats;
  }

  public Simulation getSimulation()
  {
    return simulation;
  }

  public void setSimulation(Simulation simulation)
  {
    this.simulation = simulation;
  }

}
