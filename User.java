// Class User
import java.lang.Math;
import java.util.Random;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.IOException;

public class User{
	public String UserName;
	public double PurchaseIndex;
	public int NumMaxSongs;
	public String FavoriteGenre;

	public User(String userName){
		UserName = userName;
		Random randomGenerator = new Random();
		PurchaseIndex = randomGenerator.nextDouble();
		NumMaxSongs = randomGenerator.nextInt(4)+1;
		try{
			List<String> genres = Files.readAllLines(Paths.get("Resources/Genres.txt"));
			int numGenres = genres.size();
			int genreIndex = randomGenerator.nextInt(numGenres);
			FavoriteGenre = genres.get(genreIndex);
		} catch(IOException e){}
	}

	public String toString(){
		return UserName;
	}
}