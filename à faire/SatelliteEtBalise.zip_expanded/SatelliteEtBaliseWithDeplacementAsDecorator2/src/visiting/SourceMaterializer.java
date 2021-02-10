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
import model.meta.Argument;
import model.meta.Arguments;
import model.meta.Assign;
import model.meta.Call;
import model.meta.Creation;
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
    values.put(ctx, map.get(ctx));// voir ligne 81 permets de mettre assign en tant que commande - liaison utile ?
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
    map.put(ctx.getParent(), assign); // coucou je suis la liaison
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
    Arguments arguments = new Arguments();
    if (ctx.arguments().arg() != null)
    {
      arguments = (Arguments) map.get(ctx.arguments().arg());
    }
    Call call = new Call(variable, action, arguments);
    map.put(ctx.getParent(), call); // coucou la liaison à une jumelle
    values.put(ctx, call);
    return r;
  }

  @Override
  public ParserRuleContext visitValueAssign(ValueAssignContext ctx)
  {
    System.out.println("visitValueAssign");
    ParserRuleContext r = super.visitValueAssign(ctx);
    values.put(ctx, map.get(ctx));
    return r;
  }

  @Override
  public ParserRuleContext visitCreation(CreationContext ctx)
  {
    System.out.println("visitCreation");
    ParserRuleContext r = super.visitCreation(ctx);
    String variable = ctx.VAR().getText();
    Arguments arguments = (Arguments) map.get(ctx.arguments());
    Creation creation = new Creation(variable, arguments);
    map.put(ctx.getParent(), creation);
    values.put(ctx, creation);
    return r;
  }

  @Override
  public ParserRuleContext visitValue(ValueContext ctx)
  {
    System.out.println("visitValue");
    ParserRuleContext r = super.visitValue(ctx);
    if (ctx.NB() != null)
    {
      NumberValue nv = new NumberValue(Integer.parseInt(ctx.NB().getText()));
      map.put(ctx.getParent(), nv);
      values.put(ctx, nv);
    }
    else
    {
      SymbolValue sv = new SymbolValue(ctx.SYMBOL().getText());
      map.put(ctx.getParent(), sv);
      values.put(ctx, sv);
    }

    return r;
  }

  @Override
  public ParserRuleContext visitArguments(ArgumentsContext ctx)
  {
    System.out.println("visitArguments");
    ParserRuleContext r = super.visitArguments(ctx);
    Iterator<ArgContext> itor = ctx.arg().iterator();
    ArrayList<Argument> listArguments = new ArrayList<>();
    while (itor.hasNext())
    {
      Argument arg = (Argument) map.get(itor.next());
      listArguments.add(arg);
    }
    Arguments arguments = new Arguments();
    arguments.addAll(listArguments);
    map.put(ctx, arguments);
    values.put(ctx, arguments);
    return r;
  }

  @Override
  public ParserRuleContext visitArg(ArgContext ctx)
  {
    System.out.println("visitArg");
    ParserRuleContext r = super.visitArg(ctx);
    String variable = ctx.VAR().getText();
    ValueAssign valueAssign = (ValueAssign) map.get(ctx.getChild(3));
    Argument argument = new Argument(variable, valueAssign);
    map.put(ctx, argument);
    values.put(ctx, argument);
    return r;
  }

}
