package problema.hanoi;
import megoldaskereso.allapotter.*;

public class Mozgat extends Operator{
 
	protected int mit;
	protected char hova;
	
	
	public Mozgat(int mit, char hova) {
		super();
		this.mit = mit;
		this.hova = hova;
	}

	public char getHova() {
		return hova;
	}

	public int getMit() {
		return mit;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj!=null)
		{
		if(obj instanceof Mozgat)
		{Mozgat s=(Mozgat)obj;
		if(s.hova==hova && s.mit==mit)			
			return true;
		return false;
		}
		}
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Mozgat("+mit+","+hova+")";
	}

}
