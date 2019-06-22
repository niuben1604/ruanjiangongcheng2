package library;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Signin {
	ArrayList<Customer> arrayList=new ArrayList<Customer>();
    Customer customer=new Customer();
    
public void setInformation(){
	arrayList.add(new Customer("liufengnan","1234"));
	arrayList.add(new Customer("baoyuqiao","123"));
	arrayList.add(new Customer("hanhuijie","12345"));
}

public int bianLi(String name,String passWord ){
	for(int j=0;j<arrayList.size();j++){
		customer=arrayList.get(j);
		if(customer.getName().equals(name)&&customer.getPassWord().equals(passWord)){
			break;
			}
		else if(j!=arrayList.size()-1){
			 continue;
            }
		else{
             return 0;
             }
		}
	return 1;
	}

public void writeInformation(){
	ObjectOutputStream oos=null;
	try {
		 oos=new ObjectOutputStream( new FileOutputStream("d:\\pro2.docx"));
		 oos.writeObject(arrayList);
		 } catch (IOException e) {
			 e.printStackTrace();
			 }finally{
				 try {
					 oos.flush();
					 oos.close();
					 } catch (IOException e) {
						 e.printStackTrace();
						 }
				 }
	}

    @SuppressWarnings("unchecked")
    public void readInformation(){
    	ObjectInputStream ois=null;
        try {
            ois=new ObjectInputStream(new FileInputStream("d:\\pro2.docx"));
            arrayList=(ArrayList<Customer>) ois.readObject();
             } catch (FileNotFoundException e) {
                    e.printStackTrace();
                   } catch (IOException e) {
                           e.printStackTrace();
                       } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }finally{
                                try {
                                     ois.close();
                                     } catch (IOException e) {
                                           e.printStackTrace();
                                           }
                                }
        }
}