package command;

import simulation.Simulation;

public interface ICommand
{
  public void execute(Simulation simulation);
}
