package hw1;

public class TakeOut extends HotPot{
	//f
	private static int counter=0;
	private int takeNum;
	private boolean bag;
	private int rice;
	private int noodle;
	//c
	public TakeOut(boolean member, int shachaPork, int shachaChi, int shachaBeef, int kombuPork, int kombuChi,
			int kombuBeef, int spicyPork, int spicyChi, int spicyBeef, boolean bag, int rice, int noodle) throws Check{
		super(member, shachaPork, shachaChi, shachaBeef, kombuPork, kombuChi, kombuBeef, spicyPork, spicyChi, spicyBeef);
		if(shachaPork>=0 && shachaChi>=0 && shachaBeef>=0 && kombuPork>=0 && kombuChi>=0 && kombuBeef>=0 && spicyPork>=0 && spicyChi>=0 && spicyBeef>=0 && rice>=0 && noodle>=0)
		{
			if(shachaPork!=0 || shachaChi!=0 || shachaBeef!=0 || kombuPork!=0 || kombuChi!=0 || kombuBeef!=0 || spicyPork!=0 || spicyChi!=0 || spicyBeef!=0)
			{
				if((shachaPork+shachaChi+shachaBeef+kombuPork+kombuChi+kombuBeef+spicyPork+spicyChi+spicyBeef)>=(rice+noodle))
				{
					counter++;
					this.takeNum=counter;			
					this.bag=bag;
					this.rice=rice;
					this.noodle=noodle;
					if(bag)
					{
						setSum(getSum()+2);
					}
					if(!isMember())
					{
						setSum(getSum()+rice*10+noodle*10);
					}
				}else
				{
					throw new Check("一份鍋物至多選擇一份主食。");
				}
			}else
			{
				throw new Check("送出訂單至少須點一份鍋物。");
			}
		}
		else
		{
			throw new Check("請輸入正確數量，火鍋及主食數量皆須>=0。");
		}
	}
	//m
	public boolean isBag() {
		return bag;
	}
	public void setBag(boolean bag) {
		this.bag = bag;
	}
	public int getRice() {
		return rice;
	}
	public void setRice(int rice) {
		this.rice = rice;
	}
	public int getNoodle() {
		return noodle;
	}
	public void setNoodle(int noodle) {
		this.noodle = noodle;
	}
	public int getTakeNum() {
		return takeNum;
	}
	public void setTakeNum(int takeNum) {
		this.takeNum = takeNum;
	}
	String showStr()
	{
		String Str="請輸入正確數量";
		if(getTakeNum()!=0) {
			Str=super.showStr();
			if(isMember()) Str+="您是會員可免費享用附餐主食！\n";
			if(getRice()>0) Str+="白飯："+getRice()+"份\n";
			if(getNoodle()>0) Str+="王子麵："+getNoodle()+"份\n";
			if(isBag()) Str+="需要袋子\n";
			Str=Str+"您的取餐號碼為外帶"+takeNum+"\n";
			Str+="\n總共："+getSum()+"元";
		}
		return Str;
	}
}
