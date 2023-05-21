package day2;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product getProduct(String name){
        for(Product p : products){
            if(p.getName().equals(name))
                return p;
        }

        return null;
    }

    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
        List<Product> prods = new ArrayList<>();

        for(Product p : products){
            String name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();
            if(name.contains(str) || type.contains(str) || place.contains(str))
                prods.add(p);
        }
        return prods;

    }

    public List<Product> getProductByPlace(String place) {
        String str = place.toLowerCase();
        List<Product> prod = new ArrayList<>();
        for(Product p : products)
        {
            String place1 = p.getPlace().toLowerCase();
            if(place1.contains(str))
            {
                prod.add(p);
            }
                
        }
        return prod;
    }



    public List<Product> getProductsWithOutOfWarranty() {
        int currentyear= Year.now().getValue();
        List<Product> pro = new ArrayList<>();
        for(Product p : products)
        {
            if(p.getWarranty()<currentyear)
            {
                pro.add(p);
            }
                
        }
        return pro;
    }
    

    public List<Product> getProductswithInWarranty() {
        int currentYear = Year.now().getValue();
        return products.stream()
                .filter(p -> p.getWarranty() > currentYear)
                .toList();
    }
}
