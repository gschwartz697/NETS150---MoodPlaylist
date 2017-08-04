import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ButtonBox implements Runnable {
	
	public static final int COURT_WIDTH = 800;
	public static final int COURT_HEIGHT = 800;
	private Graphics g;
	private String mood;
	private String artist;
	private HashSet<String> happy_set = new HashSet<>();
	private HashSet<String> aggressive_set = new HashSet<>();
	private HashSet<String> celebratory_set = new HashSet<>();
	private HashSet<String> introspective_set = new HashSet<>();
	private HashSet<String> somber_set = new HashSet<>();
	private HashSet<String> confident_set = new HashSet<>();
	private HashSet<String> romantic_set = new HashSet<>();
	private HashSet<String> peaceful_set = new HashSet<>();
	private Set<String> related_artists = new HashSet<>();
	private Set<String> mood_set = new HashSet<>();
	private Set<String> songs = new HashSet<>();
	
	public ButtonBox (){
	
	}
	public void run(){
		String[] happy_strs = { "animated", "euphoric", "optimistic", "sweet", "summery", 
				"sentimental", "romantic", "frollicking", "joyous", "innocent", "gleeful", 
				"fun", "freewheeling", "exuberant", "cheerful", "celebratory", "carefree", 
				"amiable/good-natured" };
		for(String h : happy_strs){
			happy_set.add(h);
		}
		String[] angry_strs = { "confrontational", "visceral", "reckless", "rebellious", "provocative", "angry",
				"volatile", "thuggish", "tense/anxious", "street-smart", "rowdy", "rousing", "raucous",
				"rambunctious", "outrageous", "menacing", "malevolent", "intense", "hostile", "harsh", 
				"fiery", "confident", "cathartic", "boisterous", "angst-ridden", "energetic" };
		for(String a : angry_strs){
			aggressive_set.add(a);
		}
		String[] celebratory_strs = {"hedonistic", "carefree", "confident", "sexy", "sensual", 
				"fun", "exuberant", "energetic", "happy", "freewheeling", "boisterous", "sexual",
				"joyous", "playful", "soft/quiet"};
		for(String c : celebratory_strs){
			celebratory_set.add(c);
		}
		String[] introspective_strs = {"flowing", "passionate", "sprawling", "swaggering", 
				"elegant", "intimate", "cathartic", "hypnotic", "lonely", "romantic", "stylish",
				"dreamy", "intense", "yearning", "sweet"};
		for(String i : introspective_strs){
			introspective_set.add(i);
		}
		String[] somber_strs = {"melancholy", "gloomy", "wintry", "weary", "restrained",
				"nocturnal", "bleak", "angst-ridden", "reflective", "poignant", "ominous", 
				"enigmatic", "detached", "brooding", "autumnal", "wistful", "tense/anxious",
				"sad", "bittersweet", "plaintive", "cathartic"};
		for(String som : somber_strs){
			somber_set.add(som);
		}
		String[] confident_strs = {"exuberant", "carefree", "brash", "boisterous",
				"amiable/good-natured", "urgent", "street-smart", "sexy", "rebellious",
				"freewheeling", "energetic", "earnest", "confrontational", "celebratory", "ambitious"};
		for(String con : confident_strs){
			confident_set.add(con);
		}
		String[] romantic_strs = {"passionate", "joyous", "elegant", "sweet", "sensual", "lush",
				"intimate", "earnest", "poignant", "laid-back/mellow", "gentle", "happy", "amibale/good-natured"};
		for(String r : romantic_strs){
			romantic_set.add(r);
		}
		String[] peaceful_strs = {"gentle", "soothing", "clam/peaceful", "reflective", 
				"intimate", "restrained", "reserved", "poignant", "ethereal", "delicate", 
				"earnest"};
		for(String p : peaceful_strs){
			romantic_set.add(p);
		}
		JFrame project = new JFrame();
		JPanel b = new JPanel();
		ImageIcon top = new ImageIcon(getClass().getResource("BANNER.jpg"));
		Image img = top.getImage();
		Image newimg = img.getScaledInstance(700, 350,  java.awt.Image.SCALE_SMOOTH);
		top = new ImageIcon(newimg);
		b.add((new JLabel(top)), BorderLayout.NORTH);
		project.add(b, BorderLayout.NORTH);
		b.setBackground(Color.yellow);
		
		JPanel buttons = new JPanel();
		buttons.setSize(800, 800);
		buttons.setBackground(Color.yellow);
		ImageIcon h = new ImageIcon(getClass().getResource("happy.jpg"));
		img = h.getImage();
		newimg = img.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
		h = new ImageIcon(newimg);
		JButton happy = new JButton(h);
		happy.setText("Happy");
		happy.setVerticalTextPosition(SwingConstants.BOTTOM);
		happy.setHorizontalTextPosition(SwingConstants.CENTER);
		happy.setFont(new Font("Ariel", Font.BOLD , 25));
		happy.setForeground(Color.black);
		happy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mood = "happy";
				mood_set = happy_set;
				project.dispose();
				newwindow();
			}
		});
		buttons.add(happy);
		
		ImageIcon m = new ImageIcon(getClass().getResource("mad.jpg"));
		img = m.getImage();
		newimg = img.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
		m = new ImageIcon(newimg);
		JButton mad = new JButton(m);
		mad.setText("Aggressive");
		mad.setVerticalTextPosition(SwingConstants.BOTTOM);
		mad.setHorizontalTextPosition(SwingConstants.CENTER);
		mad.setFont(new Font("Ariel", Font.BOLD , 25));
		mad.setForeground(Color.black);
		mad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mood = "mad";
				mood_set = aggressive_set;
				project.dispose();
				newwindow();
			}
		});
		buttons.add(mad);
		
		ImageIcon p = new ImageIcon(getClass().getResource("partying.jpg"));
		img = p.getImage();
		newimg = img.getScaledInstance(150, 100,  java.awt.Image.SCALE_SMOOTH);
		p = new ImageIcon(newimg);
		JButton partying = new JButton(p);
		partying.setText("Celebratory");
		partying.setVerticalTextPosition(SwingConstants.BOTTOM);
		partying.setHorizontalTextPosition(SwingConstants.CENTER);
		partying.setFont(new Font("Ariel", Font.BOLD , 25));
		partying.setForeground(Color.black);
		partying.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mood = "celebratory";
				mood_set = celebratory_set;
				project.dispose();
				newwindow();	
			}
		});
		buttons.add(partying);
		
		ImageIcon w = new ImageIcon(getClass().getResource("working.jpg"));
		img = w.getImage();
		newimg = img.getScaledInstance(80, 100,  java.awt.Image.SCALE_SMOOTH);
		w = new ImageIcon(newimg);
		JButton working = new JButton(w);
		working.setText("Introspective");
		working.setVerticalTextPosition(SwingConstants.BOTTOM);
		working.setHorizontalTextPosition(SwingConstants.CENTER);
		working.setFont(new Font("Ariel", Font.BOLD , 25));
		working.setForeground(Color.black);
		working.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mood = "introspective";
				mood_set = introspective_set;
				project.dispose();
				newwindow();
			}
		});
		buttons.add(working);
		
		JPanel buttons1 = new JPanel();
		buttons1.setSize(800, 800);
		buttons1.setBackground(Color.yellow);
		
		ImageIcon t = new ImageIcon(getClass().getResource("sad.jpg"));
		img = t.getImage();
		newimg = img.getScaledInstance(85, 100,  java.awt.Image.SCALE_SMOOTH);
		t = new ImageIcon(newimg);
		JButton sad = new JButton(t);
		sad.setText("Somber");
		sad.setVerticalTextPosition(SwingConstants.BOTTOM);
		sad.setHorizontalTextPosition(SwingConstants.CENTER);
		sad.setFont(new Font("Ariel", Font.BOLD , 25));
		sad.setForeground(Color.black);
		sad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mood = "somber";
				mood_set = somber_set;
				project.dispose();
				newwindow();
			}
		});
		buttons1.add(sad);
		
		ImageIcon l = new ImageIcon(getClass().getResource("carl.jpg"));
		img = l.getImage();
		newimg = img.getScaledInstance(120, 100,  java.awt.Image.SCALE_SMOOTH);
		l = new ImageIcon(newimg);
		JButton loud = new JButton(l);
		loud.setText("Confident");
		loud.setVerticalTextPosition(SwingConstants.BOTTOM);
		loud.setHorizontalTextPosition(SwingConstants.CENTER);
		loud.setFont(new Font("Ariel", Font.BOLD , 25));
		loud.setForeground(Color.black);
		loud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mood = "confident";
				mood_set = confident_set;
				project.dispose();
				newwindow();
			}
		});
		buttons1.add(loud);
		
		ImageIcon lv = new ImageIcon(getClass().getResource("love.jpg"));
		img = lv.getImage();
		newimg = img.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
		lv = new ImageIcon(newimg);
		JButton love = new JButton(lv);
		love.setText("Romantic");
		love.setVerticalTextPosition(SwingConstants.BOTTOM);
		love.setHorizontalTextPosition(SwingConstants.CENTER);
		love.setFont(new Font("Ariel", Font.BOLD , 25));
		love.setForeground(Color.black);
		love.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mood = "romantic";
				mood_set = romantic_set;
				project.dispose();
				newwindow();
			}
		});
		buttons1.add(love);
				
		ImageIcon a = new ImageIcon(getClass().getResource("acoustic.jpg"));
		img = a.getImage();
		newimg = img.getScaledInstance(110, 100,  java.awt.Image.SCALE_SMOOTH);
		a = new ImageIcon(newimg);
		JButton acoustic = new JButton(a);
		acoustic.setText("Peaceful");
		acoustic.setVerticalTextPosition(SwingConstants.BOTTOM);
		acoustic.setHorizontalTextPosition(SwingConstants.CENTER);
		acoustic.setFont(new Font("Ariel", Font.BOLD , 25));
		acoustic.setForeground(Color.black);
		acoustic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mood = "peaceful";
				mood_set = peaceful_set;
				project.dispose();
				newwindow();
			}
		});
		buttons1.add(acoustic);
		
		
		
		project.add(buttons);
		project.add(buttons1, BorderLayout.SOUTH);
		project.pack();
		project.setLocation(500, 100);
		project.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		project.setVisible(true);

	}
	
	public void newwindow(){
		JFrame frame = new JFrame();

		JPanel b = new JPanel();
		ImageIcon top = new ImageIcon(getClass().getResource("music.jpg"));
		Image img = top.getImage();
		Image newimg = img.getScaledInstance(800, 400,  java.awt.Image.SCALE_SMOOTH);
		top = new ImageIcon(newimg);
		b.add((new JLabel(top)), BorderLayout.NORTH);
		
		JPanel enterArtist = new JPanel(); 
		enterArtist.setSize(100, 100);
		enterArtist.setBackground(Color.blue);
       
		final JButton button = new JButton("Choose an Artist");
        button.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	artist = JOptionPane.showInputDialog("What is your favorite artist?", null);
                frame.dispose();
                related_artists = SongGetter.getRelatedArtists(artist.toLowerCase());                
            	playlist();
                
            }
        });
        
        button.setFont(new Font("Ariel", Font.BOLD | Font.ITALIC , 30));
		button.setForeground(Color.blue);
		button.setSize(50, 50);
		
		enterArtist.add(button);
		
		enterArtist.add(button);
		frame.add(b, BorderLayout.NORTH);
		frame.add(enterArtist, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocation(500, 100);
		frame.setVisible(true);	
		
	}

	
	public void playlist(){
		JFrame frame = new JFrame();
		JPanel b = new JPanel();
		ImageIcon top = new ImageIcon(getClass().getResource("playlist.jpg"));
		Image img = top.getImage();
		Image newimg = img.getScaledInstance(700, 350,  java.awt.Image.SCALE_SMOOTH);
		top = new ImageIcon(newimg);
		b.add((new JLabel(top)), BorderLayout.NORTH);
		JPanel l = new JPanel();
		JLabel list = new JLabel();
		b.setBackground(Color.black);
		l.add(list);
		l.setBackground(Color.black);
		list.setFont(new Font("Ariel", Font.BOLD, 20));
		list.setForeground(Color.white);
		for(String artistURL : related_artists){
        	Set<String> artistmoods = SongGetter.getArtistMoods(artistURL);	
        	if(artistmoods != null && !Collections.disjoint(mood_set, artistmoods)){
	            songs.add(SongGetter.getSong(artistURL));
        	}
        }
		String txt = "<html>This is your playlist based on your mood " + mood.toUpperCase() + ", and your favorite artist "+ artist.toUpperCase() +":<br>";
		for(String s : songs){
			txt+=("<br>"+s);
		}
		txt+="</html>";
		list.setText(txt);
		frame.add(b, BorderLayout.NORTH);
		frame.add(l, BorderLayout.SOUTH);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(500, 100);
		frame.setVisible(true);
	}
	

	public static void main(String[] args) throws IOException {
		SwingUtilities.invokeLater(new ButtonBox());
	}
}
