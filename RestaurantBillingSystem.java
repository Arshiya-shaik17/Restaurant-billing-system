class FoodItem{
    private int itemId;
    private String itemName;
    protected double unitPrice;
    protected double quantity;
    protected double discount;
    protected double gst;
    public void bill(int id,String name,double price,double quant){
        itemId=id;
        itemName=name;
        unitPrice=price;
        quantity=quant;
    }
    public int getId(){
        return itemId;
    }
    public String getName(){
        return itemName;
    }
    public double getUnitPrice(){
        return unitPrice;
    }
    public double getQuantity(){
        return quantity;
    }
    public double calculateBill(){
        return (getUnitPrice()*getQuantity())-discount+gst;
    } 
    public void display(){
        System.out.println("ItemId      : "+getId());
        System.out.println("Item name   : "+getName());
        System.out.println("unit price  : "+getUnitPrice());
        System.out.println("Quantity    : "+getQuantity());
        System.out.println("GST         : "+gst);
        System.out.println("Discount    : "+discount);
        System.out.println("Total bill  : "+calculateBill());
    }
}

class DineIn extends FoodItem{
    public int service_charges=50;
    @Override
    public double calculateBill(){
        
        double total=(unitPrice*quantity)+service_charges;
        gst=0.05*total;
        total+=gst;
        if (total>=1000){
            discount=0.10*total;
            total-=discount;
        }
        return total;
    }
    @Override
    public void display(){
        double total=calculateBill();
        System.out.println("        FOOD ITEM RECORD");
        System.out.println("ItemId          : "+getId());
        System.out.println("Item name       : "+getName());
        System.out.println("unit price      : "+getUnitPrice());
        System.out.println("Quantity        : "+getQuantity());
        System.out.println("GST             : "+gst);
        System.out.println("Service charges : "+service_charges);
        System.out.println("Discount        : "+discount);
        System.out.println("Total bill      : "+total+"\n");
    }
    

}
 
class TakeAway extends FoodItem{
    private int packing_charges=20;
    @Override
    public double calculateBill(){
        double total=(unitPrice*quantity)+packing_charges;
        gst=0.05*total;
        total+=gst;
        if(total>=1000){
            discount=0.10*total;
            total-=discount;
        }
        return total;
    }
    @Override
    public void display(){
        double total=calculateBill();
        System.out.println("        FOOD ITEM RECORD");
        System.out.println("ItemId          : "+getId());
        System.out.println("Item name       : "+getName());
        System.out.println("unit price      : "+getUnitPrice());
        System.out.println("Quantity        : "+getQuantity());
        System.out.println("GST             : "+gst);
        System.out.println("Packing charges : "+packing_charges);
        System.out.println("Discount        : "+discount);
        System.out.println("Total bill      : "+total+"\n");
    }
}

class Delivery extends FoodItem {
    public int deliveryFee=40;
    @Override
    public double calculateBill(){
        double total=(unitPrice*quantity)+deliveryFee;
        gst=0.05*total;
        total+=gst;
        if(total>=1000){
            discount=0.10*total;
            total-=discount;
        }
        return total;
    }
    @Override
    public void display(){
        double total=calculateBill();
        System.out.println("        FOOD ITEM RECORD");
        System.out.println("ItemId          : "+getId());
        System.out.println("Item name       : "+getName());
        System.out.println("unit price      : "+getUnitPrice());
        System.out.println("Quantity        : "+getQuantity());
        System.out.println("GST             : "+gst);
        System.out.println("Delivery charges: "+deliveryFee);
        System.out.println("Discount        : "+discount);
        System.out.println("Total bill      : "+total+"\n");
    }
}


public class RestaurantBillingSystem {
    public static void main(String[] args) {
        FoodItem fi=new FoodItem();
        
        fi=new DineIn();
        fi.bill(12, "DOSA", 10, 100);
        fi.display();

        fi=new TakeAway();
        fi.bill(01, "IDLY", 5, 6);
        fi.display();

        fi=new Delivery();
        fi.bill(02, "POORI", 20, 5);
        fi.display();
    }
}
