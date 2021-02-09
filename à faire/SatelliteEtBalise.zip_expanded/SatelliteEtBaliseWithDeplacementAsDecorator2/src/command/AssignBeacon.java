package command;

import java.awt.Point;

import model.Memory;
import movementStrategy.HorizontalMovement;
import simulation.Simulation;

public class AssignBeacon implements ICommand
{
  protected Simulation simulation;

  public AssignBeacon(Simulation simulation)
  {
    this.simulation = simulation;
  }

  @Override
  public void execute()
  {
    this.simulation.addBeacon(new Point(400, 200), new HorizontalMovement(4, 50, 750), new Memory(300));
  }
}
