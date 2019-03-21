package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int choose ;
		String str = new String();
		String strNew = new String();
		String numbers = new String();
		Func doThis = new Func();

    	do {
		System.out.println();
    	System.out.println("<  1. Input data  >");
		System.out.println("<  2. View data   >");
		System.out.println("< 3. Calculations >");
		System.out.println("<    4. Result    >");
		System.out.println("<    5. Finish    >");
		System.out.println("< 6. Tipa DeBug   >");

		do {
			choose = scan.nextInt();
			if (choose > 0 && choose < 6)
				break;
			else {
				System.out.println("-- wrong number, try again --");
			}
		}while (choose < 1 && choose > 5);

		switch (choose) {
			case 1:// ввід даних
				Scanner sc = new Scanner(System.in);
				System.out.println("-- input words --");
				str = sc.nextLine();
				break;
			case 2:// виводить поточні введені дані
				if( str.isEmpty()!=true)
					System.out.println(str);
				else
					System.out.println("-- you didn't input data. go to point (1) --");
				break;
			case 3:// розрахунки
				strNew = doThis.SpaceBar(str);
				numbers = doThis.AlphaberNum(strNew);
				System.out.println("-- calculations were made --");
				break;
			case 4://виводить результат
				if (strNew.isEmpty() != true && numbers.isEmpty() != true) {
					System.out.println(strNew);
					System.out.println(numbers);
				}
				else
					System.out.println("-- please, do a calculations --");
				break;
			case 5:// завершення
				System.out.println("_____THE__END_____");
				return;
			case 6: //показує всі дані
				System.out.println("ProgramData ###");
				if( str.isEmpty()!=true) {
					System.out.println("___input data___");
					System.out.println(str);
				}
				else
					System.out.println("input data is empty");

				if (strNew.isEmpty() != true ) {
					System.out.println("___line with BackSpace method___");
					System.out.println(strNew);
				}
				else
					System.out.println("string with BackSpace method is not ready");

				if ( numbers.isEmpty() != true) {
					System.out.println("___numbers___");
					System.out.println(numbers);
				}
				else
					System.out.println("number line is not ready");
				break;
			}
		}
		while (choose != 5);

		scan.close();
    }
}