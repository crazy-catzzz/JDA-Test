package com.crazycatzzz.command;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.Nullable;

import com.crazycatzzz.commandinterfaces.ICommand;
import com.crazycatzzz.commands.Donne;
import com.crazycatzzz.commands.Ping;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class CommandManager {
    private final List<ICommand> commands = new ArrayList<>();

    public CommandManager() {
        this.addCommand(new Ping(null));
        this.addCommand(new Donne(null));
    }

    private void addCommand(ICommand cmd) {
        boolean alreadyPresent = this.commands.stream().anyMatch((it) -> it.getName().equalsIgnoreCase(cmd.getName()));
    
        if (alreadyPresent) throw new IllegalArgumentException("Command already exists!");

        commands.add(cmd);
    }
    
    @Nullable
    private ICommand getCommand(String cmdName) {
        String lowName = cmdName.toLowerCase();

        for (ICommand cmd : this.commands) {
            if (cmd.getName().equals(lowName)) return cmd;
        }

        return null;
    }

    public void handle(SlashCommandInteractionEvent event) throws CommandNotFoundException {
        List<OptionMapping> options = event.getOptions();
        String commandName = event.getName();
        System.out.println(commandName);

        ICommand cmd = this.getCommand(commandName);

        if (cmd != null) {
            CommandContext ctx = new CommandContext(event, options);
            cmd.handle(ctx);
        } else {
            throw new CommandNotFoundException(commandName + ": Not Found");
        }
    }

    public List<ICommand> getCommands() {
        return this.commands;
    }
}
