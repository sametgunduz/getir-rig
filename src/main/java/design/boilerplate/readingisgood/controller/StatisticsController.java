package design.boilerplate.readingisgood.controller;

import design.boilerplate.readingisgood.model.Order;
import design.boilerplate.readingisgood.model.User;
import design.boilerplate.readingisgood.security.dto.BookRequest;
import design.boilerplate.readingisgood.security.dto.RegistrationRequest;
import design.boilerplate.readingisgood.security.dto.RegistrationResponse;
import design.boilerplate.readingisgood.security.dto.StatisticsResponse;
import design.boilerplate.readingisgood.security.service.StatisticsService;
import design.boilerplate.readingisgood.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    private final UserService userService;


    @GetMapping("/monthly")
    public ResponseEntity<StatisticsResponse> getStatistics(
            @RequestParam(required = false) String username,
            @RequestParam(defaultValue = "0") int month,
            @RequestParam(defaultValue = "0") int year
    ) {
        User user = userService.findByUsername(username);
        StatisticsResponse statisticsResponse = statisticsService.getStatistics(user, month, year);
        return ResponseEntity.status(HttpStatus.OK).body(statisticsResponse);
    }
}



