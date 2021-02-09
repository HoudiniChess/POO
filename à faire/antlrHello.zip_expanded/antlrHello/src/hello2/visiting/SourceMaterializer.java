package hello2.visiting;

import java.util.ArrayList;
import java.util.Iterator;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import hello2.generated.Hello2BaseVisitor;
import hello2.generated.Hello2Parser;
import hello2.generated.Hello2Parser.ActivitiesContext;
import hello2.generated.Hello2Parser.ActivityContext;
import hello2.generated.Hello2Parser.DayActivitiesContext;
import hello2.generated.Hello2Parser.DayContext;
import hello2.generated.Hello2Parser.MeetingContext;
import hello2.generated.Hello2Parser.NoActivityContext;
import hello2.generated.Hello2Parser.PracticeContext;
import hello2.generated.Hello2Parser.ScheduleContext;
import hello2.generated.Hello2Parser.SleepingContext;
import hello2.metamodel.Activity;
import hello2.metamodel.Day;
import hello2.metamodel.Meeting;
import hello2.metamodel.Practice;
import hello2.metamodel.Schedule;
import hello2.metamodel.Sleeping;

/*
 * schedule : dayActivities* ; dayActivities : day ':' actualActivity ; actualActivities : (activity)+ # activities |
 * none # noActivity ; day : ID ; activity : (sleeping | meeting | practice) ';' ; sleeping : 'Sleeping' NB ; practice :
 * 'Practice' ID NB ; meeting : 'Meeting' ID ; none : 'None' ';' ;
 * 
 * NB : [0-9]+ ; ID : [a-zA-Z]+ ; WS : [ \t\r\n]+ -> skip ;
 */

public class SourceMaterializer extends Hello2BaseVisitor<ParserRuleContext>
{
  ParseTreeProperty<Object> values = new ParseTreeProperty<Object>();

  public Object resultFor(ParserRuleContext ctx)
  {
    return values.get(ctx);
  }

  @Override
  public ParserRuleContext visitSchedule(ScheduleContext ctx)
  {
    ParserRuleContext r = super.visitSchedule(ctx);
    Iterator<DayActivitiesContext> itor = ctx.dayActivities().iterator();
    ArrayList<Day> days = new ArrayList<Day>();
    while (itor.hasNext())
    {
      days.add((Day) values.get(itor.next()));
    }
    Schedule schedule = new Schedule();
    schedule.addAllDays(days);
    values.put(ctx, schedule);
    return r;
  }

  @Override
  public ParserRuleContext visitDayActivities(DayActivitiesContext ctx)
  {
    ParserRuleContext r = super.visitDayActivities(ctx);
    Day day = (Day) values.get(ctx.day());
    @SuppressWarnings("unchecked")
    ArrayList<Activity> activities = (ArrayList<Activity>) values.get(ctx.actualActivities());
    if (activities != null)
    {
      day.addAllActivities(activities);
    }
    values.put(ctx, day);
    return r;
  }

  @Override
  public ParserRuleContext visitActivities(ActivitiesContext ctx)
  {
    ParserRuleContext r = super.visitActivities(ctx);
    Iterator<ActivityContext> itor = ctx.activity().iterator();
    ArrayList<Activity> activities = new ArrayList<Activity>();
    while (itor.hasNext())
    {
      activities.add((Activity) values.get(itor.next()));
    }
    values.put(ctx, activities);
    return r;
  }

  @Override
  public ParserRuleContext visitNoActivity(NoActivityContext ctx)
  {
    ParserRuleContext r = super.visitNoActivity(ctx);
    values.put(ctx, values.get(ctx.getChild(0)));
    return r;
  }

  @Override
  public ParserRuleContext visitDay(DayContext ctx)
  {
    ParserRuleContext r = super.visitDay(ctx);
    Day day = new Day(ctx.ID().getText());
    values.put(ctx, day);
    return r;
  }

  @Override
  public ParserRuleContext visitActivity(ActivityContext ctx)
  {
    ParserRuleContext r = super.visitActivity(ctx);
    values.put(ctx, values.get(ctx.getChild(0)));
    return r;
  }

  @Override
  public ParserRuleContext visitSleeping(SleepingContext ctx)
  {
    ParserRuleContext r = super.visitSleeping(ctx);
    Sleeping v = new Sleeping(Integer.valueOf(ctx.NB().getText()));
    values.put(ctx, v);
    return r;
  }

  @Override
  public ParserRuleContext visitPractice(PracticeContext ctx)
  {
    ParserRuleContext r = super.visitPractice(ctx);
    Practice v = new Practice(ctx.ID().getText(), Integer.valueOf(ctx.NB().getText()));
    values.put(ctx, v);
    return r;
  }

  @Override
  public ParserRuleContext visitMeeting(MeetingContext ctx)
  {
    ParserRuleContext r = super.visitMeeting(ctx);
    Meeting v = new Meeting(ctx.ID().getText());
    values.put(ctx, v);
    return r;
  }

  @Override
  public ParserRuleContext visitNone(Hello2Parser.NoneContext ctx)
  {
    values.put(ctx, null);
    return visitChildren(ctx);
  }

}
