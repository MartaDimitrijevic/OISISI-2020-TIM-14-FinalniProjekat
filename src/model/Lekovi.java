package model;

import java.io.Serializable;

public class Lekovi implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 256974565215620002L;
												 
	
	private String sifra;
	private String ime;
	private String proizvodjac;
	private boolean narecept;
	private float cena;
	private boolean obrisan;

	public Lekovi() {
	}

	public Lekovi(String sifra, String ime, String proizvodjac, boolean narecept, float cena, boolean obrisan) {
		this.sifra = sifra;
		this.ime = ime;
		this.proizvodjac = proizvodjac;
		this.narecept = narecept;
		this.cena = cena;
		this.obrisan = obrisan;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public boolean isNarecept() {
		return narecept;
	}

	public void setNarecept(boolean narecept) {
		this.narecept = narecept;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	
}
