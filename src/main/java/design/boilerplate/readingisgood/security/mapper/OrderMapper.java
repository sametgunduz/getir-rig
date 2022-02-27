package design.boilerplate.readingisgood.security.mapper;

import design.boilerplate.readingisgood.model.Book;
import design.boilerplate.readingisgood.model.Order;
import design.boilerplate.readingisgood.security.dto.BookRequest;
import design.boilerplate.readingisgood.security.dto.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

	Order convertToOrder(OrderRequest orderRequest);


}
