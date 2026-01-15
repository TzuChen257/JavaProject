class Tx1//07Array
{
	public static void main(String[] args) {
		//???尚未解決(5)-04承上顯示繼續運算除非輸入O，將總合一直往上加
		//(7)-01-03看課本
		//07找出1-100之間的質數
		/*
		1.宣告有n+1的boolean陣列
		2.每個元素設為true
		3.2的倍數為索引碼，索引碼所指為false，三的倍數做同樣的，以此類推到n
		4.陣列中原素值為true則是質數
		2(x),4,6,8,10
		3(x),6,9,
		5(x),10,15
		7(x),14,21
		*/


		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("請輸入一正整數：");
		int n=sc.nextInt();
		boolean[] prime=new boolean[n+1];
		for(boolean o:prime)
		{
			o=true;
		}
		for(int i=2;i<prime.length;i++)
		{
			for(int j=2;i*j<=n;j++)
			{
				prime[i*j]=false;
			}
		}
		for(int i=0;i<prime.length;i++)
		{
			System.out.print(prime[i]);
			if(prime[i])
			{
				System.out.print(i+",");
			}
		}
		System.out.print("是質數");

		//08輸入一系列數字，排列好顯示
		/*java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("請輸入一系列整數，請用逗號分隔號碼：(例如：01,02,03)");
		String input=sc.nextLine();
		String[] arr=input.split(",");//得到["1","2","3"]
		for(int i=0;i<arr.length;i++)
		{

		}
		*/
		//09
		//10
	}
}