package model.meta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Script extends MMEntity
{

  private ArrayList<ICommandLanguage> commands;

  public Script()
  {
    this.commands = new ArrayList<>();
  }

  public void addCommand(ICommandLanguage commande)
  {
    this.commands.add(commande);
  }

  public void addAllCommands(List<ICommandLanguage> commandes)
  {
    this.commands.addAll(commandes);
  }

  public Iterator<ICommandLanguage> commmandsIterator()
  {
    return this.commands.iterator();
  }

  public void accept(Visitor visitor)
  {
    visitor.visitScript(this);
  }

}
