import java.util.Scanner;

class Main 
{ 
    static int winHM;
    static int secHM;
    static int winGDR;
    static int secGDR;
    static int winOTR;
    static int secOTR;

    static class Runner
    { 
        private String name;
        private int time;
        private boolean hm,gdr,otr;
        private Runner next;

        public Runner()
        {
        	this.name = "";
            this.time = 0;
            this.hm = false;
            this.gdr = false;
            this.otr = false;
        	next = null;
        }

        public Runner(String name, int time, boolean hm, boolean gdr, boolean otr)
        {
        	this.name = name;
            this.time = time;
            this.hm = hm;
            this.gdr = gdr;
            this.otr = otr;
        	next = null;
        }
    }; 
  	static Runner head = null;
    static Runner win1 = null;
    static Runner sec1 = null;
    static Runner win2 = null;
    static Runner sec2 = null;
    static Runner win3 = null;
    static Runner sec3 = null;


    static void insert(String name, int time, boolean hm, boolean gdr, boolean otr) 
    {
        Runner  ptr_to_insert = new Runner(name,time,hm,gdr,otr);
        ptr_to_insert.next = head;
        head = ptr_to_insert;
        if(hm==true)
        {
            if(win1==null)
            {
                win1 = ptr_to_insert;
                winHM = time;
            }
            else if(sec1==null && time>winHM)
            {
                sec1 = ptr_to_insert;
                secHM = time;
            }
            else if(time<winHM)
            {
                sec1 = win1;
                secHM = winHM;
                win1 = ptr_to_insert;
                winHM = time;
            }
            else if(time>winHM && time<secHM)
            {
                sec1 = ptr_to_insert;
                secHM = time;
            }
        }
        else if(gdr==true)
        {
            if(win2==null)
            {
                win2 = ptr_to_insert;
                winGDR = time;
            }
            else if(sec2==null && time>winGDR)
            {
                sec2 = ptr_to_insert;
                secGDR = time;
            }
            else if(time<winGDR)
            {
                sec2 = win2;
                secGDR = winGDR;
                win2 = ptr_to_insert;
                winGDR = time;
            }
            else if(time>winGDR && time<secGDR)
            {
                sec2 = ptr_to_insert;
                secGDR = time;
            }
        }
        else if(otr==true)
        {
            if(win3==null)
            {
                win3 = ptr_to_insert;
                winOTR = time;
            }
            else if(sec3==null && time>winOTR)
            {
                sec3 = ptr_to_insert;
                secOTR = time;
            }
            else if(time<winOTR)
            {
                sec3 = win3;
                secOTR = winOTR;
                win3 = ptr_to_insert;
                winOTR = time;
            }
            else if(time>winOTR && time<secOTR)
            {
                sec3 = ptr_to_insert;
                secOTR = time;
            }
        }
    }


    public static void main(String args[]) 
    {
    	    insert("A",12,true,false,false);
            insert("B",111,false,true,false);
    }
}