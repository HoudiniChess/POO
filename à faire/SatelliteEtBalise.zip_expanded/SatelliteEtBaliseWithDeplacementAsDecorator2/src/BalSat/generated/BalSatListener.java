// Generated from BalSat.g4 by ANTLR 4.9.1
package BalSat.generated;


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BalSatParser}.
 */
public interface BalSatListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BalSatParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(BalSatParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link BalSatParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(BalSatParser.ScriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link BalSatParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(BalSatParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link BalSatParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(BalSatParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link BalSatParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(BalSatParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link BalSatParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(BalSatParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link BalSatParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(BalSatParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link BalSatParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(BalSatParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link BalSatParser#valueAssign}.
	 * @param ctx the parse tree
	 */
	void enterValueAssign(BalSatParser.ValueAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link BalSatParser#valueAssign}.
	 * @param ctx the parse tree
	 */
	void exitValueAssign(BalSatParser.ValueAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link BalSatParser#creation}.
	 * @param ctx the parse tree
	 */
	void enterCreation(BalSatParser.CreationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BalSatParser#creation}.
	 * @param ctx the parse tree
	 */
	void exitCreation(BalSatParser.CreationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BalSatParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(BalSatParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link BalSatParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(BalSatParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link BalSatParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(BalSatParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BalSatParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(BalSatParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BalSatParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(BalSatParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link BalSatParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(BalSatParser.ArgContext ctx);
}