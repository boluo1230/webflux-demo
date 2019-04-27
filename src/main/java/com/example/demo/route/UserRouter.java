package com.example.demo.route;

import com.example.demo.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Created by Bolun Liu
 * Date:2019/4/27
 **/
@Configuration
public class UserRouter {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> userRouter(UserHandler userHandler){

        return RouterFunctions.route(
                RequestPredicates.GET("/user/list"), userHandler::getUserList);

    }


}
