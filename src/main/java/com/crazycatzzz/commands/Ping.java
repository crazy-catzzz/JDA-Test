package com.crazycatzzz.commands;

import java.util.List;

import java.awt.Color;

import com.crazycatzzz.command.CommandContext;
import com.crazycatzzz.commandinterfaces.ICommand;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageEmbed.Field;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;

public class Ping implements ICommand {
    private List<OptionData> options; // vanity options

    public Ping(List<OptionData> options) {
        this.options = options;
    }

    @Override
    public void handle(CommandContext ctx) {
        JDA jda = ctx.getJDA();
        List<OptionMapping> optionMappings = ctx.getOptions();

        EmbedBuilder builder = new EmbedBuilder();
        builder.setAuthor("CrazyCatzzz");
        builder.setColor(Color.red);
        builder.setTitle("Pong!");
        builder.setDescription("Test Command");
        builder.addField(new Field("Field", "yooo", false));
        builder.addField(new Field("Inline field 1", "bruh", true));
        builder.addField(new Field("Inline field 2", "moment", true));

        MessageCreateBuilder messageBuilder = new MessageCreateBuilder();
        messageBuilder.addEmbeds(builder.build());

        ctx.getEvent().reply(messageBuilder.build()).queue();
    };

    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public String getDescription() {
        return "Answers with pong";
    }
}
