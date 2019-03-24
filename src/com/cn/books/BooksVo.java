package com.cn.books;

public class BooksVo {
	private String shuhao;//书号
	private String bookname;//书名
    private String author;//作者
    private String publishing;//出版社
    private String publishingtime;//出版时间
    private String price;//价格
    private String adress;//位置
    private int isrenting;//借阅情况
	public String getShuhao() {
		return shuhao;
	}
	public void setShuhao(String shuhao) {
		this.shuhao = shuhao;
	}
    public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor(){
		return author;
	}
	public void setAuthor(String author){
		this.author=author;
	}
	public String getPublishing(){
		return publishing;
	}
	public void setPublishing(String publishing){
		this.publishing=publishing;
	}
	public String getPublishingtime(){
		return publishingtime;
	}
	public void setPublishingtime(String publishingtime){
		this.publishingtime=publishingtime;
	}
	public String getPrice(){
		return price;
	}
	public void setPrice(String price){
		this.price=price;
	}
	public String getAdress(){
		return adress;
	}
	public void setAdress(String adress){
		this.adress=adress;
	}
	public int getIsrenting() {
		return isrenting;
	}
	public void setIsrenting(int isrenting) {
		this.isrenting =isrenting;
	}
}
