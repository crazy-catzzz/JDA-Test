package com.crazycatzzz.command;
import java.util.List;

import com.crazycatzzz.commandinterfaces.ICommandContext;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class CommandContext implements ICommandContext {
    private final SlashCommandInteractionEvent event;
    private final List<OptionMapping> options;

    public CommandContext(SlashCommandInteractionEvent event, List<OptionMapping> options) {
        this.event = event;
        this.options = options;
    }

    @Override
    public Guild getGuild() {
        return this.getEvent().getGuild();
    }

    @Override
    public SlashCommandInteractionEvent getEvent() {
        return this.event;
    }

    public List<OptionMapping> getOptions() {
        return this.options;
    }
}