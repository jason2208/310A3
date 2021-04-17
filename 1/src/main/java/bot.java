

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.Random;
import de.l3s.boilerpipe.BoilerpipeProcessingException;
import java.net.URL;
import java.net.MalformedURLException;
import de.l3s.boilerpipe.extractors.NumWordsRulesExtractor;

public class bot extends JFrame{

	protected static JTextArea textarea = new JTextArea();
	protected static JTextField chatbox = new JTextField();
	JScrollPane scroll = new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	String [] possibleanswer = {"I'm not sure how I can help you with that.", "Would you like to talk to a real agent? type real agent to do so.","This path is still under construction!", "please provide feedback on what the other options for help may be!", "I'm still learning. Once I grow up I can help you with this"};

	public static String gtext;
	public static String combinedtext;

	public bot() {
		JFrame frame = new JFrame ();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setLayout(null);
		frame.setSize(2000, 1600);
		frame.setTitle("Chat");
		frame.add(textarea);
		frame.add(scroll);
		frame.add(chatbox);
		//for text area
		textarea.setSize(1500, 1400);
		textarea.setLocation(2, 2);
		textarea.add(scroll);

		// for text field
		chatbox.setSize(340, 30);
		chatbox.setLocation(1550,0);





		bot("Welcome to the chat");
		bot("The text box to enter your text is on the right -->");

		chatbox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gtext = chatbox.getText().toLowerCase();
				combinedtext = combinedtext + ". " + gtext;


				textarea.append("you ->" + gtext + "\n");

				chatbox.setText("");


				if(gtext.contains("hi")) {
					bot("Hello, Welcome to T22 Eats Customer Support! Are you an existing member?");
					bot("What's your issue?");
					issuesmenu();
				}
				else if (gtext.contains("missing")) {
					bot("Enter the order number with the missing food: eg #a 45846");
				}else if(gtext.contains("#a")) {
					bot("Thank you! Could you please tell us which items your order missed?");
				}else if (gtext.contains("fries")||gtext.contains("drink")||gtext.contains("burger")||gtext.contains("chicken")) {
					bot("We apologize for the inconvenience!");
					bot("Would you like a refund or talk to a real agent?");
				}else if(gtext.contains("refund")) {
					bot("Understood. We will provide a refund via in app credits in an hour");
					bot("I hope this solves the problem");
					bot("have a great day. type menu to see the menu again");
				}else if(gtext.contains("talk") || gtext.contains("agent")) {
					bot("Understood. call 4511284 to get the help that I can't provide.");
					bot("have a great day. type menu to see the menu again");
				}
				else if (gtext.contains("late")) {
					bot("Enter the order number with the late delivery: eg #b 45846");
				}
				else if(gtext.contains("#b")) {
					bot("Thank you! Could you please tell us how late the delivery was");
				}
				else if(gtext.contains("thirty")||gtext.contains("ten") ||gtext.contains("fifteen")) {
					bot("I am sorry but this isn't late enough to warrant a refund. would you like to talk a real agent?");
					bot("If yes type real agent");
				}else if (gtext.contains("an hour")||gtext.contains("over an hour") ||gtext.contains("over two hours")) {
					bot("We apologise for the issue. would you like a refund or a conversation with a real agent?");
				}


				else if (gtext.contains("quality")) {
					bot("Enter the order number with the poor food quality: eg #c 45846");
				}else if(gtext.contains("#c")) {
					bot("Thank you! Could you please tell us how the food wasn't up to the standards");
				}else if(gtext.contains("cold") || (gtext.contains("not up to the standards"))) {
					bot("We apologise! this must've ruined the experience. We can offer a partial compensation.");
					bot("What items had the low quality");
				}else if (gtext.contains("pizza")||gtext.contains("wrap")||gtext.contains("steak")||gtext.contains("coffee")) {
					bot("Understood. We will provide in app credits to make up for the items. Thank you for letting us know.");
					bot("type menu to check the menu to address another issue. Thank you");
				}



				else if (gtext.contains("driver")) {
					bot("Enter the order number with the poor food quality: eg #d 45846");
				}else if(gtext.contains("#d")) {
					bot("Thank you! Could you please tell us what the issue was with the driver");
				}else if(gtext.contains("rude") || gtext.contains("disrespectful") || gtext.contains("shout")) {
					bot("That's awful. We'll get that sorted by talkking to the driver.");
					bot("We'll provide in app credits to make up for the experience. Our apologies");
					bot("If you are unsatisfied, type real agent to talk to a real person and futther discuss this.");
					System.out.println(combinedtext);
				}
				else if (gtext.contains("working")) {
					bot("Thank you for taking the time to provide feedback");
					bot("What is wrong with the app?");
				}else if(gtext.contains("responsive")) {
					bot("Woah! THat's a pain. please try reinstalling the app");
				}else if(gtext.contains("order being placed") || gtext.contains("items in cart")) {
					bot("Understood. This could be as tthe restraunt is closed. if the problem persists, try reinstalling it.");
				}else if(gtext.contains("money being charged is inaccurate")) {
					bot("That's a yikes. have you placed the order already?");
				}else if(gtext.contains("placed food")) {
					bot("Oh no. would you like to refund the order or talk to a real agent?");
				}else if(gtext.contains("haven't ")) {
					bot("Good save. our servers are currently down. please try again later.");
					bot("type menu to return to the main menu!");
				}

				else if (gtext.contains("other")) {
					bot("Could you describe the issue so we can help you?");
					//below handles other
				}else if(gtext.contains("slow")) {
					bot("Please provide your address again so we could provide a better delivery next"
							+ " time");
					bot("Follow the format in this example: address:802 Academy Way");
				}
				//new map API
				else if(gtext.contains("address:")) {
					try {
						JFrame f=new JFrame("map");
						f.setSize(600,500);
						String address=gtext;
						address=address.replaceAll(" ", "+");
						URL img = new URL("https://maps.googleapis.com/maps"
								+ "/api/staticmap?center="+address+"&zoom=16&size=600x300&maptype=roadmap&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318&markers=color:red%7Clabel:C%7C40.718217,-73.998284&key=AIzaSyDDE-qnzbeXnUo5zIA-6k1_rXbZ4VlhPO8");														
						ImageIcon image = new ImageIcon(img);
						JLabel label = new JLabel("", image, JLabel.CENTER);
						JPanel panel = new JPanel(new BorderLayout());
						panel.add( label, BorderLayout.CENTER );
						f.add(panel);
						f.setVisible(true);
						bot("If that's not the what it looks like around your house, put in the address "
								+ "with more details");
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				}
				else if(gtext.contains("kind of")) {
					bot("Understood, we would provide a wiki page to tell you what that is");
				}
				else if(gtext.contains("what is")) {
					try {
						String food=gtext;
						food=food.substring(food.indexOf("is")+3);
						food=food.replaceAll(" ", "_");
						URL url = new URL("https://en.wikipedia.org/wiki/"+food);
						String text=NumWordsRulesExtractor.INSTANCE.getText(url);
						String sen="";
						for(int i=0;i<text.indexOf("Contents");i++) {
							sen+=text.charAt(i);
						}
						bot(sen);
						bot("Any other issues?");
					} catch (MalformedURLException | BoilerpipeProcessingException e) {
						e.printStackTrace();
					}
				}
				else if(gtext.contains("exit")||gtext.contains("leave")) {
					bot("bye bye");
					try {
						FileWriter myWriter = new FileWriter("filename.txt");
						myWriter.write(combinedtext);
						myWriter.close();
						System.out.println("Successfully wrote to the file.");
					} catch (IOException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
					}
				}
				else if(gtext.contains("menu")) {
					issuesmenu();
				}else if(gtext.contains("thank you")) {
					bot("You are welcome! I am happy to assist in any way I can");
				}
				else if(gtext.length()==0) {
					bot("Please type something. We can't understand.");
				}
				else {
					Random rand = new Random();
					int upperbound = 5;
					int int_rand = rand.nextInt(upperbound);
					bot(possibleanswer[int_rand]);
				}




			}
		}




				);


	}
	private static void bot(String s) {
		textarea.append("Bot ->" + s + " \n");
	}
	public static void issuesmenu () {


		bot("1: missing food");
		bot("2: late delivery");
		bot("3: quality of food");
		bot("4: delivery driver");
		bot("5: the app isn't working");
		bot("6: other");
		bot("0: exit");



	}

	public static void main(String[] args) {
		new bot();


	}

}

