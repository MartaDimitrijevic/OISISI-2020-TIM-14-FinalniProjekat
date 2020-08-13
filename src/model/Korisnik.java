package model;

public class Korisnik {

	private String ime;
	private String prezime;
	private TipKor tip;
	private String korIme;
	private String lozinka;
	private boolean obrisan;

	public Korisnik() {
	}

	public Korisnik(String ime, String prezime, TipKor tip, String korIme, String lozinka, boolean obrisan) {
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

	public String korIme() {
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

	public enum TipKor { // ne znam sto ovde mora enum da ide

		LEKAR("Lekar"), APOTEKAR("Apotekar"), ADMIN("Administrator");
		// NONE(" "); ne znam da li mora none

		private String opis;

		private TipKor(String opis) {
			this.opis = opis;
		}

		public String getOpis() {
			return opis;
		}

	}

	public TipKor getTip() {
		return tip;
	}

	public void setTip(TipKor tip) {
		this.tip = tip;
	}

}
