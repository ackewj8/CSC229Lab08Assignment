/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.singlelinkedlist;
import java.util.Scanner;

/**
 *
 * @author willi
 */
public class Week08Lab extends LinkedList {
    public static void findPrime(LinkedList pList, int n) {
        for(int i = 1; i < n; i++) {
            Node temp = new Node(i);
            if(i == 1 || i == 2) { // 1 and 2 are prime numbers
                pList.append(temp); // adding the number to the list
            }
            else if(i % 2 != 0) { // all even numbers are not prime
                int j = 2;
                while(i % j != 0) {
                    j = j + 1;
                    if(i % j == 0 && j != i)
                        break;
                    else if(i % j == 0 && j == i) {
                        pList.append(temp); // adding the number to the list
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        LinkedList primeList = new LinkedList(); // list of prime numbers
        LinkedList tripleList = new LinkedList(); // list of prime numbers with a digit of 3
        int n;
        int trio = 0;
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter a value for n: ");
        n = scnr.nextInt();
        if(n < 1 || n > 999999) {
            while(n< 1 || n > 999999) {
                System.out.println("Please enter a value for n: ");
                n = scnr.nextInt();
            }
        }
        findPrime(primeList, n); // adds prime numbers to primeList
        System.out.println("Contents of primeList: ");
        Scroll(primeList);
        appendThree(primeList, tripleList); // append the numbers in primeList with a digit of 3 to tripleList
        System.out.println("Contents of tripleList: ");
        Scroll(tripleList); // show the numbers in tripleList
        trio = threeList(tripleList);
        System.out.println("Sum of the contents of tripleList: " + trio); // output the sum of the numbers in tripleList
    }
}
/*
Process:

1. First, the user inputs a number
- If the number is less than 1 or greater than 999999, the user
is told to input a number between 1 and 999999 until they do so.

2. Then, the findPrime function locates prime numbers between 1 and n.
Those numbers are added to primeList.

3. The appendThree function appends numbers in primeList with a digit of 3 to
tripleList. For some reason, after the last prime number with a digit of three, numbers
are added regularly to tripleList even if they do not contain a digit of three.
The tail is still the last prime number with a digit of 3.

4. To remedy the tail problem, I implemented a trim function. The trim function
has two integers: oldSize and newSize. oldSize is the amount of nodes in the list,
while newSize is the amount of nodes in the list until the tail. Another integer,
trim, is calculated by subtracting newSize from oldSize. The trim variable is
returned, and the array has elements removed after the tail trim times.

5. A trio variable calculates the sum of tripleList using the threeList function,
which adds the nodes in tripleList.

6. Finally, the sum is outputted.
*/