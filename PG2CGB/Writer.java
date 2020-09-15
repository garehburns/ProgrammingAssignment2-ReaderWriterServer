/**
 * Writer.java
 *
 * A writer to the database.
 *
 * Author: Garrett Burns
 * CS 350: Fund. of Computer Operating Systems
 * Programming Homework 2
 * Due: 7 November 2019
 */

public class Writer extends Thread
{
   public Writer(int w, Database db)
   {
      writerNum = w;
      server = db;
   }

   public void run()
   {
     while (true)
      {
       System.out.println("writer " + writerNum + " is sleeping.");
       Database.napping();
       
       System.out.println("writer " + writerNum + " wants to write.");
       server.startWrite();
       
       // you have access to write to the database
       System.out.println("writer " + writerNum + " is writing.");
       Database.napping();

       server.endWrite();
       System.out.println("writer " + writerNum + " is done writing.");
      }
   }
   
   private Database  server;
   private int       writerNum;
}
