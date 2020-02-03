package megoldaskereso.keresok.backtrack;
import megoldaskereso.allapotter.*;
import megoldaskereso.keresok.*;

import java.util.*;
public class BacktrackCsucs extends Csucs {


 protected Set<Operator> hatravanmeg;

	public BacktrackCsucs(Allapot kezdo) {
		super(kezdo);
		hatravanmeg=new HashSet<Operator>();
		for(Operator i : allapot.getOperatorok())
		{
		if(kezdo.isAlkalmazhato(i))
			hatravanmeg.add(i);
		}
		// TODO Auto-generated constructor stub
	}

	public BacktrackCsucs(Csucs szulo, Operator op) {
		super(szulo, op);
		// TODO Auto-generated constructor stub
		hatravanmeg=new HashSet<Operator>();
		for(Operator i : allapot.getOperatorok())
		{
		if(allapot.isAlkalmazhato(i))
			hatravanmeg.add(i);
		}
	}

	public Set<Operator> getHatravanmeg() {
		return hatravanmeg;
	}

}
