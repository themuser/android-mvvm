package xyz.themuser.mvvm;

public interface IRepository {

    Item getItem();

    class Item {
        final String first;
        final String second;

        Item(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "Item{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                '}';
        }
    }
}
