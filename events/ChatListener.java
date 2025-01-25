package com.example.examplemod.events;

import net.minecraft.client.Minecraft;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatListener {
	public static Boolean flag;
    @SubscribeEvent
    public void onChatMessage(ClientChatReceivedEvent event) {
        IChatComponent message = event.message; 

        if (message.getChatStyle() != null && message.getChatStyle().getChatClickEvent() != null) {
            ClickEvent clickEvent = message.getChatStyle().getChatClickEvent();

            if (clickEvent.getAction() == ClickEvent.Action.RUN_COMMAND) {
                String command = clickEvent.getValue(); // 実行されるコマンド
                ChatComponentText chatMessage = new ChatComponentText("Detected Command:"+command);
                chatMessage.setChatStyle(new ChatStyle().setColor(EnumChatFormatting.YELLOW)); 
                if(flag)Minecraft.getMinecraft().thePlayer.addChatMessage(chatMessage);
            }
        }
    }
}
