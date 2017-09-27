package me.xtrm.EZInstaller.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.apache.commons.io.FileUtils;

import me.xtrm.EZInstaller.Installer;
import me.xtrm.EZInstaller.Referances;

/**
 * @author xTrM_
 */
public class Frame {

	private JFrame frame;
	private JPanel panel, panelDownload;
	private JButton button, buttonQuit;
	private JLabel label, waitingLabel;
	
	public static boolean installed = false;
	public static String status = "Waiting for Input...";

	/**
	 * Launch the application.
	 */
	public static void create() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle(Referances.CLIENT_NAME + " Client Installer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button = new JButton("Install");
		
		button.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(!installed){
					System.out.println("Installed: " + installed);
					status = "Installed!";
					
					String labellText = "<html><br><br><br><br>Status: " + status + "</html>";
					waitingLabel.setText(labellText);
					int delay = 0;
					while(true){
						if(delay < 100000){
							delay++;
							status = "Installed!";
							
							waitingLabel.setText(labellText);
						}else{
							File file = new File(Referances.CLIENT_FOLDER);
							if(!file.exists()){
								System.out.println("Creating file " + Referances.CLIENT_FOLDER);
								file.mkdir();
							}
							
							try {
								Installer.saveFile(Referances.JSON_LINK, Referances.JSON_FILE);
								System.out.println("Searching file " + Referances.JSON_FILE);
								String content = FileUtils.readFileToString(new File(Referances.JSON_FILE), "UTF-8");
								System.out.println("Replacing content (Replacing \"ClientName\" for \"" + Referances.CLIENT_NAME + "\"");
							    content = content.replaceAll("ClientName", Referances.CLIENT_NAME);
							    System.out.println("Setting tempFile...");
							    File tempFile = new File(Referances.JSON_FILE);
							    System.out.println("Replacing file " + Referances.JSON_FILE + " with New one!");
							    FileUtils.writeStringToFile(tempFile, content, "UTF-8");
							} catch (IOException e) {
								e.printStackTrace();
							}
							
							try {
								Installer.saveFile(Referances.JAR_LINK, Referances.JAR_FILE);
							} catch (IOException e){
								e.printStackTrace();
							}
							
//							DownloadFinishFrame.create();
//							frame.setVisible(false);
							status = "Installed!";
							waitingLabel.setText(labellText);
							button.setEnabled(false);
							installed = true;
							break;
						}
					}
				}
			}
			
		});
		
		button.setVisible(true);
		
		buttonQuit = new JButton("Close");
		buttonQuit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
			
		});
		buttonQuit.setVisible(true);
		
		panel = new JPanel();
		panel.setVisible(true);
		
		panelDownload = new JPanel();
		panelDownload.setVisible(true);
		
		String labelText = "<html>Welcome to the " + Referances.CLIENT_NAME + " Installer. Click on the \"Install\" <br>button to install the client to your .minecraft/versions folder<br><br><br>AppData: " + Referances.APPDATA + "<br>.minecraft/versions: " + Referances.VERSIONS_FOLDER + "</html>";
		label = new JLabel(labelText);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		String labellText = "<html><br><br><br>Status: " + status + "</html>";
		waitingLabel = new JLabel(labellText);
		waitingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel.add(label);
		panel.add(waitingLabel, BorderLayout.SOUTH);
		
		panelDownload.add(button, BorderLayout.SOUTH);
		panelDownload.add(buttonQuit, BorderLayout.SOUTH);
		
		frame.getContentPane().add(panel);
		frame.getContentPane().add(panelDownload, BorderLayout.SOUTH);
	}

}
