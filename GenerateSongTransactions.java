// Generate song purchase transactions
import java.io.*;
import java.text.*;
import java.util.Date;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.Path;
import java.util.GregorianCalendar;

public class GenerateSongTransactions{
	public static void main(String[] args) {
		int numTransactions = Integer.parseInt(args[0]);

		List<String> songGenre = new ArrayList<String>();
		songGenre.add("Alternative");
		songGenre.add("Country");
		songGenre.add("Dance");
		songGenre.add("Hiphop");
		songGenre.add("Jazz");
		songGenre.add("Pop");
		songGenre.add("Rock");
		int numGenre = songGenre.size();
		Songlist[] songLists = new Songlist[numGenre];
		for(int i = 0; i < numGenre; i++){
			String songListFilePath = "Resources/"+songGenre.get(i)+"SongInfo2016.txt";
			songLists[i] = new Songlist(songGenre.get(i), songListFilePath);
			for(int j = 0; j < songLists[i].Number; j++)
				System.out.println(songLists[i].Songs[j]);
		}



		for(int i = 0; i < numTransactions; i++){

		}





		// for(int i = 0; i < numGenre; i++){
		// 	Path songListFile = Paths.get("Resources/"+songGenre.get(i)+"Song2016.txt");
		// 	File songInfoFile = new File("Resources/"+songGenre.get(i)+"SongInfo2016.txt");
		// 	try{
		// 		List<String> filelines = Files.readAllLines(songListFile);
		// 		int numSongs = filelines.size()/5;
		// 		System.out.println(numSongs);
		// 		List<String> songInfo = new ArrayList<String>();
		// 		songInfo.add("Number");
		// 		songInfo.add("Name");
		// 		songInfo.add("Artist");
		// 		songInfo.add("Album");
		// 		songInfo.add("Length");
		// 		songInfo.add("Price");
		// 		songInfo.add("Genre");
		// 		for(int j = 0; j < filelines.size(); j++){
		// 			int k = j % 5;
		// 			if(k == 0){
		// 				songInfo.set(0, filelines.get(j));
		// 			}
		// 			else if(k == 1){
		// 				songInfo.set(1, filelines.get(j));
		// 			}
		// 			else if(k == 2){
		// 				int idxArtistEnd = filelines.get(j).lastIndexOf(" on ");
		// 				String artist = filelines.get(j).substring(3, idxArtistEnd);
		// 				String album = filelines.get(j).substring(idxArtistEnd+4);
		// 				songInfo.set(2, artist);
		// 				songInfo.set(3, album);
		// 			}
		// 			else if(k == 3){
		// 				songInfo.set(4, filelines.get(j));
		// 			}
		// 			else if(k == 4){
		// 				songInfo.set(5, filelines.get(j).substring(1));
		// 				songInfo.set(6, songGenre.get(i));
		// 				String outputString = songInfo.get(0)+"\t"+songInfo.get(1)+"\t"+songInfo.get(2)+"\t"+songInfo.get(3)+"\t"+songInfo.get(4)+"\t"+songInfo.get(5)+"\t"+songInfo.get(6);
		// 				PrintWriter printWriter = new PrintWriter(new FileOutputStream(songInfoFile, true));
		// 				printWriter.println(outputString);
		// 				printWriter.close();
		// 			}
		// 		}
		// 	}catch (IOException e){

		// 	}
		// }
	}
}