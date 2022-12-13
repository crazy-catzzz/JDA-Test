package com.crazycatzzz.commandinterfaces;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public interface ICommandContext {
    // getEvent : Getter, Slash Command Event
    default public SlashCommandInteractionEvent getEvent() { 
        return null;
    }

    // getGuild : Getter, Guild Entity
    default public Guild getGuild() {
        return null;
    }

    // getJDA : Getter, JDA Object
    default public JDA getJDA() {
        return this.getEvent().getJDA();
    }
}