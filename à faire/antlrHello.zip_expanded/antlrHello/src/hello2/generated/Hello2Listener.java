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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Hello2Parser}.
 */
public interface Hello2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Hello2Parser#schedule}.
	 * @param ctx the parse tree
	 */
	void enterSchedule(Hello2Parser.ScheduleContext ctx);
	/**
	 * Exit a parse tree produced by {@link Hello2Parser#schedule}.
	 * @param ctx the parse tree
	 */
	void exitSchedule(Hello2Parser.ScheduleContext ctx);
	/**
	 * Enter a parse tree produced by {@link Hello2Parser#dayActivities}.
	 * @param ctx the parse tree
	 */
	void enterDayActivities(Hello2Parser.DayActivitiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Hello2Parser#dayActivities}.
	 * @param ctx the parse tree
	 */
	void exitDayActivities(Hello2Parser.DayActivitiesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code activities}
	 * labeled alternative in {@link Hello2Parser#actualActivities}.
	 * @param ctx the parse tree
	 */
	void enterActivities(Hello2Parser.ActivitiesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code activities}
	 * labeled alternative in {@link Hello2Parser#actualActivities}.
	 * @param ctx the parse tree
	 */
	void exitActivities(Hello2Parser.ActivitiesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noActivity}
	 * labeled alternative in {@link Hello2Parser#actualActivities}.
	 * @param ctx the parse tree
	 */
	void enterNoActivity(Hello2Parser.NoActivityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noActivity}
	 * labeled alternative in {@link Hello2Parser#actualActivities}.
	 * @param ctx the parse tree
	 */
	void exitNoActivity(Hello2Parser.NoActivityContext ctx);
	/**
	 * Enter a parse tree produced by {@link Hello2Parser#day}.
	 * @param ctx the parse tree
	 */
	void enterDay(Hello2Parser.DayContext ctx);
	/**
	 * Exit a parse tree produced by {@link Hello2Parser#day}.
	 * @param ctx the parse tree
	 */
	void exitDay(Hello2Parser.DayContext ctx);
	/**
	 * Enter a parse tree produced by {@link Hello2Parser#activity}.
	 * @param ctx the parse tree
	 */
	void enterActivity(Hello2Parser.ActivityContext ctx);
	/**
	 * Exit a parse tree produced by {@link Hello2Parser#activity}.
	 * @param ctx the parse tree
	 */
	void exitActivity(Hello2Parser.ActivityContext ctx);
	/**
	 * Enter a parse tree produced by {@link Hello2Parser#sleeping}.
	 * @param ctx the parse tree
	 */
	void enterSleeping(Hello2Parser.SleepingContext ctx);
	/**
	 * Exit a parse tree produced by {@link Hello2Parser#sleeping}.
	 * @param ctx the parse tree
	 */
	void exitSleeping(Hello2Parser.SleepingContext ctx);
	/**
	 * Enter a parse tree produced by {@link Hello2Parser#practice}.
	 * @param ctx the parse tree
	 */
	void enterPractice(Hello2Parser.PracticeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Hello2Parser#practice}.
	 * @param ctx the parse tree
	 */
	void exitPractice(Hello2Parser.PracticeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Hello2Parser#meeting}.
	 * @param ctx the parse tree
	 */
	void enterMeeting(Hello2Parser.MeetingContext ctx);
	/**
	 * Exit a parse tree produced by {@link Hello2Parser#meeting}.
	 * @param ctx the parse tree
	 */
	void exitMeeting(Hello2Parser.MeetingContext ctx);
	/**
	 * Enter a parse tree produced by {@link Hello2Parser#none}.
	 * @param ctx the parse tree
	 */
	void enterNone(Hello2Parser.NoneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Hello2Parser#none}.
	 * @param ctx the parse tree
	 */
	void exitNone(Hello2Parser.NoneContext ctx);
}