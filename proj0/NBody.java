

public class NBody {
	public static void main(String[] args)
	{
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String fileName = args[2];
		Body[] bodies = readBodies(fileName);
		double radius = readRadius(fileName);
		int numOfBodies = bodies.length;
		String imageToDraw = "images/startfield.jpg";
		StdDraw.enableDoubleBuffering();

		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 75, imageToDraw);
		StdDraw.picture(-75, -75, imageToDraw);
		StdDraw.picture(75, -75, imageToDraw);





		for (double time = 0; time < T; time += dt){
			double[] xForces = new double[numOfBodies];
			double[] yForces = new double[numOfBodies];
			int idx_force = 0;
			for (Body body: bodies){
				double xNetForce = body.calcNetForceExertedByX(bodies);
				double yNetForce = body.calcNetForceExertedByY(bodies);
				xForces[idx_force] = xNetForce;
				yForces[idx_force] = yNetForce;
				idx_force ++;
			}

			int idx_update = 0;
			for (Body body: bodies){
//				body.draw();
				body.update(dt, xForces[idx_update], yForces[idx_update]);
				idx_update++;
			}
			for (Body body: bodies){
//				body.draw();
				StdDraw.picture(body.xxPos, body.yyPos, "images/"+body.imgFileName);
				StdDraw.show();
			}
			StdDraw.pause(10);
		}

	}

	public static double readRadius (String fileName)
	{

		In in = new In(fileName);
		int num = in.readInt();
		double radius = in.readDouble();
		return radius;

	}

	public static Body[] readBodies(String fileName)
	{
		In in = new In(fileName);
		int numOfPlanets = in.readInt();
		double radius = in.readDouble();
		double xPos;
		double yPos;
		double xVel;
		double yVel;
		double massS;
		String imagefileName;
		Body[] bodyArr = new Body[numOfPlanets];
		for (int i = 0; i < numOfPlanets; i++){
			xPos = in.readDouble();
			yPos = in.readDouble();
			xVel = in.readDouble();
			yVel = in.readDouble();
			massS = in.readDouble();
			imagefileName = in.readString();
			bodyArr[i] = new Body(xPos, yPos, xVel, yVel, massS, imagefileName);
		}
		return bodyArr;
	}





}




