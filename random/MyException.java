//user defined error handling
public class MyException extends Exception{
    MyException ()
    {}
    MyException(String msg)
    {
        super(msg);
    }
}

class Main
{
    public static void main(String[] args) {
    int a=1,b=0;
    try{
        if(b==0)
        {
            throw new MyException("Division by zero not possible");
        }
    }
    catch(MyException e){
        System.out.println("Error occured: "+e);
    }
    finally{
        System.out.println(a);
    }
}
}