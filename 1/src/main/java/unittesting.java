

import static org.junit.Assert.assertEquals;

import java.awt.event.WindowEvent;

import org.junit.Test;

public class unittesting extends bot{
	@Test
	public void test_menuItem1() throws InterruptedException {
		bot b1 = new bot();
		String[] userinputs = {"hi", "yes", "1", "#a", "fries", "refund"};
		for(String i:userinputs) {
			b1.chatbox.setText(i);
			b1.chatbox.postActionEvent();
			Thread.sleep(1000);
		}
		String result=textarea.getText();
		String expected = "Bot ->Welcome to the chat \r\n"
				+ "Bot ->The text box to enter your text is on the right --> \r\n"
				+ "Bot ->Welcome to the chat \r\n"
				+ "Bot ->The text box to enter your text is on the right --> \r\n"
				+ "you ->hi\r\n"
				+ "Bot ->Hello, Welcome to T22 Eats Customer Support! Are you an existing member? \r\n"
				+ "you ->\r\n"
				+ "Bot ->Please type something. We can't understand. \r\n"
				+ "you ->yes\r\n"
				+ "Bot ->Alright Welcome to the chat. To help you, choose an option from this existing menu.\r\n"
				+ " \r\n"
				+ "Bot ->1: missing food \r\n"
				+ "Bot ->2: late delivery \r\n"
				+ "Bot ->3: quality of food \r\n"
				+ "Bot ->4: delivery driver \r\n"
				+ "Bot ->5: the app isn't working \r\n"
				+ "Bot ->6: other \r\n"
				+ "Bot ->0: exit \r\n"
				+ "you ->\r\n"
				+ "Bot ->Please type something. We can't understand. \r\n"
				+ "you ->1\r\n"
				+ "Bot ->Enter the order number with the missing food: eg #a 45846 \r\n"
				+ "you ->\r\n"
				+ "Bot ->Please type something. We can't understand. \r\n"
				+ "you ->#a\r\n"
				+ "Bot ->Thank you! Could you please tell us which items your order missed? \r\n"
				+ "you ->\r\n"
				+ "Bot ->Please type something. We can't understand. \r\n"
				+ "you ->fries\r\n"
				+ "Bot ->We apologize for the inconvenience! \r\n"
				+ "Bot ->Would you like a refund or talk to a real agent? \r\n"
				+ "you ->\r\n"
				+ "Bot ->Please type something. We can't understand. \r\n"
				+ "you ->refund\r\n"
				+ "Bot ->Understood. We will provide a refund via in app credits in an hour \r\n"
				+ "Bot ->I hope this solves the problem \r\n"
				+ "Bot ->have a great day. type menu to see the menu again \r\n"
				+ "you ->\r\n"
				+ "Bot ->Please type something. We can't understand. ";
		assertEquals(expected,result);
		Thread.sleep(1000);
	}
	
	
	
}
