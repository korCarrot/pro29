package com.myspring.pro29;

import com.myspring.pro29.ex01.MemberVO;
import com.myspring.pro29.ex01.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/test/*")
public class TestController {

    @RequestMapping("/hi")
    String hello(){

        return "hi";
    }
//    @RequestMapping("/member")
//    MemberVO member(){

//        MemberVO vo = new MemberVO();
////        vo.setId("hong");
////        vo.setPwd("1111");
////        vo.setName("홍일동");
////        vo.setEmail("hong1@naver.com");
//
//        return vo;
//    }

    @RequestMapping("/member")
    List<MemberVO> member(){

        ArrayList<MemberVO> list = new ArrayList<>();
        list.add(new MemberVO("hong", "1111", "홍일동", "hong1@naver.com"));

//        Arrays.asList(new MemberVO(""))
        return list;
    }

    @RequestMapping("/score")
    List<Student> score(){

        List<Student> list1 = Arrays.asList(new Student(80,"hong"),
                                        new Student(90,"kim"),
                                        new Student(100,"lee"));
        return list1;
    }

    @RequestMapping("/avg")
    double avg(){

        List<Student> list1 = Arrays.asList(new Student(80,"hong"),
                new Student(90,"kim"),
                new Student(100,"lee"));

        double average=list1.stream().mapToDouble((obj)->{return obj.getScore();}).average().getAsDouble();

        return average;
    }

    @RequestMapping("/map")
    Map<String, String> map(){

        Map<String,String> map = new HashMap<>();
        map.put("1", "이것은 테스트야");
        map.put("2", "이것도 테스트야");

        return map;
    }

    @RequestMapping("/map2")
    Map<String, Student> map2(){

        Map<String,Student> map = new HashMap<>();
        map.put("3", new Student(100,"hong"));
        map.put("4", new Student(90,"lee"));

        return map;
    }


    @RequestMapping("/map3")
    Map<String, List<Student>> map3(){

        List<Student> list1 = Arrays.asList(new Student(80,"hong"),
                new Student(90,"kim"),
                new Student(100,"lee"));

        List<Student> list2 = Arrays.asList(new Student(80,"hong"),
                new Student(30,"yaho"),
                new Student(40,"mang"));

        Map<String, List<Student>> map = new HashMap<>();
        map.put("stu", list1);
        map.put("stu", list2);

        return  (Map<String, List<Student>>) map.get("stu");
    }

}
