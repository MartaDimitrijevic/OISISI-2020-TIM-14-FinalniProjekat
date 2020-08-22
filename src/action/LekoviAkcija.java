package action;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



import model.Lekovi;



public class LekoviAkcija {
	public LekoviAkcija() {};
	
	public static void kreirajLek(String ime, String sifra, String proizvodjac, boolean narecept, float cena, boolean obrisan) {
				Lekovi lek1 = new Lekovi("Amoksicilin", "J01CA04 ",  "FARMALOGIST D.O.O.", true, 145, false  );
				Lekovi lek2 = new Lekovi("Hemomycin", "BR3348G", "Pliva a.d.", true, 220, false );
				Lekovi lek3 = new Lekovi("Propafen", "M01AE01", "HEMOFARM A.D.",true, 172,false );
				Lekovi lek4 = new Lekovi("Bactrim", "N02BE51", "ALKALOD A.D.",true, 205 ,false);
				Lekovi lek5 = new Lekovi("Eritromicin", "A02BC01", "Zdravlje a.d.", true, 350, false);
				Lekovi lek6 = new Lekovi("Milenol", "E06AX", "HEMOFARM A.D.", true, 275,false );
				Lekovi lek7 = new Lekovi("Ciprocianl", "D07AC13", "GALENIKA A.D.", true, 863, false);
				Lekovi lek8 = new Lekovi("Palitrex", "R06AX27", "Slaviamed a.d.", true, 220,false);
				Lekovi lek9 = new Lekovi("Madopar",  "A07AA09", "HEMOFARM A.D.", true, 720,false);
				Lekovi lek10 = new Lekovi("Cetirizin", "N06AX16", "GALENIKA A.D.",true,98,false  );
				Lekovi lek11 = new Lekovi("Ciprocinal", "J01XA01", "Lek a.d.", true, 1400,false  );
				Lekovi lek12 = new Lekovi("Triplixam", "C09B0X1", "Servior Ireland", false, 1017,false);
				Lekovi lek13 = new Lekovi( "Itanem", "J01DHO2", "GALENIKA A.D.",false,6552,false );
				Lekovi lek14 = new Lekovi( "Vesicare", "G04BD08", "Astellas d.o.o.",false,1545,false );
				Lekovi lek15 = new Lekovi("Aluvia", "J05AR10", "ABBVIE.KG.",false,9606,false );
				Lekovi lek16 = new Lekovi("Opitiray", "V08ABO7", "MEDICOM D.O.O.",false,17078,false);
				
				
	
		Lekovi noviLek = new Lekovi();
		noviLek.setIme(ime);
		noviLek.setSifra(sifra);
		noviLek.setProizvodjac(proizvodjac);
		noviLek.setNarecept(narecept);
		noviLek.setCena(cena);
		noviLek.setObrisan(false);
		
		try {
			String fileName = "kreiraniLekovi4.txt";
			File file = new File(fileName);
			if (!file.exists()) {
				noviLek.setSifra(sifra);
				ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(fileName));
				objectOutput.writeObject(noviLek);
				
				objectOutput.flush();
				objectOutput.close();
				
			} else {
				System.out.println("Fajl postoji");
				ArrayList <Lekovi> trenutniLekovi = ucitajLekove(fileName);
				Lekovi poslednjiLek = trenutniLekovi.get(trenutniLekovi.size() - 1);
				String poslednjaSifra = poslednjiLek.getSifra();
				String novaSifra = poslednjaSifra + 1;
				noviLek.setSifra(novaSifra);
				System.out.println("Poslednja sifra" + novaSifra);
				
				ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(fileName));
				trenutniLekovi.add(noviLek);
				for(Lekovi leko: trenutniLekovi) {
					objectOutput.writeObject(leko);
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
	
		public static  ArrayList<Lekovi> ucitajLekove(String fileName){
			ArrayList<Lekovi> sviLekovi = new ArrayList<Lekovi>();
			try {
				ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(fileName));
				while(true) {
					try {
						Lekovi leko = (Lekovi) objectInput.readObject();
						sviLekovi.add(leko);
					} catch(EOFException ex) {
						objectInput.close();
						return sviLekovi;
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
			return sviLekovi;
		}
}
