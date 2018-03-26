package nl.jessegeerts.discordbots.poedelbot.command.hostrelated;

import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import nl.jessegeerts.discordbots.poedelbot.command.Command;
import nl.jessegeerts.discordbots.poedelbot.util.STATIC;

public class Alerts implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();

        if (args.length == 0) {
            channel.sendMessage(event.getAuthor().getAsMention() + " ").queue();
            return;
        }
        if (args[0].equalsIgnoreCase("aan")) {
            try {
                event.getMessage().delete().queue();
                event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById(STATIC.ROLE_ALERTS_ID)).queue();
                channel.sendMessage(event.getAuthor().getAsMention() + " Je wordt vanaf nu getagt als er een alert is.").queue();

            } catch (PermissionException e) {
                channel.sendMessage(event.getAuthor().getAsMention() + " Er is iets fout gegaan. Meld dit aan de beheerder. Mijn error code: ```" + e + "```").queue();
                return;
            }
        }
        if (args[0].equalsIgnoreCase("on")) {
            try {
                event.getMessage().delete().queue();
                event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getGuild().getRoleById(STATIC.ROLE_ALERTS_ID)).queue();
                channel.sendMessage(event.getAuthor().getAsMention() + " Je wordt vanaf nu getagt als er een alert is.").queue();

            } catch (PermissionException e) {
                channel.sendMessage(event.getAuthor().getAsMention() + " Er is iets fout gegaan. Meld dit aan de beheerder. Mijn error code: ```" + e + "```").queue();
                return;
            }
        }
        if (args[0].equalsIgnoreCase("off")) {
            try {
                event.getMessage().delete().queue();
                event.getGuild().getController().removeSingleRoleFromMember(event.getMember(), event.getGuild().getRoleById(STATIC.ROLE_ALERTS_ID)).queue();
                channel.sendMessage(event.getAuthor().getAsMention() + " Je krijgt niet langer meldingen.").queue();

            } catch (PermissionException e) {
                channel.sendMessage(event.getAuthor().getAsMention() + " Er is iets fout gegaan. Meld dit aan de beheerder. Mijn error code: ```" + e + "```").queue();
                return;
            }
        }
        if (args[0].equalsIgnoreCase("uit")) {
            try {
                event.getMessage().delete().queue();
                event.getGuild().getController().removeSingleRoleFromMember(event.getMember(), event.getGuild().getRoleById(STATIC.ROLE_ALERTS_ID)).queue();
                channel.sendMessage(event.getAuthor().getAsMention() + " Je krijgt niet langer meldingen.").queue();

            } catch (PermissionException e) {
                channel.sendMessage(event.getAuthor().getAsMention() + " Er is iets fout gegaan. Meld dit aan de beheerder. Mijn error code: ```" + e + "```").queue();
                return;
            }
        }
        if(args[0].equalsIgnoreCase("give")){
            event.getMessage().delete().queue();
            if(event.getMessage().getMentionedUsers().isEmpty()){
                event.getAuthor().openPrivateChannel().queue((privateChannel -> privateChannel.sendMessage("Je moet een of meerdere personen taggen")));
                return;
            }else{
                Guild guild = event.getGuild();
                Member selfMember = guild.getSelfMember();  //This is the currently logged in account's Member object.


                //Loop over all mentioned users, kicking them one at a time. Mwauahahah!


                User user = event.getMessage().getMentionedUsers().get(0);

                Member member = guild.getMember(user);

                if (!selfMember.canInteract(member)) {
                    channel.sendMessage("Ik kan de poedel %user% niet bannen want deze persoon zit hoger in de hierachie dan ik :sob: :thinking:".replace("%user%", member.getEffectiveName())).queue();
                    return;
                }


                    ;
                guild.getController().addSingleRoleToMember(member, event.getGuild().getRoleById(STATIC.ROLE_ALERTS_ID)).queue(success -> event.getAuthor().openPrivateChannel().queue((privateChannel -> privateChannel.sendMessage("ROle was given to: ").append( member.getEffectiveName()).queue())));
            }
        }
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}