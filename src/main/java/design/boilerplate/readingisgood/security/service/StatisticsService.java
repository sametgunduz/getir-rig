package design.boilerplate.readingisgood.security.service;

import design.boilerplate.readingisgood.model.User;
import design.boilerplate.readingisgood.security.dto.StatisticsResponse;

public interface StatisticsService {

    StatisticsResponse getStatistics(User user, int month, int year);
}
