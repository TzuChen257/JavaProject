package hw1;

public class test {

	public static void main(String[] args){
		try {
			TakeOut o1=new TakeOut(false,1,0,0,0,0,1,1,0,0,true,1,1);
			TakeOut o2=new TakeOut(true,1,0,0,0,0,1,1,0,0,false,1,1);
			TakeOut o3=new TakeOut(false,0,0,0,0,0,0,0,0,0,false,0,0);
			System.out.println(o1.showStr());
			System.out.println(o2.showStr());
			System.out.println(o3.showStr());
			EatIn i1=new EatIn(false,1,0,0,0,0,1,1,0,0,0);
			EatIn i2=new EatIn(true,1,0,0,0,0,1,1,0,0,3);
			EatIn i3=new EatIn(false,0,0,0,0,0,0,0,0,0,1);
			System.out.println(i1.showStr());
			System.out.println(i2.showStr());
			System.out.println(i3.showStr());
		}catch(Check e)
		{
			e.printStackTrace();
		}
	}
}
