package model.meta;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.concurrent.Callable;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import BalSat.generated.BalSatLexer;
import BalSat.generated.BalSatParser;
import command.AssignCommand;
import command.CallCommand;
import model.ManagerBis;
import model.meta.value.Value;
import simulation.Simulation;
import visiting.SourceMaterializer;

public class BaseVisitor implements Visitor, Callable<Void>
{

  protected Simulation simulation;

  public BaseVisitor(Simulation simulation)
  {
    this.simulation = simulation;
    simulation.executor.submit(this);
  }

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
    call.arguments.accept(this);
    ManagerBis.getInstance().setUpCall(call.arguments.getArguments());
    CallCommand command = new CallCommand(call.getVariable(), call.getAction());
    command.execute(simulation);
  }

  @Override
  public void visitAssign(Assign assign)
  {

    if (assign.getValue() instanceof Creation)
    {
      System.out.println("Assign-Creation");

      ((Creation) assign.getValue()).accept(this, assign);
      Creation create = (Creation) assign.getValue();
      ManagerBis.getInstance().setUpAssign(create.arguments.getArguments());
      AssignCommand cmd = new AssignCommand(assign.variable);
      cmd.execute(simulation);
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
    ManagerBis.getInstance().setUpInstance(creation.getVariable());
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

    if (argument.getValueAssign() instanceof Creation)
    {
      System.out.println("Assign-Creation");
      ((Creation) argument.getValueAssign()).accept(this, argument);
    }
    else if (argument.getValueAssign() instanceof Value)
    {
      ((Value) argument.getValueAssign()).accept(this, argument);
    }
    else if (argument.getValueAssign() instanceof Call)
    {
      System.out.println("Assign-Call");
      System.out.println(argument.getValueAssign() + " MA VALUEEEEEEEEEEEEEEEEEEEEEEE");
      argument.getValueAssign().accept(this);
    }
  }

  @Override
  public Void call() throws Exception
  {
    InputStream is = System.in;
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    System.out.println("Input Command - " + "commande.liste();" + " pour la liste des commandes dispo");
    boolean flag = true;
    do
    {
      String input = br.readLine();

      if (input.equals("exit"))
      {
        flag = false;
      }
      CharStream stream = CharStreams.fromString(input);
      BalSatLexer lexer = new BalSatLexer(stream);
      TokenStream tokens = new CommonTokenStream(lexer);
      BalSatParser parser = new BalSatParser(tokens);
      ParseTree tree = parser.script();
      SourceMaterializer mat = new SourceMaterializer(ManagerBis.getInstance().getSimulation());
      mat.visit(tree);
      Script script = (Script) mat.resultFor((ParserRuleContext) tree);
      baseVisitored(script, simulation);
      System.out.println(tree.toStringTree());
    }
    while (flag);
    System.out.println("Fin du Script");
    return null;
  }

//@Override
//public Void call() throws Exception
//{
//  ManagerBis.getInstance().getSimulation().executor.submit(this);
//  InputStream is = System.in;
//  BufferedReader br = new BufferedReader(new InputStreamReader(is));
//  System.out.println("Input Command - LIST(); pour la liste des commandes dispo");
//  boolean flag = true;
//  do
//  {
//    String input = "bal1 = new Beacon (PointX = 400, PointY = 200, Deplacement = #horizontal, Memory = 100);"
//        + "bal2 = new Beacon (PointX = 300, PointY = 300, Deplacement = #sinusoidale, Memory = 100);"
//        + "bal3 = new Beacon (PointX = 400, PointY = 150, Deplacement = #vertical, Memory = 100);"
//        + "sat1 = new Satellite (PointX = 100, PointY = 50, Deplacement = #satelliteMouvement, Memory = 1000);"
//        + "bal1.start(Speed = 2);" + "sat1.start(Speed = 2);"
//        + "sat2 = new Satellite (PointX = 50, PointY = 80, Deplacement = #satelliteMouvement, Memory = 1000);"
//        + "sat1.stop();" + "sat2.start();";
//
//    if (input.equals("exit"))
//    {
//      flag = false;
//    }
//    CharStream stream = CharStreams.fromString(input);
//    BalSatLexer lexer = new BalSatLexer(stream);
//    TokenStream tokens = new CommonTokenStream(lexer);
//    BalSatParser parser = new BalSatParser(tokens);
//    ParseTree tree = parser.script();
//    SourceMaterializer mat = new SourceMaterializer(ManagerBis.getInstance().getSimulation());
//    mat.visit(tree);
//    Script script = (Script) mat.resultFor((ParserRuleContext) tree);
//    baseVisitored(script, ManagerBis.getInstance().getSimulation());
//  }
//  while (flag);
//  System.out.println("Fin du Script");
//  return null;
//}

  public static void baseVisitored(MMEntity entity, Simulation simulation)
  {
    BaseVisitor bv = new BaseVisitor(simulation);

    entity.accept(bv);
  }
}