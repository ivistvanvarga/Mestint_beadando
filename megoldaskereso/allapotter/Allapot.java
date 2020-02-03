package megoldaskereso.allapotter;
import java.util.*;
public abstract class Allapot {
protected static Set<Operator> operatorok=new HashSet<Operator>();	
	



public static Set<Operator> getOperatorok() {
	return operatorok;
}
public abstract boolean isAlkalmazhato(Operator op );
public abstract boolean isCelAllapot();
public abstract Allapot alkalmaz(Operator op);

public abstract boolean equals(Object obj); 
public abstract String toString();

}
