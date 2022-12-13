package com.crazycatzzz;

import com.crazycatzzz.command.CommandManager;
import com.crazycatzzz.command.CommandNotFoundException;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotEventListener extends ListenerAdapter {
    private CommandManager manager;
    
    public BotEventListener(CommandManager manager) {
        super();
        this.manager = manager;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
    }
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String evString = event.getCommandString();

        try {
            manager.handle(event);
        } catch (CommandNotFoundException e) {
            System.out.println(e);
        }
    }
}
