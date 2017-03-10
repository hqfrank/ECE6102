// Song transaction class
import java.util.Date;
import java.util.GregorianCalendar;
import java.lang.Math;
import java.util.Random;
import java.util.*;

public class Transaction{
	public String DateTrans;
	public Song[] SongsPurchased;
	// public double PriceTotal;
	public User Buyer;

	public Transaction(Songlist[] songLists, List<String> genreList, User[] users){
		DateTrans = randomDate();
		Buyer = generateRandomUser(users);
		SongsPurchased = generateRandomSongs(songLists, genreList, Buyer);



	}

	public Transaction(String date, Song[] songs, User user){
		DateTrans = date;
		SongsPurchased = songs;
		// double tempPrice = 0;
		// for(int i=0; i<songs.length; i++){
		// 	tempPrice+=songs[i].Price;
		// }
		Buyer = user;
	}

	public String randomDate(){
		GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(2016, 2017);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        int hourOfDay = randBetween(0,23);
        int minOfHour = randBetween(0,59);
        System.out.println(gc.get(gc.YEAR) + "." + (gc.get(gc.MONTH) + 1) + "." + gc.get(gc.DAY_OF_MONTH)+ " " + hourOfDay + ":" + minOfHour);
        return gc.get(gc.YEAR) + "." + (gc.get(gc.MONTH) + 1) + "." + gc.get(gc.DAY_OF_MONTH)+ " " + hourOfDay + ":" + minOfHour;
	}

	private int randBetween(int start, int end){
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public User generateRandomUser(User[] users){
		boolean searchingBuyer = true;
		int numUsers = users.length;
		Random randomGenerator = new Random();
		int buyerIndex = 0;							// initialize with 0
		double shoppingIndex = 0.0;
		while(searchingBuyer){
			buyerIndex = randomGenerator.nextInt(numUsers);
			shoppingIndex = randomGenerator.nextDouble();
			if (shoppingIndex <= users[buyerIndex].PurchaseIndex){	// this user will purchase songs, searching ends.
				searchingBuyer = false;
			}
		}
		return users[buyerIndex];
	}

	public Song[] generateRandomSongs(Songlist[] allSongLists, List<String> genreList, User buyer){
		// ----------- generate how many songs to buy -------------
		int genreNum = genreList.size();
		String genreFavorite = buyer.FavoriteGenre;
		int genreIndex = genreList.indexOf(genreFavorite);
		Songlist songListFavorite = allSongLists[genreIndex];

		int maxSongsNum = buyer.NumMaxSongs;
		Random randomGenerator = new Random();
		int numSongsBuy = randomGenerator.nextInt(maxSongsNum)+1;	// at least buy 1 song
		Song[] songsPurchased = new Song[numSongsBuy];
		int numFavoriteSongs = (int) Math.ceil(numSongsBuy/2.0);
		int numRandomSongs = numSongsBuy - numFavoriteSongs;
		int[] indexFavoriteSongs = new int[numFavoriteSongs];

		for(int i=0; i<numFavoriteSongs; i++){
			int rndIndex = randomGenerator.nextInt(songListFavorite.Number);
			if(i == 0){
				indexFavoriteSongs[0] = rndIndex;
			}
			else{
				boolean notRepeatIndex = true;
				do{
					notRepeatIndex = true;
					for(int j=0; j<i; j++){
						if(indexFavoriteSongs[j] == rndIndex){
							notRepeatIndex = false;
						}
					}
					if(notRepeatIndex){
						indexFavoriteSongs[i] = rndIndex;
					}
					else{
						rndIndex = randomGenerator.nextInt(songListFavorite.Number);
					}
				}while(notRepeatIndex == false);
			}
			songsPurchased[i] = songListFavorite.Songs[indexFavoriteSongs[i]];
		}

		// ----------------Generate Random Songs ----------------
		int[] rndGenreIndex = new int[numRandomSongs];
		int[] numSongsInGenre = new int[genreNum];
		for(int i=0; i < numRandomSongs; i++){
			rndGenreIndex[i] = randomGenerator.nextInt(genreNum);
			numSongsInGenre[rndGenreIndex[i]]++;
		}
		int songsPurchasedIndex = numFavoriteSongs;
		for(int i=0; i < genreNum; i++){
			if(numSongsInGenre[i]>0){
				int[] rndSongsIndex = generateNonRepeatNumbers(allSongLists[i].Number, numSongsInGenre[i]);
				for(int j=0; j<numSongsInGenre[i]; j++){
					songsPurchased[songsPurchasedIndex] = allSongLists[i].Songs[rndSongsIndex[j]];
					songsPurchasedIndex++;
				}
			}
		}


		return songsPurchased;
	}

	public int[] generateNonRepeatNumbers(int range, int num){
		int[] numNonRepeat = new int[num]; 
		Random randomGenerator = new Random();
		for(int i=0; i<num; i++){
			int rndNum = randomGenerator.nextInt(range);
			if(i == 0){
				numNonRepeat[0] = rndNum;
			}
			else{
				boolean notRepeatNum = true;
				do{
					notRepeatNum = true;
					for(int j=0; j<i; j++){
						if(numNonRepeat[j] == rndNum){
							notRepeatNum = false;
						}
					}
					if(notRepeatNum){
						numNonRepeat[i] = rndNum;
					}
					else{
						rndNum = randomGenerator.nextInt(range);
					}
				}while(notRepeatNum == false);
			}
		}
		return numNonRepeat;
	}

	public String toString(){
		return "On " + DateTrans + "\t" + Buyer + "\t purchased " + SongsPurchased.length + "\t songs.";
	}
}