package model.meta;

import java.util.Iterator;

import command.AssignCommand;
import model.ManagerBis;
import model.meta.value.NumberValue;
import model.meta.value.SymbolValue;
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
      ((Creation) assign.getValue()).accept(this, assign);
    }
    else if (assign.getValue() instanceof Value)
    {
      ((Value) assign.getValue()).accept(this, assign);
    }
    else if (assign.getValue() instanceof Call)
    {
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
  public void visitNumber(NumberValue numberValue)
  {
    System.out.println(numberValue.getValue());
    System.out.println(numberValue.getVariable());
    ManagerVariable.getInstance().getNumbers().put(numberValue.getVariable(), numberValue.getValue());
    numberValue.accept(this);
  }

  @Override
  public void visitSymbol(SymbolValue symbolValue)
  {
    ManagerVariable.getInstance().getSymbols().put(symbolValue.getVariable(), symbolValue.getSymbol());
    symbolValue.accept(this);
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
    System.out.println("Assign");
    // call utilité ?
    // stockage des variable ?
    if (argument.getValueAssign() instanceof Creation)
    {
      ((Creation) argument.getValueAssign()).accept(this, argument);
    }
    else if (argument.getValueAssign() instanceof Value)
    {
      ((Value) argument.getValueAssign()).accept(this, argument);
    }
    else if (argument.getValueAssign() instanceof Call)
    {
      argument.getValueAssign().accept(this);
    }
  }
}
