package controller;
import java.sql.SQLException;
import java.util.Scanner;

import dao.LoginDAO;
import dao.ProductDAO;
import model.Login;
import model.Product;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int choice;
		Scanner sc=new Scanner(System.in);
		
		Login l=new Login();
		LoginDAO ldao=new LoginDAO();
		Product p=new Product();
		ProductDAO pdao=new ProductDAO();
		
		do
		{
			System.out.println("1.ADMIN");
			System.out.println("2.AGENT");
			System.out.println("3.EXIT");
			System.out.println("*****************************");
			System.out.println("Enter your choice:");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1: System.out.println("Admin Login");
			        System.out.println("Enter UserName:");
			        String username=sc.next();
		          	System.out.println("Enter the password:");
		          	String password=sc.next();
		          	l.setUsername(username);
		          	l.setPassword(password);
		          	
			        if(ldao.checkCredential(l) )//when you are comparing two values while run time input then we have to use .equals()
			        	
			           {   		
				       System.out.println("Login successfull");
			        int option;
			        do
			        	
			           {
			           System.out.println("1.Add Product \n2.Display Product \n3.Update product \n4.Delete product \n5.Logout");
			           System.out.println("Enter your option");
			           option=sc.nextInt();
			           switch(option) {
			           case 1:
			        	   System.out.println("Add product");
			        	   System.out.println("Enter  Product_id:");
			        	   int product_id=sc.nextInt();
			        	   System.out.println("Enter the Product Name:");
			        	   String product_name=sc.next();
			        	   System.out.println("Enter minimun sell quantity:");
			        	   int minSellQuantity=sc.nextInt();
			        	   System.out.println("Enter the Price:");
			        	   int price=sc.nextInt();
			        	   System.out.println("Enter Quantity");
			        	   int quantity=sc.nextInt();
			        	   p.setProductId(product_id);
			        	   p.setProductName(product_name);
			        	   p.setMinSellQuantity(minSellQuantity);
			        	   p.setPrice(price);
			        	   p.setQuantity(quantity);
			        	   pdao.addProduct(p);                                       
			        	   System.out.println("Product Added Successfully");
			        	   
			        	   break;
			           case 2:
			        	   
			        	   System.out.println("The products are:");
			        	   pdao.display();
			        	   break;
			           case 3:
			        	   
			        	   System.out.println("Update product");
			        	   System.out.println("Enter  Product_id:");
			        	   int product_id1=sc.nextInt();
			        	   System.out.println("Enter the Product Name:");
			        	   String product_name1=sc.next();
			        	   System.out.println("Enter minimun sell quantity:");
			        	   int minSellQuantity1=sc.nextInt();
			        	   System.out.println("Enter the Price:");
			        	   int price1=sc.nextInt();
			        	   System.out.println("Enter Quantity");
			        	   int quantity1=sc.nextInt();
			        	   p.setProductId(product_id1);
			        	   p.setProductName(product_name1);
			        	   p.setMinSellQuantity(minSellQuantity1);
			        	   p.setPrice(price1);
			        	   p.setQuantity(quantity1);
			        	   pdao.updateProduct(p);                                       
			        	   System.out.println("Product Updated Successfully");
			        	   break;
			           case 4:
			        	   System.out.println("Enter the element Id to be Deleted:");
			        	   int product_id2=sc.nextInt();
			        	   
			        	   p.setProductId(product_id2);
			        	   pdao.deleteProduct(p);
			        	   System.out.println("Element Deleted Successfully");
			        	   break;
			        	   
			           case 5:
			        	   System.out.println("Logout");
                           break;
			        	  
			           }
			           } while(option!=5);
			        
			           }
			        	
			        else
				       System.out.println("Incorrect Usernamr or Password");
			        break;
			case 2: System.out.println("Agent Login");
			        System.out.println("Enter UserName:");
			        String usernameagent=sc.next();
			        System.out.println("Enter the password:");
			        String passwordagent=sc.next();
			        l.setUsername(usernameagent);
			        l.setPassword(passwordagent);
			        if(((LoginDAO) ldao).checkCredential(l)) //when you are comparing two values while run time input then we have to use .equals()
			        { 
			        	 System.out.println("Login successfull");
			        	 int optionagent;
			        	 do {
			        		System.out.println("1.Display Product \n2.Logout");
			        		System.out.println("Enter your option");
			        		
			        		optionagent=sc.nextInt();
			        		switch(optionagent) {
			        		case 1: 
			        			
			        			System.out.println("Products are");
			        			pdao.display();
			        			break;
			        		case 2:
			        			System.out.println("Logout");
			        			break;
			        		}
			        	 }while(optionagent!=2);
			        	
			        }
			        
				      
			        else
				       System.out.println("Incorrect Username or Password");
			        break;
			        
			        
			case 3: System.out.println("Exit");
			break;
			}
			
		     
		}while(choice !=3);
        sc.close(); //only in eclipse we have to close the scanner screen
	}

}

