package com.cn.service;



public class BorrowsVo {
	private int id;//编号
	private String xuehao;//学号
	private String reader_name;//姓名
    private String classname;//班级
    private String shuhao;//书号
    private String bookname;//书名
    private String borrowtime;//借书时间
    private String backtime;//应还书时间
    private int timepass;//是否过期
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getShuhao(){
		return shuhao;
	}
	public void setShuhao(String shuhao){
		this.shuhao=shuhao;
	}
	public String getBookname(){
		return bookname;
	}
	public void setBookname(String bookname){
		this.bookname=bookname;
	}
	public String  getBorrowtime(){
		return borrowtime;
	}
	public void setBorrowtime(String  borrowtime){
		this.borrowtime=borrowtime;
	}
	public String  getBacktime(){
		return backtime;
	}
	public void setBacktime(String backtime){
		this.backtime=backtime;
	}
	
	
	public int getTimepass() {
		return timepass;
	}
	public void setTimepass(int timepass) {
		this.timepass= timepass;
	}
	
}