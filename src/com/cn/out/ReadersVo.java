package com.cn.out;

public class ReadersVo {
	private String xuehao;//学号
	private String reader_name;//姓名
    private String classname;//班级
    private int borrow_num;//借书数量
	public String getXuehao() {
		return xuehao;
	}
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
    public String getReader_name() {
		return reader_name;
	}
	public void setReader_name(String reader_name) {
		this.reader_name = reader_name;
	}
	public String getClassname(){
		return classname;
	}
	public void setClassname(String classname){
		this.classname=classname;
	}
	public int getBorrow_num() {
		return borrow_num;
	}
	public void setBorrow_num(int borrow_num) {
		this.borrow_num= borrow_num;
	}
	
}
