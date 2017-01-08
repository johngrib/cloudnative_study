package com.reservation;

import com.reservation.jooq.tables.Reservation;
import com.reservation.repository.ReservationRepository;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;

@SpringBootApplication
public class ReservationApplication {

    @Bean
    CommandLineRunner runner(ReservationRepository rr) {
        return args -> {

            rr.deleteAll();

            //Arrays.asList("Dr. Rod,Dr. Syer,Juergen,Spencer,Phillip,ALL THE COMMUNITY,Josh".split(","))
                    //.forEach(x -> rr.save(new Reservation(x)));

            rr.findAll().forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ReservationApplication.class, args);

        String userName = "이름";
        String password = "패스워드";
        String url = "jdbc:mysql://접속주소:3306/study";

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            System.out.println("connected!");

            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            Result<Record> result = create.select().from(Reservation.RESERVATION).fetch();

            // 자동생성된 쿼리를 확인해 보자.
            String sql = create.select().from(Reservation.RESERVATION).getSQL();
            System.out.println(sql);

            // 쿼리 실행 결과를 확인해 보자.
            System.out.println("??????????");
            result.stream().forEach(System.out::println);
            System.out.println("!!!!!!!!!!");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

