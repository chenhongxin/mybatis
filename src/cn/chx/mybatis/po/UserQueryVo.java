package cn.chx.mybatis.po;

import java.util.List;

public class UserQueryVo {

	// �������װ����Ҫ�Ĳ�ѯ����
	// ������id
	private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	// �û���ѯ����
	private UserCustomer userCustomer;

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	// ���԰�װ�����Ĳ�ѯ��������������Ʒ
	// ...

}
