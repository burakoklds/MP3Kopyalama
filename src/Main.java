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
		
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {

				kopyala("music2.mp3");
			}
			
		});
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {

				kopyala("music3.mp3");
			}
			
		});
		
		Thread thread3 = new Thread(new Runnable() {

			@Override
			public void run() {

				kopyala("music4.mp3");
			}
			
		});
		
		long baslang�c = System.currentTimeMillis();
		thread1.start();
		thread2.start();
		thread3.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		long bitis = System.currentTimeMillis();
		
		System.out.println("3 dosyan�n kopyalanmas� bu kadar s�rd� : " + ((bitis - baslang�c) / 1000) + "saniye");
		
	}
}
