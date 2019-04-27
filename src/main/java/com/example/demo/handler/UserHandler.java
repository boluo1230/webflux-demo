package com.example.demo.handler;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * Created by Bolun Liu
 * Date:2019/4/27
 **/
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserHandler{

    private final UserService userService;

    public Mono<ServerResponse> getUserList(ServerRequest serverRequest){
        List<User> userList = userService.getUserList();
        Mono<ServerResponse> response = null;
        Flux<User> userFlux = Flux.fromIterable(userList);
        return ServerResponse.ok().body(userFlux,User.class);
    }

    public Mono<ServerResponse> saveUser(ServerRequest serverRequest){
        Mono<User> userMono = serverRequest.bodyToMono(User.class);
        return ServerResponse.created(UriComponentsBuilder.fromPath("user/save").build().toUri())
                .contentType(APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(
                        userMono.map(x -> new User(x.getId(), x.getUsername()))
                                .flatMap(userService::saveUser), User.class));
    }

}
