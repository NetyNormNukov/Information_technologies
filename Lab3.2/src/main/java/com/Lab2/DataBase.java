package com.Lab2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataBase {
	private String filePath;
	private ArrayList<Student> db = new ArrayList<Student>();
	
	DataBase(){

	};
	
	public ArrayList<Student> getDb() {
		return db;
	}

	public void setDb(ArrayList<Student> db) {
		this.db = db;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void create() 
	{
		db = new ArrayList<Student>();
	}
	
	public void read()
	{
		try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));
            db =(ArrayList<Student>)is.readObject();
            is.close();
        } catch (IOException | ClassNotFoundException ex) {System.out.println("File Error");}
	}
	
	public void add(Student st)
	{
		db.add(st);
	}
	
	public void del(int ID)
	{
		for (int i = 0; i < db.size(); i++) {
			if (db.get(i).getID() == ID) {
				db.remove(i);
				break;
			}
		}
	}
	
	public void save()
	{
		try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filePath));
            os.writeObject(db);
            os.close();
        }catch (IOException ex){
			ex.printStackTrace();
		}
	}
	public int size(){
		return db.size();
	}
}
