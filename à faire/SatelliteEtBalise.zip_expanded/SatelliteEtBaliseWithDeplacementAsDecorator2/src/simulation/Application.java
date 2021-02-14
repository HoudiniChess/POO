package simulation;

import model.meta.BaseVisitor;

public class Application
{

  public static void main(String[] args)
  {
    startApplication();
  }

  protected static void startApplication()
  {
    Simulation simulation = new Simulation();
    new BaseVisitor(simulation);
    simulation.launch();
  }
}