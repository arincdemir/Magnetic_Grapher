import java.awt.Color;
import java.util.ArrayList;

public class Main {
	static final int CANVAS_WIDTH = 600;
	static final int CANVAS_HEIGTH = 600;
	static final int FPS = 30;
	static final double MS_PER_FRAME = 1000 / FPS;

	static Color bgColor = Color.black;
	static boolean running = true;
	static double previousTime = 0;
	static double deltaTime = 0;
	
	
	static ArrayList<SpacePoint> spacePoints = new ArrayList<SpacePoint>();
	static int numOfPointsPerAxis = 13;
	static ArrayList<SourceWire> sourceWires = new ArrayList<SourceWire>();
	
	
	

	public static void main(String[] args) {
		initializeStuff();
		mainLoop();
	}

	private static void initializeStuff() {
		StdDraw.setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGTH);
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenColor(Color.white);
		addPointsAndWires();
		InputHandler.initializeHandler(sourceWires);

		previousTime = System.currentTimeMillis();
	}

	private static void mainLoop() {
		while (running) {
			StdDraw.clear(bgColor);

			InputHandler.handleInputs();
			calcuatePointsField();
			drawAll();
			

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
	
	private static void calcuatePointsField() {
		for (SpacePoint spacePoint : spacePoints) {
			spacePoint.resetField();
			for (SourceWire sourceWire : sourceWires) {
				spacePoint.addFieldComponent(sourceWire.fieldOfPoint(spacePoint));
			}
		}
	}
	
	private static void drawAll() {
		for (SpacePoint spacePoint : spacePoints) {
			spacePoint.draw();
		}
		for (SourceWire sourceWire : sourceWires) {
			sourceWire.draw();
		}
	}
	
	private static void addPointsAndWires() {
		double step = 1.0 / numOfPointsPerAxis;
		for (int i = 1; i <= numOfPointsPerAxis; i++) {
			for (int j = 1; j <= numOfPointsPerAxis; j++) {
				spacePoints.add(new SpacePoint(i * step, j * step));
			}
		}
		
		System.out.println(spacePoints);
		
		
		sourceWires.add(new SourceWire(0.5, 0.5));
	}

}
