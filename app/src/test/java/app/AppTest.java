package app;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

import org.junit.jupiter.api.Test;

import app.Utils.Animal;
import app.Utils.Cat;
import app.Utils.Dog;
import app.Utils.MessageR;
import app.Utils.OceanCreatures;

class AppTest {
    
    // JDK 9
    @Test void collectionsConstructors() {
        var list = List.of("foo", "bar", "baz");
        var set = Set.of("foo", "bar", "baz");
        var map = Map.of("Foo", 1, "Bar", 2, "Baz", 3);

        var mapEntry = Map.entry("foo", 1);
        var map2 = Map.ofEntries(mapEntry);

        System.out.println(list);
    }

    // JDK 10
    @Test void typeInference() {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        var foo = "bar";
        var var = "foo";
    }

    // JDK 12
    @Test void switches() {
        var number = 1;

        // traditional
        String result = "";
        switch (number) {
            case 1:
            case 2:
                result = "one or two";
                break;
            case 3:
                result = "three";
                break;
            case 4:
            case 5:
            case 6:
                result = "four or five or six";
                break;
            default:
                result = "unknown";
        };

        // multiple cases, comma seperated
        switch (number) {
            case 1, 2:
                result = "one or two";
                break;
            case 3:
                result = "three";
                break;
            case 4, 5, 6:
                result = "four or five or six";
                break;
            default:
                result = "unknown";
        };

        // switch as an expression
        result = switch (number) {
            case 1:
            case 2:
                yield "one or two"; 
            case 3:
                yield "three";
            case 4:
            case 5:
            case 6:
                yield "four or five or six";
            default:
                yield "unknown";
        };

        // new syntax
        result = switch (number) {
            case 1, 2 -> "one or two";
            case 3 -> "three";
            case 4, 5, 6 -> "four or five or six";
            default -> "unknown";
        };

        // with enums
        var oceanCreature = OceanCreatures.Spongebob;
        result = switch (oceanCreature) {
            case Spongebob -> "spongebob";
            case Patrick -> "patrick";
            case Squidward -> "squidward";
        };
    }

    // JDK 14
    @Test void patternMatching() {
        var animal = new Animal();

        if (animal instanceof Cat cat) {
            cat.meow();
        } else if (animal instanceof Dog dog) {
            dog.woof();
        }
    }

    @Test void meaningfulNPE() {
        var cats = List.of(new Cat());
        Dog dog = new Dog();
        dog.chase(cats.get(0));
    }

    @Test void records() {
        var msg = new MessageR("MT103", "intoMS", "MSNYUS33", "CITIUS33");
    }

    // JDK 15
    @Test void textBlocks() {
        var str = """
                {
                    "foo": "bar",
                    "baz": "foo"
                }
                """;

        System.out.println(str);

        str = """
                {
                    "foo": "bar",
                    "baz": "%s"
                }
                """.formatted("foo");

        System.out.println(str);
    }

    // JDK 17 - sealed classes and pattern matching with switch (preview)
    @Test void patternMatchingWithSwitch() {
        Object integer = 123;

        String result = switch (integer) {
            case String str -> str;
            case Double dbl -> Double.toString(dbl);
            case Integer inte -> Integer.toString(inte);
            case null -> "0";
            default -> "0";
        };

        System.out.println(result);
    }

    // Noteworthy - https://dev.java/learn/launching-single-file-source-code-programs/ 
}
