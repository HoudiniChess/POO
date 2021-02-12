package model.meta;

import java.util.HashMap;
import java.util.Map;

public class ManagerVariable
{

  public static ManagerVariable instance;

  protected Map<String, String> values;

  private ManagerVariable()
  {
    this.values = new HashMap<>();
  }

  public static ManagerVariable getInstance()
  {
    if (instance == null)
    {
      instance = new ManagerVariable();
    }
    return instance;
  }

  public Map<String, String> getValues()
  {
    return values;
  }

  public void setValues(Map<String, String> values)
  {
    this.values = values;
  }

}
