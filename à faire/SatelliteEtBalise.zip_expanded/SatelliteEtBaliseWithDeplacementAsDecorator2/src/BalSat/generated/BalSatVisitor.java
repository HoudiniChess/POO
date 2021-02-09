// Generated from BalSat.g4 by ANTLR 4.9.1
package BalSat.generated;


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BalSatParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BalSatVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BalSatParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(BalSatParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link BalSatParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(BalSatParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link BalSatParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(BalSatParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link BalSatParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(BalSatParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link BalSatParser#valueAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueAssign(BalSatParser.ValueAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link BalSatParser#creation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreation(BalSatParser.CreationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BalSatParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(BalSatParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link BalSatParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(BalSatParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BalSatParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(BalSatParser.ArgContext ctx);
}