package hello1.example;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import hello1.generated.Hello1Lexer;
import hello1.generated.Hello1Parser;
import hello1.generated.Hello1Parser.MeetingContext;

public class Example1
{

  public static void main(String[] args)
  {
    String input = "Hello John";
    CharStream stream = CharStreams.fromString(input);
    TokenStream tokens = new CommonTokenStream(new Hello1Lexer(stream));
    Hello1Parser parser = new Hello1Parser(tokens);
    ParseTree tree = parser.meeting();

    System.out.println(tree.toStringTree());

    MeetingContext o = (MeetingContext) tree;

    System.out.println(o.toStringTree());

    System.out.println(o.met);

  }
}

// meeting   returns [String met] : 'Hello' ID { $met = "Meet " + $ID.getText(); };
