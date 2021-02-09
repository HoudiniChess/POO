package model.meta;

public interface Visitor
{

  public void visitCall(Call call);

  public void visitAssign(Assign assign);

//  public void visitMeeting(Meeting meeting);
//
//  public void visitPratice(Practice practice);
//
//  public void visitSchedule(Schedule schedule);
//
//  public void visitSleeping(Sleeping sleeping);

}
