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
import command.ICommand;
import model.meta.Assign;
import model.meta.Script;
import model.meta.value.Value;

public class SourceMaterializer extends BalSatBaseVisitor<ParserRuleContext>
{
  ParseTreeProperty<Object> values = new ParseTreeProperty<Object>();

  protected HashMap<String, String> map;

  public SourceMaterializer()
  {
    this.map = new HashMap<String, String>();
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
    ArrayList<ICommand> commands = new ArrayList<ICommand>();
    while (itor.hasNext())
    {
      commands.add((ICommand) values.get(itor.next()));
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
    String variable = ctx.VAR().getText();
    String valueAssign = ctx.getChild(2).getText();
    switch (valueAssign)
    {
      case "value":
        System.out.println("VALUE SWITCH");
        ValueContext context = ctx.valueAssign().value();
        System.out.println("Mon Contexte de value : " + context);
        break;

      case "call":
        System.out.println();
        break;

      case "creation":
        break;

      default:
        break;
    }
    Assign assign = new Assign(variable, valueAssign);
//    CreationContext context = ctx.valueAssign().creation();
//    List<ArgContext> variables = context.arguments().arg();
//
//    for (ArgContext var : variables)
//    {
//      String valeur = var.VAR().getText();
//      String nb = var.valueAssign().value().NB().getText();
//      map.put(valeur, nb);
//    }

    System.out.println("Assign = " + assign.getVariable());
    return visitChildren(ctx);

  }

  @Override
  public ParserRuleContext visitCall(CallContext ctx)
  {
    System.out.println("visitCall");
    ParserRuleContext r = super.visitCall(ctx);
    String variable = ctx.VAR().get(0).getText();
    String action = ctx.VAR().get(1).getText();
    // Map<String, String> arguments = (Map<String, String>) values.get(ctx.arguments());

    switch (action)
    {
      case "start":
        System.out.println("Créer commande START");
        break;

      case "stop":
        System.out.println("Créer commande STOP");
        break;

      default:
        System.out.println("Throw UNDIFINED COMMAND");
        break;
    }
    return r;
  }

  @Override
  public ParserRuleContext visitValueAssign(ValueAssignContext ctx)
  {
    System.out.println("visitValueAssign");
    return visitChildren(ctx);
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
    // faire le switch pour récupérer soit un number soit un symbol
    System.out.println("visitValue");
    ParserRuleContext r = super.visitValue(ctx);
    values.put(ctx, values.get(ctx.getChild(0)));
    Value value = new Value(values.get(ctx.getChild(0)));
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
