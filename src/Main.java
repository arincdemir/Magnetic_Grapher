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
	
	
	static SpacePoint sp1 = new SpacePoint(0.3, 0.4);
	static SourceWire sw1 = new SourceWire(0.5, 0.5);
	

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

			sp1.addFieldComponent(sw1.fieldOfPoint(sp1));
			sp1.draw();
			System.out.println(sp1.getArrow());
			sp1.resetField();

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
