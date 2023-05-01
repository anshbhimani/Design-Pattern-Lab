// Mvc Pattern Demo
class ProductModel
{
    int id;
    String name;
    int price;

    public ProductModel(int i,String n, int p)
    {
        id=i;
        name=n;
        price=p;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public void setName(String n)
    {
        name=n;
    }

    public void setPrice(int p)
    {
        price=p;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getPrice()
    {
        return price;
    }
}

class ProductView
{
    ProductModel pm;

    public ProductView(ProductModel pm)
    {
        this.pm = pm;
    }

    public void printProductDetails()
    {
        System.out.println("Product Details\n" + pm.getId() + "," + pm.getName() + "," + pm.getPrice());
    }
}

class ProductController
{
    ProductModel pm = new ProductModel(10,"sd",10);
    ProductView pv = new ProductView(pm);

    public void setProductDetails(int i, String n, int p)
    {
        pm.setId(i);
        pm.setName(n);
        pm.setPrice(p);
    }

    public void updateView()
    {
        pv.printProductDetails();
    }
}

class MvcPatternDemo
{
    public static void main(String[] args)
    {
        ProductController pc = new ProductController();
        pc.setProductDetails(1,"Laptop",50000);
        pc.setProductDetails(2, "Wireless Modem", 1500);
        pc.updateView();
    }
}