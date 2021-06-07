package mod;

import java.util.ArrayList;

import cont.JOP;

public class World {
	
	//Declaring and initializing variables needed to properly execute the code
	ArrayList<Integer> a = new ArrayList<Integer>();
	ArrayList<Integer> b = new ArrayList<Integer>();
	ArrayList<Integer> c = new ArrayList<Integer>();
	
	boolean running = true;
	
	int count = 0;
	String m;
	int b1 = 0;
	int x = 0;
	int y = 0;
	int check;
	int compare1, compare2;
	double[] heehee;
	int edit;
	
	
	
	
	public World() {
		
		//Displays the intro message
		JOP.msg("Type in Exit at anytime if you ever want to leave.");
		
		//Sets up the infinite loop to run the code
		while(running == true)
		{
			
			//Sets up an input message that separates the line's set up into either standard form or in slope form
			String response = JOP.in("Type in Standard if you want to create your line in Standard Form (Ax + By + C = 0)\nType in Slope if you want to create your line in Slope Form (y= mx + b)\nType Check to see if a specific point is on a line you've entered previously\nEnter Compare if you want to see if two lines intercect\nEnter Edit if you want to edit a line.");
			
			if (response.equalsIgnoreCase("exit"))
			{
				System.exit(0);
			}
			
			//Standard form
			if (response.equalsIgnoreCase("standard"))
			{
				//Sets the values for A, B, and C for a line in its respective arrayList
				String respons = JOP.in("What is the value of A?");
				
				if (respons.equalsIgnoreCase("exit"))
				{
					System.exit(0);
				}
				
				a.add(Integer.parseInt(respons));
				
				String respon = JOP.in("What is the value of B?");
				
				if (respon.equalsIgnoreCase("exit"))
				{
					System.exit(0);
				}
				
				b.add(Integer.parseInt(respon));
				
				String respo = JOP.in("What is the value of C?");
				
				if (respo.equalsIgnoreCase("exit"))
				{
					System.exit(0);
				}
				
				c.add(Integer.parseInt(respo));
				
				//Calculates the line's slope and displays the line's information
				JOP.msg("The line you inserted is:\n" + a.get(count) + "x + " + b.get(count) + "y + " + c.get(count) + " = 0\nThe Slope of this line is: " + -(a.get(count) / ((double) b.get(count))) + "\nThe value of A, B, and C is: " + a.get(count) + ", " + b.get(count) + ", " + c.get(count));
				
				count++;
			}
			
			//Slope form
			if (response.equalsIgnoreCase("slope"))
			{
				//Checks whether or not if the slope is a fraction and separates into a different message if so
				String respons = JOP.in("Yes or no, is the slope a fraction?");
				
				if (respons.equalsIgnoreCase("exit"))
				{
					System.exit(0);
				}
				
				//determines the slope of the intercept
				if (respons.equalsIgnoreCase("yes"))
				{
					String respon = JOP.in("What is the numerator of the fraction?\nIf the fraction is negative, add the negative sign here");
					
					if (respon.equalsIgnoreCase("exit"))
					{
						System.exit(0);
					}
					
					int nume = Integer.parseInt(respon);
					
					String respo = JOP.in("What is the denominator of the fraction?");
					
					if (respo.equalsIgnoreCase("exit"))
					{
						System.exit(0);
					}
					
					int deno = Integer.parseInt(respo);
					
					if (nume < 0)
					{
						a.add(-1 * nume);
						b.add(deno);
					}
					else
					{
						a.add(nume);
						b.add(-1 * deno);
					}
					
					m = nume + "/" + deno;
				}
				
				//determines the slope of the line
				if (respons.equalsIgnoreCase("no"))
				{
					String respon = JOP.in("What is the slope of the line?");
					
					if (respon.equalsIgnoreCase("exit"))
					{
						System.exit(0);
					}
					
					if (respon.equalsIgnoreCase("exit"))
					{
						System.exit(0);
					}
					
					if (Integer.parseInt(respon) < 0)
					{
						a.add(-1 * Integer.parseInt(respon));
						b.add(1);
					}
					else
					{
						a.add(Integer.parseInt(respon));
						b.add(-1);
					}
					
					m = Integer.parseInt(respon) + "";
					
				}
			
				//determines the intercept of the line
				String respon = JOP.in("What is the value of the y intercept?\n\nIntegers only, we only run on pretty numbers here\n\nHave a problem? Speak to my advisor\nsmh");
				
				if (respon.equalsIgnoreCase("exit"))
				{
					System.exit(0);
				}
				
				//Sets the line's A, B, and C values to its respective arrayList
				c.add(Integer.parseInt(respon) * b.get(count) * -1);
				b1 = Integer.parseInt(respon);
				System.out.println(a.get(count) + " " + b.get(count) + " " + c.get(count));
				
				JOP.msg("The line you inserted is:\ny = " + m + "x + " + b1 + "\nThe Slope of this line is: " + m + "\nThe value of A, B, and C is: " + a.get(count) + ", " + b.get(count) + ", " + c.get(count));
				
				
				count++;
			}
			
			//Checks if the you entered is on the selected line
			if(response.equalsIgnoreCase("check"))
			{
				
				String respons = JOP.in("What line do you want to check\nType in the number of the line you want to check\nEx if you want to check the first line you entered, you would enter 1\nWant to check the second line you entered 2, etc.");
				if (respons.equalsIgnoreCase("exit"))
				{
					System.exit(0);
				}
				check = Integer.parseInt(respons) - 1;
				String respon = JOP.in("What's the x-value of the point you want to check?");
				if (respon.equalsIgnoreCase("exit"))
				{
					System.exit(0);
				}
				x = Integer.parseInt(respon);
				String respo = JOP.in("Y-value?");
				if (respo.equalsIgnoreCase("exit"))
				{
					System.exit(0);
				}
				y = Integer.parseInt(respo);
				
				if((a.get(check)*x + b.get(check)* y + c.get(check)) == 0)
				{
					JOP.msg("That point is on the line.");
				}
				else if ((a.get(check)*x + b.get(check)* y + c.get(check)) > 0)
				{
					JOP.msg("That point is above the line.");
				}
				else
				{
					JOP.msg("That point is below the line.");
				}
			
			}
			
			//Compares two lines and checks if whether or not they intersect and where they intersect
			if(response.equalsIgnoreCase("compare"))
			{
				String respons = JOP.in("What's the first line do you want to compare\nType in the number of the line you want to check\nEx if you want to check the first line you entered, you would enter 1\nWant to check the second line you entered 2, etc.\n\nps bruhhh yall expect me to remember wtf system of equations is???");
				if (respons.equalsIgnoreCase("exit"))
				{
					System.exit(0);
				}
				compare1 = Integer.parseInt(respons) - 1;
				String respon = JOP.in("Second line?");
				if (respon.equalsIgnoreCase("exit"))
				{
					System.exit(0);
				}
				compare2 = Integer.parseInt(respon) - 1;
				
				if(a.get(compare1) == a.get(compare2) && b.get(compare1) == b.get(compare2))
				{
					JOP.msg("The lines do not intersect, they are parallel/have the same slop or are the same line.");
				}
				
				else
				{
					heehee= getIntersectionPoint(a.get(compare1), b.get(compare1), c.get(compare1), a.get(compare2), b.get(compare2), c.get(compare2));
					JOP.msg("The point of intersections is (" + heehee[0] + "," + heehee[1] + ")");
				}
			}
			
			//Changes the selected line's A, B, or C value
			if(response.equalsIgnoreCase("edit"))
			{
				String respons = JOP.in("What's the line you want to edit\nType in the number of the line you want to check\nEx if you want to check the first line you entered, you would enter 1\nWant to check the second line you entered 2, etc.");
				edit = Integer.parseInt(respons);
				if (respons.equalsIgnoreCase("exit"))
				{
					System.exit(0);
				}
				String respon = JOP.in("What value do you want to change (A, B, or C)");
				if (respon.equalsIgnoreCase("exit"))
				{
					System.exit(0);
				}
				if(respon.equalsIgnoreCase("a"))
				{
					String respo = JOP.in("What do you want to change the value to?");
					a.set(edit-1, Integer.parseInt(respo));
					if (respo.equalsIgnoreCase("exit"))
					{
						System.exit(0);
					}
					JOP.msg("The line has been editted.");
				}
				if(respon.equalsIgnoreCase("b"))
				{
					String respo = JOP.in("What do you want to change the value to?");
					b.set(edit-1, Integer.parseInt(respo));
					if (respo.equalsIgnoreCase("exit"))
					{
						System.exit(0);
					}
					JOP.msg("The line has been editted.");
				}
				if(respon.equalsIgnoreCase("c"))
				{
					String respo = JOP.in("What do you want to change the value to?");
					c.set(edit-1, Integer.parseInt(respo));
					if (respo.equalsIgnoreCase("exit"))
					{
						System.exit(0);
					}
					JOP.msg("The line has been editted.");
				}
			}
		}
	}

	//Method to find where two lines intersect
	public double[] getIntersectionPoint(int a1, int b1, int c1, int a2, int b2, int c2)
    {
        double bb1 = (-1*c1)/((double) b1);
        //THE B VALUE FOR Y=MX + B IN LINE 1
        double bb2 = (-1*c2)/((double)b2);
         //THE B VALUE FOR Y=MX + B IN LINE 2
        double m1 = -(a1 / ((double) b1));
          //THE M VALUE FOR Y=MX + B IN LINE 1
        double m2 = -(a2 / ((double) b2));
         //THE M VALUE FOR Y=MX + B IN LINE 2
        double x = (bb2-bb1)/(m1-m2);
        //X INTERSECTION POINT
        double y = m1*(x) + bb1;
        //Y INTERSECTION POINT
        double [] temp = new double[2];
        temp[0] = x;
        temp[1] = y;
        return temp;
    }
	
}
