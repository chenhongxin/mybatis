package cn.chx.mybatis.po;

import java.util.List;

public class UserQueryVo {

	// 在这里包装所需要的查询条件
	// 传入多个id
	private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	// 用户查询条件
	private UserCustomer userCustomer;

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	// 可以包装其它的查询条件，订单、商品
	// ...

}
