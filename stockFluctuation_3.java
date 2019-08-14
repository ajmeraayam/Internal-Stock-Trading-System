import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.lang.*;

class stockFluctuation implements Runnable
{
    public String name;
    public int stock;
    //private List stockList = new CopyOnWriteArrayList();
    //static CopyOnWriteArrayList<Thread> stockList = new CopyOnWriteArrayList<Thread>();

    public stockFluctuation(String name, int stock)
    {
        this.name = name;                                                           //name of the stock
        this.stock = stock;                                                         //initial value for each stock
    } 

    /*void addStock(stockFluctuation sf)
    {
        stockList.add(new Thread(sf));
    }*/

    String getName()
    {
        return this.name;
    }

    int getStock()
    {
        return this.stock;
    }

    public void run()
    {
        int incr;
        
        try{
            while(true)
            {
                incr = ThreadLocalRandom.current().nextInt(-10, 10);                //random number generator using threads; generates a number between -10 and 10 randomly
                if(this.stock + incr <= 0)                                          //check if the stock price doesn't go below 1; if it does, reverse the increment value to push it up again
                {
                    incr = -1 * incr;
                    this.stock += incr;                       
                }
                else
                    this.stock += incr;
                
                System.out.println(this.name + " - " + this.stock + "\t");                                //printing to check values
                TimeUnit.SECONDS.sleep(10);

                //System.out.print("\n");
            }
        }
        catch(Exception e)
        {
            System.out.println("New exception");
        }
    }

    
}

class stockFluctuation_3
{
    //static Map<Thread, stockFluctuation> stockList = new HashMap<Thread, stockFluctuation>();
    static CopyOnWriteArrayList<Thread> stockList = new CopyOnWriteArrayList<Thread>();

    void addStock(stockFluctuation sf)
    {
        stockList.add(new Thread(sf));
    }

    public static void main(String[] main)
    {
        stockFluctuation_3 s = new stockFluctuation_3();
        //CopyOnWriteArrayList<Thread> stockList = new CopyOnWriteArrayList<Thread>();
        stockFluctuation sf1 = new stockFluctuation("osx", 250);
        stockFluctuation sf2 = new stockFluctuation("ria", 340);
        stockFluctuation sf3 = new stockFluctuation("nibc", 290);
        stockFluctuation sf4 = new stockFluctuation("vienta", 170);
        stockFluctuation sf5 = new stockFluctuation("bht", 260);
        stockFluctuation sf6 = new stockFluctuation("cones", 470);

        s.addStock(sf1);
        s.addStock(sf2);
        s.addStock(sf3);
        s.addStock(sf4);
        s.addStock(sf5);
        s.addStock(sf6);


        //ScheduledExecutorService execserv = Executors.newScheduledThreadPool(2);
        for(int i = 0; i < stockList.size(); i++)
        {
            stockList.get(i).start();
            System.out.println(stockList.get(i).getName() + " - " + stockList.get(i).getStock() + "\t");
        }
    }
}