package megoldaskereso.keresok.backtrack;
import megoldaskereso.allapotter.*;
import megoldaskereso.keresok.*;
import java.util.*;
public class BacktrackKereso extends Kereso {

	public static final  int KORFIGYEL=4;
	protected boolean korfigyeles;
	public int korlat;
	protected Stack<BacktrackCsucs> ut;
	
	{
	korfigyeles=false;
	korlat=0;
	ut= new Stack<BacktrackCsucs>();
	}
	
	public BacktrackKereso(Allapot kezdo) {
		super();
		ut.push(new BacktrackCsucs(kezdo));
	}

	public BacktrackKereso(Allapot kezdo,int jellemzo) {
		super(jellemzo);
		korfigyeles=(jellemzo & KORFIGYEL)!=0;
		ut.push(new BacktrackCsucs(kezdo));
	}
	public BacktrackKereso(Allapot kezdo,int jellemzo,int korlat) {
		this(kezdo,jellemzo);
		this.korlat=korlat;
	}
	@Override
	public void keres() {
		// TODO Auto-generated method stub
		
		while(true)
		{
		
		if(ut.isEmpty())break;
		BacktrackCsucs akt=ut.peek();
		if(akt.getAllapot().isCelAllapot())
		{
		terminálisok.add(akt);
		if(!osszesmegold) break;
		ut.pop();
		continue;
		}
		if(korlat>0 && akt.getMelyseg()==korlat)
		{
			ut.pop();continue;
		}
		Set<Operator> ops=akt.getHatravanmeg();
		if(ops.isEmpty()){ut.pop();continue;}
		Operator op=ops.iterator().next();
		
			BacktrackCsucs uj=new BacktrackCsucs(akt,op);
		if((!korfigyeles) || (!ut.contains(uj)))
		
		{
			ut.add(uj);
			ops.remove(op);
			
		}
			
		}
		
	}
	
	
@Override
	public String jellemzok() {
		// TODO Auto-generated method stub
	StringBuffer s=new StringBuffer( super.jellemzok());
	s.append(korfigyeles ? " Az algoritmus figyeli a köröket és " : " Az algoritmus nem figyeli a köröket és ");
	if(korlat>0)
	s.append("úthossz korlát van beállítva ,amely megmondja, hogy a maximális úthossz ").append(korlat).append(" lehet.");
	else
		s.append(" az utak hossza nincs korlátozva.");
		return s.toString();
	}

public String toString()
{
	return "Ez egy backtrack kereső alkoritmus. "+this.jellemzok();
}

}


