// Generate user names
import java.lang.Math;
import java.util.Random;
import java.io.*;
import java.text.*;
import java.util.Date;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

public class GenerateName{
	public static void main(String[] args) {
		Path firstNameFile = Paths.get("Resources/FirstNames.txt");
		File userNameFile = new File("Resources/UserNames.txt");
		try{
			List<String> filelines = Files.readAllLines(firstNameFile,StandardCharsets.UTF_8);
			int numFirstNames = filelines.size();
			System.out.println(numFirstNames);
			Random randomGenerator = new Random(1000);
			
			for(int i = 0; i < numFirstNames; i++){
				String firstName = filelines.get(i);
				int numSameFirstName = randomGenerator.nextInt(5);
				for(int j = 0; j < numSameFirstName; j++){
					int numInUserName = randomGenerator.nextInt(10000);
					String userName = firstName+numInUserName;
					// System.out.println(userName);
					PrintWriter printWriter = new PrintWriter(new FileOutputStream(userNameFile, true));
					printWriter.println(userName);
					printWriter.close();
				}
			}


		}catch(IOException e){

		}
	}
}