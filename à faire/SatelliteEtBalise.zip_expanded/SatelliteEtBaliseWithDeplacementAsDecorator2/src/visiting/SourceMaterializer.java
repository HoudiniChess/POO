package visiting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import BalSat.generated.BalSatBaseVisitor;
import BalSat.generated.BalSatParser.ArgContext;
import BalSat.generated.BalSatParser.ArgumentsContext;
import BalSat.generated.BalSatParser.AssignContext;
import BalSat.generated.BalSatParser.CallContext;
import BalSat.generated.BalSatParser.CommandContext;
import BalSat.generated.BalSatParser.CreationContext;
import BalSat.generated.BalSatParser.ScriptContext;
import BalSat.generated.BalSatParser.ValueAssignContext;
import BalSat.generated.BalSatParser.ValueContext;
import model.meta.Arguments;
import model.meta.Assign;
import model.meta.Call;
import model.meta.ICommandLanguage;
import model.meta.Script;
import model.meta.ValueAssign;
import model.meta.value.NumberValue;
import model.meta.value.SymbolValue;

public class SourceMaterializer extends BalSatBaseVisitor<ParserRuleContext>
{
  ParseTreeProperty<Object> values = new ParseTreeProperty<Object>();

  protected HashMap<Object, Object> map;

  public SourceMaterializer()
  {
    this.map = new HashMap<>();
  }

  public Object resultFor(ParserRuleContext ctx)
  {
    return values.get(ctx);
  }

  @Override
  public ParserRuleContext visitScript(ScriptContext ctx)
  {
    System.out.println("visitScript");
    ParserRuleContext r = super.visitScript(ctx);
    Iterator<CommandContext> itor = ctx.command().iterator();
    ArrayList<ICommandLanguage> commands = new ArrayList<>();
    while (itor.hasNext())
    {
      ICommandLanguage cmd = (ICommandLanguage) map.get(itor.next());
      commands.add(cmd);
    }
    Script script = new Script();
    script.addAllCommands(commands);
    values.put(ctx, script);
    return r;

  }

  @Override
  public ParserRuleContext visitCommand(CommandContext ctx)
  {
    System.out.println("visitCommand");
    ParserRuleContext r = super.visitCommand(ctx);
    values.put(ctx, ctx.getChild(0));
    return r;
  }

  @Override
  public ParserRuleContext visitAssign(AssignContext ctx)
  {
    System.out.println("visitAssign");
    ParserRuleContext r = super.visitAssign(ctx);
    String variable = ctx.VAR().getText();
    ValueAssign valueAssign = (ValueAssign) map.get(ctx.getChild(2));
    Assign assign = new Assign(variable, valueAssign);
    values.put(ctx, assign);
    return r;
  }

  @Override
  public ParserRuleContext visitCall(CallContext ctx)
  {
    System.out.println("visitCall");
    ParserRuleContext r = super.visitCall(ctx);
    String variable = ctx.VAR().get(0).getText();
    String action = ctx.VAR().get(1).getText();
    Arguments arguments = (Arguments) map.get(ctx.arguments().arg());
    Call call = new Call(variable, action, arguments);
    values.put(ctx, call);
    return r;
  }

  @Override
  public ParserRuleContext visitValueAssign(ValueAssignContext ctx)
  {
    System.out.println("visitValueAssign");
    ParserRuleContext r = super.visitValueAssign(ctx);
    values.put(ctx, ctx.getChild(0));
    return r;
  }

  @Override
  public ParserRuleContext visitCreation(CreationContext ctx)
  {
    System.out.println("visitCreation");
    return super.visitCreation(ctx);
  }

  @Override
  public ParserRuleContext visitValue(ValueContext ctx)
  {
    System.out.println("visitValue");
    ParserRuleContext r = super.visitValue(ctx);
    if (ctx.NB() != null)
    {
      NumberValue nv = new NumberValue(Integer.parseInt(ctx.NB().getText()));
      map.put(ctx, nv);
      values.put(ctx, nv);
    }
    else
    {
      SymbolValue sv = new SymbolValue(ctx.SYMBOL().getText());
      map.put(ctx, sv);
      values.put(ctx, sv);
    }

    return r;
  }

  @Override
  public ParserRuleContext visitArguments(ArgumentsContext ctx)
  {
    System.out.println("visitArguments");
    return visitChildren(ctx);
  }

  @Override
  public ParserRuleContext visitArg(ArgContext ctx)
  {
    System.out.println("visitArg");
    return visitChildren(ctx);
  }

}
