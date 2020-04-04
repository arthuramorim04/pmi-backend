package br.com.plugshop.api.utility;

import br.com.plugshop.api.entity.Product;

public class Split {

    public String[] splitProductName(Product product){
       return product.getName().split(" ");
    }

    public String[] splitProductTag(Product product){
        return product.getTags().split(",");
    }
}
