package hello1.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import hello1.generated.Hello1Lexer;
import hello1.generated.Hello1Parser;

public class Example2 {
	public static void main(String[] args) throws IOException {
		// read from standard input
		InputStream is = System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		String input = br.readLine(); 	// get first expression
		int line = 1; 					// track input expr line numbers

		Hello1Parser parser = new Hello1Parser(null); // share single parser instance
		
		while (input != null) { // while we have more expressions (Ctrl-D for EOF)
			CharStream stream = CharStreams.fromString(input);
			Hello1Lexer lexer = new Hello1Lexer(stream);

			lexer.setLine(line); // notify lexer of input position
			lexer.setCharPositionInLine(0);

			TokenStream tokens = new CommonTokenStream(lexer);
			parser.setInputStream(tokens);

			Hello1Parser.MeetingContext o = parser.meeting();
			System.out.println(o.met);
			input = br.readLine(); // see if there's another line
			line++;
		}
	}

}
