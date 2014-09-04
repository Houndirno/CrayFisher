package sample;




import java.util.concurrent.Callable;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Npc;


public class Bank extends Task<ClientContext> {
    private int[] Banker = {14924};
    private int fishId = 13435;
    private int[] FishingSpotIds = {14907};
    

    public Bank(ClientContext ctx) {
        super(ctx);
        }
    
    @Override
    public boolean activate() {
        return !ctx.npcs.select().id(FishingSpotIds).isEmpty()
                && ctx.backpack.select().count() == 28;
        
         
    }
       
    @Override
   
    public void execute() {
        
		{
                        
                        
			ctx.movement.step(new Tile(2898, 3469, 0));
                        ctx.camera.pitch(Random.nextInt(50, 40));
                        ctx.camera.angle(20);
                        try {
    Thread.sleep(3000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
			ctx.movement.step(new Tile(2894, 3460, 0));
                        ctx.camera.pitch(Random.nextInt(30, 110));
                        ctx.camera.angle(90);
                        try {
    Thread.sleep(3000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
			ctx.movement.step(new Tile(2885, 3448, 0));
                        ctx.camera.pitch(Random.nextInt(10, 66));
                        ctx.camera.angle(180);
                        try {
    Thread.sleep(3000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
			ctx.movement.step(new Tile(2883, 3434, 0));
                        ctx.camera.pitch(Random.nextInt(22, 80));
                        ctx.camera.angle(120);
                        try {
    Thread.sleep(3000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
			ctx.movement.step(new Tile(2881, 3421, 0));
                        ctx.camera.pitch(Random.nextInt(80, 180));
                        try {
    Thread.sleep(3000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
			ctx.movement.step(new Tile(2880, 3417, 0));
                        ctx.camera.pitch(Random.nextInt(60, 20));
                        try {
    Thread.sleep(3000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
                        ctx.movement.step(new Tile(2875,3417, 0));
                        ctx.camera.pitch(Random.nextInt(180, 80));
                        
                
                try {
    Thread.sleep(3000);                
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
                     if (ctx.bank.inViewport() && ctx.movement.reachable(ctx.bank.nearest().tile(), ctx.players.local().tile())) {
            if (ctx.bank.open()) {

                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return ctx.bank.opened();
                    }
                }, 500, 5);

                if (ctx.bank.opened()) {
                    ctx.bank. depositInventory();
                    Condition.wait(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return !ctx.bank.opened();
                        }
                    }, 500, 5);
                }
            }
        } else {
            ctx.camera.turnTo(ctx.bank.nearest().tile().derive(1, 10));
            ctx.camera.pitch(Random.nextInt(20, 80));

            if (!ctx.bank.inViewport()) {
                ctx.movement.step(ctx.bank.nearest().tile().derive(1, 5));
                while (ctx.players.local().inMotion()) {
                    

                }
            }

        }
    }
                
                
                 ctx.movement.step(new Tile(2877,3417, 0));
                        ctx.camera.pitch(Random.nextInt(180, 80));
                        
                
                try {
    Thread.sleep(3500);                
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
                
                ctx.movement.step(new Tile(2884, 3434, 0));
                        ctx.camera.pitch(Random.nextInt(180, 80));
                        
                
                try {
    Thread.sleep(3000);                
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
                
                ctx.movement.step(new Tile(2885,3448, 0));
                        ctx.camera.pitch(Random.nextInt(180, 80));
                        
                
                try {
    Thread.sleep(3000);                
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
                
                ctx.movement.step(new Tile(2894, 3460, 0));
                        ctx.camera.pitch(Random.nextInt(180, 80));
                        
                
                try {
    Thread.sleep(3000);                
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
                
                ctx.movement.step(new Tile(2898,3469, 0));
                        ctx.camera.pitch(Random.nextInt(180, 80));
                        
                
                try {
    Thread.sleep(3000);                
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
                
                
                
}
    {
    Condition.sleep();
			}
}
			
		
                        
                
    

        
    





        
        
		

   