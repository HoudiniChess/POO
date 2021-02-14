package tests;

import static org.junit.Assert.assertTrue;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import BalSat.generated.BalSatLexer;
import BalSat.generated.BalSatParser;
import model.ManagerBis;
import model.meta.Arguments;
import model.meta.Assign;
import model.meta.Call;
import model.meta.Creation;
import model.meta.Script;
import model.meta.value.Value;
import visiting.SourceMaterializer;

class TestScript
{

  // Test d'un assign
  @Test
  void testScriptCommandAssign()
  {
    String input = "bal1 = new Beacon (PointX = 100, PointY = 200, Deplacement = #horizontal, Memory = 100); ";
    CharStream stream = CharStreams.fromString(input);
    BalSatLexer lexer = new BalSatLexer(stream);
    TokenStream tokens = new CommonTokenStream(lexer);
    BalSatParser parser = new BalSatParser(tokens);
    ParseTree tree = parser.script();
    SourceMaterializer mat = new SourceMaterializer(ManagerBis.getInstance().getSimulation());
    mat.visit(tree);
    // Récupération du script, soit une liste de commmande.
    Script script = (Script) mat.resultFor((ParserRuleContext) tree);
    // Récupération de l'assign.
    Assign assign = (Assign) script.getCommands().get(0);
    assertTrue(assign.getVariable().equals("bal1"));
    // Récupération de la creation.
    Creation creation = (Creation) assign.getValue();
    assertTrue(creation.getVariable().equals("Beacon"));
    // Récupération des arguments.
    Arguments arguments = creation.getArguments();
    assertTrue(arguments.getArguments().get(0).getVariable().equals("PointX"));
    // Récupération du premier argument.
    Value value = (Value) arguments.getArguments().get(0).getValueAssign();
    assertTrue(value.getValeur().equals("100"));
  }

  // Test d'un Call
  @Test
  void testScriptCommandCall()
  {
    String input = "bal2.start(Speed = 2);";
    CharStream stream = CharStreams.fromString(input);
    BalSatLexer lexer = new BalSatLexer(stream);
    TokenStream tokens = new CommonTokenStream(lexer);
    BalSatParser parser = new BalSatParser(tokens);
    ParseTree tree = parser.script();
    SourceMaterializer mat = new SourceMaterializer(ManagerBis.getInstance().getSimulation());
    mat.visit(tree);

    // Récupération du script, soit une liste de commmande.
    Script script = (Script) mat.resultFor((ParserRuleContext) tree);
    // Récupération du call.
    Call call = (Call) script.getCommands().get(0);
    assertTrue(call.getVariable().equals("bal2"));
    assertTrue(call.getAction().equals("start"));
    // Récupération des arguments.
    Arguments arguments = call.getArguments();
    assertTrue(arguments.getArguments().get(0).getVariable().equals("Speed"));
    // Récupération de l'argument.
    Value value = (Value) arguments.getArguments().get(0).getValueAssign();
    assertTrue(value.getValeur().equals("2"));
  }

}
