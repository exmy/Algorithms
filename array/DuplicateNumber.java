public class DuplicateNumber{
    
    public boolean duplicate(int a[],int length,int [] duplication) {
        if(a == null || length == 0) return false;
        for(int i = 0; i < length; i++){
            while(a[i] != i){
                if(a[i] == a[a[i]]){
                    duplication[0] = a[i];
                    return true;
                }
                int t = a[i];
                a[i] = a[t];
                a[t] = t;
            }
        }
        return false;
    }
}