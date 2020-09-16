package cn.mjw.hello.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 15 Nov 2019, 2:47 PM
 */
class StreamTest
{
    @Test
    void testForEach()
    {
        List<String> cList = new ArrayList<>();
        cList.add("India");
        cList.add("USA");
        cList.add("Japan");
        cList.add("Canada");
        cList.add("Singapore");

        /*** List Instantiation :: Type #2 ***/
        // List<String> cList = Arrays.asList("India", "USA", "Japan", "Canada", "Singapore");

        System.out.println("<------------Iterating List By Passing Lambda Expression-------------->");
        cList.forEach(cName -> System.out.println(cName));

        System.out.println();

        // You Can Even Replace Lambda Expression With Method Reference. Here We Are Passing The Lambda Parameter As It Is To The Method.
        System.out.println("<------------Iterating List By Passing Method Reference--------------->");
        cList.forEach(System.out::println);

        System.out.println();

        // There Is One More Foreach() Method On Stream Class, Which Operates On Stream And Allows You To Use Various Stream Methods E.g. filter(), mapToInt() Etc.
        System.out.println("<------------Printing Elements Of List By Using 'forEach' Method------------>");
        cList.stream().forEach(System.out::println);

        System.out.println();

        // Using Stream API & Filter.
        System.out.println("<------------Printing Specific Element From List By Using Stream & Filter------------>");
        cList.stream().filter(cname -> cname.startsWith("S")).forEach(System.out::println);

        System.out.println();

        // You Can Also Use 'forEach' With Parallel Stream. In This, The Order Will Not Be Guaranteed.
        System.out.println("<------------Printing Elements Of List By Using Parallel Stream------------>");
        cList.parallelStream().forEach(cName -> System.out.println(cName));
    }
}
