package visiting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import BalSat.generated.BalSatLexer;
import BalSat.generated.BalSatParser;
import model.meta.Script;
import simulation.Simulation;

class SourceMaterializerTest
{

  protected BalSatParser parserFor(String input)
  {
    CharStream stream = CharStreams.fromString(input);
    BalSatLexer lexer = new BalSatLexer(stream);
    TokenStream tokens = new CommonTokenStream(lexer);
    BalSatParser parser = new BalSatParser(tokens);
    return parser;
  }

  @Test
  void testAssignBalise()
  {
    String input = "bal = new Beacon(Memory=100);";
    Simulation simul = new Simulation();
    BalSatParser parser = this.parserFor(input);
    ParseTree tree = parser.script();
    SourceMaterializer mat = new SourceMaterializer(simul);
    mat.visit(tree);
    Script script = (Script) mat.resultFor((ParserRuleContext) tree);
    assertTrue(input.equals(script));
  }

//  @Test
//  void test2()
//  {
//    String input = "Practice swimming 1";
//    Hello2Parser parser = this.parserFor(input);
//    ParseTree tree = parser.practice();
//    SourceMaterializer mat = new SourceMaterializer();
//    mat.visit(tree);
//    assertTrue(mat.resultFor((ParserRuleContext) tree) instanceof Practice);
//    Practice r = (Practice) mat.resultFor((ParserRuleContext) tree);
//    assertTrue(r.getDuration() == 1);
//    assertTrue(r.getWhat().equals("swimming"));
//  }
//
//  @Test
//  void test3()
//  {
//    String input = "Practice swimming 1;";
//    Hello2Parser parser = this.parserFor(input);
//    ParseTree tree = parser.activity();
//    SourceMaterializer mat = new SourceMaterializer();
//    mat.visit(tree);
//    assertTrue(mat.resultFor((ParserRuleContext) tree) instanceof Practice);
//    Practice r = (Practice) mat.resultFor((ParserRuleContext) tree);
//    assertTrue(r.getDuration() == 1);
//    assertTrue(r.getWhat().equals("swimming"));
//  }
//
//  @Test
//  void test4()
//  {
//    String input = "lundi : Practice swimming 1; Meeting bill;\n";
//    Hello2Parser parser = this.parserFor(input);
//    ParseTree tree = parser.dayActivities();
//    SourceMaterializer mat = new SourceMaterializer();
//    mat.visit(tree);
//    assertTrue(mat.resultFor((ParserRuleContext) tree) instanceof Day);
//    Day day = (Day) mat.resultFor((ParserRuleContext) tree);
//    assertTrue(day.getWhich().equals("lundi"));
//    assertTrue(day.haveActivities());
//    Activity[] activities = day.getActivitiesArray();
//    assertTrue(activities != null);
//    assertTrue(activities.length == 2);
//    assertTrue(activities[0] instanceof Practice);
//    assertTrue(activities[1] instanceof Meeting);
//    Practice practice = (Practice) activities[0];
//    assertTrue(practice.getDuration() == 1);
//    assertTrue(practice.getWhat().equals("swimming"));
//    Meeting meeting = (Meeting) activities[1];
//    assertTrue(meeting.getWho().equals("bill"));
//  }
//
//  @Test
//  void test5()
//  {
//    String input = "lundi : None;\n";
//    Hello2Parser parser = this.parserFor(input);
//    ParseTree tree = parser.dayActivities();
//    SourceMaterializer mat = new SourceMaterializer();
//    mat.visit(tree);
//    assertTrue(mat.resultFor((ParserRuleContext) tree) instanceof Day);
//    Day day = (Day) mat.resultFor((ParserRuleContext) tree);
//    assertTrue(day.getWhich().equals("lundi"));
//    assertFalse(day.haveActivities());
//    Activity[] activities = day.getActivitiesArray();
//    assertTrue(activities == null);
//  }
}
