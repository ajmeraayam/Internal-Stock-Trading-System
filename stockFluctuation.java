import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

class stockFluctuation
{
    int osx, ria, nibc, vienta, bht, cones;

    public stockFluctuation()
    {
        osx = 250;
        ria = 340;
        nibc = 290;
        vienta = 170;
        bht = 260;
        cones = 470;
    } 

    public void fluctuation()
    {
        int incr1, incr2, incr3, incr4, incr5, incr6;
        
        try{
            while(true)
            {
                incr1 = ThreadLocalRandom.current().nextInt(-10, 10);
                incr2 = ThreadLocalRandom.current().nextInt(-10, 10);
                incr3 = ThreadLocalRandom.current().nextInt(-10, 10);
                incr4 = ThreadLocalRandom.current().nextInt(-10, 10);
                incr5 = ThreadLocalRandom.current().nextInt(-10, 10);
                incr6 = ThreadLocalRandom.current().nextInt(-10, 10);

                osx += incr1;
                ria += incr2;
                nibc += incr3;
                vienta += incr4;
                bht += incr5;
                cones += incr6;

                System.out.println(osx + "\t" + ria + "\t" + nibc + "\t" + vienta + "\t" + bht + "\t" + cones);
                TimeUnit.SECONDS.sleep(5);
            }
        }
        catch(Exception e)
        {
            System.out.println("New exception");
        }
    }

    public static void main(String[] main)
    {
        stockFluctuation sf = new stockFluctuation();
        sf.fluctuation();
    }
}