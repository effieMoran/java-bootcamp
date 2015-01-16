package Revisions;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Building casita = new Building.Builder(2, 1).kitchens(1).livingrooms(1).diningrooms(1).build();

		System.out.println(casita);

		Building casa = new Building.Builder(3, 1).kitchens(1).floors(1).livingrooms(1).diningrooms(1).build();

		System.out.println(casa);

		Building hotel = new Building.Builder(24, 35).kitchens(2).floors(5).livingrooms(2).diningrooms(2).build();

		System.out.println(hotel);

	}

}
