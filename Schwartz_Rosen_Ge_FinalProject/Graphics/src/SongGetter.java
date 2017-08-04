import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SongGetter {
	
	public static void main(String args[]) {
		
		Set<String> results = getRelatedArtists("Chris Brown");
		
	}
	
	//takes in an artist and returns a set of artist URLs
	public static Set<String> getRelatedArtists(String artist) {
		//get rid of the spaces in the artist name
		artist = artist.replaceAll("\\s","%20");
		
		Set<String> output = new HashSet<>();
		
		//searching for the artist and getting the url
		URLGetter g1 = new URLGetter("http://www.allmusic.com/search/all/" + artist);
		ArrayList<String> contents = g1.getContents();
		
		//going to the inputted artist's page
		//boolean to keep track of whether in artist section or not
		boolean inArtist = false;
		String artistURL = null;
		for(int i = 0; i < contents.size(); i++) {
			String currLine = contents.get(i);
			//System.out.println(currLine);
			
			if(currLine.contains("artist")) {
				//System.out.println("artist found");
				inArtist = true;	
			}
			
			if(inArtist) {
				Pattern p1 = Pattern.compile("<a href=\"http(.*)\" data-tooltip=");
				Matcher m1 = p1.matcher(contents.get(i));
				
				if(m1.find()) {
					artistURL = m1.group(1);
					break;
				}
			}
		}
		
		if(artistURL != null) {
			URLGetter g2 = new URLGetter("http" + artistURL + "/related");
			ArrayList<String> relatedContents = g2.getContents();
			
			boolean inRelated = false;
			
			for(int i = 0; i < relatedContents.size(); i++) {
				String currLine = relatedContents.get(i);
				
				if(currLine.contains("Similar To")) {
					inRelated = true;	
				}
				
				if(inRelated && output.size()<20) {
					Pattern p2 = Pattern.compile("<a href=\"http(.*)\" data-tooltip=");
					Matcher m2 = p2.matcher(relatedContents.get(i));
					
					if(m2.find()) {
						
						output.add("http" + m2.group(1));
						//System.out.println("http" + m2.group(1));
					}
				}
				if(currLine.contains("</section>")) {
					inRelated = false;
				}
			}
		}
		
		return output;
	}
	
	 public static String getSong(String artistURL) {
         URLGetter g1 = new URLGetter(artistURL + "/songs");
         ArrayList<String> contents = g1.getContents();
         StringBuilder page = new StringBuilder();
         for (String m : contents) {
                 page.append(m);
         }
         Document doc = Jsoup.parse(page.toString());
         Elements songs = doc.select("div.title");
         String artist = doc.select("h1.artist-name").first().text();
         int numSongs = songs.size();
         if(numSongs==0)
        	 return "";
         int index = new Random().nextInt(numSongs);
         String title = songs.get(index).child(0).text();
         return "\""+title+"\" - " + artist;
	 }

	 public static Set<String> getArtistMoods(String artistURL) {
		 URLGetter g1 = new URLGetter(artistURL);
		 Set<String> artistMoods = new HashSet<>();
		 ArrayList<String> contents = g1.getContents();
		 
		 StringBuilder page = new StringBuilder();
		 for (String m : contents) {
		         page.append(m);
		 }
		 Document doc = Jsoup.parse(page.toString());
		 Elements moods = doc.select("section.moods");
		 if(moods == null || moods.isEmpty()) {
			 return null;
		 }
		 Element moods2 = moods.first().child(1);
		 Elements listOfMoods = moods2.children();
		 for (Element e : listOfMoods) {
		         artistMoods.add(e.text().toLowerCase());
		 }
		 return artistMoods;
	 }
}
