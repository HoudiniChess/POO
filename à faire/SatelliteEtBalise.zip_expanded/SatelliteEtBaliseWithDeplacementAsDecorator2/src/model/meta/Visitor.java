package model.meta;

import model.meta.value.Value;

public interface Visitor
{

  public void visitCall(Call call);

  public void visitAssign(Assign assign);

  public void visitScript(Script script);

  public void visitCreation(Creation creation);

  public void visitValue(Value value);

  public void visitArguments(Arguments arguments);

  public void visitArgument(Argument argument);

}
