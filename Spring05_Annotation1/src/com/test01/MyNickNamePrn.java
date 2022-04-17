package com.test01;

public class MyNickNamePrn {
	
	private NickName nickname;

	

	
	public void setNickname(NickName nickname) {
		this.nickname = nickname;
	}

	

	
	public NickName getNickname() {
		return nickname;
	}




	@Override
	public String toString() {
		return "제직업은" + nickname + "입니다.";
	}
	
	
}
