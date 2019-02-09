package cn.e3mall.order.service;


import cn.e3mall.order.pojo.OrderInfo;
import xn.e3mall.common.utils.E3Result;

public interface OrderService {

	E3Result createOrder(OrderInfo orderInfo);


}
