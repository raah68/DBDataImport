package exam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import exam.Address;

public class MainClass {
	
	public static void main(String[] args) {
		//addressImport();
		productImport();
	}	
	
	// Method to import the addresses
	private static void addressImport(){
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Load driver success");
			
			Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Reepa\\Desktop\\ExportDB\\restaurant.sqlite");
			String query = "INSERT INTO address values(?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ArrayList<Address> listProduct = getListAddressFromTextFile("C:\\Users\\Reepa\\Documents\\br.csv");
			
			for(int i = 0; i < listProduct.size(); i ++){
				try{
				preparedStatement.setString(1, listProduct.get(i).getBuilding_name());
				}catch(Exception e){
					System.out.println("not Found 1");
				}
				try{
				preparedStatement.setString(2,listProduct.get(i).getStreet_name());
				} catch(Exception e){
					System.out.println("not found 2");
				}
				try{
				preparedStatement.setString(3,listProduct.get(i).getTown_name());
				}catch(Exception e){
					System.out.println("not found 2");
				}
				try{
				preparedStatement.setString(4,listProduct.get(i).getPost_code());
				}catch (Exception e){
					System.out.println("not found 3");
				}
/*				try {
				preparedStatement.setString(5,listProduct.get(i).getPost_code());
				}catch(Exception e){
					System.out.println("not found 4");
				}*/
				
				preparedStatement.executeUpdate();
				System.out.println("Insert success: "+(i+1));
				
				
			}
			System.out.println("All Insert Completed");
			//connection.commit();
			//connection.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	// Method to get addresses from the CSV file
	private static ArrayList<Address> getListAddressFromTextFile(String filePath) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader bReader = null;
		ArrayList<Address> listResult = new ArrayList<Address>();
		
		try{
			fis = new FileInputStream(filePath);
			isr = new InputStreamReader(fis);
			bReader = new BufferedReader(isr);
			
			String line = null;
			String[] strProduct = null;
			
			//Loop
			while (true){
				line = bReader.readLine();
				if(line == null){
					break;
				}
				else {
					strProduct = line.split(",");
					//ArrayList<Product> arr = new ArrayList<Product>();
					listResult.add(
							new Address(
									strProduct[0],
									strProduct[1], 
									strProduct[2], 
									strProduct[3]
									));
				}
			}
		}
		catch(Exception e){
			System.out.println("Read file error");
			e.printStackTrace();
		} finally{
			try {
				bReader.close();
				isr.close();
				fis.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		return listResult;
				
	}

	// Method to import the products into the menu table
	private static void productImport(){
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Load driver success");
			
			Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Reepa\\Desktop\\ExportDB\\restaurant.sqlite");
			String query = "INSERT INTO menu values(?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ArrayList<Product> listProduct = getListProductFromTextFile("C:\\Users\\Reepa\\Desktop\\ExportDB\\menu.csv");
			
			for(int i = 0; i < listProduct.size(); i ++){
				try{
					preparedStatement.setString(1,listProduct.get(i).getName());
				} catch(Exception e){
					System.out.println("not found 1");
				}
				try{
					preparedStatement.setString(2,listProduct.get(i).getPrice());
				}catch(Exception e){
					System.out.println("not found 2");
				}
				try{
					preparedStatement.setString(3,listProduct.get(i).getItemtype());
				}catch (Exception e){
					System.out.println("not found 3");
				}
				try{
					preparedStatement.setString(4,listProduct.get(i).getId());
					
				}catch (Exception e){
					System.out.println("not found 4");
				}
				preparedStatement.executeUpdate();
				System.out.println("Insert success: "+(i+1));
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	// Method to get product from the CSV file
	public static ArrayList<Product> getListProductFromTextFile(String filePath) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader bReader = null;
		ArrayList<Product> listResult = new ArrayList<Product>();
		
		try{
			fis = new FileInputStream(filePath);
			isr = new InputStreamReader(fis);
			bReader = new BufferedReader(isr);
			
			String line = null;
			String[] strProduct = null;
			
			//Loop
			while (true){
				line = bReader.readLine();
				if(line == null){
					break;
				}
				else {
					strProduct = line.split(",");
					listResult.add(new Product(strProduct[0], strProduct[1], strProduct[2], strProduct[3]));
				}
			}
		}
		catch(Exception e){
			System.out.println("Read file error");
			e.printStackTrace();
		} finally{
			try {
				bReader.close();
				isr.close();
				fis.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		return listResult;
				
	}
} // End of class
