package threading;

public class Alphabets {

	public static void main(String[] args) {

		AN an = new AN(false);

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {

					an.alpha();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					an.numbers();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		t1.start();
		t2.start();
	}

}