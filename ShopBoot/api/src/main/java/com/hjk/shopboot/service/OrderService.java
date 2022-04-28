package com.hjk.shopboot.service;

import java.util.List;

import com.hjk.dto.OrderRequestDto;
import com.hjk.dto.UserResponseDto;
import com.hjk.model.Orders;
import com.hjk.shopboot.respository.OrderRepository;
import com.hjk.enums.Search;
import com.hjk.shopboot.utils.session.SessionUtils;
import com.hjk.shopboot.utils.specification.OrderSpecs;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    // 모든 주문 조회(관리자)
    public List<Orders> getAll() {
        return orderRepository.findAll();
    }

    // 모든 주문 조회+PAGE+SEARCH(관리자)
    public Page<Orders> getAllPageSearch(Pageable page, String keyword, Search search) {
        Specification<Orders> spec = Specification.where(OrderSpecs.hasTitle(keyword, search));
        return orderRepository.findAll(spec, page);
    }

    // 모든 주문 조회+PAGE(사용자)
    public Page<Orders> getAllPage(Pageable page) {
        UserResponseDto session = SessionUtils.getUser();
        Specification<Orders> spec = Specification.where(OrderSpecs.hasUser(session.getId()));
        return orderRepository.findAll(spec, page);
    }

    // 모든 주문 조회+PAGE+검색(사용자)
    public Page<Orders> getAllPageSearch(Pageable page,String keyword,String search) {
        UserResponseDto session = SessionUtils.getUser();
        Specification<Orders> spec = Specification.where(OrderSpecs.hasUserTitle(session.getId(),keyword,search));
        return orderRepository.findAll(spec, page);
    }


    // 진행중인 주문 조회
    public List<Orders> getMyOrderAllON() {
        UserResponseDto session = SessionUtils.getUser();
        Specification<Orders> spec = Specification.where(OrderSpecs.hasUserOn(session.getId()));
        return orderRepository.findAll(spec);
    }

    // 진행중으로 주문 임시저장
    public void orderStatusOn(List<Orders> orderRequest) {
        deleteOn();
        orderRepository.saveAll(orderRequest);
    }

    //포인트적용
    public void orderPointApply(OrderRequestDto orderRequest){
        orderRequest.applyPoint();
        orderRepository.save(orderRequest.toEntity());
    }

    // 체크아웃 벗어날시 진행중 주문 삭제
    public void deleteOn() {
        orderRepository.deleteOn(SessionUtils.getUser().getId());
    }

    // 결제 완료시 상태 COMPLETE
    public void orderComplete() {
        orderRepository.updateComplete(SessionUtils.getUser().getId());
    }

    //주문 취소
    public void cancelOrder(long id){
        UserResponseDto session = SessionUtils.getUser();
        orderRepository.updateCancel(session.getId(),id);
    }
}
