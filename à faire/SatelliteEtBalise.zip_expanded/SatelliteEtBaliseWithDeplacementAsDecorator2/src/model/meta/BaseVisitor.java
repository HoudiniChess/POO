package model.meta;

import java.util.Iterator;

import command.AssignCommand;
import model.ManagerBis;
import model.meta.value.Value;

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
    // call utilité ?
    // stockage des variable ?
    if (assign.getValue() instanceof Creation)
    {
      System.out.println("Assign-Creation");
      ((Creation) assign.getValue()).accept(this, assign);
    }
    else if (assign.getValue() instanceof Value)
    {
      System.out.println("Assign-Value");
      ((Value) assign.getValue()).accept(this, assign);
    }
    else if (assign.getValue() instanceof Call)
    {
      System.out.println("Assign-Call");
      assign.getValue().accept(this);
    }

  }

  @Override
  public void visitCreation(Creation creation)
  {
    creation.arguments.accept(this);
    AssignCommand cmd = new AssignCommand(creation.arguments.getArguments());
    cmd.execute(ManagerBis.getInstance().getSimulation());
  }

  @Override
  public void visitValue(Value value)
  {
    System.out.println("value");
    ManagerVariable.getInstance().getValues().put(value.getVariable(), value.getValeur());
  }

  @Override
  public void visitArguments(Arguments arguments)
  {
    for (Argument currentArg : arguments.getArguments())
    {
      currentArg.accept(this);
    }

  }

  @Override
  public void visitArgument(Argument argument)
  {
    // call utilité ?
    // stockage des variable ?
    if (argument.getValueAssign() instanceof Creation)
    {
      System.out.println("Assign-Creation");
      ((Creation) argument.getValueAssign()).accept(this, argument);
    }
    else if (argument.getValueAssign() instanceof Value)
    {
      System.out.println("Assign-Value");
      ((Value) argument.getValueAssign()).accept(this, argument);
    }
    else if (argument.getValueAssign() instanceof Call)
    {
      System.out.println("Assign-Call");
      argument.getValueAssign().accept(this);
    }
  }
}
