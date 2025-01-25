package com.example.examplemod.commands;

 
import java.util.List;

import com.example.examplemod.events.ChatListener;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class SwitchCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "cdt";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + this.getCommandName();
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true; // return true otherwise you won't be able to use the command
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        
    	if(ChatListener.flag) {
    		ChatListener.flag=false;
    		ChatComponentText chatMessage = new ChatComponentText("Command Detector:OFF");
            chatMessage.setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)); 
            Minecraft.getMinecraft().thePlayer.addChatMessage(chatMessage);
    	}
    	else {
    		ChatListener.flag=true;
    		ChatComponentText chatMessage = new ChatComponentText("Command Detector:ON");
            chatMessage.setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)); 
            Minecraft.getMinecraft().thePlayer.addChatMessage(chatMessage);
    	}

    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        // when you type the command and press tab complete,
        // this method will allow you to cycle through the words that match what you typed
        final String[] options = new String[]{"option1", "option2", "option3"};
        return getListOfStringsMatchingLastWord(args, options);
    }

}
