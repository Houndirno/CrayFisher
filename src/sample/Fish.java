package sample;

import org.powerbot.script.Random;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Npc;

public class Fish extends Task<ClientContext> {
    private int[] FishingSpotIds = {14907};
     java.util.Random random = new java.util.Random();
   int RN = random.nextInt(360) + 1;
    
    public Fish(ClientContext ctx) {
        super(ctx);
    }
    
    @Override
    public boolean activate() {
        return !ctx.npcs.select().id(FishingSpotIds).isEmpty()
                && ctx.backpack.select().count()< 28
                && ctx.players.local().animation() == -1;
        
    }
    
    @Override
    public void execute(){
        Npc FishingSpot = ctx.npcs.nearest().poll();
        ctx.camera.pitch(Random.nextInt(RN, RN));
            ctx.camera.angle(RN);
        if (FishingSpot.inViewport()) {
            ctx.camera.pitch(Random.nextInt(RN, RN));
            ctx.camera.angle(RN);
            boolean interact = FishingSpot.interact("Cage");
            ctx.camera.pitch(Random.nextInt(RN, RN));
            ctx.camera.angle(RN);
           
        } else {
            ctx.movement.step(FishingSpot);
            ctx.camera.turnTo(FishingSpot);
            ctx.camera.pitch(Random.nextInt(80, 10));
        }
        
    }
}