package com.zhangchao.classLoader;

public class Main
{
    public static void main (String [] args) throws Exception
    {
        for (int repeat = 0; repeat < 3; ++ repeat)
        {
//            try
//            {
                // "Real" name for X is outer class name+$+nested class name:
                Class.forName ("com.zhangchao.classLoader.Main$X");
//            }
//            catch (Throwable t)
//            {
//                System.out.println ("load attempt #" + repeat + ":");
//                t.printStackTrace (System.out);
//            }
        }
        System.out.println ("end");
    }
    private static class X
    {
        static
        {
            if (++ s_count == 1)
//                throw new RuntimeException ("failing static initializer...");
            { int a = 1/0; }
        }
        
    } // End of nested class
    private static int s_count;
} // End of class