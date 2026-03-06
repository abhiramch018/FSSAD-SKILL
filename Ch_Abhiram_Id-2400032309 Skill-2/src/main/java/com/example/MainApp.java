
package com.example;

public class MainApp {

    public static void main(String[] args){

        ProductCRUD crud = new ProductCRUD();

        Product p1 = new Product("Laptop","Dell Laptop",55000,10);
        Product p2 = new Product("Mouse","Wireless Mouse",800,50);

        crud.insertProduct(p1);
        crud.insertProduct(p2);

        Product result = crud.getProduct(1);
        if(result!=null){
            System.out.println("Product: "+result.getName()+" Price:"+result.getPrice());
        }

        crud.updateProduct(1,53000,12);

        crud.deleteProduct(2);

        System.out.println("CRUD Operations Completed");
    }
}
