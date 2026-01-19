package hw1;

public class HotPot {
	//f
	private boolean member;
	private int shachaPork;
	private int shachaChi;
	private int shachaBeef;
	private int kombuPork;
	private int kombuChi;
	private int kombuBeef;
	private int spicyPork;
	private int spicyChi;
	private int spicyBeef;
	private int sum;
	//c
	public HotPot(boolean member, int shachaPork, int shachaChi, int shachaBeef, int kombuPork, int kombuChi,
			int kombuBeef, int spicyPork, int spicyChi, int spicyBeef) {
		this.member = member;
		this.shachaPork = shachaPork;
		this.shachaChi = shachaChi;
		this.shachaBeef = shachaBeef;
		this.kombuPork = kombuPork;
		this.kombuChi = kombuChi;
		this.kombuBeef = kombuBeef;
		this.spicyPork = spicyPork;
		this.spicyChi = spicyChi;
		this.spicyBeef = spicyBeef;
		sum=shachaPork*120+shachaChi*120+shachaBeef*130+
				kombuPork*110+kombuChi*110+kombuBeef*120+
				spicyPork*130+spicyChi*130+spicyBeef*140;
	}
	//m
	public boolean isMember() {
		return member;
	}
	public void setMember(boolean member) {
		this.member = member;
	}
	public int getShachaPork() {
		return shachaPork;
	}
	public void setShachaPork(int shachaPork) {
		this.shachaPork = shachaPork;
	}
	public int getShachaChi() {
		return shachaChi;
	}
	public void setShachaChi(int shachaChi) {
		this.shachaChi = shachaChi;
	}
	public int getShachaBeef() {
		return shachaBeef;
	}
	public void setShachaBeef(int shachaBeef) {
		this.shachaBeef = shachaBeef;
	}
	public int getKombuPork() {
		return kombuPork;
	}
	public void setKombuPork(int kombuPork) {
		this.kombuPork = kombuPork;
	}
	public int getKombuChi() {
		return kombuChi;
	}
	public void setKombuChi(int kombuChi) {
		this.kombuChi = kombuChi;
	}
	public int getKombuBeef() {
		return kombuBeef;
	}
	public void setKombuBeef(int kombuBeef) {
		this.kombuBeef = kombuBeef;
	}
	public int getSpicyPork() {
		return spicyPork;
	}
	public void setSpicyPork(int spicyPork) {
		this.spicyPork = spicyPork;
	}
	public int getSpicyChi() {
		return spicyChi;
	}
	public void setSpicyChi(int spicyChi) {
		this.spicyChi = spicyChi;
	}
	public int getSpicyBeef() {
		return spicyBeef;
	}
	public void setSpicyBeef(int spicyBeef) {
		this.spicyBeef = spicyBeef;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	String showStr()
	{
		String Str="";
		if(getShachaPork()>0) Str+="沙茶豬肉："+getShachaPork()+"份\n";
		if(getShachaChi()>0) Str+="沙茶雞肉："+getShachaChi()+"份\n";
		if(getShachaBeef()>0) Str+="沙茶牛肉："+getShachaBeef()+"份\n";
		if(getKombuPork()>0) Str+="昆布豬肉："+getKombuPork()+"份\n";
		if(getKombuChi()>0) Str+="昆布雞肉："+getKombuChi()+"份\n";
		if(getKombuBeef()>0) Str+="昆布牛肉："+getKombuBeef()+"份\n";
		if(getSpicyPork()>0) Str+="麻辣豬肉："+getSpicyPork()+"份\n";
		if(getSpicyChi()>0) Str+="麻辣雞肉："+getSpicyChi()+"份\n";
		if(getSpicyBeef()>0) Str+="麻辣牛肉："+getSpicyBeef()+"份\n";
		return Str;
	}
	
}
