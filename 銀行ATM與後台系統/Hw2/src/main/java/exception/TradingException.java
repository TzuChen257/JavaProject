package exception;

public class TradingException extends Exception{
	//f
	//c
	//待整理
	TradingException(String errMsg)
	{
		System.out.println(errMsg);
	}
	//m
	public String insufficientBalance()
	{
		return "交易失敗：帳戶餘額不足";
	}
	public String exceedTransLimit()
	{
		return "交易失敗：超過單筆交易額度上限30000元";
	}
	public String exceedDayLimit()
	{
		return "交易失敗：超過單日交易額度上限60000元";
	}
}
