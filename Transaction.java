// Song transaction class
import java.util.Date;
import java.util.GregorianCalendar;
import java.lang.Math;

public class Transaction{
	public String DateTrans;
	public Song[] SongsPurchased;
	public double PriceTotal;
	public String UserName;

	public Transaction(Songlist[] songRepository, String[] users){
		DateTrans = randomDate();


	}

	public Transaction(String date, Song[] songs, String user){
		DateTrans = date;
		SongsPurchased = songs;
		double tempPrice = 0;
		for(int i=0; i<songs.length; i++){
			tempPrice+=songs[i].Price;
		}
		UserName = user;
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
	}

	private int randBetween(int start, int end){
		return start + (int) Math.round(Math.random() * (end - start));
	}
}