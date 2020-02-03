package megoldaskereso.keresok;
import java.util.*;
public abstract class Kereso {
public static final int OSSZES=1;
public static final int CELMEGOLD=2;
protected boolean osszesmegold;
protected boolean celallapotmegold;
protected Set<Csucs> terminálisok;
protected Kereso()
{
terminálisok=new HashSet<Csucs>();
osszesmegold=false;
celallapotmegold=false;
}
protected Kereso(int p)
{
this();
this.osszesmegold=(p & OSSZES)!=0;
this.celallapotmegold= (p & CELMEGOLD)!=0;
}
public boolean isCelallapotmegold() {
	return celallapotmegold;
}
public boolean isosszesmegold() {
	return osszesmegold;
}
public Set<Csucs> getTerminálisok() {
	return terminálisok;
}
public void kiir(Csucs a)
{
if(a!=null)
	{if(this.celallapotmegold)
		System.out.println(a.getAllapot());
		else
		{
		kiir(a.getSzulo());
		System.out.println(a);
		}
	
	}
}
public abstract void keres();
public String jellemzok()
{StringBuffer s= new StringBuffer();
s.append("Ez megkeres").append(osszesmegold ? "i az öszzesmegoldást és" : " egy megoldást.\n");
s.append(celallapotmegold ? "Minden célállapot megoldás." : "Nem minden célállapot megoldás.\n");
return s.toString();
}
}
