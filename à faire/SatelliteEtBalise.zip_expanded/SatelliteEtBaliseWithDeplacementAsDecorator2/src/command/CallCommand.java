package command;

import java.util.Map;

import model.Beacon;
import model.ManagerBis;
import model.Satellite;
import simulation.Simulation;

public class CallCommand implements ICommand
{

  String var;
  String action;

  public CallCommand(String var, String action)
  {
    this.var = var;
    this.action = action;
  }

  @Override
  public void execute(Simulation simulation)
  {
    switch (action)
    {
      case "start":

        for (Map.Entry<String, Beacon> mapentry : ManagerBis.getInstance().getBals().entrySet())
        {
          if (mapentry.getKey().equals(var))
          {
            ManagerBis.getInstance().getBals().get(var).getCollectMovement()
                .setSpeed(Integer.parseInt(ManagerBis.getInstance().getSpeed()));
          }
        }

        for (Map.Entry<String, Satellite> mapentry : ManagerBis.getInstance().getSats().entrySet())
        {
          if (mapentry.getKey().equals(var))
          {

            ManagerBis.getInstance().getSats().get(var).getMovement()
                .setSpeed(Integer.parseInt(ManagerBis.getInstance().getSpeed()));
          }
        }

        break;

      case "stop":

        for (Map.Entry<String, Beacon> mapentry : ManagerBis.getInstance().getBals().entrySet())
        {
          if (mapentry.getKey().equals(var))
          {

            ManagerBis.getInstance().getBals().get(var).getCollectMovement().setSpeed(Integer.parseInt(("0")));
          }
        }

        for (Map.Entry<String, Satellite> mapentry : ManagerBis.getInstance().getSats().entrySet())
        {
          if (mapentry.getKey().equals(var))
          {

            ManagerBis.getInstance().getSats().get(var).getMovement().setSpeed(Integer.parseInt("0"));
          }
        }

        break;

      default:
        System.out.println("commande inconnue");
        break;

    }
  }

}
