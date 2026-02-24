package vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

interface ViewService
{
	//all
	List<View01> allAccountView(); 
	//one
	List<View01> oneAccountView(String subject_account);
}
public class ViewServiceImpl implements ViewService{

	public static void main(String[] args) {
		System.out.println(new ViewServiceImpl().allAccountView());
	}
	//要用的物件
	ViewDaoImpl viewDaoImpl=new ViewDaoImpl();
	//method
	@Override
	public List<View01> allAccountView() {
		List<View01> all=new ArrayList<>();
		all.addAll(viewDaoImpl.allIncome());
		all.addAll(viewDaoImpl.allExpenses());
		Stream<View01> s=all.stream();
		List<View01> allsort=new ArrayList<>();
		s.sorted().forEach(c->allsort.add(c));
		return allsort;
	}
	@Override
	public List<View01> oneAccountView(String subject_account) {
		List<View01> one=new ArrayList<>();
		one.addAll(viewDaoImpl.onesIncome(subject_account));
		one.addAll(viewDaoImpl.onesExpenses(subject_account));
		Stream<View01> s=one.stream();
		List<View01> onesort=new ArrayList<>();
		s.sorted().forEach(c->onesort.add(c));
		return onesort;
	}
}