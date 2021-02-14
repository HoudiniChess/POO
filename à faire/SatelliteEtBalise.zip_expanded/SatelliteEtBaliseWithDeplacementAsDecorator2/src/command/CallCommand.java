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

      case "liste":

        System.out.println("Créer une balise : x = new Beacon (PointX = x, PointY = x, Deplacement = #x, Memory = x);");
        System.out
            .println("Créer un satellite : x = new Satellite (PointX = x, PointY = x, Deplacement = #x, Memory = x);");
        System.out.println("Lancer une balise ou un Satellite : x.start(Speed = x);");
        System.out.println("Stopper une balise ou un Satellite : x.stop();");
        break;

      default:
        System.out.println("commande inconnue");
        break;

    }
  }

}
