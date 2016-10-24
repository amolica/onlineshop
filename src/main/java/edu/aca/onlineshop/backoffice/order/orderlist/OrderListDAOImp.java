package edu.aca.onlineshop.backoffice.order.orderlist;

import edu.aca.onlineshop.backoffice.order.Order;
import edu.aca.onlineshop.backoffice.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 */
@Repository
public class OrderListDAOImp implements OrderListDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public JdbcTemplate getJdbcTemplate(){return jdbcTemplate;}
    
    @Override
    public OrderList getProductsForOrder(int orderId){
        OrderList orderList = new OrderList();
        String query = "Select * from orderlist where order_id = ?";
        orderList.setProductList(getJdbcTemplate().query(query, new OrderListMapper(), orderId));
        return orderList;
    }
    
    @Override
    public void addProductsFromOrder(Order order){
        String insert = "Insert into orderlist(order_id, product_id, product_name, price) values (?,?,?,?)";
        for(Product p : order.getProducts()){
            KeyHolder keyHolder = new GeneratedKeyHolder();
            getJdbcTemplate().update((PreparedStatementCreator) (connection) -> {
                PreparedStatement ps = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, order.getId());
                ps.setInt(2, p.getId());
                ps.setString(3, p.getName());
                ps.setBigDecimal(4, p.getPrice());
                return ps;
            }, keyHolder);
        }
    }
}

class OrderListMapper implements RowMapper<Product>{
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException{
        Product product = new Product();
        product.setId(resultSet.getInt("product_id"));
        product.setName(resultSet.getString("product_name"));
        product.setPrice(resultSet.getBigDecimal("price"));
        product.setQuantity(1); //hardcoded but having quantity may be feature added later
        return product;
    }
}