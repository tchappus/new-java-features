package app;

public class Utils {
    static enum OceanCreatures {
        Spongebob, Patrick, Squidward;
    }
    
    static sealed class Animal permits Dog, Cat {
    }

    static final class Dog extends Animal {

        public void woof() {
            System.out.println("woof");
        }

        public void chase(Cat cat) {
            System.out.println("Dog chasing cat!");
        }
    }

    static final class Cat extends Animal {
        public void meow() {
            System.out.println("meow");
        }
    }

    static class Message {
        private final String type;
        private final String dir;
        private final String intParty;
        private final String extParty;
        
        public Message(String type, String dir, String intParty, String extParty) {
            this.type = type;
            this.dir = dir;
            this.intParty = intParty;
            this.extParty = extParty;
        }

        public String getType() {
            return type;
        }

        public String getDir() {
            return dir;
        }

        public String getIntParty() {
            return intParty;
        }

        public String getExtParty() {
            return extParty;
        }
        
    }

    static record MessageR(String type, String dir, String intParty, String extParty) {}
}
