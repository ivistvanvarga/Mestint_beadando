package problema.puzzle;
//import megoldaskereso.allapotter.*;
import megoldaskereso.keresok.Csucs;
import  megoldaskereso.keresok.keresofa.*;
import megoldaskereso.keresok.backtrack.*;
/**
 * Puzlle kirakását megoldó program.
 * @author Varga István
 *
 */
public class PuzzleMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Puzzle k2=new Puzzle();
		k2=((Puzzle)k2.alkalmaz(new Elhelyez(Puzzle.getDarab(5),3,3,270)));
		k2=(Puzzle)k2.alkalmaz(new Elhelyez(Puzzle.getDarab(6),3,6,90));
		k2=(Puzzle)k2.alkalmaz(new Elhelyez(Puzzle.getDarab(3),3,9,270));
		k2=(Puzzle)k2.alkalmaz(new Elhelyez(Puzzle.getDarab(4),6,3,0));
		//k2=(Puzzle)k2.alkalmaz(new Elhelyez(Puzzle.getDarab(8),6,6,0));
		//k2=(Puzzle)k2.alkalmaz(new Elhelyez(Puzzle.getDarab(2),6,9,90));
		//k2=(Puzzle)k2.alkalmaz(new Elhelyez(Puzzle.getDarab(9),9,3,0));
		//k2=(Puzzle)k2.alkalmaz(new Elhelyez(Puzzle.getDarab(1),9,6,90));
		//k2=(Puzzle)k2.alkalmaz(new Elhelyez(Puzzle.getDarab(7),9,9,270));
		//Fakereso ker=new Fakereso(k2);
		BacktrackKereso ke= new BacktrackKereso(k2);
		
		System.out.println(ke);
		System.out.println("Megoldás keresése...");
		ke.keres();
		System.out.println("Megtalált megoldások:");
		System.out.println("A kiindulási helyzet:");
		
		for(Csucs i : ke.getTerminálisok())
			ke.kiir(i);
		
		
		
	}

}
