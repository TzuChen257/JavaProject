package service;

import java.util.List;

import dao.UserDaoImpl;
import model.User;

interface UserService
{
	//c
	boolean addUser(User user);
	//r
	List<User> allUser();//登入選項用(下拉式選單)
	List<User> findByUser(String username);//確認使用者是否重複用
	//u
	void updateUser(User user);//每日簽到：同一天只執行一次；以週為單位(7日)累計，跨週自動重置。@return 若本次登入有觸發簽到+1，回傳 true。
	boolean processDailyCheckin(User user);//遊戲勝利加分並自動升等(最多10等)
	void addWinPoints(User user, int mapLevel);
}
public class UserServiceImpl implements UserService{
	//test main
	public static void main(String[] args) {
		System.out.println(new UserServiceImpl().addUser(new User("kkk","1234")));
	}
	//連線方法用物件
	UserDaoImpl userDaoImpl=new UserDaoImpl();
	//method
	@Override
	public boolean addUser(User user) {
		boolean isAdd=false;//用戶名稱重複
		if(new UserServiceImpl().findByUser(user.getUsername()).isEmpty())//查無此用戶則可新增
		{
			userDaoImpl.add(user);
			isAdd=true;
		}
		return isAdd;
	}
	@Override
	public List<User> allUser() {
		return userDaoImpl.selectAll();
	}
	@Override
	public List<User> findByUser(String username) {
		return userDaoImpl.selectByUser(username);
	}

	@Override
	public void updateUser(User user) {
		userDaoImpl.updateGameStateAndCheckin(user);
	}

	@Override
	public boolean processDailyCheckin(User user) {
		// Guest 不簽到
		if (user == null || "Guest".equalsIgnoreCase(user.getUsername())) return false;

		String today = util.Tool.loginDate(); // yyyy/MM/dd
		String thisWeek = util.UserWeekTool.weekKey(today); // e.g. 2026-W08

		// 跨週：重置
		if (user.getCheckin_week() == null || !thisWeek.equals(user.getCheckin_week())) {
			user.setCheckin_week(thisWeek);
			user.setCheckin_count(0);
			user.setLatest_checkin(null);
		}

		// 同一天已簽到：不重複
		if (today.equals(user.getLatest_checkin())) {
			return false;
		}

		// 觸發簽到：+1 分、累計+1（最多7）
		int newCount = Math.min(7, user.getCheckin_count() + 1);
		user.setCheckin_count(newCount);
		user.setLatest_checkin(today);

		// 簽到 +1 分
		user.setScore(user.getScore() + 1);
		recalcLevel(user);

		updateUser(user);
		return true;
	}

	@Override
	public void addWinPoints(User user, int mapLevel) {
		if (user == null || "Guest".equalsIgnoreCase(user.getUsername())) return;

		int add = 0;
		switch (mapLevel) {
			case 1: add = 5; break; // Easy
			case 2: add = 30; break; // Advanced
			case 3: add = 100; break; // Hard
			default: add = 0;
		}
		user.setScore(user.getScore() + add);
		recalcLevel(user);
		updateUser(user);
	}

	private void recalcLevel(User user) {
		// 依等級表（LevelTable）升等：最高 10 等；最低 1 等
		int lvl = util.LevelTable.calcLevel(user.getScore());
		user.setLevel(Math.min(util.LevelTable.maxLevel(), Math.max(1, lvl)));
	}
}
