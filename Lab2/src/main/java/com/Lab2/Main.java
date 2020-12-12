package com.Lab2;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationResources.xml");
		ServiceDB base = (ServiceDB)ctx.getBean("Service");
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("|_____________________|");
			System.out.println("|1 Create base        |");
			System.out.println("|2 Read base from file|");
			System.out.println("|3 Add to base        |");
			System.out.println("|4 Delete from base   |");
			System.out.println("|5 Save to file       |");
			System.out.println("|6 Print base         |");
			System.out.println("|7 Exit				  |");
			System.out.println("|Input Value :        |");
			System.out.println("|_____________________|");
			int input = sc.nextInt();

			switch(input)
			{
				case 1:
					base.create();
					break;
				case 2:
					base.read();
					break;
				case 3:
					base.add(createStudent(sc));
					break;
				case 4:
					base.del(sc.nextInt());
					break;
				case 5:
					base.save();
					break;
				case 6:
					base.printDb();
					break;
				case 7:
					return;
				default:
					System.out.println("Invalid value");
			}
		}
	}

	
	public static Student createStudent(Scanner sc)
	{

		sc.nextLine();
		Student st = new Student();
		System.out.println("Input ID: ");
		st.setID(Integer.parseInt(sc.nextLine()));
		System.out.println("Input name: ");
		st.setName(sc.nextLine());
		System.out.println("Input surname: ");
		st.setSurname(sc.nextLine());
		System.out.println("Input department: ");
		st.setDepartment(sc.nextLine());
		return st;
	}
}
