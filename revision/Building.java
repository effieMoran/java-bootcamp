package Revisions;

public class Building {

    private final int rooms;
    private final int bathrooms;
    private final int kitchens;
    private final int livingrooms;
    private final int diningrooms;
    private final int floors;

    public static class Builder {
        private int rooms;
        private int bathrooms;

        private int kitchens    = 0;
        private int livingrooms = 0;
        private int diningrooms = 0;
        private int floors      = 0;

        public Builder(int rooms, int bathrooms) {
            this.rooms = rooms;
            this.bathrooms = bathrooms;

        }

        public Builder livingrooms(int value) {
            this.livingrooms = value;
            return this;
        }

        public Builder kitchens(int value) {
            this.kitchens = value;
            return this;
        }

        public Builder diningrooms(int value) {
            this.diningrooms = value;
            return this;
        }

        public Builder floors(int value) {
            this.floors = value;
            return this;
        }

        public Building build() {
            return new Building(this);
        }

    }

    private Building(Builder builder) {
        rooms = builder.rooms;
        bathrooms = builder.bathrooms;
        livingrooms = builder.livingrooms;
        kitchens = builder.kitchens;
        diningrooms = builder.diningrooms;
        floors = builder.floors;
    }

    public String toString() {
        return "rooms:" + rooms + " bathrooms:" + bathrooms + " livingrooms:"
                + livingrooms + " kitchens:" + kitchens + " diningrooms:"
                + diningrooms + " Floors:" + floors;
    }

}
