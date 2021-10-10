package deo1;

public class Uzorak {
	
	private String evidencioniBroj, tipUzorka, klijent, datumIVremePrispeca, opisAnalize;
	private int cena;
	
	public Uzorak() {
		
	}
	
	public Uzorak(String evidencioniBroj, String tipUzorka, String klijent, String datumIVremePrispeca,
			String opisAnalize, int cena) {
		super();
		this.evidencioniBroj = evidencioniBroj;
		this.tipUzorka = tipUzorka;
		this.klijent = klijent;
		this.datumIVremePrispeca = datumIVremePrispeca;
		this.opisAnalize = opisAnalize;
		this.cena = cena;
	}

	public String getEvidencioniBroj() {
		return evidencioniBroj;
	}

	public void setEvidencioniBroj(String evidencioniBroj) {
		this.evidencioniBroj = evidencioniBroj;
	}

	public String getTipUzorka() {
		return tipUzorka;
	}

	public void setTipUzorka(String tipUzorka) {
		this.tipUzorka = tipUzorka;
	}

	public String getKlijent() {
		return klijent;
	}

	public void setKlijent(String klijent) {
		this.klijent = klijent;
	}

	public String getDatumIVremePrispeca() {
		return datumIVremePrispeca;
	}

	public void setDatumIVremePrispeca(String datumIVremePrispeca) {
		this.datumIVremePrispeca = datumIVremePrispeca;
	}

	public String getOpisAnalize() {
		return opisAnalize;
	}

	public void setOpisAnalize(String opisAnalize) {
		this.opisAnalize = opisAnalize;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	@Override
	public String toString() {
		return "Uzorak [evidencioniBroj=" + evidencioniBroj + ", tipUzorka=" + tipUzorka + ", klijent=" + klijent
				+ ", datumIVremePrispeca=" + datumIVremePrispeca + ", opisAnalize=" + opisAnalize + ", cena=" + cena
				+ "]";
	}	

}
