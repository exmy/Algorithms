class NewtonIteration{

    
    // X(n+1) = Xn - f(Xn)/f'(Xn)
    // 用切线逼近曲线

    private static final double EPS = 1e-9;

    public double sqrt2(double a){
        double x1 = a;
        double x2 = a / 2;

        // X0 starts from a/2
        while(Math.abs(x1-x2) > EPS){
            x1 = x2;
            x2 = (x1 + a/x1) / 2;
        }
        
        return x1;
    }

    public double sqrt3(double a){
        double x1 = a;
        double x2 = a / 3;

        while(Math.abs(x1-x2) > EPS){
            x1 = x2;
            x2 = (2*x1+a/(x1*x1))/3;
        }

        return x1;
    }
}