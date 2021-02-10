package model.meta;

import java.util.Iterator;

public class BaseVisitor implements Visitor
{
  @Override
  public void visitScript(Script script)
  {
    Iterator<ICommandLanguage> itor = script.commmandsIterator();
    while (itor.hasNext())
    {
      itor.next().accept(this);
    }
  }

  @Override
  public void visitCall(Call call)
  {
    System.out.println("Variable = " + call.getVariable());
    System.out.println(call.getAction());

  }

  @Override
  public void visitAssign(Assign assign)
  {
    System.out.println("Variable = " + assign.getVariable());

  }
}
