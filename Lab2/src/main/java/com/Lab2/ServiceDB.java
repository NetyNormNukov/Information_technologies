package com.Lab2;

import java.util.ArrayList;

public class ServiceDB {
	
	private DataBase db = new DataBase();
	
	public DataBase getDb() {
		return db;
	}
	
	public void create() 
	{
		db.create();
	}
	
	public void read()
	{
		db.read();
	}
	
	public void add(Student st)
	{
		db.add(st);
	}
	
	public void del(int pos)
	{
		db.del(pos);
	}
	
	public void save()
	{
		db.save();
	}
	public void printDb()
	{
		ArrayList <Student> store = db.getDb();
		for(int i = 0; i < store.size(); i++)
		{
			System.out.println("Student #"+(i+1) );
			System.out.println("ID: "+store.get(i).getID());
			System.out.println("Name: " + store.get(i).getName());
			System.out.println("Surename: "+store.get(i).getSurname());
			System.out.println("Department: "+ store.get(i).getDepartment());
			System.out.println();
		}
	}

	public void setDb(DataBase db) {
		this.db = db;
	}

	public int size(){
		return db.size();
	}
}