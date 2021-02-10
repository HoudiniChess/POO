package model.meta;

import java.util.Iterator;

import model.Beacon;
import model.ManagerBis;
import model.Memory;
import model.Satellite;
import model.meta.value.NumberValue;
import model.meta.value.SymbolValue;

public class BaseVisitor implements Visitor
{
  @Override
  public void visitScript(Script script)
  {
    Iterator<ICommandLanguage> itor = script.commmandsIterator();
    while (itor.hasNext())
    {
      itor.next().accept(this);
    }
  }

  @Override
  public void visitCall(Call call)
  {
    System.out.println("Call");
    switch (call.getAction())
    {
      case "start":
        ManagerBis.getInstance().start(call.getVariable());
        break;

      default:
        System.out.println("Action: " + call.getAction() + " non connue");
        break;
    }

  }

  @Override
  public void visitAssign(Assign assign)
  {
    System.out.println("Assign");
    // call utilité ?
    // stockage des variable ?
    if (assign.getValue() instanceof Creation)
    {
      ((Creation) assign.getValue()).acceptCreation(this, assign);
    }
    else
    {
      assign.getValue().accept(this);
    }

  }

  @Override
  public void visitCreation(Creation creation)
  {
    switch (creation.getVariable())
    {
      case "Satellite":
        // list arg dans manager ?
        ManagerBis.getInstance().addSatellite(creation.getName(), new Satellite(new Memory(100)));
        break;
      case "Balise":
        ManagerBis.getInstance().addBeacon(creation.getName(), new Beacon(new Memory(100)));
        break;
      default:
        System.out.println("Creation: " + creation.getName() + " non connue");
        break;
    }

  }

  @Override
  public void visitNumber(NumberValue numberValue)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void visitSymbol(SymbolValue symbolValue)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void visitArguments(Arguments arguments)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void visitArgument(Argument argument)
  {
    // TODO Auto-generated method stub

  }
}
