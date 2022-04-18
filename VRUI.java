public class VRUI {
	private final VRManager VRManager = new VRManager();

	public static void main(String[] args) {
		VRUI ui = new VRUI() ;

		boolean quit = false ;
		while ( ! quit ) {
			int command = ui.showCommand() ;
			switch ( command ) {
				case 0: quit = true ; break ;
				case 1: ui.listCustomers() ; break ;
				case 2: ui.listVideos() ; break ;
				case 3: ui.register("customer") ; break ;
				case 4: ui.register("video") ; break ;
				case 5: ui.rentVideo() ; break ;
				case 6: ui.returnVideo() ; break ;
				case 7: ui.getCustomerReport() ; break;
				case 8: ui.clearRentals() ; break ;
				case -1: ui.init() ; break ;
				default: break ;
			}
		}
		System.out.println("Bye");
	}

	public void clearRentals() {

		VRManager.clearRentals();
	}

	public void returnVideo() {

		VRManager.returnVideo();
	}

	private void init() {

		VRManager.init();
	}

	public void listVideos() {

		VRManager.listVideos();
	}

	public void listCustomers() {
		VRManager.listCustomers();
	}

	public void getCustomerReport() {

		VRManager.getCustomerReport();
	}

	public void rentVideo() {

		VRManager.rentVideo();
	}

	public void register(String object) {
		VRManager.register(object);
	}

	public int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. List videos");
		System.out.println("\t 3. Register customer");
		System.out.println("\t 4. Register video");
		System.out.println("\t 5. Rent video");
		System.out.println("\t 6. Return video");
		System.out.println("\t 7. Show customer report");
		System.out.println("\t 8. Show customer and clear rentals");

		int command = VRManager.getScanner().nextInt() ;

		return command ;

	}
}
