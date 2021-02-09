package model.meta;

import java.util.ArrayList;
import java.util.List;

import command.ICommand;

public class Script
{

  private ArrayList<ICommand> commands;

  public Script()
  {
    this.commands = new ArrayList<>();
  }

  public void addCommand(ICommand commande)
  {
    this.commands.add(commande);
  }

  public void addAllCommands(List<ICommand> commandes)
  {
    this.commands.addAll(commandes);
  }

}
