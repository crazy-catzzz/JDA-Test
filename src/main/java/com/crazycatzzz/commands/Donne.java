package com.crazycatzzz.commands;

import java.util.List;

import com.crazycatzzz.command.CommandContext;
import com.crazycatzzz.commandinterfaces.ICommand;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

public class Donne implements ICommand {
    private List<OptionData> options;

    public Donne(List<OptionData> options) {
        this.options = options;
    }

    @Override
    public String getName() {
        return "donne";
    }
    @Override
    public String getDescription() {
        return "La mia opinione sulle donne";
    }

    @Override
    public void handle(CommandContext ctx) {
        JDA jda = ctx.getJDA();
        List<OptionMapping> optionMappings = ctx.getOptions();

        ctx.getEvent().reply("Odio le donne").queue();
    }
}
