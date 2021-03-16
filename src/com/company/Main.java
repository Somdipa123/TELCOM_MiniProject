    //import java.io.*;
    package com.company;
    import java.io.BufferedWriter;
	import java.io.FileWriter;
	import java.util.Random;
	public class Main {

	    public static void main(String[] args) throws Exception{
	        Performance p = new Performance();
	        p.simulate(120,120,100, 1000000);
	        //p.simulateComp();
	    }
	}

	class Performance{
	    private int pkt_in_q = 0;
	    private int pkt_dropped = 0;
	    private static int count = 0;
	    public void simulate(int arrive, int departure, int buffer, int times) throws Exception{
	        Random randgenerator = new Random();

	        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

	        for(int i=0; i< times; i++){
	            double y = randgenerator.nextDouble();
	            if(y <= (double) arrive / (arrive+departure)){
	                if(pkt_in_q < buffer)
	                    pkt_in_q++;
	                else
	                    pkt_dropped++;
	            }
	            else {
	                if(pkt_in_q > 0 )
	                    pkt_in_q--;
	            }
	            count++;
	            bw.write(this.count + " " + this.pkt_in_q + " " + this.pkt_dropped + "\r\n");
	        }
	        bw.close();
	    }
	    public void simulateComp() throws Exception{
	        Random randgenerator = new Random();
	        int departure = 120, buffer = 100, times = 1000000;
	        int arrive=0;
	        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
	        for(int i=0; i< times; i++){
	            if(i<100000)
	                arrive = 70;
	            else if(i>=100000 && i<700000)
	                arrive = 200;
	            else if(i>=700000 && i<800000)
	                arrive = 130;
	            else if(i>=800000 && i<900000)
	                arrive = 120;
	            else
	                arrive = 70;

	            double y = randgenerator.nextDouble();
	            if(y <= (double) arrive / (arrive+departure)){
	                if(pkt_in_q < buffer)
	                    pkt_in_q++;
	                else
	                    pkt_dropped++;
	            }
	            else {
	                if(pkt_in_q > 0 )
	                    pkt_in_q--;
	            }
	            count++;
	            bw.write(this.count + " " + this.pkt_in_q + " " + this.pkt_dropped + "\r\n");
	        }
	        bw.close();
	    }
	}

