package com.demo.orderapp.utils;

import com.demo.orderapp.dto.AddressDto;
import com.demo.orderapp.dto.OrderDto;
import com.demo.orderapp.dto.ProductBean;
import com.demo.orderapp.entity.Address;
import com.demo.orderapp.entity.Order;
import org.springframework.stereotype.Component;
@Component
public class Converter {

        // Convert Order Entity to DTO
        public static OrderDto toDto(Order order) {
            OrderDto dto = new OrderDto();

            dto.setBarCode(order.getBarCode());

            if (order.getBillingAddress() != null) {
                dto.setBillingAddress(toDto(order.getBillingAddress()));
            }

            return dto;
        }

        // Convert Address Entity to DTO
        private static AddressDto toDto(Address address) {
            AddressDto dto = new AddressDto();
            dto.setStreet(address.getStreet());
            dto.setCity(address.getCity());
            dto.setState(address.getState());
            dto.setPincode(address.getPincode());
            return dto;
        }

        // Convert DTO to Order Entity
        public static Order toOrder(OrderDto dto) {
            Order order = new Order();

            order.setBarCode(dto.getBarCode());
            order.setQty(dto.getQuantity());
            order.setEmailId(dto.getEmailId());
            order.setBillingAddress(toOrder(dto.getBillingAddress()));

            if (dto.getBillingAddress() != null) {
                order.setBillingAddress(toOrder(dto.getBillingAddress()));
            }

            return order;
        }

        // Convert AddressDTO to Address Entity
        public static Address toOrder(AddressDto dto) {
            Address address = new Address();
            address.setStreet(dto.getStreet());
            address.setCity(dto.getCity());
            address.setState(dto.getState());
            address.setPincode(dto.getPincode());
            return address;
        }
        public static Order toOrderFromProduct(ProductBean productBean) {
            Order order = new Order();
            order.setBarCode(productBean.getBarCode());
            order.setCategory(productBean.getCategory());
            order.setDescription(productBean.getDescription());
            order.setProductName(productBean.getName());
            order.setPrice(productBean.getPrice());
            return order;
        }
    }

