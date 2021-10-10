package deo1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();

		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

		GradskaLaboratorija gradskaLaboratorija = null;
		
		gradskaLaboratorija = ucitavanje(gradskaLaboratorija, mapper);
		
		ArrayList <Uzorak> mlecniUzorci = new ArrayList<Uzorak>();	//grupisanje po tipu uzorka (ja sam stavio 3 grupe)
		ArrayList <Uzorak> animalniUzorci = new ArrayList<Uzorak>();	
		ArrayList <Uzorak> pekarskiUzorci = new ArrayList<Uzorak>();
		
		ArrayList <Uzorak> Q1 = new ArrayList<Uzorak>();				// ove 4 liste su grupisane po godisnjim kvartalima
		ArrayList <Uzorak> Q2 = new ArrayList<Uzorak>();				// podelio sam onu glavnu sa svim uzorcima na te 4 
		ArrayList <Uzorak> Q3 = new ArrayList<Uzorak>();				// manje liste
		ArrayList <Uzorak> Q4 = new ArrayList<Uzorak>();
		
		grupisanjeISortiranjePoKvartalima(gradskaLaboratorija, Q1, Q2, Q3, Q4);
		
		grupisanjePoTipuUzorka(gradskaLaboratorija, mlecniUzorci, animalniUzorci, pekarskiUzorci);
		
		ArrayList<Double> ukupneCene = racunanjeUkupneCene(gradskaLaboratorija, Q1, Q2, Q3, Q4, mlecniUzorci,
				animalniUzorci, pekarskiUzorci);
		
		ArrayList<ArrayList<String>> jedinstveniKlijenti = kreiranjeNizaKlijenata(gradskaLaboratorija, Q1, Q2, Q3, Q4, 
				mlecniUzorci,
				animalniUzorci, pekarskiUzorci);
		
		upisivanje(ukupneCene, jedinstveniKlijenti);
		
	}


	private static ArrayList<ArrayList<String>> kreiranjeNizaKlijenata(GradskaLaboratorija gradskaLaboratorija, 
			ArrayList<Uzorak> Q1, ArrayList<Uzorak>
	Q2, ArrayList<Uzorak> Q3, ArrayList<Uzorak> Q4, ArrayList<Uzorak> mlecniUzorci, ArrayList<Uzorak> animalniUzorci, 
	ArrayList<Uzorak> pekarskiUzorci) {
		
		ArrayList<String> Q1Mlecni = new ArrayList<String>();
		ArrayList<String> Q1Animalni = new ArrayList<String>();
		ArrayList<String> Q1Pekarski = new ArrayList<String>();
		ArrayList<String> Q2Mlecni = new ArrayList<String>();
		ArrayList<String> Q2Animalni = new ArrayList<String>();
		ArrayList<String> Q2Pekarski = new ArrayList<String>();
		ArrayList<String> Q3Mlecni = new ArrayList<String>();
		ArrayList<String> Q3Animalni = new ArrayList<String>();
		ArrayList<String> Q3Pekarski = new ArrayList<String>();
		ArrayList<String> Q4Mlecni = new ArrayList<String>();
		ArrayList<String> Q4Animalni = new ArrayList<String>();
		ArrayList<String> Q4Pekarski = new ArrayList<String>();
		
		for (Uzorak uzorak : gradskaLaboratorija.getUzorci()) {
			
			if (Q1.contains(uzorak) && mlecniUzorci.contains(uzorak)) {
				
				Q1Mlecni.add(uzorak.getKlijent());
			}
			
			else if (Q1.contains(uzorak) && animalniUzorci.contains(uzorak)) {
				
				Q1Animalni.add(uzorak.getKlijent());
			}
			
			else if (Q1.contains(uzorak) && pekarskiUzorci.contains(uzorak)) {
				
				Q1Pekarski.add(uzorak.getKlijent());
			}
			
			else if (Q2.contains(uzorak) && mlecniUzorci.contains(uzorak)) {
				
				Q2Mlecni.add(uzorak.getKlijent());
			}
			
			else if (Q2.contains(uzorak) && animalniUzorci.contains(uzorak)) {
				
				Q2Animalni.add(uzorak.getKlijent());
			}
			
			else if (Q2.contains(uzorak) && pekarskiUzorci.contains(uzorak)) {
				
				Q2Pekarski.add(uzorak.getKlijent());
			}
			
			else if (Q3.contains(uzorak) && mlecniUzorci.contains(uzorak)) {
				
				Q3Mlecni.add(uzorak.getKlijent());
			}
			
			else if (Q3.contains(uzorak) && animalniUzorci.contains(uzorak)) {
				
				Q3Animalni.add(uzorak.getKlijent());
			}
			
			else if (Q3.contains(uzorak) && pekarskiUzorci.contains(uzorak)) {
				
				Q3Pekarski.add(uzorak.getKlijent());
			}
			
			else if (Q4.contains(uzorak) && mlecniUzorci.contains(uzorak)) {
				
				Q4Mlecni.add(uzorak.getKlijent());
			}
			
			else if (Q4.contains(uzorak) && animalniUzorci.contains(uzorak)) {
				
				Q4Animalni.add(uzorak.getKlijent());
			}
			
			else if (Q4.contains(uzorak) && pekarskiUzorci.contains(uzorak)) {
				
				Q4Pekarski.add(uzorak.getKlijent());
			}
		}
		
		ArrayList<ArrayList<String>> sviKlijenti = new ArrayList<ArrayList<String>>();
		sviKlijenti.add(Q1Mlecni);
		sviKlijenti.add(Q1Animalni);
		sviKlijenti.add(Q1Pekarski);
		sviKlijenti.add(Q2Mlecni);
		sviKlijenti.add(Q2Animalni);
		sviKlijenti.add(Q2Pekarski);
		sviKlijenti.add(Q3Mlecni);
		sviKlijenti.add(Q3Animalni);
		sviKlijenti.add(Q3Pekarski);
		sviKlijenti.add(Q4Mlecni);
		sviKlijenti.add(Q4Animalni);
		sviKlijenti.add(Q4Pekarski);	
		
		return sviKlijenti;
	}


	private static ArrayList<Double> racunanjeUkupneCene(GradskaLaboratorija gradskaLaboratorija, ArrayList<Uzorak> Q1, ArrayList<Uzorak>
	Q2, ArrayList<Uzorak> Q3, ArrayList<Uzorak> Q4, ArrayList<Uzorak> mlecniUzorci, ArrayList<Uzorak> animalniUzorci, 
	ArrayList<Uzorak> pekarskiUzorci) {
		
		double cenaQ1Mlecni = 0, cenaQ1Animalni = 0, cenaQ1Pekarski = 0, cenaQ2Mlecni = 0, cenaQ2Animalni = 0, 
				cenaQ2Pekarski = 0, cenaQ3Mlecni = 0, cenaQ3Animalni = 0, cenaQ3Pekarski = 0, cenaQ4Mlecni = 0, 
				cenaQ4Animalni = 0, cenaQ4Pekarski = 0;
		
		for (Uzorak uzorak : gradskaLaboratorija.getUzorci()) {
			
			if (Q1.contains(uzorak) && mlecniUzorci.contains(uzorak)) {
				
				cenaQ1Mlecni = cenaQ1Mlecni + uzorak.getCena();
			}
			
			else if (Q1.contains(uzorak) && animalniUzorci.contains(uzorak)) {
				
				cenaQ1Animalni = cenaQ1Animalni + uzorak.getCena();
			}
			
			else if (Q1.contains(uzorak) && pekarskiUzorci.contains(uzorak)) {
				
				cenaQ1Pekarski = cenaQ1Pekarski + uzorak.getCena();
			}
			
			else if (Q2.contains(uzorak) && mlecniUzorci.contains(uzorak)) {
				
				cenaQ2Mlecni = cenaQ2Mlecni + uzorak.getCena();
			}
			
			else if (Q2.contains(uzorak) && animalniUzorci.contains(uzorak)) {
				
				cenaQ2Animalni = cenaQ2Animalni + uzorak.getCena();
			}
			
			else if (Q2.contains(uzorak) && pekarskiUzorci.contains(uzorak)) {
				
				cenaQ2Pekarski = cenaQ2Pekarski + uzorak.getCena();
			}
			
			else if (Q3.contains(uzorak) && mlecniUzorci.contains(uzorak)) {
				
				cenaQ3Mlecni = cenaQ3Mlecni + uzorak.getCena();
			}
			
			else if (Q3.contains(uzorak) && animalniUzorci.contains(uzorak)) {
				
				cenaQ3Animalni = cenaQ3Animalni + uzorak.getCena();
			}
			
			else if (Q3.contains(uzorak) && pekarskiUzorci.contains(uzorak)) {
				
				cenaQ3Pekarski = cenaQ3Pekarski + uzorak.getCena();
			}
			
			else if (Q4.contains(uzorak) && mlecniUzorci.contains(uzorak)) {
				
				cenaQ4Mlecni = cenaQ4Mlecni + uzorak.getCena();
			}
			
			else if (Q4.contains(uzorak) && animalniUzorci.contains(uzorak)) {
				
				cenaQ4Animalni = cenaQ4Animalni + uzorak.getCena();
			}
			
			else if (Q4.contains(uzorak) && pekarskiUzorci.contains(uzorak)) {
				
				cenaQ4Pekarski = cenaQ4Pekarski + uzorak.getCena();
			}
		}
		
		ArrayList<Double> ukupneCene = new ArrayList<Double>();
		ukupneCene.add(cenaQ1Mlecni);
		ukupneCene.add(cenaQ1Animalni);
		ukupneCene.add(cenaQ1Pekarski);
		ukupneCene.add(cenaQ2Mlecni);
		ukupneCene.add(cenaQ2Animalni);
		ukupneCene.add(cenaQ2Pekarski);
		ukupneCene.add(cenaQ3Mlecni);
		ukupneCene.add(cenaQ3Animalni);
		ukupneCene.add(cenaQ3Pekarski);
		ukupneCene.add(cenaQ4Mlecni);
		ukupneCene.add(cenaQ4Animalni);
		ukupneCene.add(cenaQ4Pekarski);
		
		return ukupneCene;
		
	}

	static void grupisanjePoTipuUzorka(GradskaLaboratorija gradskaLaboratorija, ArrayList<Uzorak> mlecniUzorci,
			ArrayList<Uzorak> animalniUzorci, ArrayList<Uzorak> pekarskiUzorci) {
		
		for (Uzorak uzorak : gradskaLaboratorija.getUzorci()) {
			
			if (uzorak.getTipUzorka().equals("mlecni")) {
				
				mlecniUzorci.add(uzorak);
			}
			
			else if (uzorak.getTipUzorka().equals("animalni")) {
				
				animalniUzorci.add(uzorak);
			}
			
			else {
				
				pekarskiUzorci.add(uzorak);
			}
		}
		
		System.out.println(mlecniUzorci);
	}
	
	static void grupisanjeISortiranjePoKvartalima(GradskaLaboratorija gradskaLaboratorija, ArrayList<Uzorak> Q1, 
			ArrayList<Uzorak> Q2, ArrayList<Uzorak> Q3, ArrayList<Uzorak> Q4) {
		
		for (Uzorak uzorak : gradskaLaboratorija.getUzorci()) {
			
			String tokeni [] = uzorak.getDatumIVremePrispeca().split("/");
			
			if (tokeni[1].equals("01") || tokeni[1].equals("02") || tokeni[1].equals("03")) {
				
				Q1.add(uzorak);
			}
			
			else if (tokeni[1].equals("04") || tokeni[1].equals("05") || tokeni[1].equals("06")) {
				
				Q2.add(uzorak);
			}
			
			else if (tokeni[1].equals("07") || tokeni[1].equals("08") || tokeni[1].equals("09")) {
				
				Q3.add(uzorak);
			}
			
			else {
				
				Q4.add(uzorak);
			}
		}
		
		gradskaLaboratorija.getUzorci().clear();               //brisem prvobitnu listu uzoraka kako bih je lakse sortirao
		
		for (Uzorak uzorak : Q1) {
			
			gradskaLaboratorija.getUzorci().add(uzorak);
		}
		
		for (Uzorak uzorak : Q2) {
			
			gradskaLaboratorija.getUzorci().add(uzorak);
		}
		
		for (Uzorak uzorak : Q3) {
			
			gradskaLaboratorija.getUzorci().add(uzorak);
		}
		
		for (Uzorak uzorak : Q4) {
			
			gradskaLaboratorija.getUzorci().add(uzorak);
		}
		
		//System.out.println(gradskaLaboratorija.getUzorci());    //ovde se ispisuje sortirana lista uzoraka po godisnjim
																//kvartalima (januar - decembar) 
	}
	
	static GradskaLaboratorija ucitavanje(GradskaLaboratorija gradskaLaboratorija, ObjectMapper mapper) {
		
		try {
			gradskaLaboratorija = mapper.readValue(new File("resources/gradskaLaboratorija.json"), GradskaLaboratorija.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println(gradskaLaboratorija);
		
		return gradskaLaboratorija;
	}
	
	static void upisivanje(ArrayList<Double> ukupneCene, 
			ArrayList<ArrayList<String>> jedinstveniKlijenti) throws IOException {
		
		ObradjeniPodaci op1 = new ObradjeniPodaci("Q1", "mlecni", ukupneCene.get(0), jedinstveniKlijenti.get(0));
		ObradjeniPodaci op2 = new ObradjeniPodaci("Q1", "animalni", ukupneCene.get(1), jedinstveniKlijenti.get(1));
		ObradjeniPodaci op3 = new ObradjeniPodaci("Q1", "pekarski", ukupneCene.get(2), jedinstveniKlijenti.get(2));
		ObradjeniPodaci op4 = new ObradjeniPodaci("Q2", "mlecni", ukupneCene.get(3), jedinstveniKlijenti.get(3));
		ObradjeniPodaci op5 = new ObradjeniPodaci("Q2", "animalni", ukupneCene.get(4), jedinstveniKlijenti.get(4));
		ObradjeniPodaci op6 = new ObradjeniPodaci("Q2", "pekarski", ukupneCene.get(5), jedinstveniKlijenti.get(5));
		ObradjeniPodaci op7 = new ObradjeniPodaci("Q3", "mlecni", ukupneCene.get(6), jedinstveniKlijenti.get(6));
		ObradjeniPodaci op8 = new ObradjeniPodaci("Q3", "animalni", ukupneCene.get(7), jedinstveniKlijenti.get(7));
		ObradjeniPodaci op9 = new ObradjeniPodaci("Q3", "pekarski", ukupneCene.get(8), jedinstveniKlijenti.get(8));
		ObradjeniPodaci op10 = new ObradjeniPodaci("Q4", "mlecni", ukupneCene.get(9), jedinstveniKlijenti.get(9));
		ObradjeniPodaci op11 = new ObradjeniPodaci("Q4", "animalni", ukupneCene.get(10), jedinstveniKlijenti.get(10));
		ObradjeniPodaci op12 = new ObradjeniPodaci("Q4", "pekarski", ukupneCene.get(11), jedinstveniKlijenti.get(11));
		
		ArrayList<ObradjeniPodaci> gradskiObradjeniPodaci = new ArrayList<ObradjeniPodaci>();
		gradskiObradjeniPodaci.add(op1);
		gradskiObradjeniPodaci.add(op2);
		gradskiObradjeniPodaci.add(op3);
		gradskiObradjeniPodaci.add(op4);
		gradskiObradjeniPodaci.add(op5);
		gradskiObradjeniPodaci.add(op6);
		gradskiObradjeniPodaci.add(op7);
		gradskiObradjeniPodaci.add(op8);
		gradskiObradjeniPodaci.add(op9);
		gradskiObradjeniPodaci.add(op10);
		gradskiObradjeniPodaci.add(op11);
		gradskiObradjeniPodaci.add(op12);
		
		Yaml yaml = new Yaml(new Constructor(GradskaLaboratorija.class));

			Writer writer = new FileWriter("resources/obradjeniPodaci.yaml");

			yaml.dump(gradskiObradjeniPodaci, writer);
			
	}

}
