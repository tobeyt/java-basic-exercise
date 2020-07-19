import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        Scanner sc = new Scanner( System.in );
        System.out.print("请输入第一串字符串：");
        String firstWordList = sc.next();
        System.out.print("请输入第二串字符串：");
        String secondWordList = sc.next();

        List<String> result = findCommonWordsWithSpace(firstWordList, secondWordList);
        //按要求输出到命令行
        result.forEach(System.out::println);
    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        String pattern = ",{2}|[^a-zA-z,]";
        Pattern r = Pattern.compile(pattern);
        Matcher firstMacher = r.matcher(firstWordList);
        Matcher secondMacher = r.matcher(secondWordList);
        if (firstMacher.find() || secondMacher.find()) {
            throw new RuntimeException("input not valid");
        }

        List<String> first = Arrays.asList(firstWordList.toUpperCase().split(","));
        List<String> second = Arrays.asList(secondWordList.toUpperCase().split(","));
        return first.stream().distinct().filter(cur -> second.contains(cur)).map(cur -> cur.replace("", " ").trim()).collect(Collectors.toList());
    }

}
