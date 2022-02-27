package design.boilerplate.readingisgood.security.mapper;

import design.boilerplate.readingisgood.model.Order;
import design.boilerplate.readingisgood.model.Order.OrderBuilder;
import design.boilerplate.readingisgood.model.OrderItem;
import design.boilerplate.readingisgood.security.dto.OrderRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-27T19:41:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order convertToOrder(OrderRequest orderRequest) {
        if ( orderRequest == null ) {
            return null;
        }

        OrderBuilder order = Order.builder();

        order.createdDate( orderRequest.getCreatedDate() );
        order.totalPrice( orderRequest.getTotalPrice() );
        List<OrderItem> list = orderRequest.getOrderItems();
        if ( list != null ) {
            order.orderItems( new ArrayList<OrderItem>( list ) );
        }
        order.user( orderRequest.getUser() );

        return order.build();
    }
}
