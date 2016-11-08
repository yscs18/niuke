package niuketest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Textmain {
	public static void main(String args[]) throws FileNotFoundException{
	      JFileChooser fileChooser=new JFileChooser();
	     if(fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
	    	 File file=fileChooser.getSelectedFile();
	    	 Scanner input=new Scanner(file);
	    	 while(input.hasNext()){
	    		 System.out.println(input.nextLine());
	    	 }
	    	 input.close();
	     }else{
	    	 System.out.println("NO file Found");
	     }
		}
	}
