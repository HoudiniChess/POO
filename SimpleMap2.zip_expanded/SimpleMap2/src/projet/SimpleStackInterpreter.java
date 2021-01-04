package projet;

import java.util.Hashtable;
import java.util.Stack;

// Principe : 
// Pour un calcul les arguments sont récupérés dans la pile
//	- par pour un +, les opg et opd sont dépilé
// Quand le calcul est effectué, on empile le résultat
// Le parcous se fait en profondeur à gauche d'abord
// Le résultat courant est toujours en tête de pile
// A la fin du calcul d'une expression complete, la pile ne contient qu'un seul element, le résultat
//
// en entrée j'ai l'entier 9, le résultat est 9
// - le résultat du calcul pour une expression unaire est l'expression unaire elle-même
// en j'ai 2 * 3

public class SimpleStackInterpreter extends Visitor
{
  Stack<Expr> stk;
  Hashtable<String, Expr> variableValues = new Hashtable<String, Expr>();
  Hashtable<String, Variable> variables = new Hashtable<String, Variable>();

  public SimpleStackInterpreter()
  {
    stk = new Stack<Expr>();
  }

  @Override
  public void visitValExpr(VariableUse variableUse)
  {
    stk.push(variableValues.get(variableUse.val.name));
  }

  @Override
  public void visitIntExpr(IntExpr intExpr)
  {
    stk.push(intExpr);
  }

  @Override
  public void visitMultExpr(MultExpr multExpr)
  {
    Expr eg = multExpr.getOpg();
    Expr ed = multExpr.getOpd();
    eg.accept(this);
    ed.accept(this);
    IntExpr ied = (IntExpr) stk.pop();
    IntExpr ieg = (IntExpr) stk.pop();
    stk.push(new IntExpr(ied.getVal() * ieg.getVal()));
  }

  @Override
  public void visitPlusExpr(PlusExpr plusExpr)
  {
    Expr eg = plusExpr.getOpg();
    Expr ed = plusExpr.getOpd();
    eg.accept(this);
    ed.accept(this);
    IntExpr ied = (IntExpr) stk.pop();
    IntExpr ieg = (IntExpr) stk.pop();
    stk.push(new IntExpr(ied.getVal() + ieg.getVal()));
  }

  @Override
  public void visitPrintln(Println print)
  {
    IntExpr exp = (IntExpr) print.expr;
    exp.accept(this);
    System.out.println(((IntExpr) stk.pop()).getVal());
  }

  @Override
  public void visitAssignment(Assignment assign)
  {
    Variable var = assign.getVar();
    IntExpr exp = assign.getExp();
    var.accept(this);
    exp.accept(this);
    // var = (Variable) stk.pop().valeur();
    exp = (IntExpr) stk.pop();
  }

  @Override
  public void visitVariable(Variable var)
  {
    if (var.getName() != null)
    {
      variables.put("", var);
    }
  }

  public Expr result()
  {
    return stk.peek();
  }

}
