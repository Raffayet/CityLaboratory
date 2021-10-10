package deo1;

import java.util.List;

public class GradskaLaboratorija {
	
	private List<Uzorak> uzorci;
	
	GradskaLaboratorija(){
		
	}

	public GradskaLaboratorija(List<Uzorak> uzorci) {
		super();
		this.uzorci = uzorci;
	}

	public List<Uzorak> getUzorci() {
		return uzorci;
	}

	public void setUzorci(List<Uzorak> uzorci) {
		this.uzorci = uzorci;
	}

	@Override
	public String toString() {
		return "GradskaLaboratorija [uzorci=" + uzorci + "]";
	}

}
