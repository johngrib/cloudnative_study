package com.reservation.controller;

import com.reservation.common.DBConnectionInfo;
import com.reservation.domain.Reservation;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class TestController {

    @Autowired
    private DBConnectionInfo dbinfo;

    public TestController() {
    }

    @RequestMapping("/find-by-name/{name}")
    public Object test(@PathVariable final String name) {

        try (Connection conn = DriverManager.getConnection(dbinfo.getUrl(), dbinfo.getUsername(), dbinfo.getPassword())) {
            System.out.println("connected!");

            final DSLContext dsl = DSL.using(conn, SQLDialect.MYSQL);
            final com.reservation.jooq.tables.Reservation r = com.reservation.jooq.tables.Reservation.RESERVATION;
            final List<Reservation> result = dsl
                    .select()
                    .from(r)
                    .where(r.NAME.eq(name))
                    .fetchInto(Reservation.class);

            conn.close();

            result.stream().forEach(System.out::println);

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
