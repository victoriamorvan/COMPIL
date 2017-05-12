package ATC;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Test_ATC {
	public static void main(String[] args) throws IOException {
		    
	     
	     String dbPath = "/home/depot/2A/gmd/projet_2016-17/atc/br08303.keg";;
	     String id ="A01AA02";
	     ATC_Parser pars = new ATC_Parser(id);
	     System.out.println("1"+pars.getAtc().getName());

 }
}
