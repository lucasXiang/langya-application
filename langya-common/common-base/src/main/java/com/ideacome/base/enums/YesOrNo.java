package com.ideacome.base.enums;


public enum YesOrNo {
	yes(Byte.valueOf("1"),"��"),
	no(Byte.valueOf("0"),"��")
	;
	private Byte value;
	private String msg;
	
	private YesOrNo(Byte value,String msg){
		this.value = value;
		this.msg = msg;
	}

	public Byte getValue() {
		return value;
	}
	public String getMsg() {
		return msg;
	}
}
