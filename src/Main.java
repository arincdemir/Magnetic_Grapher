import java.awt.Color;

public class Main {
	static final int CANVAS_WIDTH = 512;
	static final int CANVAS_HEIGTH = 512;
	static final int FPS = 30;
	static final double MS_PER_FRAME = 1000 / FPS;

	static Color bgColor = Color.black;
	static boolean running = true;
	static double previousTime = 0;
	static double deltaTime = 0;
	static Arrow arrow1 = new Arrow();

	public static void main(String[] args) {
		StdDraw.setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGTH);
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenColor(Color.white);
		initializeStuff();
		mainLoop();
	}

	private static void initializeStuff() {

		previousTime = System.currentTimeMillis();
	}

	private static void mainLoop() {
		while (running) {
			StdDraw.clear(bgColor);

			System.out.println("1");
			arrow1.draw();

			StdDraw.show();
			waitForNextFrame();
		}
	}

	private static void waitForNextFrame() {
		do {
			deltaTime += System.currentTimeMillis() - previousTime;
			previousTime = System.currentTimeMillis();
			StdDraw.pause(1);
		} while (deltaTime <= MS_PER_FRAME);

		deltaTime -= MS_PER_FRAME;
	}

}
