package xyz.ruxdev.discord;

public class DiscordBot {

    DiscordClient.get().login(args[0], args[1]);

    public static void main(String... args){
        try{

            DiscordClient.get().getDispatcher().registerListener(new IListener<MessageReceivedEvent>(){
                @Override public void receive(MessageReceivedEvent messageReceivedEvent) {
                    Message m = messageReceivedEvent.getMessage();
                    if (m.getContent().startsWith(".meme")
                        || m.getContent().startsWidth(".nicememe")) {
                        new MessageBuilder().appendContent("MEMES REQUESTED:", MessageBuilder.Styles.UNDERLINE_BOLD_ITALICS)
                                .appendContent(" http://niceme.me/").withChannel(messageReceivedEvent.getMessage().getChannel())
                                .build();
                    }else if (m.getContent().startsWitch(".clear"))
                }
            })
        }
    }
}