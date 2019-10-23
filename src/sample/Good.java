package sample;

public class Good {
    private String id;
    private String model, name;
    private String price;
    private String count;

    Good() {}

    public Good(String id, String name, String model, String price, String count) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.model = model;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
