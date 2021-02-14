package command;

import java.awt.Point;

import model.ManagerBis;
import model.Memory;
import movementStrategy.HorizontalMovement;
import movementStrategy.SinusoidaleMovement;
import movementStrategy.VerticalMovement;
import simulation.Simulation;

public class AssignCommand implements ICommand
{
  String variable;

  public AssignCommand(String variable)
  {
    this.variable = variable;
  }

  @Override
  public void execute(Simulation simulation)
  {

    if (ManagerBis.getInstance().getElementMobile().equalsIgnoreCase("Beacon"))
    {
      switch (ManagerBis.getInstance().getMouvement())
      {

        case "horizontal":

          simulation.addBeacon(variable,
                               new Point(Integer.parseInt(ManagerBis.getInstance().getPointX()),
                                   Integer.parseInt(ManagerBis.getInstance().getPointY())),
                               new HorizontalMovement(0, 50, 750),
                               new Memory(Integer.parseInt(ManagerBis.getInstance().getMemory())));

          break;

        case "vertical":

          simulation.addBeacon(variable,
                               new Point(Integer.parseInt(ManagerBis.getInstance().getPointX()),
                                   Integer.parseInt(ManagerBis.getInstance().getPointY())),
                               new VerticalMovement(0, 50, 250),
                               new Memory(Integer.parseInt(ManagerBis.getInstance().getMemory())));
          break;

        case "sinusoidale":
          simulation.addBeacon(variable,
                               new Point(Integer.parseInt(ManagerBis.getInstance().getPointX()),
                                   Integer.parseInt(ManagerBis.getInstance().getPointY())),
                               new SinusoidaleMovement(0, 100, 700, 50, 200),
                               new Memory(Integer.parseInt(ManagerBis.getInstance().getMemory())));

          break;

        default:
          System.out.println("Mouvement inconnu");
          break;
      }
    }

    else if (ManagerBis.getInstance().getElementMobile().equalsIgnoreCase("Satellite"))
    {
      simulation.addSatellite(variable,
                              new Point(Integer.parseInt(ManagerBis.getInstance().getPointX()),
                                  Integer.parseInt(ManagerBis.getInstance().getPointY())),
                              0, new Memory(Integer.parseInt(ManagerBis.getInstance().getPointY())));
    }

    else
    {
      System.out.println("L'élément mobile n'existe pas");
    }

  }

}
