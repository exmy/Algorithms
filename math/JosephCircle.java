public class JosephCircle{

    public int josephCircle(int n, int m){
        if(n < 1 || m < 1) return -1;
        int[] a = new int[n];
        int p = -1, count = n, k = 0;
        while (count > 0){
            if(++p == n) p = 0;
            if(a[p] == -1) continue;
            if(++k == m){
                a[p] = -1;
                k = 0;
                count--;
            }
        }
        return p;
    }

    public int josephCircle2(int n, int m){
        if(n < 1 || m < 1) return -1;
        int ans = 0;
        for(int i = 2; i <= n; i++){
            ans = (ans + m) % i;
        }
        return ans;
    }

    struct node {
        int a, b;
    };
    node a[10001];
    int main() {
        int n, s, m, p;
        scanf("%d%d%d", &n, &s, &m);
        for(int i = 1; i <= n; i++) {
            a[i].a = i - 1;
            a[i].b = i + 1; 
        }
        a[1].a = n; 
        a[n].b = 1;
        p = s;
        while(n) {
            for(int i = 1; i < m; i++) p = a[p].b;
            cout << p << endl;
            a[a[p].b].a = a[p].a;
            a[a[p].a].b = a[p].b;
            p = a[p].b;
            n--;
        }
        return 0;
    }

}