package model.meta;

import java.util.ArrayList;
import java.util.List;

public class Script
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

}
