package model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Recept implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4150572356720514260L;
	
	private int index;
	private int sifra;
	private String lekar;
	private String jmbg;
	private String datumIvreme;
	private Map<String, Integer> lekKolicina = new HashMap<String, Integer>();
	private boolean obrisan;

	public Recept() {
	}

	public Recept(int sifra, String lekar, String jmbg, String datumIvreme, Map<String, Integer> lekKolicina, boolean obrisan) {
		this.sifra = sifra;
		this.lekar = lekar;
		this.jmbg = jmbg;
		this.datumIvreme = datumIvreme;
		this.lekKolicina = lekKolicina;
		this.obrisan = obrisan;
	}

	public int getSifra() {
		return sifra;
	}

	public String getLekar() {
		return lekar;
	}

	public String getJmbg() {
		return jmbg;
	}
	
	public String getDatumIvreme() {
		return datumIvreme;
	}

	public Map<String, Integer> getLekKolicina() {
		return lekKolicina;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public void setLekar(String lekar) {
		this.lekar = lekar;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public void setDatumIvreme(String datumIvreme) {
		this.datumIvreme = datumIvreme;
	}

	public void setLekKolicina(Map<String, Integer> lekKolicina) {
		this.lekKolicina = lekKolicina;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
}