package model;

import java.io.Serializable;

public class Korisnik implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 506164890054350708L;
	
	private String ime;
	private String prezime;
	private TipKorisnika tip;
	private String korIme;
	private String lozinka;
	private boolean obrisan;

	public Korisnik() {
	}

	public Korisnik(String ime, String prezime, TipKorisnika tip, String korIme, String lozinka, boolean obrisan) {
		this.ime = ime;
		this.prezime = prezime;
		this.tip = tip;
		this.korIme = korIme;
		this.lozinka = lozinka;
		this.obrisan = obrisan;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getKorIme() {
		return korIme;
	}

	public void setKorIme(String korIme) {
		this.korIme = korIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

//	public enum TipKor { // ne znam sto ovde mora enum da ide
//
//		LEKAR("Lekar"), APOTEKAR("Apotekar"), ADMIN("Administrator");
//		// NONE(" "); ne znam da li mora none
//
//		private String opis;
//
//		private TipKor(String opis) {
//			this.opis = opis;
//		}
//
//		public String getOpis() {
//			return opis;
//		}
//
//	}

	public TipKorisnika getTip() {
		return tip;
	}

	public void setTip(TipKorisnika tip) {
		this.tip = tip;
	}
	
	
}
