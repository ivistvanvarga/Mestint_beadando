package megoldaskereso.keresok;
import megoldaskereso.allapotter.*;
public  class Csucs {
protected Allapot allapot;
protected Csucs szulo;
protected Operator operator;
protected int melyseg;

public Csucs(Allapot kezdo)
{
allapot=kezdo;
szulo=null;
operator=null;
melyseg=0;
}
public Csucs(Csucs szulo,Operator op)
{
allapot=szulo.allapot.alkalmaz(op);
this.szulo=szulo;
operator=op;
melyseg=szulo.melyseg+1;
}
public Allapot getAllapot() {
	return allapot;
}
public int getMelyseg() {
	return melyseg;
}
public Operator getOperator() {
	return operator;
}
public Csucs getSzulo() {
	return szulo;
}
@Override
public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	if(obj==null && !(obj instanceof Csucs)) return false;

	return allapot.equals(((Csucs)obj).allapot);
}
@Override
public String toString() {
	
	return operator+" => "+allapot;
}


}
