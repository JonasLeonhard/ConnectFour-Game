package viergewinnt;

public class Main
{

    public static void main(String[] args)
    {

     
        // Configuration config1=Configuration.startConfiguration();
        // GameFrame frame1=new GameFrame();
        // frame1.setLocation(200, 100);
        // frame1.pnl1.setColor(0);
        // frame1.pnl1.setConfiguration(config1);
        //
        // // GameFrame frame2=new GameFrame();
        // // frame2.setLocation(frame1.getX()+430, frame1.getY());
        // // frame2.pnl1.setColor(1);
        // // frame2.pnl1.setConfiguration(config1);
        // // ^^^für spieler 2
        //
        // Player player=new SimplePlayer();
        // player.setColor(1);
        // player.setConfiguration(config1);

        Configuration config=new Configuration();
        GameFrame frame1=new GameFrame();
        frame1.setLocation(200, 100);

//         GameFrame frame2=new GameFrame();
//         frame2.setLocation(frame1.getX()+430, frame1.getY());
//         frame2.pnl1.setColor(1);
//         frame2.pnl1.setConfiguration(config);

        Player computer=new SuperPlayer();
        frame1.pnl1.setColor(0);
        frame1.pnl1.setConfiguration(config);

        computer.setColor(1);
        computer.setConfiguration(config);
        config.reset();
        
        //zwei computer gegeneinander:
//        Configuration config=new Configuration();
//        GameFrame f1=new GameFrame();
//        //GameFrame f2=new GameFrame();
//        Player f2=new SimplePlayer();
//        Player f3=new SimplePlayer();
//        //f1.pnl1.setColor(0);
//        f1.pnl1.setConfiguration(config);
//        f2.setColor(0);
//        f2.setConfiguration(config);
//        f3.setColor(1);
//        f3.setConfiguration(config);
//        config.reset();

    }

}
