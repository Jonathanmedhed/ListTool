package main;
import listTool.ListTools;
import gui.Gui;

public class Main {

	public static void main(String[] args) {
		
		ListTools lc = new ListTools();
		
		String s = "pool stick\r\n" + 
				"mp3 player\r\n" + 
				"rubber duck\r\n" + 
				"toilet\r\n" + 
				"spoon\r\n" + 
				"buckel\r\n" + 
				"carrots\r\n" + 
				"money\r\n" + 
				"remote\r\n" + 
				"greeting card\r\n" + 
				"sidewalk\r\n" + 
				"toe ring\r\n" + 
				"playing card\r\n" + 
				"toothpaste\r\n" + 
				"checkbook\r\n" + 
				"controller\r\n" + 
				"chocolate\r\n" + 
				"lip gloss\r\n" + 
				"magnet\r\n" + 
				"flowers";
		/*
		System.out.println(lc.spaceToComma(s));
		
		System.out.println("---------------------------Testing space to Array-----------------------------------");
		for(String x : lc.spaceToArray(s)) {
			System.out.println(x);
		}
		
		System.out.println("---------------------------Testing Array to Linear-----------------------------------");
		System.out.println(lc.arrayToLinear(lc.spaceToArray(s)));
		*/
		
		Gui gui = new Gui();
		gui.createAndShowGUI();
	}	
}
