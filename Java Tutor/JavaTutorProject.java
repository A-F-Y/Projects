import java.util.Scanner;
public class JavaTutorProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scannerObj = new Scanner (System.in);
		
		//Provide a menu and options based on Arrays in the Java Tutor Program for the user
		while (true) {
            System.out.println("Menu:");
            System.out.println("1. Java Intro");
            System.out.println("2. Data Types");
            System.out.println("3. Loops");
            System.out.println("4. Arrays Definition");
            System.out.println("5. Array Elements");
            System.out.println("6. Sum of an Array");
            System.out.println("7. Single Dimensional Arrays");
            System.out.println("8. Multi-Dimensional Arrays");
            System.out.println("9. Identifiers, Data Types, & Operators");
            System.out.println("10. If-else statements");
            System.out.println("11. If-else example");
            System.out.println("12. If-else example 2");
            System.out.println("13. Functions/Methods");
            System.out.println("14. Exit");
            
            //The user now inputs a number from the menu to get an output  
            //It then displays the information/examples or the exit option that they chose from the menu provided 
            System.out.print("Enter your option: ");
            int option = scannerObj.nextInt();

            switch (option) {
                case 1:
                	JavaIntro();
                	break;
                case 2:	
                	DataTypes();
                	break;    
                case 3:
                	Loops();
                	break;
                case 4:
                	ArraysDefinition();
                    break;
                case 5:
                    ArrayElements();
                    break;
                case 6:
                    SumOfArrays();
                    break;
                case 7:
                	SingleDimensionalArrays();
                    break;
                case 8:
                	MultiDimensionalArrays();
                    break;
                case 9:
                	IdentDataOps();
                    break;
                case 10:
                	IfElse();
                    break;
                case 11:
                	IfExample();
                    break;
                case 12:
                	IfElseExample();
                    break;
                case 13:
                	FunctionMethods();
                	break;
                case 14:
                    System.out.println("Exiting The Java Tutor Program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please enter a number between 1-14.");
                    
            }
        }
    }
	public static void JavaIntro() {
        System.out.println("Java is a popular programming language, created in 1995.\n"

                + "\n" + "It is owned by Oracle, and more than 3 billion devices run Java.\n" + "\n"
                + "It is used for:\n" + "\n" + "Mobile applications (specially Android apps)\n"
                + "Desktop applications\n" + "Web applications\n" + "Web servers and application servers\n" + "Games\n"
                + "Database connection\n" + "And much, much more!");

    }

    public static void DataTypes() {
        
        Scanner scannerObj = new Scanner(System.in);
        int usrOption = 0;
        System.out.println("Please select an option\n"
                +"\n"
                +"*---------*\n"
                +"1. Definition\n"
                +"2. Operators\n"
                +"*-------------------*");
        usrOption = scannerObj.nextInt();
        
        if (usrOption == 1)
        {
            System.out.println("An identifier is a sequence of characters that consist of letters, digits.\n"
                    +";underscores (_), and dollar signs ($).\n"
                    +"An identifier must start with a letter, an underscore (_), or a dollar sign\n"
                    +"($). It cannot start with a digit.\n"
                    +"An identifier cannot be a reserved word.\n"
                    +"An identifier cannot contain spaces.\n"
                    +"An identifier can be of any length.");
        }
        if (usrOption == 2)
        {
            System.out.println("Operators are very important in Java.\n"
                    +"\n"
                    +"An example of common operators are");
        }
    }

    public static void Loops() {

        Scanner scannerObj = new Scanner(System.in);
        int usrOption = 0;
        System.out.println("Please select an option\n" + "\n" + "*---------*\n" + "1. Definition\n" + "2. Examples\n"
                + "3. Operators\n" + "*-------------------*");
        usrOption = scannerObj.nextInt();

        if (usrOption == 1) {
            System.out
                    .println("Loops are a programming construct that allows us to execute a block of code repeatedly.\n"
                            + "There are various types of loops such as Infinite Loop, Definite Loop, and Indefinite Loop.\n"
                            + "The infinite loop results in your program not being able to stop by itself. That's why you should avoid this loop.\n"
                            + "A definite loop is one in which you, the programmer, are able to identify (count) the number of times that the loop will iterate.\n"
                            + "An indefinite loop in one where you do not know how many times the loop will execute.");
        } else if (usrOption == 2) {
            System.out.println("Let's look at some examples of loops:");

            System.out.println("\nInfinite Loop Example:");

            System.out.println("\nDefinite Loop Example (for loop):");
            definiteLoopExample();

            System.out.println("\nIndefinite Loop Example (while loop):");
            indefiniteLoopExample();
        } else

        if (usrOption == 3) {
            System.out.println(
                    "Operators allow us to control the flow of a loop, change the loop variable, and set the condition for the loop to terminate.\n"
                            + "Common loop operators include increment (i++), decrement (i--), and comparison operators (==, <, >, <=, >=).\n");
        } else {
            System.out.println("Invalid option. Please select a valid option.");
        }
    }

    private static void definiteLoopExample() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration " + i);
        }
    }

    private static void indefiniteLoopExample() {
        int count = 1;
        while (count <= 5) {
            System.out.println("Iteration " + count);
            count++;
        }
    }

    public static void ArraysDefinition() {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("The Definition of Arrays is: ");
        // Print the Definition of Arrays in Java
        System.out.println("Arrays are used to store multiple values in a single variable, instead of declaring separate variables for each value.");
        System.out.println("To declare an array, define the variable type with square brackets");
        System.out.println("An array is also a container object that holds a fixed number of values of a single type.");
        System.out.println("length of an array is established when the array is created. After creation, its length is fixed.");
        System.out.println("Arrays in Java are zero-indexed. meaning the first element is accessed using index 0, the second element with index 1, and the rest is so on"); 
        System.out.println("They provide a convenient way to work with collections of data of the same type in a structured manner.");
    }

    public static void ArrayElements() {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Array Elements: ");
                
        		// Declare & initialize an array of integers
                int[] numbers = {5, 10, 15, 20, 25};

                // Access & print the output of the elements in the array
                System.out.println("Elements of the array:");
                for (int i = 0; i < numbers.length; i++) {
                    System.out.println("Element at index " + i + ": " + numbers[i]);
                }
            }
        

    public static void SumOfArrays() {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Sum of an Array: ");
        
        // Declare & initialize an array of integers
        int[] numbers = {2, 4, 6, 8, 10};

        // Calculate the sum of all integers or elements in the array
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        // Print the output or sum of the elements in the array
        System.out.println("Sum of elements in the array: " + sum);
    }
    
    public static void SingleDimensionalArrays() {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Single Dimensional Arrays: ");  
    // Declare & initialize a 1D array of integers
    int[] numbers = {1, 2, 3, 4, 5};

    // Access & print elements of the 1D array
    System.out.println("Elements of an single-dimensional array:");
    for (int i = 0; i < numbers.length; i++) {
        System.out.println(numbers[i] + " ");
    }
    
    }
    
    public static void MultiDimensionalArrays() {
            Scanner scannerObj = new Scanner(System.in);
            System.out.println("Multi-Dimensional Arrays: ");   
     // Declare & initialize a 2D array of integers
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Access & print elements of the 2D array
        System.out.println("Elements of an multi-dimensional array (2D array):");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println(); 
        }
	}

    public static void IdentDataOps() {
		
		Scanner scannerObj = new Scanner(System.in);
		int usrOption = 0;
		System.out.println("Please select an option\n"
				+ "\n"
				+ "*---------*\n"
				+ "1. Identifiers\n"
				+ "2. Data types\n"
				+ "3. Operators\n"
				+ "*-------------------*");
		usrOption = scannerObj.nextInt();
		
		if (usrOption == 1)
		{
			System.out.println("An identifier is a sequence of characters that consist of letters, digits,\n"
					+ "underscores (_), and dollar signs ($).\n"
					+ "An identifier must start with a letter, an underscore (_), or a dollar sign ($).\n"
					+ "It cannot start with a digit.\n"
					+ "An identifier cannot be a reserved word.\n"
					+ "An identifier cannot contain spaces.\n"
					+ "An identifier can be of any length.\n"
					+ "An Identifier must also be delcared before it can be used.\n"
					+ "Common identifiers are x, y, and z.");
		}
		if (usrOption == 2)
		{
			System.out.println("Data types are divided into two groups:\n"
					+ "\n"
					+ "Primitive data types - includes byte, short, int, long, float, double, boolean and char\n"
					+ "Non-primitive data types - such as String and  Arrays");
		}
		if (usrOption == 3)
		{
			System.out.println("Operators are very important in Java.\n"
					+ "\n"
					+ "An example of common operators are the following.\n"
					+ "\n"
					+ "Plus (+) for addition.\n"
					+ "Equal (=) for assignment.\n"
					+ "Minus (-) for subtraction.\n"
					+ "Asterisk (*) for multiplication\n"
					+ "Forward slash (/) for division\n");
			
			System.out.println("Would you like to see further examples of these operators? Press 1 for yes or 2 for no.");
			usrOption = scannerObj.nextInt();
			
			if (usrOption == 1) {
				System.out.println("The addition operator adds two numbers to add 1 and 5 you would type 1 + 5, or a variable x and a variable y would be x + y.\n"
						+ "\n"
						+ "The equal operator assigns a value to a vairable. For example to assign variable x to 10 you would type int x = 10\n"
						+ "\n"
						+ "The subtraction operator subracts one number for anohter. For example to take 5 away from 10 you wpuld type 10 - 5, the same can be done with variables\n"
						+ "\n"
						+ "The multiplication operator multiplies a number with another. For example to multiply 5 by 5 you would type 5 * 5.\n"
						+ "\n"
						+ "The division operator divides a number with another. For example to divide 10 with 1000 you would type 1000 / 10.\n"
						+ "\n");
			}
			else
			{
				return;
			}
			
			
		}
		
		
		
	}
	
	public static void IfElse() {
		
		Scanner scannerObj = new Scanner(System.in);
		int usrOption = 0;
		System.out.println("Please select an option\n"
				+ "\n"
				+ "*---------*\n"
				+ "1. If Statements\n"
				+ "2. If Else Statements\n"
				+ "*-------------------*");
		usrOption = scannerObj.nextInt();
		
		if (usrOption == 1)
		{
			System.out.println("If statements determine whether or not a line of code will be executed.\n"
					+ "The if statement uses a boolean to decide whether the next statement or block of statements executes\n"
					+ "\n"
					+ "If statemnets also make use of relational operators such as: == to compare, < less than, > greater than, || or, && and, != not equal to, and so on.\n"
					+ "\n"
					+ "An example of a if statement is as follows:\n");
					 IfExample();
		}
		if (usrOption == 2)
		{
			System.out.println("The if-else statement adds the ability to conditionally execute code when the if condition is false.\n"
					+ "\n"
					+ "An example of a if else statement is as follows\n");
					IfElseExample();
		}
		
	}
	
	public static void IfExample() {
		
		int x = 2;
		if (x == 2)
		{
			System.out.println("\tint x = 2;\n"
					+ "	if (x == 2)\n"
					+ "	{\n"
					+ "	System.out.println(\"This is a good example\");\n"
					+ "	}");
		}
	}
	
