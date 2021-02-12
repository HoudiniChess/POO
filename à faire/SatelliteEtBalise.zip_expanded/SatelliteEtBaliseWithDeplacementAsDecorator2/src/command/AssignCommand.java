package command;

import java.awt.Point;
import java.util.List;

import model.Memory;
import model.meta.Argument;
import model.meta.ManagerVariable;
import movementStrategy.HorizontalMovement;
import movementStrategy.SinusoidaleMovement;
import movementStrategy.VerticalMovement;
import simulation.Simulation;

public class AssignCommand implements ICommand
{

  String PointX;
  String PointY;
  String mouvement;
  String memory;
  String speed;

  public AssignCommand(List<Argument> args)
  {
    this.setUp(args);
  }

  @Override
  public void execute(Simulation simulation)
  {

    switch (mouvement)
    {

      case "satelliteMouvement":

        simulation.addSatellite(new Point(Integer.parseInt(PointX), Integer.parseInt(PointY)), Integer.parseInt(speed),
                                new Memory(Integer.parseInt(memory)));
        break;

      case "horizontal":

        simulation.addBeacon(new Point(Integer.parseInt(PointX), Integer.parseInt(PointY)),
                             new VerticalMovement(Integer.parseInt(speed), 50, 750),
                             new Memory(Integer.parseInt(memory)));
        break;

      case "vertical":

        simulation.addBeacon(new Point(Integer.parseInt(PointX), Integer.parseInt(PointY)),
                             new SinusoidaleMovement(Integer.parseInt(speed), 100, 700, 50, 200),
                             new Memory(Integer.parseInt(memory)));
        break;

      case "sinusoidale":

        simulation.addBeacon(new Point(Integer.parseInt(PointX), Integer.parseInt(PointY)),
                             new HorizontalMovement(Integer.parseInt(speed), 50, 750),
                             new Memory(Integer.parseInt(memory)));
        break;

      default:
        System.out.println("Mouvement inconnu");
        break;
    }

  }

  public void setUp(List<Argument> args)
  {
    this.PointX = ManagerVariable.getInstance().getValues().get(args.get(0).getVariable());
    this.PointY = ManagerVariable.getInstance().getValues().get(args.get(1).getVariable());
    this.mouvement = ManagerVariable.getInstance().getValues().get(args.get(2).getVariable());
    this.memory = ManagerVariable.getInstance().getValues().get(args.get(3).getVariable());
    this.speed = ManagerVariable.getInstance().getValues().get(args.get(4).getVariable());
  }

}
