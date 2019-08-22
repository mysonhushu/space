public class Test {
  public static void main(String args[]) {
    try{
     throw new ExceptionB();
    } catch (ExceptionA e) {
      System.out.println("exceptionA");
    } catch (Exception e) {
      System.out.println("exception");
    }
  }
}
