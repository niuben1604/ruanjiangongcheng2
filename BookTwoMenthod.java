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
		System.out.println("**********��ã���ӭʹ�����ϵͳ**********");
		System.out.println("1.����ͼ��");
        System.out.println("2.����ͼ��");
        System.out.println("3.�黹ͼ��");
        System.out.println("4.ɾ��ͼ��");
        System.out.println("5.�˳�ϵͳ");
        System.out.print("������Ҫѡ��ı�ţ�");
    }
	public void show1(ArrayList<BookTwo> list) {
		list.add(new BookTwo("001","��ÿ��һЦ��","��Ц",20,100));
		list.add(new BookTwo("002","������Ħ˹��","����",77,100));
		list.add(new BookTwo("003","����ЦС�ס�","��Ц",35,100));
		list.add(new BookTwo("004","���������������ɵġ�","��־",46,100));
		list.add(new BookTwo("005","�����в��ʡ�","Ű��",50,100));
		list.add(new BookTwo("006","��ƽ�������硷","��־", 66,100));
		list.add(new BookTwo("007","�������΢���","����",30,100));
		}
	
	public void show2(ArrayList<BookTwo> list){
		Iterator<BookTwo> ti=list.iterator();
		System.out.println("���\t����\t\t����\t\t�۸�\t���");
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
				System.out.println("���û���㹻��棡");
				break;
				}
			else if(book.getBnum().equals(bnum)){
				System.out.println("��Ҫ��������ǣ�"+book.getBname());
				System.out.println("����Ҫ֧������ǣ�"+bcount*book.getBprice());
				book=new BookTwo(bnum, book.getBname(), book.getBtype(), book.getBprice(), book.getBleft()-bcount);
                list.set(i, book);
                break;
                }
			else if(i==list.size()-1){
				System.out.println("û����Ҫ�������");
				}
			else{
				continue;
				}
			}
		}
	
	public  void addBook(ArrayList<BookTwo> list) {  
        Scanner input=new Scanner(System.in);  
        System.out.println("��������ı�ţ����֣����ͣ��۸񣬿ⴺ");
        String bnum=input.next();
        String bname=input.next();
        String btype=input.next();
        double bprice=input.nextDouble();
        int bleft=input.nextInt();
        System.out.println("��ӳɹ�����\n");  
        BookTwo book=new BookTwo(bnum,bname,btype,bprice,bleft);  
        list.add(book);    
	}
	
	public  void deleteBook(ArrayList<BookTwo> list) {  
        Scanner input =new Scanner(System.in);  
        Boolean b=true;  
        System.out.println("��������Ҫɾ��ͼ��ı��");  
        String bnum=input.next();  
        for(int i=0;i<list.size();i++) {  
               Iterator<BookTwo> it=list.iterator();  
            while(it.hasNext()) {  
                // Book1 B=  A.get(i);  //û��<Book1>����Ҫǿ��ת�� Book1(A.get(i));  
           BookTwo book = it.next();//������ɾ�������з��;Ͳ���ǿת��ǿ��ת��      
            if(bnum.equals(book.getBnum())) {  
                it.remove();  
                System.out.println("�Ѿ��ɹ�ɾ��");  
                b=false;  
                 
            } 
       }  
  }     
        if(b) {  
            System.out.println("û���ҵ�����");        
        }  
    }  

	public void rentBook(ArrayList<BookTwo> list,String bnum,int bcount,int date){
		for(int i=0;i<list.size();i++){
			book=list.get(i);
			if(bcount>=book.getBleft()){
				System.out.println("���û���㹻��棡");
				break;
				}
			else if(book.getBnum().equals(bnum)){
				switch (date){
				case 1:System.out.println("��Ҫ������ǣ�"+book.getBname());
				       System.out.println("��Ҫ֧���ļ۸��ǣ�"+7*bcount*5);
				       break;
			    case 2:System.out.println("��Ҫ�����ǣ�"+book.getBname());
                       System.out.println("��Ҫ֧���ļ۸��ǣ�"+15*bcount*2);
                       break;
                case 3:System.out.println("��Ҫ��������ǣ�"+book.getBname());
                       System.out.println("��Ҫ֧���ļ۸��ǣ�"+183*bcount*1);
                       break;
                default:System.out.println("���������֣�1-3����");
                        break;
                        }
				}
			else if(i!=list.size()-1){
				continue;
				}
			else{
				System.out.println("û�иñ��飡");
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
            System.out.println("����ɹ���");
            return 1;
          }
        else{
            System.out.println("��û�н��������ȷ�����ź��ڻ���");
            return 1;
          }
        }
        else if(i!=list.size()-1){
               continue;
               }
        else{
            System.out.println("û�и��飬��ȷ����ı��,���µ�½");
            break;
            }
        }
		return 0;
		}
	}
