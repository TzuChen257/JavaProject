package util.gameSettings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import model.BombMap;

public class BombMapTool{

	public static BombMap[] newMapSet(int xMax,int yMax,int bombNum)//10*10 就輸入10,10,10，16*16就輸入16,16,40
	{
		//newMap
		BombMap[] mapArr=new BombMap[xMax*yMax];
		//NewMap座標系統
		int index=0;
		for(int y=1;y<=xMax;y++)
		{
			for(int x=1;x<=yMax;x++)
			{
				mapArr[index++]=new BombMap(x,y);
			}
		}
		//放bomp
		List<Integer> pickNum=new ArrayList<>();//不拿原本的洗牌
		for(int i=0;i<xMax*yMax;i++)
		{
			pickNum.add(i);
		}
		Collections.shuffle(pickNum);//隨便洗牌
		
		for(int i=0;i<bombNum;i++)
		{
			BombMap m=mapArr[pickNum.get(i)];
			m.setBomb(true);//選其中10個
			m.setSurroundBomb(-1);
			m.setImage(BombResources.getBottomImage("bomb"));
		}
		//將其他設定補齊：格子顯示附近有多少bomb
		Arrays.asList(mapArr).stream().filter(m->m.getSurroundBomb()!=-1)
		.forEach(m->{
			int count=BombMapTool.arroundBompNum(m.getX(), m.getY(), mapArr);
			m.setSurroundBomb(count);
			if(count==0) m.setImage(BombResources.getBottomImage("white"));
			else m.setImage(BombResources.getBottomImage(count));
		});
		return mapArr;
	}
	//用xy找已知物件
	public static BombMap getMapByXY(int x, int y, BombMap[] mapSet)
	{
		return Arrays.asList(mapSet).stream().filter(m->m.getX()==x&&m.getY()==y).findFirst().orElse(null);
	}
	//不是bomb者找附近的格子bomb數量
	public static int arroundBompNum(int x, int y, BombMap[] mapSet)
	{
		int countBomp=0;
		for(int i=x-1;i<=x+1;i++)
		{
			for(int j=y-1;j<=y+1;j++)
			{
				if(i==x&&j==y) continue;//跳過此格
				BombMap nearby=BombMapTool.getMapByXY(i,j,mapSet);
				if(nearby!=null&&nearby.getSurroundBomb()==-1)
				{
					countBomp++;
				}
			}
		}
		return countBomp;
	}
	//空白者呼叫所有附近bomp
	public static List<BombMap> arroundBomps(int x, int y, BombMap[] mapSet)
	{
		List<BombMap> l=new ArrayList<>();
		for(int i=x-1;i<=x+1;i++)
		{
			for(int j=y-1;j<=y+1;j++)
			{
				if(i==x&&j==y) continue;//跳過此格
				BombMap near=BombMapTool.getMapByXY(i,j,mapSet);
				if(near!=null) l.add(near);
			}
		}
		return l;
	}
}