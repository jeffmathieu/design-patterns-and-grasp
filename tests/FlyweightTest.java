package tests;

import java.util.ArrayList;
import java.util.List;

class Sprite {
    byte[] sprite = new byte[20_000]; // 20KB = 20,000B
}

class ParticleType {
    Sprite sprite;

    public ParticleType(Sprite sprite) {
        this.sprite = sprite;
    }
}

class Particle {
    byte[] coords = new byte[8];     // 8B
    byte[] vector = new byte[16];    // 16B
    byte[] speed = new byte[4];      // 4B
    byte[] color = new byte[4];      // 4B
    ParticleType type;


    void draw(Object canvas) {}
}

public class FlyweightTest {
    List<Particle> particles = new ArrayList<>();

    void addParticle(Particle p) {
        particles.add(p);
    }

    void draw(Object canvas) {
        for (Particle p : particles) {
            p.draw(canvas);
        }
    }
    class Unit {
        void fireAt(Unit target, FlyweightTest game) {
            Particle p = new Particle();
            game.addParticle(p);
        }
    }
    public void simulateParticles(int count, Sprite sprite) {
        for (int i = 0; i < count; i++) {
            ParticleType type = new ParticleType(sprite);
            Particle p = new Particle();
            p.type = type;
            particles.add(p);
        }
    }

    public static class ParticleMemoryDemo {
        public static void main(String[] args) {
            Runtime runtime = Runtime.getRuntime();
            runtime.gc(); // clear memory before measuring

            long before = runtime.totalMemory() - runtime.freeMemory();

            FlyweightTest flyweight = new FlyweightTest();
            Sprite sprite = new Sprite();
            flyweight.simulateParticles(1_000, sprite);

            runtime.gc(); // stabilize memory after allocation
            long after = runtime.totalMemory() - runtime.freeMemory();

            double usedMB = (after - before) / (1024.0 * 1024.0);
            System.out.printf("Memory used by Game.particles: %.2f MB%n", usedMB);
        }
    }
}
