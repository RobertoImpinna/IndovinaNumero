package it.polito.tdp.indonumero;

public class TestModel {

	public static void main(String[] args) {
		Model model=new Model();
		int min=1;
		int max=model.getNMAX();
		model.newGame();
		while(model.isInGame()) {
			int t= (min+max)/2;
			System.out.println("Tra "+min+" e "+max+" provo "+t);
			int ris=model.tentativo(t);
			System.out.println(ris);
			
			if(ris>0) {
				max = t-1;
			}else {
				min=t+1;
			}
			
			
		}
	}

}
