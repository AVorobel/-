package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Conteiner conteiner = new Conteiner();

        int choice=0;
        do {
            System.out.println("1.Add Data");
            System.out.println("2.To String");
            System.out.println("3.Clear");
            System.out.println("4.Remove String");
            System.out.println("5.To Array");
            System.out.println("6.Size of Data");
            System.out.println("7.Serialize");
            System.out.println("8.Deserialize");
            System.out.println("9.Compare");
            System.out.println("10.Sort");
            System.out.println("11.Search");
            System.out.println("12.Show all data");
            System.out.println("13.Iterator");
            System.out.println("14.Off\n");

            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    Scanner scan1 = new Scanner(System.in);
                    String temp;
                    do {
                        System.out.println("Write string you want to add:");
                        temp = scan1.nextLine();
                    } while (temp == "");
                    conteiner.add(temp);
                    break;
                case 2:
                    System.out.println(conteiner.toString());
                    break;
                case 3:
                    conteiner.clear();
                    System.out.println("Cleared");
                    break;
                case 4:
                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("Write string you want to remove:");
                    String tmp = scan2.nextLine();
                    conteiner.remove(tmp);
                    break;
                case 5:
                    Object[] array = conteiner.toArray();
                    break;
                case 6:
                    System.out.println("Size : "+conteiner.size());
                    break;
                case 7:
                    Scanner scan3 = new Scanner(System.in);
                    System.out.println("input name of file");
                    String file = scan3.nextLine();
                    if(conteiner.Serialize(file))
                        System.out.println("Check your new file");
                    else
                        System.out.println("Something goes wrong");
                    break;
                case 8:
                    Scanner scan4 = new Scanner(System.in);
                    System.out.println("input name of file");
                    String filename = scan4.nextLine();
                    if (conteiner.Deserialize(filename))
                        System.out.println("deserializing correct");
                    else
                        System.out.println("Something goes wrong");
                    break;
                case 9:
                    Scanner scan5 = new Scanner(System.in);
                    System.out.println("input line index you want to campsre");
                    int a = scan5.nextInt(); int b = scan5.nextInt();
                    if (conteiner.compare(a,b))
                        System.out.println("the same");
                    else
                        System.out.println("different");
                    break;
                case 10:
                    conteiner.sort();
                    System.out.println("sorted");
                    break;
                case 11:
                    Scanner scan6 = new Scanner(System.in);
                    System.out.println("what string do you search?");
                    String search = scan6.nextLine();
                    System.out.println("string founded by index "+conteiner.search(search));
                    break;
                case 12:
                    for(String s: conteiner.lines)
                        System.out.println(s);
                    break;
                case 13:
                    Iterator iter = new Iterator();
                    System.out.println("iteration with while");
                    while(iter.hasNext()){
                        System.out.println(iter.next());
                    }
                    conteiner.pointer = 0;
                    System.out.println("iteration with for each");
                    for (String i: conteiner.lines){
                        if (iter.hasNext()) {
                            String s = iter.next();
                            System.out.println(s);
                        }
                        else
                            break;
                    }
                    break;
                case 14:
                    return;
            }
        } while(choice != 14);
    }
}