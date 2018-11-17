class Primes {
    // Count the number of prime numbers less than a non-negative number, n.
    public int countPrimes1(int n) {
        boolean[] primes = new boolean[n];
        for(int i = 2; i < n; i++){
            primes[i] = true;
        }
        for(int i = 2; i * i < n; i++){
            for(int j = i * i; j < n; j += i) primes[j] = false;
        }
        int ans = 0;
        for(int i = 2; i < n; i++) if(primes[i]) ans++;
        return ans;
    }
    // more efficient
    public int countPrimes2(int n) {
        if(n <= 2) return 0;
        boolean[] primes = new boolean[n];
        int ans = 1;
        for(int i = 3; i < n; i += 2){
            if(!primes[i]){
                ans++;
                for(int j = 3; i * j < n; j += 2) primes[i*j] = true;
            }
        }
        return ans;
    }
}