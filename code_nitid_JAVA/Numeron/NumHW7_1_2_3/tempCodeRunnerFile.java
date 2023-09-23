    //CONJUGATE
    void R(){
        for(int i=0;i<size;i++){
            double sum=0;
            for(int j=0;j<size;j++){
                sum += mat[i][j]*x[j];
            }
            r[i] = sum - y[i];
        }
    }

    void D0(){
        for(int i=0;i<size;i++){
            d[i] = r[i]*-1;
        }
    }

    double A(){
        double sumtop = 0;
        double sumbutt = 0;
        double[] temp = new double[size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                temp[i] += mat[i][j]*d[j];
            }
            sumbutt += temp[i]*d[i];
            sumtop += temp[i]*r[i];
        }
        return sumtop/sumbutt;
    }

    void D(){
        double temp = A();
        for(int i=0;i<size;i++){
            d[i] = (temp*d[i])-r[i];
        }
    }

    double ramda(){
        double sumtop = 0;
        double sumbutt = 0;
        double[] temp = new double[size];
        for(int i=0;i<size;i++){
            sumtop += d[i]*r[i];
            for(int j=0;j<size;j++){
                temp[i] += mat[i][j]*d[j];
            }
            sumbutt += temp[i]*d[i]; 
        }
        return (sumtop/sumbutt)*-1;
    }

    void X(){
        double temp = ramda();
        for(int i=0;i<size;i++){
            x[i] = x[i]+temp*d[i];
        }
    }
    boolean conjuCheck(){
        double sum=0;
        for(int i=0;i<size;i++){
            sum += r[i]*r[i];
        }
        if(Math.sqrt(sum)<0.01){
            return false;
        }
        else{
            return true;
        }
    }