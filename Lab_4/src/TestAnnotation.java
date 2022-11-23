public class TestAnnotation
{
    @CallCountParam(CallCount = 2)
    public static void FirstPublic ()
    {
        System.out.println("FirstPublic");
    }
    public static void SecondPublic ()
    {
        System.out.println("SecondPublic");
    }

    protected static void FirstProtected ()
    {
        System.out.println("FirstProtected");
    }
    @CallCountParam(CallCount = 4)
    protected static void SecondProtected ()
    {
        System.out.println("SecondProtected");
    }

    @CallCountParam(CallCount = 3)
    private static void FirstPrivate ()
    {
        System.out.println("FirstPrivate");
    }
    private static void SecondPrivate ()
    {
        System.out.println("SecondPrivate");
    }
}
