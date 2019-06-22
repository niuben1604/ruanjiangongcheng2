package library;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;  


import java.util.ArrayList;
import java.util.Iterator;

public class BookTwoMenthod {
	int count;
	BookTwo book=new BookTwo();
	public void show(){
		System.out.println("**********你好！欢迎使用书店系统**********");
		System.out.println("1.查阅图书");
        System.out.println("2.增加图书");
        System.out.println("3.归还图书");
        System.out.println("4.删除图书");
        System.out.println("5.退出系统");
        System.out.print("请输入要选择的编号：");
    }
	public void show1(ArrayList<BookTwo> list) {
		list.add(new BookTwo("001","《每日一笑》","搞笑",20,100));
		list.add(new BookTwo("002","《福尔摩斯》","悬疑",77,100));
		list.add(new BookTwo("003","《爆笑小白》","搞笑",35,100));
		list.add(new BookTwo("004","《钢铁是怎样炼成的》","励志",46,100));
		list.add(new BookTwo("005","《心有不甘》","虐心",50,100));
		list.add(new BookTwo("006","《平凡的世界》","励志", 66,100));
		list.add(new BookTwo("007","《世界的微尘里》","言情",30,100));
		}
	
	public void show2(ArrayList<BookTwo> list){
		Iterator<BookTwo> ti=list.iterator();
		System.out.println("编号\t名称\t\t种类\t\t价格\t库存");
		while(ti.hasNext()){
			BookTwo e=(BookTwo) ti.next();
			System.out.println(e.getBnum()+"\t"+e.getBname()+"\t"
			+e.getBtype()+"\t\t"+e.getBprice()+"\t"+e.getBleft());
			}
		}
	public void buyBook(ArrayList<BookTwo> list,String bnum,int bcount){
		for(int i=0;i<list.size();i++){
			book=list.get(i);
			if(bcount>=book.getBleft()){
				System.out.println("书库没有足够库存！");
				break;
				}
			else if(book.getBnum().equals(bnum)){
				System.out.println("您要购买的书是："+book.getBname());
				System.out.println("您需要支付金额是："+bcount*book.getBprice());
				book=new BookTwo(bnum, book.getBname(), book.getBtype(), book.getBprice(), book.getBleft()-bcount);
                list.set(i, book);
                break;
                }
			else if(i==list.size()-1){
				System.out.println("没有您要购买的书");
				}
			else{
				continue;
				}
			}
		}
	
	public  void addBook(ArrayList<BookTwo> list) {  
        Scanner input=new Scanner(System.in);  
        System.out.println("请输入书的编号，名字，类型，价格，库春");
        String bnum=input.next();
        String bname=input.next();
        String btype=input.next();
        double bprice=input.nextDouble();
        int bleft=input.nextInt();
        System.out.println("添加成功！！\n");  
        BookTwo book=new BookTwo(bnum,bname,btype,bprice,bleft);  
        list.add(book);    
	}
	
	public  void deleteBook(ArrayList<BookTwo> list) {  
        Scanner input =new Scanner(System.in);  
        Boolean b=true;  
        System.out.println("请输入你要删除图书的编号");  
        String bnum=input.next();  
        for(int i=0;i<list.size();i++) {  
               Iterator<BookTwo> it=list.iterator();  
            while(it.hasNext()) {  
                // Book1 B=  A.get(i);  //没有<Book1>，就要强制转换 Book1(A.get(i));  
           BookTwo book = it.next();//迭代器删除，（有泛型就不用强转）强型转换      
            if(bnum.equals(book.getBnum())) {  
                it.remove();  
                System.out.println("已经成功删除");  
                b=false;  
                 
            } 
       }  
  }     
        if(b) {  
            System.out.println("没有找到该书");        
        }  
    }  

	public void rentBook(ArrayList<BookTwo> list,String bnum,int bcount,int date){
		for(int i=0;i<list.size();i++){
			book=list.get(i);
			if(bcount>=book.getBleft()){
				System.out.println("书库没有足够库存！");
				break;
				}
			else if(book.getBnum().equals(bnum)){
				switch (date){
				case 1:System.out.println("您要租的书是："+book.getBname());
				       System.out.println("您要支付的价格是："+7*bcount*5);
				       break;
			    case 2:System.out.println("您要的书是："+book.getBname());
                       System.out.println("您要支付的价格是："+15*bcount*2);
                       break;
                case 3:System.out.println("您要购买的书是："+book.getBname());
                       System.out.println("您要支付的价格是："+183*bcount*1);
                       break;
                default:System.out.println("请输入数字（1-3）！");
                        break;
                        }
				}
			else if(i!=list.size()-1){
				continue;
				}
			else{
				System.out.println("没有该本书！");
				break;
				}
			break;
			}
		for(int i=0;i<list.size();i++){
			book=list.get(i);
            if(book.getBnum().equals(bnum)){
                 book=new BookTwo(bnum, book.getBname(), book.getBtype(), book.getBprice(), book.getBleft()-bcount);
                 list.set(i, book);
            }
            else{
            	continue;
            	}
            }
		}
	
	public int returnBook(ArrayList<BookTwo> list,String bnum,int bcount){
		for(int i=0;i<list.size();i++){
        book=list.get(i);
        if(book.getBnum().equals(bnum)){
        if(book.getBleft()<100){
        	book=new BookTwo(bnum, book.getBname(), book.getBtype(), book.getBprice(), book.getBleft()+bcount);
            list.set(i, book);
            System.out.println("还书成功！");
            return 1;
          }
        else{
            System.out.println("您没有借这个书请确定书编号后，在还书");
            return 1;
          }
        }
        else if(i!=list.size()-1){
               continue;
               }
        else{
            System.out.println("没有该书，请确定书的编号,重新登陆");
            break;
            }
        }
		return 0;
		}
	}
