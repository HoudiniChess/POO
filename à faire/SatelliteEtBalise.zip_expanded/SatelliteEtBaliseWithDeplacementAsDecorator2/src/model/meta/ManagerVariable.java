package model.meta;

import java.util.HashMap;
import java.util.Map;

public class ManagerVariable
{

  public static ManagerVariable instance;

  protected Map<String, String> symbols;
  protected Map<String, Integer> numbers;

  private ManagerVariable()
  {
    this.symbols = new HashMap<>();
    this.numbers = new HashMap<>();
  }

  public static ManagerVariable getInstance()
  {
    if (instance == null)
    {
      instance = new ManagerVariable();
    }
    return instance;
  }

  public Map<String, String> getSymbols()
  {
    return symbols;
  }

  public void setSymbols(Map<String, String> symbols)
  {
    this.symbols = symbols;
  }

  public Map<String, Integer> getNumbers()
  {
    return numbers;
  }

  public void setNumbers(Map<String, Integer> numbers)
  {
    this.numbers = numbers;
  }

  public static void setInstance(ManagerVariable instance)
  {
    ManagerVariable.instance = instance;
  }

}
