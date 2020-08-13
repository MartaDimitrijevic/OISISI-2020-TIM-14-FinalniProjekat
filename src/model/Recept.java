package model;

import java.util.Date;

public class Recept {
	private int sifra;
	private Korisnik lekar;
	private String jmbg;
	private Date datumIvreme;
	private Lekovi lek;
	private int kolicina;
	private float ukCena;
	private boolean obrisan;

	public Recept() {
	}

	public Recept(int sifra, Korisnik lekar, String jmbg, Date datumIvreme, Lekovi lek, int kolicina, float ukCena,
			boolean obrisan) {
		this.sifra = sifra;
		this.lekar = lekar;
		this.jmbg = jmbg;
		this.datumIvreme = datumIvreme;
		this.lek = lek;
		this.kolicina = kolicina;
		this.ukCena = ukCena;
		this.obrisan = obrisan;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra() {
		this.sifra = sifra;
	}

	public Korisnik getLekar() {
		return lekar;
	}
	
	public void setLekar() {
		this.lekar = lekar;
	}
	
	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg() {
		this.jmbg = jmbg;
	}

	public Date getDatumIvreme() {
		return datumIvreme;
	}

	public void setDatumIvreme() {
		this.datumIvreme = datumIvreme;
	}
	
	public Lekovi getLek() {
		return lek;
	}
	
	public void setLek() {
		this.lek = lek;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina() {
		this.kolicina = kolicina;
	}

	public float getUkCena() {
		return ukCena;
	}

	public void setUkCena() {
		this.ukCena = ukCena;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan() {
		this.obrisan = obrisan;
	}
}