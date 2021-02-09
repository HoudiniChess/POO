// Generated from Hello1.g4 by ANTLR 4.9
package hello1.generated;

// antlr exo1

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Hello1Parser}.
 */
public interface Hello1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Hello1Parser#meeting}.
	 * @param ctx the parse tree
	 */
	void enterMeeting(Hello1Parser.MeetingContext ctx);
	/**
	 * Exit a parse tree produced by {@link Hello1Parser#meeting}.
	 * @param ctx the parse tree
	 */
	void exitMeeting(Hello1Parser.MeetingContext ctx);
}