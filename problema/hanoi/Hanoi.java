package problema.hanoi;
import megoldaskereso.allapotter.*;
import java.util.*;
public class Hanoi extends Allapot {

	protected char korong[];
	protected int darab;
	
	
	public Hanoi(int db) {
		super();
		this.korong = new char[darab=db];
		Arrays.fill(korong,'A');
		for(int i=0;i<darab;++i)
		{
		operatorok.add(new Mozgat(i,'A'));
		operatorok.add(new Mozgat(i,'B'));
		operatorok.add(new Mozgat(i,'C'));
		}
	}
	public Hanoi(Hanoi allapot)
	{this(allapot.darab);
    
		System.arraycopy(allapot.korong, 0, korong, 0, allapot.darab);
	}
	
	@Override
	public Allapot alkalmaz(Operator op) {
		// TODO Auto-generated method stub
		Hanoi uj=new Hanoi(this);
		if(op instanceof Mozgat)
		{
		Mozgat m=(Mozgat)op;
		
		uj.korong[m.getMit()]=m.getHova();return uj;
		}
		return null;
	}

	
	@Override
	public boolean isAlkalmazhato(Operator op) {
		// TODO Auto-generated method stub
		if(op!=null && op instanceof Mozgat)
		{
		Mozgat m=(Mozgat)op;
		if(korong[m.getMit()]==m.getHova())return false;
		for(int i=0;i<m.getMit();++i)
		{
			if(korong[i]==korong[m.getMit()])return false;
		}
		for(int i=0;i<m.getMit();++i){
			
			if(korong[i]==m.getHova()) return false;
			
		}
		
		return true;
		}
		return false;
	}

	@Override
	public boolean isCelAllapot() {
		// TODO Auto-generated method stub
		char[] cel1=new char[darab];
		char[] cel2=new char[darab];
		char[] cel3=new char[darab];
		Arrays.fill(cel1,'B');
		Arrays.fill(cel2,'C');
		Arrays.fill(cel3,'A');
		if(Arrays.equals(cel3, korong)) return false;
		return Arrays.equals(cel1, korong)|| Arrays.equals(cel2, korong);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == null || !(obj instanceof Hanoi) ) return false;
		
		return Arrays.equals(korong, ((Hanoi)obj).korong);
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer s=new StringBuffer("Hanoi[korong(");
		for(int i=0;i<darab;++i)
			if(i==0) s.append(korong[i]);
			else
				s.append(",").append(korong[i]);
		
		return s.append(")]").toString();
	}

}
