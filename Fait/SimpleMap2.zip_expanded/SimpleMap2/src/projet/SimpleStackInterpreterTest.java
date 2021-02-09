package projet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SimpleStackInterpreterTest
{

  @Test
  void testCalculs()
  {

    SimpleStackInterpreter interpreter = new SimpleStackInterpreter();

    // Test avec une valeur simple
    Expr e1 = new IntExpr(9);
    e1.accept(interpreter);
    assertTrue(interpreter.result() instanceof IntExpr);
    IntExpr ie = (IntExpr) interpreter.result();
    assertTrue(ie.getVal() == 9);

    // Test avec la multiplication de deux valeurs
    Expr e2 = new IntExpr(2);
    Expr mult1 = new MultExpr(e1, e2);
    mult1.accept(interpreter);
    assertTrue(interpreter.result() instanceof IntExpr);
    ie = (IntExpr) interpreter.result();
    assertTrue(ie.getVal() == 18);

    // Test avec l'addition de deux valeurs
    Expr plus1 = new PlusExpr(e1, e2);
    plus1.accept(interpreter);
    assertTrue(interpreter.result() instanceof IntExpr);
    ie = (IntExpr) interpreter.result();
    assertTrue(ie.getVal() == 11);

    // Test avec la multiplication de deux résultats d'opération
    Expr mult2 = new MultExpr(mult1, plus1);
    mult2.accept(interpreter);
    assertTrue(interpreter.result() instanceof IntExpr);
    ie = (IntExpr) interpreter.result();
    assertTrue(ie.getVal() == 198);

  }

  @Test
  void testVisiteur()
  {

    SimpleStackInterpreter interpreter = new SimpleStackInterpreter();

    // Initialisation des valeurs

    Expr trente = new IntExpr(30);
    trente.accept(interpreter);
    assertEquals(30, ((IntExpr) trente).getVal());

    Expr neuf = new IntExpr(9);
    neuf.accept(interpreter);
    IntExpr ie = (IntExpr) interpreter.result();

    Expr sept = new IntExpr(7);
    sept.accept(interpreter);
    assertEquals(7, ((IntExpr) sept).getVal());

    Expr quatre = new IntExpr(4);
    quatre.accept(interpreter);
    assertEquals(4, ((IntExpr) quatre).getVal());

    Expr trois = new IntExpr(3);
    trois.accept(interpreter);
    assertEquals(3, ((IntExpr) trois).getVal());

    Expr deux = new IntExpr(2);
    deux.accept(interpreter);
    assertEquals(2, ((IntExpr) deux).getVal());

    // Initialisation opération plus
    Expr plus = new PlusExpr(neuf, trois);
    plus.accept(interpreter);

    // Initialisation opération mult
    Expr mult2 = new MultExpr(deux, trois);
    mult2.accept(interpreter);

    // Test du print d'une valeur
    Println print = new Println(quatre);
    print.accept(interpreter);

    // Création des variables
    Variable var = new Variable("a");
    var.accept(interpreter);
    assertEquals("a", var.getName());

    Variable var1 = new Variable("b");
    var1.accept(interpreter);
    assertEquals("b", var1.getName());

    Variable var2 = new Variable("c");
    var2.accept(interpreter);
    assertEquals("c", var2.getName());

    Variable var3 = new Variable("x");
    var3.accept(interpreter);
    assertEquals("x", var3.getName());

    Variable var4 = new Variable("y");
    var4.accept(interpreter);
    assertEquals("y", var4.getName());

    // Assignement de valeurs à des variables
    Assignment assign = new Assignment(var, quatre);
    assign.accept(interpreter);

    Assignment assign1 = new Assignment(var1, trois);
    assign1.accept(interpreter);

    Assignment assign2 = new Assignment(var2, deux);
    assign2.accept(interpreter);

    Assignment assign3 = new Assignment(var3, trente);
    assign3.accept(interpreter);

    Assignment assign4 = new Assignment(var4, sept);
    assign4.accept(interpreter);

    // Mise en place de la futur utilisation des variables
    VariableUse varUse = new VariableUse(assign.getVar());
    varUse.accept(interpreter);

    VariableUse varUse1 = new VariableUse(assign1.getVar());
    varUse1.accept(interpreter);

    VariableUse varUse2 = new VariableUse(assign2.getVar());
    varUse2.accept(interpreter);

    VariableUse varUse3 = new VariableUse(assign3.getVar());
    varUse3.accept(interpreter);

    VariableUse varUse4 = new VariableUse(assign4.getVar());
    varUse4.accept(interpreter);

    // Test d'ajout d'une valeur à une variable
    Expr plus2 = new PlusExpr(neuf, varUse);
    plus2.accept(interpreter);
    assertTrue(interpreter.result() instanceof IntExpr);
    ie = (IntExpr) interpreter.result();
    assertTrue(ie.getVal() == 13);

    // Test de multiplication d'une valeur à une variable
    Expr mult3 = new MultExpr(neuf, varUse1);
    mult3.accept(interpreter);
    assertTrue(interpreter.result() instanceof IntExpr);
    ie = (IntExpr) interpreter.result();
    assertTrue(ie.getVal() == 27);

    // Test d'ajout d'une variable à une autre variable
    Expr plus3 = new PlusExpr(varUse1, varUse);
    plus3.accept(interpreter);
    assertTrue(interpreter.result() instanceof IntExpr);
    ie = (IntExpr) interpreter.result();
    assertTrue(ie.getVal() == 7);

    // Test de multiplication de deux variables
    Expr mult4 = new MultExpr(varUse2, varUse1);
    mult4.accept(interpreter);
    assertTrue(interpreter.result() instanceof IntExpr);
    ie = (IntExpr) interpreter.result();
    assertTrue(ie.getVal() == 6);

    // Test de multiplication d'une variable et d'une opération d'addition
    Expr plus4 = new PlusExpr(varUse3, plus);
    plus4.accept(interpreter);
    assertTrue(interpreter.result() instanceof IntExpr);
    ie = (IntExpr) interpreter.result();
    assertTrue(ie.getVal() == 42);

    // Test de multiplication d'une variable et d'une opération de mult
    Expr mult5 = new MultExpr(varUse4, mult2);
    mult5.accept(interpreter);
    assertTrue(interpreter.result() instanceof IntExpr);
    ie = (IntExpr) interpreter.result();
    assertTrue(ie.getVal() == 42);

    // Affichage du résultat de la multiplication
    Println print2 = new Println(mult5);
    print2.accept(interpreter);

  }

}
