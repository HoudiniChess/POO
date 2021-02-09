package model.meta.value;

public interface Value<T>
{
  public static Value<Object> UNDEFINED_VALUE = new Value<Object>()
  {
    @Override
    public Object getValue()
    {
      return null;
    }

  };

  T getValue();
}
