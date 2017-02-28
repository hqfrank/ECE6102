// class Song
public class Song{
	public int Rank;
	public String Name;
	public String Artist;
	public String Album;
	public String Genre;
	public String Length;
	public double Price;

	public Song(int rank, String name, String artist, String album, String length, double price, String genre){
		Rank = rank;
		Name = name;
		Artist = artist;
		Album = album;
		Genre = genre;
		Length = length;
		Price = price;
	}

	public String toString(){
		return Rank + "\t" + Name + "\t" + Artist + "\t" + Album + "\t" + Genre + "\t" + Length + "\t" + Price;
	}

}