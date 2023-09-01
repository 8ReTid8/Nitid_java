public class Primenum{
    private int x,prime = -1;
    
    void setX(int x){
        this.x = x;
    }

    void checkP(){
        if(x==1){
            this.x = -1;
        }
        for(int i=2;i<=x;i++){
            if(x%i==0&&x!=i){
                this.x = -1;    
                break;
            }
            else{
                this.x = x;
            }
        }
    }
    
    void Pmax(){
        if(prime<x&&x!=0){
            this.prime = x;
        }
    }

    public int ansP(){
        return prime;
    }


}