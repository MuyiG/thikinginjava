package com.sunshinevvv.thinkinginjava.innerclass;

/**
 * Created by sunshine on 2017/10/12.
 */
public class OuterClass {

    /**
     * 普通非静态InnerClass，支持四种访问控制符
     */
    class InnerClass {

    }
    private class PrivateInnerClass {

    }
    protected class ProtectedInnerClass {

    }
    public class PublicInnerClass {

    }

    /**
     * 加了static的内部类变成了Nested Class，支持四种访问控制符，创建时不依赖外部类实例
     */
    static class NestedClass {

    }
    public static class PublicNestedClass {

    }
    protected static class ProtectedNestedClass {

    }
    private static class PrivateNestedClass {

    }

}

/**
 * 只能是package级别，也可以独立出去，写在这里只是为了组织方便
 */
class AnotherClass {

    /**
     * 这里也支持内部类，同上
     */
    class AnotherInnerClass {

    }
    static class AnotherNestedClass {

    }
}
