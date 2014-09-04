package sample;

import static java.awt.Color.BLACK;
import static java.awt.Color.CYAN;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import org.powerbot.script.MessageEvent;
import org.powerbot.script.MessageListener;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.Skills;
import org.powerbot.script.rt6.ClientContext;


@Script.Manifest(name = "Cra cra fisher", description = "Fishes and banks at taverly")
public class CrayFisher extends PollingScript<ClientContext> implements PaintListener, MessageListener {
    private int FishCaught = 0;
        private int startExp = 0;
        private int experienceGained = 0;
        private int Profit = 0;
          int mY = 6;
        int mX = 6;
        boolean mouseMoved;
        
        Image image;
        
        
    private final List<Task> taskList = new ArrayList<Task>();
    
    @Override
    public void start(){
        taskList.addAll(Arrays.asList(new Fish(ctx), new Bank(ctx)));
        startExp = ctx.skills.experience(Skills.FISHING);
     
    }
    
    
    @Override
    public void poll() {
        taskList.stream().filter((task) -> (task.activate())).forEach((task) -> {
            task.execute();
        });
    }
    
    public void mouseMoved(MouseEvent e){
      e.consume();
        
        mX = e.getX()-1;
        mY = e.getY()-1;
        
        mouseMoved = true;
        
        
    
    }
    private String formatTime(final long time) {
        final int sec = (int) (time / 1000), h = sec / 3600, m = sec / 60 % 60, s = sec % 60;
        return (h < 10 ? "0" + h : h) + ":" + (m < 10 ? "0" + m : m) + ":" + (s < 10 ? "0" + s : s);
    }

    
    
private final Font font1 = new Font("Arial", 1, 12);
private final Font font2 = new Font("Arial", 1, 12);
    @Override
    public void repaint(Graphics g) {
        ImageIcon i = new ImageIcon("resource/gui.png");
        image = i.getImage();
           final int sec = (int) (getTotalRuntime() / 1000), h = sec / 3600, m = sec / 60 % 60, s = sec % 60;
        int xpPH = (int) ((experienceGained * 3600000D) / (getTotalRuntime()));
       int x=40,y=100;
                experienceGained = ctx.skills.experience(Skills.FISHING) - startExp;
                
                g.setColor(BLACK);
                
                g.drawRect(x-7, y-32, 202, 152);
                g.drawImage(image, x-5, y-30, 200, 150, null);
               
                
                g.setColor(BLACK);
                g.setFont(font1);
                
                g.setFont(font2);
                g.drawString("CrayFish Caught: " + FishCaught, x, y+30);
                g.drawString("Experience gained: " + experienceGained, x, y+50);
                g.drawString("xp Per hour: " + xpPH, x, y+70);
                g.drawString("Profit: " + Profit, x, y+90);
                g.drawString("Time Ran: "+ formatTime(getTotalRuntime()), x, y+110);
                if(mouseMoved){
                g.setColor(BLACK);
                g.fillOval(mX, mY, 10, 10);
                }
                
                
                
                
    }

    @Override
    public void messaged(MessageEvent e) {
         if (e.text().toLowerCase().contains("you catch a crayfish"))
                        FishCaught++;
         if (e.text().toLowerCase().contains("cray"))
                        Profit += 50;
         if (e.text().toLowerCase().contains("attempt"))
                        Profit -= 35;
         
    }
    
}