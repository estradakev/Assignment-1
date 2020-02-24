package com.mycompany.a1;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
public class Game extends Form{
	private GameWorld gw ;
	
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
		
	}
	private void play(){
		
		Label myLabel = new Label("Enter a Command:"); 
		this.addComponent(myLabel);
		final TextField myTextField=new TextField(); 
		this.addComponent(myTextField); 
		this.show();
		
		myTextField.addActionListener(new ActionListener(){ 
			
			public void actionPerformed(ActionEvent evt) {
				
				String sCommand=myTextField.getText().toString();
				myTextField.clear();
				if(sCommand.length() != 0)
					switch (sCommand.charAt(0)) {
					case '1':
						gw.baseCollision();
						break;
					case '2':
						gw.baseCollision();
						break;
					case '3':
						gw.baseCollision();
						break;
					case '4':
						gw.baseCollision();
						break;
					case '5':
						gw.baseCollision();
						break;
					case '6':
						gw.baseCollision();
						break;
					case '7':
						gw.baseCollision();
						break;
					case '8':
						gw.baseCollision();
						break;
					case '9':
						gw.baseCollision();
						break;
					case 'x':
						System.out.print("Are you sure you want to exit");
							break;
					case 'a':
						gw.cyborgAccelerate();
						break;
					case 'b':
						gw.cyborgBreaking();
						break;
					case 'l':
						gw.goLeft();
						break;
					case 'r':
						gw.goRight();
						break;
					case 'c':
						gw.cyborgCollision();
						break;
					case 'e':
						gw.energyBaseCollision();
						break;
					case 'g':
						gw.droneCollision();
						break;
					case 't':
						gw.tick();
						break;
					case 'd':
						gw.display();
						break;
					case 'm':
						gw.mapGame();
						break;
					case 'n':
						System.out.println("Continue");
						break;
					case'y':
						gw.exit();
						break;
					default:
						System.out.println("Type a correct command");
					
				} //switch
			
			} //actionPerformed
		}//new ActionListener()
		);//addActionListener
	} //play
	
	
}
