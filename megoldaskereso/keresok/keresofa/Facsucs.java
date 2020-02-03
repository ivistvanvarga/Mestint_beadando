package megoldaskereso.keresok.keresofa;
import java.util.HashSet;
import java.util.Set;

import megoldaskereso.allapotter.*;
import megoldaskereso.keresok.*;
public class Facsucs extends Csucs {
	 protected Set<Operator> hatravanmeg;
	public Facsucs(Allapot kezdo) {
		super(kezdo);
		hatravanmeg=new HashSet<Operator>();
		for(Operator i : allapot.getOperatorok())
		{
		if(kezdo.isAlkalmazhato(i))
			hatravanmeg.add(i);
		}
		// TODO Auto-generated constructor stub
	}

	public Facsucs(Csucs szulo, Operator op) {
		super(szulo, op);
		// TODO Auto-generated constructor stub
		hatravanmeg=new HashSet<Operator>();
		for(Operator i : allapot.getOperatorok())
		{
		if(allapot.isAlkalmazhato(i))
			hatravanmeg.add(i);
		}
		// TODO Auto-generated constructor stub
	}

	

	public Set<Operator> getHatravanmeg() {
		return hatravanmeg;
	}

}
