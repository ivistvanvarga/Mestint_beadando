package problema.puzzle;
import problema.puzzle.Puzzle.Darab;
import megoldaskereso.allapotter.*;
import java.util.*;
/**
 * A puzzle darabját elhelyező operátort reprezentáló osztály.
 * @author Varga István
 *
 */
public class Elhelyez extends Operator {
	protected Darab mit;
	protected int x,y;
	protected int forgatva;
	
	
	/**
	 * A konstruktor létrehoz a mit puzzle darabból egy olyan darabot, amely elvan forgatva a
	 * megadott szöggel és eltárolja azt.  
	 * @param mit
	 * @param x
	 * @param y
	 * @param forgatva
	 *  
	 */
	
	public Elhelyez(Darab mit, int x, int y, int forgatva) {
		super();
		this.mit =new Darab(mit);
		this.x = x;
		this.y = y;
		this.forgatva = forgatva;
		forgat(forgatva);
		//tukroz(-1);
	}
	
	/**
	 * A darabot reprezentáló mátrixot tükrözi az x értékétől függően.
	 * Egy egy ilyen tüktözés 90 fokos elforgatást jelent.
	 * @param x
	 * Ha x=1 akkor a fő átlóra.
	 * Ha x=-1 akkor a mellékátlóra.
	 */
	protected void tukroz(int x)
	{
	if(x==1){
		
	for(int i=0;i<5;++i)
		for(int j=i;j<5;++j){
			if(i==j) continue;
			short s=mit.darab[i][j];
			mit.darab[i][j]=mit.darab[j][i];
			mit.darab[j][i]=s;
		}
		
	
		
	}
	if(x==-1)
	{//itt kellene folytatni
		short[][] d=mit.darab;
		for(int i=4;i>=0;--i)
			for(int j=i;j>=0;--j){
				//System.out. println("("+i+","+(4-i)+") "+j);
				//System.out. println("("+(i-j)+","+(4-i)+") <=>"+"("+i+","+(4-i+j)+")");
				if(i-j==i && 4-i==4-i+j) continue;
				short s=d[i-j][4-i];
				d[i-j][4-i]=d[i][4-i+j];
				d[i][4-i+j]=s;
			}
			
		
		
	}
	}
	/**
	 * A tárolt darab elforgatása s szöggel.
	 * @param s
	 */
	protected void forgat(int s)
	{
		
		switch(s % 360)
		{
		case 90: tukroz(1);break;
		case 180: tukroz(1);tukroz(-1);break;
		case 270: tukroz(1);tukroz(-1);tukroz(1);break;
		default:
			break;
		}
		
	}
	/**
	 * Operátorok összehasonlítása.
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == null || !(obj instanceof Elhelyez) ) return false;
		Elhelyez s=(Elhelyez)obj;
		
				
		return s.x==x && s.y==y && s.forgatva==forgatva && s.mit.getSorszam()==mit.getSorszam();
	}

	/**
	 * Elforgatási szög lekérdezése.
	 * @return
	 * Szög
	 */
	public int getForgatva() {
		return forgatva;
	}
	/**
	 * Az osztályban tárolt darab lekérdezése.
	 * @return
	 * Puzzle darab elforgatva.
	 */
	public Darab getMit() {
		return mit;
	}
	/**
	 * Az elhelyezés sorának lekérdezése.
	 * @return
	 * Az elhelyezés sora.
	 */
	public int getX() {
		return x;
	}
	/**
	 * Az elhelyezés oszlopának lekérdezése.
	 * @return
	 * Az elhelyezés oszlopa.
	 */
	public int getY() {
		return y;
	}
	/**
	 * Az operátor ésa az adattagok String-é alakítása.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Elhelyez("+mit.getSorszam()+". darab,"+x+","+y+","+forgatva+")";
	}

}
