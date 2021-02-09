// Generated from Hello2.g4 by ANTLR 4.9.1
package hello2.generated;

// example :
// lundi : Sleeping 10; Practice swimming 1; Meeting John;
// mardi : Sleeping 7; Practice running 2; Meeting Bill;
// mercredi : None;

// Exercice : Compléter l'exemple 2 avec :
// - Méta-modélisation : Spécifier un méta-modèle pour le langage en Java
// - Outils d'analyse : Construire un visiteur "Antlr" pour construire les instances de votre méta-model
// - Back-end XML : Construire un visiteur "classique" pour produire du XML à partir des instances du méta-model

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Hello2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Hello2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Hello2Parser#schedule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchedule(Hello2Parser.ScheduleContext ctx);
	/**
	 * Visit a parse tree produced by {@link Hello2Parser#dayActivities}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDayActivities(Hello2Parser.DayActivitiesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code activities}
	 * labeled alternative in {@link Hello2Parser#actualActivities}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActivities(Hello2Parser.ActivitiesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noActivity}
	 * labeled alternative in {@link Hello2Parser#actualActivities}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoActivity(Hello2Parser.NoActivityContext ctx);
	/**
	 * Visit a parse tree produced by {@link Hello2Parser#day}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDay(Hello2Parser.DayContext ctx);
	/**
	 * Visit a parse tree produced by {@link Hello2Parser#activity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActivity(Hello2Parser.ActivityContext ctx);
	/**
	 * Visit a parse tree produced by {@link Hello2Parser#sleeping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSleeping(Hello2Parser.SleepingContext ctx);
	/**
	 * Visit a parse tree produced by {@link Hello2Parser#practice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPractice(Hello2Parser.PracticeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Hello2Parser#meeting}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeeting(Hello2Parser.MeetingContext ctx);
	/**
	 * Visit a parse tree produced by {@link Hello2Parser#none}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNone(Hello2Parser.NoneContext ctx);
}