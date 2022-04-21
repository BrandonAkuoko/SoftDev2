public class AlienAlphabet implements Comparable<AlienAlphabet>{
   private final int sequenceNumber;
   private final String symbol;
   
   public AlienAlphabet(int sequenceNumber, String symbol){
       this.sequenceNumber = sequenceNumber;
       this.symbol = symbol;
   }
   public int getSequenceNumber(){
       return this.sequenceNumber;
   }
   public String getSymbol(){
       return this.symbol;
   }
   @Override
   public String toString(){
       return sequenceNumber +", " + symbol;
   }
   @Override
   public int compareTo(AlienAlphabet other){
       // this vs other
       //this.sequenceNumber < other.sequenceNumber
       return this.sequenceNumber - other.sequenceNumber;
   }

}
