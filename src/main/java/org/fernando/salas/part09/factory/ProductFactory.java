package org.fernando.salas.part09.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ProductFactory {
    final static private Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Product obtainProduct(String name) {
        return switch (name) {
            case "loan" -> new Loan();
            case "stock" -> new Stock();
            case "bond" -> new Bond();
            default -> throw new RuntimeException("No such product " + name);
        };
    }

    public static Product createProductLambda(String name) {
        Supplier<Product> p = map.get(name);
        if (p != null) {
            return p.get();
        }
        throw new RuntimeException("No such product " + name);
    }

    public static Product createProduct(String name) {
        Supplier<Product> p = map.get(name);
        if (p != null) {
            return p.get();
        }
        throw new RuntimeException("No such product " + name);
    }

    public static void main(String[] args) {
        Product product = ProductFactory.createProduct("loan");

    }

}
