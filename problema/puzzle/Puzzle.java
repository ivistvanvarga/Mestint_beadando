package problema.puzzle;
import java.util.*;
import megoldaskereso.allapotter.*;

public class Puzzle extends Allapot {

	/**
	 * A puzzle darabjait reprezentáló alosztály.
	 * @author Varga István
	 * 
	 */
	
	
	public static class Darab{
		protected short darab[][];
		protected int sorszam;
		
		/**
		 * Konstruktor be állítja az alapértelmezett értékeket. 
		 */
		public Darab() {
			this.darab = new short[5][5];
			for(int i=0;i<5;++i)
			Arrays.fill(darab[i],(short) 0);
			sorszam=0;
		}
		/**
		 * A darab másoló konstruktora.
		 * @param d
		 *  A d darabról készít egy másolatot
		 */
		public Darab(Darab d) {
			this();
			set(d.getSorszam());
			
			//System.out.println("miez ?? "+d);
		}
		/**
		 * Darabnak  megfelelő értékek beállítása.
		*/
		public void set(int db)
		{if(sorszam!=0)return;
			
		switch(db)
		{
		case 1:
		{
		darab[1][1]=darab[1][2]=darab[1][3]=1;
		darab[2][1]=darab[2][2]=darab[2][3]=darab[2][4]=1;
		darab[3][1]=darab[3][2]=darab[3][3]=1;
		}break;
		case 2:
		{	darab[0][2]=darab[4][2]=1;
			darab[1][1]=darab[1][2]=darab[1][3]=1;
			darab[2][1]=darab[2][2]=darab[2][3]=1;
			darab[3][1]=darab[3][2]=darab[3][3]=1;
		}break;
		case 3:
		{	darab[0][2]=darab[4][2]=darab[2][4]=1;
			darab[1][1]=darab[1][2]=darab[1][3]=1;
			darab[2][1]=darab[2][2]=darab[2][3]=1;
			darab[3][1]=darab[3][2]=darab[3][3]=1;
		}break;
		case 4:
		{
			darab[0][2]=darab[4][2]=darab[2][4]=darab[2][0]=1;
			darab[1][1]=darab[1][2]=darab[1][3]=1;
			darab[2][1]=darab[2][2]=darab[2][3]=1;
			darab[3][1]=darab[3][2]=darab[3][3]=1;
		}break;
		case 5:
		{	darab[4][2]=darab[0][2]=darab[2][4]=1;
			darab[1][1]=darab[1][2]=darab[1][3]=1;
			darab[2][2]=darab[2][3]=1;
			darab[3][1]=darab[3][2]=darab[3][3]=1;
		}break;
		case 6:
		{	
			darab[1][1]=darab[1][3]=1;
			darab[2][0]=darab[2][1]=darab[2][2]=darab[2][3]=1;
			darab[3][1]=darab[3][3]=1;
		}break;
		case 7:
		{	darab[0][2]=darab[2][0]=1;
			darab[1][1]=darab[1][2]=darab[1][3]=1;
			darab[2][1]=darab[2][2]=darab[2][3]=1;
			darab[3][1]=darab[3][2]=darab[3][3]=1;
		}break;
		case 8:
		{	darab[1][1]=darab[1][2]=darab[1][3]=1;
			darab[2][2]=1;
			darab[3][1]=darab[3][2]=darab[3][3]=1;
		}break;
		case 9:
		{	darab[2][0]=darab[4][2]=1;
			darab[1][1]=darab[1][3]=1;
			darab[2][1]=darab[2][2]=darab[2][3]=1;
			darab[3][1]=darab[3][2]=darab[3][3]=1;
		}break;
		default:
			break;
		}
		sorszam=db;		
		}
		/**
		 * A darab sorszámát adja vissza. Minden darabnek csak egy van.
		 * @return A darab sorszáma.
		 */
		public int getSorszam() {
			return sorszam;
		}
		/**
		 * A darabot reprezentáló tömb lekérdezése.
		 * @return
		 */
		protected short[][] getDarab() {
			return darab;
		}
		@Override
		/**
		 * Két elem összehasonlítása a sorszám alapján.Így minden
		 * darabnak aminak megegyezik a sorszáma ugyanazt a puzzle darabot reprezentálja.
		 */
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			if(obj == null || !(obj instanceof Darab) ) return false;
			if(sorszam == ((Darab)obj).getSorszam()) return true;
			return false;
		}
		@Override
		/**
		 * Egy darab Stringé alakítása.
		 */
		public String toString() {
			// TODO Auto-generated method stub
			StringBuffer s=new StringBuffer("\n");
			s.append("A ").append(sorszam).append(". darab\n");
			for(int i=0;i<5;++i){
				for(int j=0;j<5;++j)
					s.append(darab[i][j]).append(" ");
				s.append("\n");
			}
			return s.toString();
		}
		
		
	}
	
	
	protected short mezo[][];
	public static Darab darabok[];
	public static Vector<Set<Integer>> H;
	//public static  int pel=0;
	protected  int lerakott[];
	
	/** Osztályszinten tárolódbak le az egyes darabok és a halmazok mivel 
	 * ezek mindig kellenek.
	 */
	static {
	darabok=new Darab[10];
	 H=new Vector<Set<Integer>>();
	 Set<Integer> t=new HashSet<Integer>();//H1={0,90,180,270}
	t.add(new Integer(0));
	t.add(new Integer(90));
	t.add(new Integer(180));
	t.add(new Integer(270));
	H.add(t);
	t=new HashSet<Integer>();//H2={1,2,4,5,7,8,10,11}
	t.add(new Integer(1));
	t.add(new Integer(2));
	t.add(new Integer(4));
	t.add(new Integer(5));
	t.add(new Integer(7));
	t.add(new Integer(8));
	t.add(new Integer(10));
	t.add(new Integer(11));
	H.add(t);
	t=new HashSet<Integer>();//H3={1,11}
	t.add(new Integer(1));
	t.add(new Integer(11));
	H.add(t);
	t=new HashSet<Integer>();//H4={2,4,5,7,8,10}
	t.add(new Integer(2));
	t.add(new Integer(4));
	t.add(new Integer(5));
	t.add(new Integer(7));
	t.add(new Integer(8));
	t.add(new Integer(10));
	H.add(t);
		
	for(int i=1;i<10;++i){Elhelyez s;
		darabok[i]=new Darab();
		darabok[i].set(i);
	//	System.out.println((i)+": "+darabok[i]);
		for(int k=1;k<4;++k)	
			for(int h=1;h<4;++h)
			for(int j=0;j<4;++j)
			{s=new Elhelyez(darabok[i],k*3,h*3,90*j);
		operatorok.add(s);
		
		}
		
		
		}
	/*System.out.println(operatorok.size());
	for(int i=1;i<10;++i)
		System.out.println(i+" :"+darabok[i].getSorszam());*/
	
	}
	
	
	
	
	
	/**
	 * Alapállapot inicializálása.
	 *
	 */
	public Puzzle() {
		super();
		//++pel;
		this.mezo =new short[11][11] ;
		lerakott=new int[10];
		Arrays.fill(lerakott, 0);
		for(int i=0;i<11;++i)
			Arrays.fill(mezo[i],(short) 0);
		for(Integer i:H.get(1))
			for(Integer j:H.get(2))
			{
				mezo[i.intValue()-1][j.intValue()-1]=1;
			}
		for(Integer i:H.get(2))
			for(Integer j:H.get(3))
			{
				mezo[i.intValue()-1][j.intValue()-1]=1;
			}		
		
	}
	/**
	 * Másoló konstruktor.
	 * @param allapot
	 * Az allapot minden példányszintű adattagjáról készít másolatot.
	 */
	public Puzzle(Puzzle allapot) {
		this.mezo =new short[11][11] ;
		//++pel;System.out.println(pel);
		lerakott=new int[10];
		System.arraycopy(allapot.lerakott, 0, lerakott, 0, 10);
		for(int i=0;i<11;++i)
		System.arraycopy(allapot.mezo[i],0, mezo[i],0, 11);
	}
	
	
	/**
	 * A puzzel i. darabjának lekérése.
	 * @param i
	 * @return
	 * Visszatérés az i. darabbal.
	 */
	public static Darab getDarab(int i) {
		
		
		return darabok[i%10];
	}
	/**
	 * Az op operátor alkalmazása az aktuális állapotra. 
	 */
	@Override
	public Allapot alkalmaz(Operator op) {
		// TODO Auto-generated method stub
		if(op==null || !(op instanceof Elhelyez) ) return null;
		Elhelyez o=(Elhelyez)op;
		Puzzle s=new Puzzle(this);
		int x=o.getX(),y=o.getY();
		
		s.lerakott[o.getMit().getSorszam()]=1;
		for(int i=0;i<5;++i)
			for(int j=0;j<5;++j)
			{
			s.mezo[x-3+i][y-3+j] += o.getMit().getDarab()[i][j]; 	
			}
		
		return s;
	}

	/**
	 * Az op operátor alkalmazható-e az aktuális állapotra?
	 */
	@Override
	public boolean isAlkalmazhato(Operator op) {
		// TODO Auto-generated method stub
		
		if(op==null || !(op instanceof Elhelyez) ) return false;
		Elhelyez o=(Elhelyez)op;
		
		if(lerakott[o.getMit().getSorszam()]!=0) return false;
		
		int x=o.getX(),y=o.getY();
		for(int i=0;i<5;++i)
			for(int j=0;j<5;++j)
			{
			if(!((mezo[x-2+i-1][y-2+j-1] + o.getMit().getDarab()[i][j])==1 || 
				(mezo[x-2+i-1][y-2+j-1] + o.getMit().getDarab()[i][j])==0)) 
				return false ;	
			}
			
		return true;
	}
	/**
	 * Az aktuális állapot célállapot-e? 
	 */
	@Override
	public boolean isCelAllapot() {
		// TODO Auto-generated method stub
		
		
		for(int i=0;i<11;++i)
			for(int j=0;j<11;++j)if(mezo[i][j]!=1) return false;
		
		
		return true;
	}
	/**
	 * Két állapot összehasionlítása.
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == null || !(obj instanceof Puzzle) ) return false;
		Puzzle s=(Puzzle)obj;
		for(int i=0;i<11;++i)
			if(!Arrays.equals(mezo, s.mezo)) return false;
		return true;
	}

	/**
	 * A metőt reprezentáló mátrix String-é alakítása.
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer s=new StringBuffer("\n");
		for(int i=0;i<11;++i)
		{
		for(int j=0;j<11;++j)
			s.append(mezo[i][j]).append(" ");
		s.append("\n");
		}
		return s.toString();
	}
	
}
