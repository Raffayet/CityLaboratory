package deo1;

import java.util.ArrayList;

public class ObradjeniPodaci {
	
	private String godisnjiKvartal, tipUzorka;
	private double ukupnaCena;
	private ArrayList<String> nizJedinstvenihKlijenata;
	
	ObradjeniPodaci(){
		
	}

	public ObradjeniPodaci(String godisnjiKvartal, String tipUzorka, double ukupnaCena,
			ArrayList<String> nizJedinstvenihKlijenata) {
		super();
		this.godisnjiKvartal = godisnjiKvartal;
		this.tipUzorka = tipUzorka;
		this.ukupnaCena = ukupnaCena;
		this.nizJedinstvenihKlijenata = nizJedinstvenihKlijenata;
	}

	public String getGodisnjiKvartal() {
		return godisnjiKvartal;
	}

	public void setGodisnjiKvartal(String godisnjiKvartal) {
		this.godisnjiKvartal = godisnjiKvartal;
	}

	public String getTipUzorka() {
		return tipUzorka;
	}

	public void setTipUzorka(String tipUzorka) {
		this.tipUzorka = tipUzorka;
	}

	public double getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public ArrayList<String> getNizJedinstvenihKlijenata() {
		return nizJedinstvenihKlijenata;
	}

	public void setNizJedinstvenihKlijenata(ArrayList<String> nizJedinstvenihKlijenata) {
		this.nizJedinstvenihKlijenata = nizJedinstvenihKlijenata;
	}

	@Override
	public String toString() {
		return "ObradjeniPodaci [godisnjiKvartal=" + godisnjiKvartal + ", tipUzorka=" + tipUzorka + ", ukupnaCena="
				+ ukupnaCena + ", nizJedinstvenihKlijenata=" + nizJedinstvenihKlijenata + "]";
	}
	
}
