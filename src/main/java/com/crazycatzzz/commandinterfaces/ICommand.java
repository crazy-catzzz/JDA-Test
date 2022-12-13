package com.crazycatzzz.commandinterfaces;

import com.crazycatzzz.command.CommandContext;

public interface ICommand {
    public void handle(CommandContext ctx);

    public String getName();
    public String getDescription();
}
