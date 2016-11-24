package com.parvin.interviewprep;
public class ExtendingExample
{
   public static void main(String args[])
   {
	  DemoThread demoThread = new DemoThread();
      try
      {
         while(demoThread.isAlive())
         {
           System.out.println("Main thread will be alive till the child thread is live");
           Thread.sleep(1500);
         }
      }
      catch(InterruptedException e)
      {
        System.out.println("Main thread interrupted");
      }
      System.out.println("Main thread's run is over" );
   }
}