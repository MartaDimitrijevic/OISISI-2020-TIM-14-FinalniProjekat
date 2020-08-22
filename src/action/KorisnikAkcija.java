package action;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import application.MainFrame;
import model.Korisnik;
import model.Recept;
import model.TipKorisnika;


public class KorisnikAkcija {
	
	public KorisnikAkcija() {}
	
	public void registracijaKorisnika (String ime, String prezime, TipKorisnika tip, String korIme, String lozinka, boolean obrisan) throws ClassNotFoundException {
		
		Korisnik noviKorisnik = new Korisnik();
		noviKorisnik.setIme(ime);
		noviKorisnik.setPrezime(prezime);
		noviKorisnik.setTip(tip);
		noviKorisnik.setLozinka(lozinka);
		noviKorisnik.setObrisan(false);
		noviKorisnik.setKorIme(korIme); 

		ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
		try {
			ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream("korisnik.txt"));
			try {
				while (true) {
					Korisnik kor = (Korisnik) objectInput.readObject();
					if(kor == null)
						break;
					korisnici.add(kor);
				}
			} catch (EOFException eof) {
				
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			objectInput.close();

			String fileName = "korisnik.txt";
			File file = new File(fileName);
			ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(file));
			
			Boolean postoji = false;
			for(Korisnik k : korisnici) {
				if(k.getKorIme().equals(noviKorisnik.getKorIme())) {
					System.out.println("Username je vec u upotrebi");
					JOptionPane.showMessageDialog(null, "Username je vec u upotrebi", "Greška", JOptionPane.ERROR_MESSAGE);
					postoji = true;
					break;
				}
			}
			if(!postoji) {
				korisnici.add(noviKorisnik);
				for(Korisnik k : korisnici) {
					objectOutput.writeObject(k);
				}
			} else {
				for(Korisnik k : korisnici) {
					objectOutput.writeObject(k);
				}
			}
			
			
			objectOutput.flush();
			objectOutput.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Korisnik> ucitajKorisnike(String fileName){
		ArrayList<Korisnik> sviKorisnici = new ArrayList<Korisnik>();
		try {
			ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(fileName));
			while(true) {
				try {
					Korisnik korReg = (Korisnik) objectInput.readObject();
					sviKorisnici.add(korReg);
				} catch(EOFException ex) {
					objectInput.close();
					return sviKorisnici;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sviKorisnici;
	}
}