public static void IfElseExample() {
		
		int x = 50;
		if (x == 2)
		{
			System.out.println("\tint x = 2;\n"
					+ "	if (x == 2)\n"
					+ "	{\n"
					+ "	System.out.println(\"This is a good example as x = 2 so the statement is executed.\");\n"
					+ "	}");
		}
		else
		{
			System.out.println("\tint x = 2;\n"
					+ "	if (x == 2)\n"
					+ "	{\n"
					+ "	System.out.println(\"This is a good example but for a if else statement as the statement is not true so the else statement executes.\");\n"
					+ "	}}\n"
					+ "	else\n"
					+ "	{\n"
					+ "	System.out.println(\"\\tint x = 50;\\n\"\n"
					+ "	+ \"if (x == 2)\\n\"\n"
					+ "	+ \"{\\n\"\n"
					+ "	+ \"System.out.println(\\\"This is a good example but for a if else statement as the statement is not true so the else statement executes.\\\");\\n\"\n"
					+ "	+ \"}\");");
		}
	}
public static void FunctionMethods() {
	
	//Add Intro
	System.out.println("Functions/Methods in Java:");
	
	// Definition
    System.out.println("Functions (or methods) in Java allow you to encapsulate a block of code "
            + "that can be reused by calling the function multiple times.");
    
    Scanner scannerObj = new Scanner(System.in);
    int functionMethod = 0;
    System.out.println("Please choose an example\n"
            +"\n"
            +"*---------*\n"
            +"1. Return the greater of two values\n"
            +"2. Format Number as a Percentage\n"
            +"*-------------------*");
    functionMethod = scannerObj.nextInt();
    
    if (functionMethod == 1)
    {
        System.out.println(" In order to get the greatest of two values"
        		+ " you're going to use the Math.max function./n"
        		+ "In this example we know the variables are 1 and 2./n"
        		+ "Now we indicate the type of variable, in this case 1 and two are integers./n"
        		+ "int max = Math.max(1,2);"
        		+ "Now we print the result"
        		+ "System.out.println(max);"
        		+ "The output is 2 because the greatst of those two numbers is 2.");
        

    }
    if (functionMethod == 2)
    {
        System.out.println("In order to use functions to format a number to a percentage"
        		+ "we are goin to use the NumberFormat.getPercentInstance()/n"
        		+ "This will also add import java.text.NumberFormat; to the top of the code./n"
        		+ "This will help us change a number into a percentage./n"
        		+ "Define your string and add .format.(01) which changes the number"
        		+ " 0.1 into a percentage./n So, 0.1 becomes \"10%\" because it's 10% of a whole./n"
        		+ "Code: String per = NumberFormat.getPercentInstance().format(0.1);"
        		+ "Now let's print it"
        		+ "Code: System.out.println(per)/n"
        		+ "This method will convert all numbers into percentages.");
        
        System.out.println("\nFunctions can have parameters and return values, allowing them to accept inputs "
                + "and produce outputs.");
        	
        	
        		
   
    
    	}
	}

}
