package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import BalSat.generated.BalSatLexer;
import BalSat.generated.BalSatParser;
import command.AssignBeacon;
import model.ManagerBis;
import model.meta.BaseVisitor;
import model.meta.MMEntity;
import model.meta.Script;
import visiting.SourceMaterializer;

public class Application
{

  public static void main(String[] args)
  {
    startApplication();
  }

  protected static void startApplication()
  {
    Simulation simulation = new Simulation();
    ManagerBis.getInstance().setSimulation(simulation);
    Thread t1 = launch(simulation);
    Thread t2 = reader(simulation);
    t2.start();
    t1.start();
  }

  public static void baseVisitored(MMEntity entity)
  {
    BaseVisitor bv = new BaseVisitor();
    entity.accept(bv);
  }

  protected static Thread launchInput(Simulation simulation)
  {
    Thread t = new Thread()
    {
      @Override
      public void run()
      {
        InputStream is = System.in;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try
        {

          String input = br.readLine();

          CharStream stream = CharStreams.fromString(input);
          BalSatLexer lexer = new BalSatLexer(stream);
          TokenStream tokens = new CommonTokenStream(lexer);
          BalSatParser parser = new BalSatParser(tokens);
          ParseTree tree = parser.script();
          SourceMaterializer mat = new SourceMaterializer();
          mat.visit(tree);
          Script script = (Script) mat.resultFor((ParserRuleContext) tree);
          baseVisitored(script);
          AssignBeacon cmd = new AssignBeacon(simulation);
          cmd.execute();
          System.out.println(tree.toStringTree());

        }
        catch (IOException e)
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    };

    return t;

  }

  protected static Thread launch(Simulation simulation)
  {
    Thread t = new Thread()
    {
      @Override
      public void run()
      {
        String input = "bal1 = new Balise(); " + "sat1 = new Satellite(); " + "bal1.start();" + "sat1.start()";
        CharStream stream = CharStreams.fromString(input);
        BalSatLexer lexer = new BalSatLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        BalSatParser parser = new BalSatParser(tokens);
        ParseTree tree = parser.script();
        SourceMaterializer mat = new SourceMaterializer();
        mat.visit(tree);
        Script script = (Script) mat.resultFor((ParserRuleContext) tree);
        baseVisitored(script);
        AssignBeacon cmd = new AssignBeacon(simulation);
        cmd.execute();
        System.out.println(tree.toStringTree());
      };
    };
    return t;
  }

  protected static Thread reader(Simulation simulation)
  {
    Thread t = new Thread()
    {
      @Override
      public void run()
      {
        simulation.launch();
      }
    };

    return t;
  }

}