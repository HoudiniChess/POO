package model;

import java.util.HashMap;
import java.util.Map.Entry;

import events.SatelliteMoved;
import simulation.Simulation;
import state.BeaconStateSynchro;

public class ManagerBis
{

  protected HashMap<String, Beacon> bals;
  protected HashMap<String, Satellite> sats;
  private static ManagerBis instance;
  protected Simulation simulation;

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

  public void start(String variable)
  {
    if (this.bals.containsKey(variable))
    {
      this.simulation.addBeacon(this.bals.get(variable));
    }
    else
    {
      this.simulation.addSatellite(this.sats.get(variable));
    }

  }

  public void addSatellite(String variable, Satellite satellite)
  {
    if (variable != null && satellite != null)
    {
      this.sats.put(variable, satellite);
    }
    this.simulation.addSatellite(satellite);
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

  public Simulation getSimulation()
  {
    return simulation;
  }

  public void setSimulation(Simulation simulation)
  {
    this.simulation = simulation;
  }

}
