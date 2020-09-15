/**
 * ReaderWriterServer.java
 *
 * This class creates the reader and writer threads and
 * the database they will be using to coordinate access.
 *
 * Author: Garrett Burns
 * CS 350: Fund. of Computer Operating Systems
 * Programming Homework 2
 * Due: 7 November 2019
 */

public class ReaderWriterServer
{
   public static void main(String args[])
   {
      Database server = new Database();

      Reader[] readerArray = new Reader[NUM_OF_READERS];
      Writer[] writerArray = new Writer[NUM_OF_WRITERS];

      for (int i = 0; i < NUM_OF_READERS; i++)
      {
         readerArray[i] = new Reader(i, server);
         readerArray[i].start();
      }

      for (int i = 0; i < NUM_OF_WRITERS; i++)
      {
         writerArray[i] = new Writer(i, server);
         writerArray[i].start();
      }
   }

   private static final int NUM_OF_READERS = 9; // creates nine reader threads
   private static final int NUM_OF_WRITERS = 3; // creates three writer threads
}
