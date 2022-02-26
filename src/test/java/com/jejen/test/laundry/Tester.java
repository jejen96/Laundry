package com.jejen.test.laundry;
//
//import com.jbase.jremote.JDynArray;
//import com.jbase.jremote.JRemoteException;
//import org.apache.logging.log4j.Level;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.xml.sax.SAXException;
//
//import javax.xml.parsers.ParserConfigurationException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootApplication
//public class Tester implements CommandLineRunner {
//
//    public static List<String> getList(int start, int end, JDynArray rows) {
//        List<String> result = new ArrayList<>();
//        for (int i = start; start <= end; i++) {
//            result.add(rows.get(i));
//        }
//        return result;
//    }
//
//    public static void main(String[] args) throws JRemoteException, IOException, ParserConfigurationException, SAXException {
//        SpringApplication.run(Tester.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
////        System.out.println("asdgf");
//        Logger logger = LogManager.getLogger("OFS");
//        logger.log(Level.forName("REQUEST", 10), "Tests");
//    }
//}
