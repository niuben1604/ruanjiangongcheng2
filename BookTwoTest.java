package library;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookTwoTest {
	public static void main(String[] args) {
    Signin signin=new Signin();
    Customer customer=new Customer();
    ArrayList<BookTwo> list=new ArrayList<BookTwo>();
    BookTwoMenthod fiction=new BookTwoMenthod();
    Scanner input=new Scanner(System.in);
    signin.setInformation();
    signin.writeInformation();
    fiction.show1(list);
    do{
    	System.out.println("**********欢迎使用登陆界面***********");
    	System.out.println("请输入您的姓名：");
        String name =input.next();
        System.out.println("请输入您的密码：");
        String passWord=input.next();
        if(signin.bianLi(name, passWord)==1){
        	System.out.println("登陆成功！");
            for(int j=0;;j++){
            	fiction.show();
            	String i=input.next();
            	switch(i){
            	case "1": fiction.show2(list);
            	          System.out.println("请输入您所需要的操作数:1、买书   2、租书   3、退出");
                          String k=input.next();
                          if(k.equals("1")){
                                    System.out.println("请输入您要购买的书的编号，数量：");
                                    String bnum=input.next();
                                    int bcount =input.nextInt();
                                    fiction.buyBook(list,bnum, bcount);
                                    continue;
                              }
                          else if(k.equals("2")){
                                    System.out.println("请输入您要购租的书的编号，数量：");
                                    String bnum=input.next();
                                    int bcount =input.nextInt();
                                    System.out.println("您要租的时长：1.一个周；2.一个月；3.半年");
                                    try{
                                    	int date=input.nextInt();
                                    	fiction.rentBook(list,bnum, bcount, date);
                                    	}catch(InputMismatchException e){
                                    		System.out.println("请输入数字");
                                    		}
                                    continue;
                                    }else if(k.equals("3")){
                                    	break;
                                    	}else{
                                    		System.out.println("请输入规定数字！");
                                    		continue;
                                    		}
            case "2":
            		 fiction.addBook(list); 
            		 continue;

            case "3":
                     do {
                         System.out.println("请输入要还书的编号，数量");
                         String bnum=input.next();
                         int bcount=input.nextInt();
                         if(fiction.returnBook(list,bnum, bcount)==0){
                        			  continue;
                        			  }else{
                        				  break;
                        				  }
                        		  }while(true);
                        	            continue;
                        	   
            case "4":
                       	fiction.deleteBook(list); 
                        continue;

            case "5":  break;
               
            default:
                        System.out.println("请输入数字（1-5）！");
                        continue;
                       }
            	break;
            	}
            }else{
            	System.out.println("密码或用户名错误！");
                System.out.println("您是否要注册？y or n");
                String s=input.next();
                if(s.equals("y")){
                	System.out.println("请输入您的姓名：");
                	String name1 =input.next();
                	System.out.println("请输入您的密码：");
                	String passWord1=input.next();
                	for(int j=0;j<signin.arrayList.size();j++){
                		customer=signin.arrayList.get(j);
                		if(customer.getName().equals(name)&&customer.getPassWord().equals(passWord)){
                			System.out.println("用户已存在！");
                			break;
                			}
                		else{
                			signin.arrayList.add(new Customer(name1, passWord1));
                			signin.writeInformation();
                			System.out.println("注册成功！");
                			signin.readInformation();
                			signin.bianLi(name1, passWord1);
                			break;
                			}
                		}
                	continue;
                	}
                else{
                	System.out.println("用户名或密码错误！不注册您不能访问该系统！");
                	continue;
                	}
                }
        }while(true);
    }
}