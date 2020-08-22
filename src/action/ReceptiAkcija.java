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

import model.Korisnik;
import model.Recept;

public class ReceptiAkcija {
	public ReceptiAkcija() {};
	
	public void kreirajRecept(String jmbg, String lek, String kolicina, Korisnik korisnik) {
		String[] listaLekova = lek.split(",");
		String[] listaKolicina = kolicina.split(",");
		
		Map<String, Integer> lekKolicina = new HashMap<String, Integer>();
		for(int i = 0; i < listaLekova.length; i++) {
			String lekInt = String.valueOf(listaLekova[i]);
			Integer kolicinaInt = Integer.valueOf(listaKolicina[i]);
			lekKolicina.put(lekInt, kolicinaInt);
		}

		DateTimeFormatter datumIVreme = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime trenutno = LocalDateTime.now();
		String trenutnoString = datumIVreme.format(trenutno);
		System.out.println(datumIVreme.format(trenutno));
		
		String lekar = korisnik.getIme() + " " + korisnik.getPrezime();
		System.out.println(korisnik.getIme() + "\t" + korisnik.getPrezime() + "\t");
		
		Recept novRecept = new Recept();
		novRecept.setDatumIvreme(trenutnoString);
		novRecept.setLekar(lekar);
		novRecept.setJmbg(jmbg);
		novRecept.setLekKolicina(lekKolicina);
		novRecept.setObrisan(false);
		
		try {
			String fileName = "kreiraniRecepti.txt";
			File file = new File(fileName);
			if (!file.exists()) {
				novRecept.setSifra(1); 
				ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(fileName));
				objectOutput.writeObject(novRecept);
				
				objectOutput.flush();
				objectOutput.close();
			} else {
				System.out.println("Fajl postoji");
				ArrayList<Recept> trenutniRecepti = ucitajRecepte(fileName);
				Recept poslednjiRecept = trenutniRecepti.get(trenutniRecepti.size() - 1);
				int poslednjaSifra = poslednjiRecept.getSifra();
				int novaSifra = poslednjaSifra + 1;
				novRecept.setSifra(novaSifra);
				System.out.println("Poslednja sifra" + novaSifra);
				
				ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(fileName));
				trenutniRecepti.add(novRecept);
				for(Recept recept: trenutniRecepti) {
					objectOutput.writeObject(recept);
				}
				objectOutput.flush();
				objectOutput.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Recept> ucitajRecepte(String fileName){
		ArrayList<Recept> sviRecepti = new ArrayList<Recept>();
		try {
			ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(fileName));
			while(true) {
				try {
					Recept rec = (Recept) objectInput.readObject();
					sviRecepti.add(rec);
				} catch(EOFException ex) {
					objectInput.close();
					return sviRecepti;
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
		return sviRecepti;
	}
}
