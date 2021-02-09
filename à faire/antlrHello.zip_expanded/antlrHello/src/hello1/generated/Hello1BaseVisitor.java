// Generated from Hello1.g4 by ANTLR 4.9
package hello1.generated;

// antlr exo1

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link Hello1Visitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class Hello1BaseVisitor<T> extends AbstractParseTreeVisitor<T> implements Hello1Visitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitMeeting(Hello1Parser.MeetingContext ctx) { return visitChildren(ctx); }
}