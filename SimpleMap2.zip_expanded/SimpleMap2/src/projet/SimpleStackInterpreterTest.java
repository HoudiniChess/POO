package projet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SimpleStackInterpreterTest
{

  @Test
  void test()
  {
    Expr e1 = new IntExpr(9);
    SimpleStackInterpreter interpreter = new SimpleStackInterpreter();
    e1.accept(interpreter);
    assertTrue(interpreter.result() instanceof IntExpr);
    IntExpr ie = (IntExpr) interpreter.result();
    assertTrue(ie.getVal() == 9);
    Expr e2 = new IntExpr(2);
    Expr mult1 = new MultExpr(e1, e2);
    mult1.accept(interpreter);
    assertTrue(interpreter.result() instanceof IntExpr);
    ie = (IntExpr) interpreter.result();
    assertTrue(ie.getVal() == 18);
    Expr plus1 = new PlusExpr(e1, e2);
    plus1.accept(interpreter);
    assertTrue(interpreter.result() instanceof IntExpr);
    ie = (IntExpr) interpreter.result();
    assertTrue(ie.getVal() == 11);
    Expr mult2 = new MultExpr(mult1, plus1);
    mult2.accept(interpreter);
    assertTrue(interpreter.result() instanceof IntExpr);
    ie = (IntExpr) interpreter.result();
    assertTrue(ie.getVal() == 198);

  }

  @Test
  void testPrintln()
  {
    IntExpr quatre = new IntExpr(4);
    assertEquals(4, quatre.getVal());
    Println print = new Println(quatre);

    SimpleStackInterpreter interpreter = new SimpleStackInterpreter();
    print.accept(interpreter);
  }

}
