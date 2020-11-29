import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	private static ArrayList<Integer> icerik = new ArrayList<Integer>();
	
	public static void dosyaOku() {
		
		try {
			FileInputStream in = new FileInputStream("Music.mp3");
			
			int oku;
			
			while((oku = in.read()) != -1) {
				
				icerik.add(oku);
			}
		}
		catch (IOException ex) {
			System.out.println("Hata");
		}
	}
	
	public static void kopyala(String dosyaismi) {
		
		FileOutputStream out;
		try {
			out = new FileOutputStream(dosyaismi);
			
			for (int deger : icerik) {
				
				out.write(deger);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		dosyaOku();
		kopyala("music.mp3");
	}
}
