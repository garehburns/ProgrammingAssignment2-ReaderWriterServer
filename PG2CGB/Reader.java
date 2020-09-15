/**
 * Reader.java
 *
 * A reader to the database.
 *
 * Author: Garrett Burns
 * CS 350: Fund. of Computer Operating Systems
 * Programming Homework 2
 * Due: 7 November 2019
 */

public class Reader extends Thread
{
   public Reader(int r, Database db)
   {
      readerNum = r;
      server = db;
   }

   public void run()
   {
   int c;

     while (true)
      {
       //System.out.println("reader " + readerNum + " is sleeping.");
       Database.napping();

       System.out.println("reader " + readerNum + " wants to read.");
       c = server.startRead();

       // you have access to read from the database
       System.out.println("reader " + readerNum + " is reading. Reader Count = " + c);
       Database.napping();

       System.out.print("reader " + readerNum + " is done reading. ");

       c = server.endRead();
       //System.out.println("reader " + readerNum + " is done reading. Count = " + c);
      }
   }

   private Database	server;
   private int       readerNum;
}
