package util.gameSettings;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import model.Rank;
import model.Result;
import model.User;
import service.ResultServiceImpl;
import service.UserServiceImpl;

public class Ranking{
	public static void main(String[] args) {
		
	}
	//ResultRanking
	public static List<Rank<Result>> resultRankByLevel(int level)
	{
		List<Result> allByLevel=new ResultServiceImpl().allUser()
				.stream()
				.filter(r->r.getMap_level()==level)
				.sorted()
				.collect(Collectors.toList());
		
		//如果所花時間相同則排名相同
		List<Rank<Result>> rankList = new ArrayList<>();
		int rankNum=1;
		for(int i=0;i<allByLevel.size();i++)
		{
			if(i>0)
			{
				if(!allByLevel.get(i).getTime_spend().equals(allByLevel.get(i-1).getTime_spend()))
				{
					rankNum=i+1;
				}
			}
			rankList.add(new Rank<>(allByLevel.get(i),rankNum));
		}
		return rankList;
	}
	public static List<Rank<Result>> resultTopByLevel(int level, int limit)
	{
		List<Rank<Result>> rankList=Ranking.resultRankByLevel(level);
		//TOP5
		List<Rank<Result>> top=rankList.stream().limit(limit).collect(Collectors.toList());
		return top;
	}
	public static List<Rank<Result>> resultRankAndThis(String username, int level, int limit)
	{
		List<Rank<Result>> rankList=Ranking.resultRankByLevel(level);
		List<Rank<Result>> top=rankList.stream().limit(limit).collect(Collectors.toList());
		//是否上榜
		boolean isUserTop=top.stream().anyMatch(p->p.getObject().getUsername().equals(username));
		if(!isUserTop)
		{
			rankList.stream().filter(p->p.getObject().getUsername().equals(username))
			.findFirst().ifPresent(userRank->{
				userRank.setShow("未上榜");
				top.add(userRank);
			});;//Optional如果存在
		}
		return top;
	}
	public static List<Rank<Result>> userRecord(String username, int level)
	{
		List<Result> myRecord=new ResultServiceImpl().findByUser(username)
				.stream()
				.filter(r->r.getMap_level()==level)
				.sorted()
				.collect(Collectors.toList());
		
		//如果所花時間相同則排名相同
		List<Rank<Result>> rankList = new ArrayList<>();
		
		int rankNum=1;
		for(int i=0;i<myRecord.size();i++)
		{
			if(i>0)
			{
				if(!myRecord.get(i).getTime_spend().equals(myRecord.get(i-1).getTime_spend()))
				{
					rankNum=i+1;
				}
			}
			rankList.add(new Rank<>(myRecord.get(i),rankNum));
		}
		return rankList;
	}
	//UserRank
	public static List<Rank<User>> allUser()
	{
		List<User> allByLevel=new UserServiceImpl().allUser()
				.stream()
				.sorted()
				.collect(Collectors.toList());
		
		//如果所花時間相同則排名相同
		List<Rank<User>> rankList = new ArrayList<>();
		int rankNum=1;
		for(int i=0;i<allByLevel.size();i++)
		{
			if(i>0)
			{
				if(allByLevel.get(i).getLevel()!=allByLevel.get(i-1).getLevel())
				{
					rankNum=i+1;
				}
			}
			rankList.add(new Rank<>(allByLevel.get(i),rankNum));
		}
		return rankList;
	}
	public static List<Rank<User>> userTop(int limit)
	{
		List<Rank<User>> top=Ranking.allUser().stream().limit(limit).collect(Collectors.toList());
		return top;
	}
	public static List<Rank<User>> userTopAndThis(String username, int limit)
	{
		List<Rank<User>> rankList = Ranking.allUser();
		List<Rank<User>> top = rankList.stream().limit(limit).collect(Collectors.toList());
		boolean isUserTop = top.stream().anyMatch(p -> p.getObject().getUsername().equals(username));
		if(!isUserTop)
		{
			rankList.stream().filter(p->p.getObject().getUsername().equals(username))
			.findFirst().ifPresent(userRank->{
				userRank.setShow("未上榜");
				top.add(userRank);
			});
		}
		return top;
	}
	//ResultRankexcel
	public void exportAllByLevelToFile(String filePath) throws IOException {
		exportRankWorkbook(filePath, null);
	}

	public void exportUserByLevelToFile(String username, String filePath) throws IOException {
		exportRankWorkbook(filePath, username);
	}

	private void exportRankWorkbook(String filePath, String username) throws IOException {
		HSSFWorkbook excel = new HSSFWorkbook();
		// 標題樣式
		HSSFCellStyle titleStyle = excel.createCellStyle();
		HSSFFont titleFont = excel.createFont();
		titleFont.setBold(true);
		titleStyle.setFont(titleFont);
		titleStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		titleStyle.setBorderBottom(BorderStyle.THIN);

		String[] sheetName = {"Easy", "Advanced", "Hard"};
		String[] title = {"名次", "使用者", "花費時間", "完成時間"};

		for (int i = 0; i < sheetName.length; i++) {
			HSSFSheet sheet = excel.createSheet(sheetName[i]);

			HSSFRow titleRow = sheet.createRow(0);
			for (int j = 0; j < title.length; j++) {
				titleRow.createCell(j).setCellValue(title[j]);
				titleRow.getCell(j).setCellStyle(titleStyle);
			}

			List<Rank<Result>> data;
			int level = i + 1;
			if (username == null) {
				data = resultRankByLevel(level);
			} else {
				data = userRecord(username, level);
			}

			int rowIndex = 1;
			for (Rank<Result> ranking : data) {
				HSSFRow row = sheet.createRow(rowIndex++);
				row.createCell(0).setCellValue(ranking.getShow());
				row.createCell(1).setCellValue(ranking.getObject().getUsername());
				row.createCell(2).setCellValue(ranking.getObject().getTime_spend());
				row.createCell(3).setCellValue(ranking.getObject().getTime_now());
			}

			for (int j = 0; j < title.length; j++) {
				// 讓欄寬完整顯示（並加一點 padding），避免開啟 Excel 時被截斷
				sheet.autoSizeColumn(j, true);
				int w = sheet.getColumnWidth(j);
				w = Math.min(255 * 256, w + 512);
				sheet.setColumnWidth(j, w);
			}
		}

		try (FileOutputStream out = new FileOutputStream(filePath)) {
			excel.write(out);
			out.flush();
		} finally {
			excel.close();
		}
	}
}