package model.meta;

import model.meta.value.NumberValue;
import model.meta.value.SymbolValue;

public interface Visitor
{

  public void visitCall(Call call);

  public void visitAssign(Assign assign);

  public void visitScript(Script script);

  public void visitCreation(Creation creation);

  public void visitNumber(NumberValue numberValue);

  public void visitSymbol(SymbolValue symbolValue);

  public void visitArguments(Arguments arguments);

  public void visitArgument(Argument argument);

//  public void visitMeeting(Meeting meeting);
//
//  public void visitPratice(Practice practice);
//
//  public void visitSchedule(Schedule schedule);
//
//  public void visitSleeping(Sleeping sleeping);

}
