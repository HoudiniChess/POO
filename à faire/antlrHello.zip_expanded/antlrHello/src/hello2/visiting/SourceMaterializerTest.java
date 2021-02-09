package hello2.visiting;

import static org.junit.jupiter.api.Assertions.*;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import hello2.generated.Hello2Lexer;
import hello2.generated.Hello2Parser;
import hello2.metamodel.Activity;
import hello2.metamodel.Day;
import hello2.metamodel.MMEntity;
import hello2.metamodel.Meeting;
import hello2.metamodel.Practice;
import hello2.metamodel.PrettyPrinter;
import hello2.metamodel.Schedule;

class SourceMaterializerTest {

	protected Hello2Parser parserFor(String input) {
		CharStream stream = CharStreams.fromString(input);
		TokenStream tokens = new CommonTokenStream(new Hello2Lexer(stream));
		Hello2Parser parser = new Hello2Parser(tokens);
		return parser;
	}
	
	public String prettyPrinted(MMEntity entity) {
		PrettyPrinter pp = new PrettyPrinter();
		entity.accept(pp);
		return pp.result();
	}
	
	@Test
	void test1() {
		String input = 
				"lundi : Sleeping 10; Practice swimming 1; Meeting John;\n"
				+ "mardi : Sleeping 7; Practice running 2; Meeting Bill;\n"
				+ "mercredi : Meeting Ralph;\n"
				+ "jeudi : None;\n"
				+ "vendredi : Meeting Ralph;\n";
		Hello2Parser parser = this.parserFor(input);
		ParseTree tree = parser.schedule();
		SourceMaterializer mat = new SourceMaterializer();
		mat.visit(tree);
		Schedule schedule = (Schedule) mat.resultFor((ParserRuleContext) tree);
		assertTrue(input.equals(prettyPrinted(schedule)));
	}
	
	@Test
	void test2() {
		String input = "Practice swimming 1";
		Hello2Parser parser = this.parserFor(input);
		ParseTree tree = parser.practice();
		SourceMaterializer mat = new SourceMaterializer();
		mat.visit(tree);
		assertTrue (mat.resultFor((ParserRuleContext) tree) instanceof Practice);
		Practice r = (Practice) mat.resultFor((ParserRuleContext) tree);
		assertTrue (r.getDuration() == 1);
		assertTrue (r.getWhat().equals("swimming"));
	}

	@Test
	void test3() {
		String input = "Practice swimming 1;";
		Hello2Parser parser = this.parserFor(input);
		ParseTree tree = parser.activity();
		SourceMaterializer mat = new SourceMaterializer();
		mat.visit(tree);
		assertTrue (mat.resultFor((ParserRuleContext) tree) instanceof Practice);
		Practice r = (Practice) mat.resultFor((ParserRuleContext) tree);
		assertTrue (r.getDuration() == 1);
		assertTrue (r.getWhat().equals("swimming"));
	}
	
	@Test
	void test4() {
		String input = "lundi : Practice swimming 1; Meeting bill;\n";
		Hello2Parser parser = this.parserFor(input);
		ParseTree tree = parser.dayActivities();
		SourceMaterializer mat = new SourceMaterializer();
		mat.visit(tree);
		assertTrue (mat.resultFor((ParserRuleContext) tree) instanceof Day);
		Day day = (Day) mat.resultFor((ParserRuleContext) tree);
		assertTrue(day.getWhich().equals("lundi"));
		assertTrue(day.haveActivities());
		Activity [] activities = day.getActivitiesArray();
		assertTrue(activities != null);
		assertTrue(activities.length == 2);
		assertTrue(activities[0] instanceof Practice);
		assertTrue(activities[1] instanceof Meeting);
		Practice practice = (Practice) activities[0];
		assertTrue (practice.getDuration() == 1);
		assertTrue (practice.getWhat().equals("swimming"));
		Meeting meeting = (Meeting) activities[1];
		assertTrue(meeting.getWho().equals("bill"));
	}
	@Test
	void test5() {
		String input = "lundi : None;\n";
		Hello2Parser parser = this.parserFor(input);
		ParseTree tree = parser.dayActivities();
		SourceMaterializer mat = new SourceMaterializer();
		mat.visit(tree);
		assertTrue (mat.resultFor((ParserRuleContext) tree) instanceof Day);
		Day day = (Day) mat.resultFor((ParserRuleContext) tree);
		assertTrue(day.getWhich().equals("lundi"));
		assertFalse(day.haveActivities());
		Activity [] activities = day.getActivitiesArray();
		assertTrue(activities == null);
	}
}
