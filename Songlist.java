// Songlist class
import java.io.*;
import java.text.*;
import java.util.Date;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

public class Songlist{
	public Song[] Songs;
	public String Genre;
	public int Number;
	private String Filepath;

	public Songlist(String genre, String filepath){
		Genre = genre;
		Filepath = filepath;
		Path songListFile = Paths.get(Filepath);
		try{
			List<String> filelines = Files.readAllLines(songListFile,StandardCharsets.UTF_8);
			Number = filelines.size();
			Songs = new Song[Number];
			for(int i=0; i<Number; i++){
				String[] data = filelines.get(i).split("\t");
				Songs[i] = new Song(Integer.parseInt(data[0]),data[1],data[2],data[3],data[4],Double.parseDouble(data[5]),data[6]);
			}
		}catch(IOException e){

		}
	}

	public Songlist(Song[] songs){
		Songs = songs;
		Genre = "Hybrid";
		Number = songs.length;
		Filepath = "N/A";
	}
}