import java.lang.Math;


public class Body{

	public double xxPos;

	public double yyPos;

	public double xxVel;

	public double yyVel;

	public double mass;

	public String imgFileName;

	public Body(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b)
	{

		double dist;
		double xValue = this.xxPos-b.xxPos;
		double yValue = this.yyPos - b.yyPos;

		dist = Math.sqrt(Math.pow(xValue, 2) + Math.pow(yValue, 2));

		return dist;
	}

	public double calcForceExertedBy(Body b)
	{
		double F;
		double R;
		double FZero = 0.0000;
		double G = 6.67 * Math.pow(10, -11);

		R = this.calcDistance(b);
		if (R == 0){
			if (this.equals(b)){
				return FZero;
			}
		}

		F = G * this.mass * b.mass / Math.pow(R, 2);

		return F;

	}

	public double calcForceExertedByX(Body b)
	{
		double xF;
		double R = this.calcDistance(b);
		double F = this.calcForceExertedBy(b);
		xF = F * (b.xxPos - this.xxPos)/R;
		return xF;
	}

	public double calcForceExertedByY(Body b)
	{
		double yF;
		double R = this.calcDistance(b);
		double F = this.calcForceExertedBy(b);

		yF = F * (b.yyPos - this.yyPos)/R;
		return yF;

	}

	public double calcNetForceExertedByX(Body[] bodyArr)
	{
		double xF;
		double netF_x = 0.0000;
		for (Body b: bodyArr){
			if (this.equals(b)){
				continue;
			}
			netF_x += this.calcForceExertedByX(b);
		}
		return netF_x;

	}

	public double calcNetForceExertedByY(Body[] bodyArr)
	{
		double yF;
		double netF_y = 0.0000;
		for (Body b: bodyArr){
			if (this.equals(b)){
				continue;
			}
			netF_y += this.calcForceExertedByY(b);
		}
		return netF_y;

	}

	public void update(double t, double xF, double yF)
	{
		double xA = xF / this.mass;
		double yA = yF / this.mass;
		this.xxVel += xA * t;
		this.yyVel += yA * t;
		this.xxPos += this.xxVel * t;
		this.yyPos += this.yyVel * t;

	}

	public void draw()
	{

		StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);
		StdDraw.show();

	}


}








