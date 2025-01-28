public class Main {
    public static void main(String[] args) {


        assert BinaryExponenation.binaryExponentiation(2, 5) == 32:"BinaryExponentiationFailed";
        assert BinaryExponenation.modularExponentiation(2, 5, 1000000007) == 32:"ModularExponentiationFailed";
       assert Algebra.extendedEuclideanGcd(80, 55).equals(new Algebra.Pair(-2, 3)) :"ExtendedEucledianFailed";
    }



}