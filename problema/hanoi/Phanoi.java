package problema.hanoi;
import megoldaskereso.keresok.backtrack.*;
import  megoldaskereso.keresok.keresofa.*;
import megoldaskereso.keresok.*;
public class Phanoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hanoi k=new Hanoi(2);
	
		BacktrackKereso ker=new BacktrackKereso(k);
		ker.keres();
		Fakereso sz= new Fakereso(k,Fakereso.OSSZES,6);
		//sz.keres();
		System.out.println(k);
		for(Csucs i : sz.getTerminálisok())
		ker.kiir(i);
		for(Csucs i : ker.getTerminálisok())
			ker.kiir(i);
		
	}

}
