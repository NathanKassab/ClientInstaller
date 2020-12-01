package me.xtrm.EZInstaller;

import java.io.IOException;

import me.xtrm.EZInstaller.frames.*;
import me.xtrm.EZInstaller.info.spicyClient.javaFx.Stage;

/**
 * @author xTrM_ && lavaflowglow
 */



public class Main {
	
	public static Stage stage = new Stage();
	
	public static void main(String[] args) {
		
		stage.createGui(args);
		
		//Frame.create();
		
	}

}
