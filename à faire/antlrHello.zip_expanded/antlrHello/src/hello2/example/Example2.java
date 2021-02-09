package hello2.example;

import javax.xml.transform.TransformerException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import hello2.generated.Hello2Lexer;
import hello2.generated.Hello2Parser;
import hello2.metamodel.MMEntity;
import hello2.metamodel.PrettyPrinter;
import hello2.metamodel.Schedule;
import hello2.metamodel.XMLSerializer;
import hello2.visiting.SourceMaterializer;

public class Example2
{

  protected static Hello2Parser parserFor(String input)
  {
    CharStream stream = CharStreams.fromString(input);
    TokenStream tokens = new CommonTokenStream(new Hello2Lexer(stream));
    Hello2Parser parser = new Hello2Parser(tokens);
    return parser;
  }

  public static String prettyPrinted(MMEntity entity)
  {
    PrettyPrinter pp = new PrettyPrinter();
    entity.accept(pp);
    return pp.result();
  }

  public static void main(String[] args) throws TransformerException
  {
    String input = "lundi : Sleeping 10; Practice swimming 1; Meeting John;\n"
        + "mardi : Sleeping 7; Practice running 2; Meeting Bill;\n" + "mercredi : Meeting Ralph;\n" + "jeudi : None;\n"
        + "vendredi : Meeting Ralph;\n";
    Hello2Parser parser = parserFor(input);
    ParseTree tree = parser.schedule();
    SourceMaterializer mat = new SourceMaterializer();
    mat.visit(tree);
    Schedule schedule = (Schedule) mat.resultFor((ParserRuleContext) tree);
    System.out.println(prettyPrinted(schedule));
    XMLSerializer serializer = new XMLSerializer();
    System.out.println(serializer.xmlContents(schedule));
  }

}

/*
 * lundi : Sleeping 10; Practice swimming 1; Meeting John; mardi : Sleeping 7; Practice running 2; Meeting Bill;
 * mercredi : Meeting Ralph; jeudi : None; vendredi : Meeting Ralph;
 * 
 * <?xml version="1.0" encoding="UTF-8" standalone="no"?> <root xmlns="univ-brest.fr"> <schedule> <day which="lundi">
 * <sleeping duration="10"/> <practice duration="1" what="swimming"/> <meeting who="John"/> </day> <day which="mardi">
 * <sleeping duration="7"/> <practice duration="2" what="running"/> <meeting who="Bill"/> </day> <day which="mercredi">
 * <meeting who="Ralph"/> </day> <day which="jeudi"/> <day which="vendredi"> <meeting who="Ralph"/> </day> </schedule>
 * </root>
 * 
 */
