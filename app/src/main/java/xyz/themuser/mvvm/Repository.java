package xyz.themuser.mvvm;

public class Repository implements IRepository {

    private Item item = new Item(null, null);

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Repository{" +
            "item=" + item +
            '}';
    }
}
