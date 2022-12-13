package com.crazycatzzz;

import java.util.ArrayList;
import java.util.Collection;

import com.crazycatzzz.command.CommandManager;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

public class Main
{
    public static void main(String[] args)
    {
        CommandManager manager = new CommandManager();
        Collection<SlashCommandData> commands = new ArrayList<>();

        JDABuilder builder = JDABuilder.createDefault("Nzg2OTk3MDk3MzI0NzQwNjgw.GAdBp0.xWcm-y8OESBaR0AN8SZZ5zD6GBBzoJWYMTYl5w");
        builder.setActivity(Activity.watching("your mom"));
        builder.addEventListeners(new BotEventListener(manager));
        
        JDA jda = builder.build();

        // Add commands
        manager.getCommands().forEach((cmd) -> {
            commands.add(Commands.slash(cmd.getName(), cmd.getDescription()));
        });

        jda.updateCommands().addCommands(commands).queue();
    }
}
