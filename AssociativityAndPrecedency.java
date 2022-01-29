public class AssociativityAndPrecedency {
    public static void main(String[] args) {
        //precedency is basically the priority or order in which expression will be evaluated
        //associativty is from where the evaluation of any expression takes place in java it goes from left to right
        //in  the below calculation / and * has same precedency so it will be evaluated according to the associativity  that is from left to right.
        //operation with higher precedency is evaluated first irrespective of associativity if there is clash between two operators having same precedency then associativity comes in play.
        int a =6*5-34/2;
        System.out.println(a);
        int b =60/5-34*2;
        System.out.println(b);
    }
}
