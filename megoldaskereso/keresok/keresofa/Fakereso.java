package megoldaskereso.keresok.keresofa;
import megoldaskereso.allapotter.*;
import megoldaskereso.keresok.*;
import java.util.*;
public class Fakereso extends Kereso{
	public static final  int KORFIGYEL=4;
	protected Vector<Facsucs> sor;
	protected Set<Facsucs> zartak;
	protected boolean korfigyeles;
	public int korlat;
	
	{
		sor=new Vector<Facsucs>();
		zartak=new HashSet<Facsucs>();
		korfigyeles=false;
		korlat=0;
	}
	public Fakereso(Allapot kezd) {
		super();
		sor.add(new Facsucs(kezd));
		// TODO Auto-generated constructor stub
	}

	public Fakereso(Allapot kezd,int p) {
		super(p);
		korfigyeles=(p & KORFIGYEL)!=0;
		sor.add(new Facsucs(kezd));
		// TODO Auto-generated constructor stub
	}
	public Fakereso(Allapot kezd,int p,int korlat) {
		super(p);
		korfigyeles=(p & KORFIGYEL)!=0;
		this.korlat=korlat;
		sor.add(new Facsucs(kezd));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keres() {
		// TODO Auto-generated method stub
		while(true)
		{
			if(sor.isEmpty()) break;
			Facsucs akt=sor.firstElement();
			if(akt.getAllapot().isCelAllapot() && (!terminálisok.contains(akt)))
			{
				terminálisok.add(akt);
				if(!osszesmegold) break;
				System.out.println("Megoldas"+terminálisok.size()+":"+akt);
				sor.removeElement(akt);
				continue;
			}
			if(korlat>0 && akt.getMelyseg()==korlat) break;
			if(akt.getHatravanmeg().isEmpty()){sor.removeElement(akt);continue;}
			for(Operator i: akt.getHatravanmeg())
			{Facsucs s=new Facsucs(akt,i);
			
				if(!(sor.contains(s) || zartak.contains(s)|| terminálisok.contains(s))){
					//System.out.println(s+":"+s.getMelyseg());
					sor.add(s);
					}
			}
			zartak.add(akt);
			sor.remove(akt);
			
		}
		
	}

}
