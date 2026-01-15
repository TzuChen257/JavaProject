package hw1;

public class EatIn extends HotPot{
	//f
	private static int counter=0;
	private int eatInNum;
	private int share;
	//c
	public EatIn(boolean member, int shachaPork, int shachaChi, int shachaBeef, int kombuPork, int kombuChi,
			int kombuBeef, int spicyPork, int spicyChi, int spicyBeef, int share) throws Check {
		super(member, shachaPork, shachaChi, shachaBeef, kombuPork, kombuChi, kombuBeef, spicyPork, spicyChi, spicyBeef);
		if((shachaPork+shachaChi+shachaBeef+kombuPork+kombuChi+kombuBeef+spicyPork+spicyChi+spicyBeef)!=0)
		{
			counter++;
			this.eatInNum=counter;
			this.share=share;
			setSum(getSum()+share*90);
			if(!isMember())
			{
				setSum((int)(getSum()*1.1));
			}
		}
		else
		{
			throw new Check("請至少點一份鍋物。");
		}
	}
	//m
	public int getShare() {
		return share;
	}
	public void setShare(int share) {
		this.share = share;
	}
	String showStr()
	{
		String Str=super.showStr();
		if(getShare()!=0) Str+="有"+getShare()+"位共鍋\n";
		if(isMember()) Str+="您是會員內用無需服務費！\n";
		else Str+="內用額外加收一成服務費\n";
		Str=Str+"您的取餐號碼為內用"+eatInNum+"\n";
				
		Str+="\n總共："+getSum()+"元";
		
		return Str;
	}
}
