package xyz.ruxdev.discord;

import me.itsghost.jdiscord.message.MessageBuilder;

public class DiscordBot
{

    public static void main(String... args){
        DiscordClient.get().login(args[0], args[1]);
        try{

            DiscordClient.get().getDispatcher().registerListener(new IListener<MessageReceivedEvent>()
            {
                @Override public void receive(MessageReceivedEvent messageReceivedEvent)
                {
                    Message m = messageReceivedEvent.getMessage();

                    if (m.getContent().startsWith("#r d4"))
                    {
                        new MessageBuilder()
                                .appendContent("").withChannel(messageReceivedEvent.getMessage()
                                .getChannel())
                                .build();
                        new MessageBuilder().appendContent();
                    }

                    else if (m.getContent().startsWitch("#clear"))
                    {

                    }
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}