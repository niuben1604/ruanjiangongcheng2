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
    	System.out.println("**********��ӭʹ�õ�½����***********");
    	System.out.println("����������������");
        String name =input.next();
        System.out.println("�������������룺");
        String passWord=input.next();
        if(signin.bianLi(name, passWord)==1){
        	System.out.println("��½�ɹ���");
            for(int j=0;;j++){
            	fiction.show();
            	String i=input.next();
            	switch(i){
            	case "1": fiction.show2(list);
            	          System.out.println("������������Ҫ�Ĳ�����:1������   2������   3���˳�");
                          String k=input.next();
                          if(k.equals("1")){
                                    System.out.println("��������Ҫ�������ı�ţ�������");
                                    String bnum=input.next();
                                    int bcount =input.nextInt();
                                    fiction.buyBook(list,bnum, bcount);
                                    continue;
                              }
                          else if(k.equals("2")){
                                    System.out.println("��������Ҫ�������ı�ţ�������");
                                    String bnum=input.next();
                                    int bcount =input.nextInt();
                                    System.out.println("��Ҫ���ʱ����1.һ���ܣ�2.һ���£�3.����");
                                    try{
                                    	int date=input.nextInt();
                                    	fiction.rentBook(list,bnum, bcount, date);
                                    	}catch(InputMismatchException e){
                                    		System.out.println("����������");
                                    		}
                                    continue;
                                    }else if(k.equals("3")){
                                    	break;
                                    	}else{
                                    		System.out.println("������涨���֣�");
                                    		continue;
                                    		}
            case "2":
            		 fiction.addBook(list); 
            		 continue;

            case "3":
                     do {
                         System.out.println("������Ҫ����ı�ţ�����");
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
                        System.out.println("���������֣�1-5����");
                        continue;
                       }
            	break;
            	}
            }else{
            	System.out.println("������û�������");
                System.out.println("���Ƿ�Ҫע�᣿y or n");
                String s=input.next();
                if(s.equals("y")){
                	System.out.println("����������������");
                	String name1 =input.next();
                	System.out.println("�������������룺");
                	String passWord1=input.next();
                	for(int j=0;j<signin.arrayList.size();j++){
                		customer=signin.arrayList.get(j);
                		if(customer.getName().equals(name)&&customer.getPassWord().equals(passWord)){
                			System.out.println("�û��Ѵ��ڣ�");
                			break;
                			}
                		else{
                			signin.arrayList.add(new Customer(name1, passWord1));
                			signin.writeInformation();
                			System.out.println("ע��ɹ���");
                			signin.readInformation();
                			signin.bianLi(name1, passWord1);
                			break;
                			}
                		}
                	continue;
                	}
                else{
                	System.out.println("�û�����������󣡲�ע�������ܷ��ʸ�ϵͳ��");
                	continue;
                	}
                }
        }while(true);
    }
}